package kh.com.petbreedding.Chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Chat.model.dao.ChatDao;
import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

@Service("chService")
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatDao chDao;
	
	@Override
	public String getbp_type(String bp_id) {
		String result = "";
		try {
			result = chDao.getbp_type(bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	

	@Override
	public int createRoom(ChatRoom cr) {
		int result = 0;
		try {
			result = chDao.createRoom(cr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ChatRoom isRoom(ChatRoom cr) {
		ChatRoom result = null;
		try {
			result = chDao.isRoom(cr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertMessage(ChatMessage cm) {
		int result = 0;
		try {
			result = chDao.insertMessage(cm);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ChatRoom selectChatRoom(String chatId) {
		ChatRoom result = null;
		try {
			result = chDao.selectChatRoom(chatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ChatList> getList(String cl_num) {
		List<ChatList> result = null;
		try {
			result = chDao.getList(cl_num);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatList> getListbp_id(String bp_id) {
		List<ChatList> result = null;
		try {
			result = chDao.getListbp_id(bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ChatList> getUnreadList(String cl_num) {
		List<ChatList> result = null;
		try {
			result = chDao.getUnreadList(cl_num);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatList> getUnreadListbp_id(String bp_id) {
		List<ChatList> result = null;
		try {
			result = chDao.getUnreadListbp_id(bp_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatMessage> getMessageList(ChatRoom cr) {
		List<ChatMessage> result = null;
		try {
			result = chDao.getMessageList(cr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatMessage> getMessageListbp_id(ChatRoom cr) {
		List<ChatMessage> result = null;
		try {
			result = chDao.getMessageListbp_id(cr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatMessage> getUnreadCountList(ChatMessage cm) {
		List<ChatMessage> result = null;
		try {
			result = chDao.getUnreadCountList(cm);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateUnreadCount(String mId) {
		int result = 0;
		try {
			result = chDao.updateUnreadCount(mId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getAllCount(String mReceiver) {
		int result = 0;
		try {
			result = chDao.getAllCount(mReceiver);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ChatMessage> getListforInvisible(String chatId) {
		List<ChatMessage> result = null;
		try {
			result = chDao.getListforInvisible(chatId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateInvisibleCleint(String mId) {
		int result = 0;
		try {
			result = chDao.updateInvisibleCleint(mId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateInvisibleBp(String mId) {
		int result = 0;
		try {
			result = chDao.updateInvisibleBp(mId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getUnreadCount(ChatMessage cm) {
		int result = 0;
		try {
			result = chDao.getUnreadCount(cm);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
