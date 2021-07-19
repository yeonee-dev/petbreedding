package kh.com.petbreedding.Chat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.Chat.model.service.ChatService;
import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.Notice;

@Controller
public class ChatController {

	@Autowired
	private ChatService chService;
	
	@Autowired
	private NoticeService noticeService;
	
//	@RequestMapping("/insertNoticeforChat.do")
//	public void insertNoticeforChat(HttpServletRequest req) {
//				
//		String chatId = req.getParameter("chatId");
//		String mReceiver = req.getParameter("mReceiver");
//		String notPublisher = req.getParameter("notPublisher");
//		
//		ChatMessage cm = new ChatMessage();
//		cm.setmReceiver(mReceiver);
//		cm.setChatId(chatId);
//		
//		int unreadCount = chService.getUnreadCount(cm);
//		
//		Notice notice = new Notice();
//		notice.setNotReceiver(mReceiver);
//		notice.setNotPublisher(notPublisher);
//		
//		if(unreadCount>0) {
//			int result = noticeService.inUnreadChat(notice);
//			if(result==1) {
//				System.out.println("알림 인서트 성공");
//			}else {
//				System.out.println("알림 인서트 실패ㅠㅠ");
//			}
//		}
//		
//	}

	@RequestMapping("/chat")
	public ModelAndView chat(ModelAndView mv, @RequestParam(value = "chatId", required = false) String chatId,
			@RequestParam(value = "shopName", required = false) String shopName,			
			@RequestParam(value = "bp_id", required = false) String bp_id, 
			@RequestParam(value = "bp_type", required = false) String bptype, 
			HttpSession session) {
			
		List<ChatMessage> list = null;
		
		Client client = (Client) session.getAttribute("client");
		
		String nickName = "";
		String id = "";
		String cl_num = "";
		ChatRoom cr = new ChatRoom();
		
		// 세션이 널이 아니면(==로그인 되어있으면)
		if(session!=null) {
			nickName = client.getNickname();
			id = client.getEmail();
			cl_num = client.getCl_num();
		}
		
		if(bptype == null ) {
			bptype = chService.getbp_type(bp_id);
			System.out.println("bptype" + bptype);
		}
		//파라미터로 가져온 cl_num, bp_id, bp_type cr에 set
		cr.setCl_num(cl_num);
		cr.setBp_id(bp_id);
		int bp_type = Integer.parseInt(bptype);
		cr.setBp_type(bp_type);
		
		
		// 채팅방 번호가 없다면
		if (chatId == null) {		
			
			// 채팅방이 있는지 한번 확인 후
			ChatRoom roomResult = null;
			roomResult = chService.isRoom(cr);
			
			// 기존의 채팅방이 없다면
			if(roomResult == null) {
				int result = 0;
				// 채팅방 생성
				result = chService.createRoom(cr);
				
				if(result == 1) {
					System.out.println("채팅방 생성 성공");
					roomResult = chService.isRoom(cr);
				} else {
					System.out.println("채팅방 생성 실패");
				}
			}
			chatId = roomResult.getChatId();
		}
		
		if (chatId !=null) {
			cr.setChatId(chatId);
			// 해당 채팅방의 저장된 메시지 가져오기
			list = chService.getMessageList(cr); 
		}
		
		// 안 읽은 메시지 있으면 업데이트
		updateUnread(cl_num, chatId);
				
		String user = "user";
		mv.addObject("user", user);
		mv.addObject("cl_num", cl_num);
		mv.addObject("bp_id", bp_id);
		mv.addObject("chatlist", list);
		mv.addObject("bp_type", bp_type);
		mv.addObject("id", id);
		mv.addObject("chatId", chatId);
		mv.addObject("shopName", shopName);
		mv.addObject("nickName", nickName);
		mv.setViewName("/user/uMyPage/myChatRoom");
		return mv;
	}

	@RequestMapping("/bchat")
	public ModelAndView bchat(ModelAndView mv, @RequestParam(value = "chatId", required = false) String chatId,
			@RequestParam(value = "nickName", required = false) String nickName,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "cl_num", required = false) String cl_num, 
			HttpSession session) {
		
		List<ChatMessage> list = null;
		
		BPartner bpartner = (BPartner) session.getAttribute("bP");
		
		String id = "";
		String bp_id = "";
		int bp_type = 0;
		ChatRoom cr = new ChatRoom();
		
		// 세션이 널이 아니면(==로그인 되어있으면)
		if(session!=null) {
			id = bpartner.getBp_email();
			bp_id = bpartner.getBp_Id();
			bp_type = bpartner.getBp_type();
		}
		
		//파라미터로 가져온 cl_num, bp_id, bp_type cr에 set
		cr.setCl_num(cl_num);
		cr.setBp_id(bp_id);
		cr.setBp_type(bp_type);
		
		// 채팅방 번호가 없다면
		if (chatId == null) {
			
			// 채팅방이 있는지 한번 확인 후
			ChatRoom roomResult = null;
			roomResult = chService.isRoom(cr);
			
			// 기존의 채팅방이 없다면
			if(roomResult == null) {
				int result = 0;
				
				// 채팅방 생성
				result = chService.createRoom(cr);
				
				if(result == 1) {
					System.out.println("채팅방 생성 성공");
					roomResult = chService.isRoom(cr);
				} else {
					System.out.println("채팅방 생성 실패");
				}
			}
			chatId = roomResult.getChatId(); 
		}
		
		if (chatId !=null) {
			cr.setChatId(chatId);
			// 해당 채팅방의 저장된 메시지 가져오기
			list = chService.getMessageList(cr); 
		}
				
		// 안 읽은 메시지 있으면 업데이트
		updateUnread(bp_id, chatId);
				
		String user = "bPartber";
		mv.addObject("user", user);
		mv.addObject("cl_num", cl_num);
		mv.addObject("bp_id", bp_id);
		mv.addObject("chatlist", list);
		mv.addObject("id", id);
		mv.addObject("chatId", chatId);
		mv.addObject("shopName", shopName);
		mv.addObject("nickName", nickName);
		mv.setViewName("/user/uMyPage/myChatRoom");
		return mv;
	}

	@RequestMapping("/chatlist")
	public ModelAndView chatlist(ModelAndView mv, HttpSession session) {
		List<ChatList> list = null;
		List<ChatList> unreadList = null;
		int countUnread = 0;
		
		Client client = (Client) session.getAttribute("client");
		
		// 로그인 되어있다면 세선에셔 cl_num 받아와 
		// 채팅내역과 안읽은 채팅 내역, 안읽은 메시지의 총합 가져오기
		if (session != null) {
			String cl_num = client.getCl_num();
			list = chService.getList(cl_num);
			unreadList = chService.getUnreadList(cl_num);
			countUnread = chService.getAllCount(cl_num);
		}
		mv.addObject("Roomlist", list);
		mv.addObject("unreadList", unreadList);
		mv.addObject("countUnread", countUnread);
		mv.setViewName("/user/uMyPage/myChatList");
		return mv;
	}

	@RequestMapping("/bchatlist")
	public ModelAndView bchatlist(ModelAndView mv, HttpSession session) {
		List<ChatList> list = null;
		List<ChatList> unreadList = null;
		int countUnread = 0;
		
		BPartner bpartner = (BPartner) session.getAttribute("bP");
		
		// 로그인 되어있다면 세선에셔 bp_id 받아와
		// 채팅내역과 안읽은 채팅 내역, 안읽은 메시지의 총합 가져오기
		if (session != null) {
			String bp_id = bpartner.getBp_Id();
			list = chService.getListbp_id(bp_id);
			unreadList = chService.getUnreadListbp_id(bp_id);
			countUnread = chService.getAllCount(bp_id);
		}
		mv.addObject("Roomlist", list);
		mv.addObject("unreadList", unreadList);
		mv.addObject("countUnread", countUnread);
		mv.setViewName("/bPartner/bChat/bChatList");
		return mv;
	}
	
	@RequestMapping("/chatdelete.do")
	@ResponseBody
	public int chatdelete(HttpServletRequest req) {
		
		List<ChatMessage> list = null;
		int result = 0;
		
		String chatId = req.getParameter("chatId");
		System.out.println("chatId" + chatId);
		
		// 현재 시점 이전의 메시지 리스트를 가져와서
		list = chService.getListforInvisible(chatId);
		
		for(int i=0; i<list.size(); i++) { 
			result = 0;
			String mId = list.get(i).getmId();
			result = chService.updateInvisibleCleint(mId);
			if(result==1) {
				System.out.println("메시지 보이지 않게 처리 완료!");
			}else {
				System.out.println("메시지 보이지 않게 업데이트 실패");
			}
		}
		return result;
	}
	
	@RequestMapping("/bchatdelete.do")
	@ResponseBody
	public int bchatdelete(HttpServletRequest req) {
		
		List<ChatMessage> list = null;
		int result = 0;
		
		String chatId = req.getParameter("chatId");
		System.out.println("chatId" + chatId);
		
		// 현재 시점 이전의 메시지 리스트를 가져와서
		list = chService.getListforInvisible(chatId);
		
		for(int i=0; i<list.size(); i++) { 
			result = 0;
			String mId = list.get(i).getmId();
			result = chService.updateInvisibleBp(mId);
			if(result==1) {
				System.out.println("사업자 - 메시지 보이지 않게 처리 완료!");
			}else {
				System.out.println("사업자 - 메시지 보이지 않게 업데이트 실패");
			}
		}
		return result;
	}
	
	
	public void updateUnread(String mReceiver, String chatId) {
	
		// 안 읽은 메시지 업데이트 하기
		List<ChatMessage> unreadList = null;
		ChatMessage cm = new ChatMessage();
		cm.setmReceiver(mReceiver);
		cm.setChatId(chatId);
		unreadList = chService.getUnreadCountList(cm);
		
		if(unreadList!=null) {
			//안 읽은 메시지가 있다면
			for(int i=0; i<unreadList.size(); i++) {
				String mId = unreadList.get(i).getmId();
				int result = 0;
				result = chService.updateUnreadCount(mId);
				if(result==1) {
					System.out.println("언리드메시지 리드 완료!");
				}else {
					System.out.println("언리드메시지 업데이트 실패");
				}
			}
		}
	}
	
	}
