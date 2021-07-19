package kh.com.petbreedding.Chat.model.service;

import java.util.List;

import kh.com.petbreedding.Chat.model.vo.ChatList;
import kh.com.petbreedding.Chat.model.vo.ChatMessage;
import kh.com.petbreedding.Chat.model.vo.ChatRoom;

public interface ChatService {

	public String getbp_type(String bp_id);
	public int createRoom(ChatRoom cr);
	public ChatRoom isRoom(ChatRoom cr);
	public int insertMessage(ChatMessage cm);
	public ChatRoom selectChatRoom(String chatId);
	public List<ChatList> getList(String cl_num);
	public List<ChatList> getListbp_id(String bp_id);
	public List<ChatList> getUnreadList(String cl_num);
	public List<ChatList> getUnreadListbp_id(String bp_id);
	public List<ChatMessage> getMessageList(ChatRoom cr);
	public List<ChatMessage> getMessageListbp_id(ChatRoom cr);
	public List<ChatMessage> getUnreadCountList(ChatMessage cm);
	public int getUnreadCount(ChatMessage cm);
	public int updateUnreadCount(String mId);
	public int getAllCount(String mReceiver);
	public List<ChatMessage> getListforInvisible(String chatId);
	public int updateInvisibleCleint(String mId);
	public int updateInvisibleBp(String mId);
}
