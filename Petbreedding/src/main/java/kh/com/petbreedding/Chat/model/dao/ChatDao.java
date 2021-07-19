package kh.com.petbreedding.Chat.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

@Repository("chDao")
public class ChatDao {

	@Autowired
	private SqlSession sqlSession;

	// BP_TYPE 찾기
	public String getbp_type(String bp_id) throws Exception {
		return sqlSession.selectOne("Chat.getbp_type", bp_id);
	}

	// 채팅방 만들기
	public int createRoom(ChatRoom cr) throws Exception {
		return sqlSession.insert("Chat.createRoom", cr);
	}

	// 채팅방 존재하는지 확인
	public ChatRoom isRoom(ChatRoom cr) throws Exception {
		return sqlSession.selectOne("Chat.isRoom", cr);
	}

	// 메시지 작성시마다 저장
	public int insertMessage(ChatMessage cm) throws Exception {
		return sqlSession.insert("Chat.insertMessage", cm);
	}

	// 채팅방 아이디로 채팅방 찾기
	public ChatRoom selectChatRoom(String chatId) throws Exception {
		return sqlSession.selectOne("Chat.selectChatRoom", chatId);
	}

	// 채팅방 리스트 찾기(client)
	public List<ChatList> getList(String cl_num) throws Exception {
		return sqlSession.selectList("Chat.getList", cl_num);
	}

	// 채팅방 리스트 찾기(bPartner)
	public List<ChatList> getListbp_id(String bp_id) throws Exception {
		return sqlSession.selectList("Chat.getListbp_id", bp_id);
	}

	// 안읽은메시지가 있는 채팅방 리스트 찾기(client)
	public List<ChatList> getUnreadList(String cl_num) throws Exception {
		return sqlSession.selectList("Chat.getUnreadList", cl_num);
	}

	// 안 읽은 메시지가 있는 채팅방 리스트 찾기(bPartner)
	public List<ChatList> getUnreadListbp_id(String bp_id) throws Exception {
		return sqlSession.selectList("Chat.getUnreadListbp_id", bp_id);
	}

	// 채팅방의 메시지 리스트(client)
	public List<ChatMessage> getMessageList(ChatRoom cr) throws Exception {
		return sqlSession.selectList("Chat.getMessageList", cr);
	}

	// 채팅방의 메시지 리스트(bPartner)
	public List<ChatMessage> getMessageListbp_id(ChatRoom cr) throws Exception {
		return sqlSession.selectList("Chat.getMessageListbp_id", cr);
	}

	// 해당 채팅방의 내가 안 읽은 메시지 리스트(client)
	public List<ChatMessage> getUnreadCountList(ChatMessage cm) throws Exception {
		return sqlSession.selectList("Chat.getUnreadCountList", cm);
	}

	// 채팅방 입장 시 안 읽은 메시지 -> 읽은 메시지로 업데이트
	public int updateUnreadCount(String mId) throws Exception {
		return sqlSession.update("Chat.updateUnreadCount", mId);
	}

	// 총 내가 안 읽은 메시지의 수 카운트
	public int getAllCount(String mReceiver) throws Exception {
		return sqlSession.selectOne("Chat.getAllCount", mReceiver);
	}
	
	// 해당 채팅방에서 읽지 않은 메시지 수
	public int getUnreadCount(ChatMessage cm) throws Exception {
		return sqlSession.selectOne("Chat.getUnreadCount", cm);
	}

	// 채팅 리스트에서 채팅 삭제 시 DB 삭제는 하지 않고 리스트에만 보이지 않게 하기 위해
	// 우선 클릭한 시점(지금) 이전의 해당 채팅방의 메시지들의 Message_id를 받아옴
	public List<ChatMessage> getListforInvisible(String chatId) throws Exception {
		return sqlSession.selectList("Chat.getListforInvisible", chatId);
	}

	// 해당 채팅방과 삭제 시점 이전의 메시지들이 보이지 않도록 invisible~ 컬럼을 업데이트함(사용자)
	public int updateInvisibleCleint(String mId) throws Exception {
		return sqlSession.update("Chat.updateInvisibleCleint", mId);
	}

	// 해당 채팅방과 삭제 시점 이전의 메시지들이 보이지 않도록 invisible~ 컬럼을 업데이트함(사업자)
	public int updateInvisibleBp(String mId) throws Exception {
		return sqlSession.update("Chat.updateInvisibleBp", mId);
	}

}