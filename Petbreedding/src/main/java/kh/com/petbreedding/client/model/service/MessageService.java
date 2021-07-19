package kh.com.petbreedding.client.model.service;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


@Service("messageService")
public class MessageService {
	
	public static void sendMessage(String tel, String randomNumber) {
		
		String api_key = "NCSFXHHYSMAD5RM3";
	    String api_secret = "7VCI7HEXB0HFRPSUDQKEDUQNWXESXVTS";
	    Message coolsms = new Message(api_key, api_secret);
	
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", tel);
	    params.put("from", "01029352391");
	    params.put("type", "SMS");
	    params.put("text", "[Petbreedding] 인증번호 " +randomNumber+ " 를 입력하세요.");
	    params.put("app_version", "test app 1.2"); // application name and version
	
	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	  }
	
}
