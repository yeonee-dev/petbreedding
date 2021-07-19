package kh.com.petbreedding.Chat.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ChatRoom {
    
    private String chatId;
	private String cl_num;
	private String bp_id;
	private int bp_type;
	
	public int getBp_type() {
		return bp_type;
	}
	public void setBp_type(int bp_type) {
		this.bp_type = bp_type;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getCl_num() {
		return cl_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public String getBp_id() {
		return bp_id;
	}
	public void setBp_id(String bp_id) {
		this.bp_id = bp_id;
	}	
}
