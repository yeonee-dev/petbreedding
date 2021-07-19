package kh.com.petbreedding.common.model.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("kakaoLogin")
public class KakaoLogin {
	
	private final static String K_CLIENT_ID = "a860c31780498929b7a9fa95ed725bf5"; //REST_API
	private final static String K_REDIRECT_URI = "http://localhost:8090/petbreedding/kakaoLogin";
	private final static String K_CLIENT_SECRET = "Osq8t7qXdVClBMeuXl54n8vYlkOR6NUa"; 

	public static String getAuthorizationUrl(HttpSession session) { 
		String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?" + "client_id=" 
				+ K_CLIENT_ID + "&redirect_uri=" + K_REDIRECT_URI + "&response_type=code"; 
		return kakaoUrl; 
	}
	
	public static JsonNode getAccessToken(String autorize_code) {
		
//		System.out.println("autorize_code : "+ autorize_code);
		
		final String RequestUrl = "https://kauth.kakao.com/oauth/token";
		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", K_CLIENT_ID));
		postParams.add(new BasicNameValuePair("redirect_uri", K_REDIRECT_URI));
		postParams.add(new BasicNameValuePair("client_secret", K_CLIENT_SECRET));
		postParams.add(new BasicNameValuePair("code", autorize_code));
		
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(RequestUrl);
		JsonNode returnNode = null;
		
		try {
			post.setEntity(new UrlEncodedFormEntity(postParams));
			final HttpResponse response = client.execute(post);
			//JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();
			returnNode = mapper.readTree(response.getEntity().getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("returnNode : "+ returnNode);
		return returnNode;
	}

	//여기가 redirect 부분
	public static JsonNode getKakaoUserInfo(JsonNode accessToken) { 
		
//		System.out.println("accessToken : "+ accessToken);
		
		final String RequestUrl = "https://kapi.kakao.com/v2/user/me"; 
		final HttpClient client = HttpClientBuilder.create().build(); 
		final HttpPost post = new HttpPost(RequestUrl); 
		// add header 
		post.addHeader("Authorization", "Bearer " + accessToken); 
		JsonNode returnNode = null; 
		try { 
			final HttpResponse response = client.execute(post); 
			// JSON 형태 반환값 처리 
			ObjectMapper mapper = new ObjectMapper(); 
			returnNode = mapper.readTree(response.getEntity().getContent()); 
		} catch (ClientProtocolException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} finally {
			// clear resources } return returnNode; }
		}
		
		
		return returnNode;
	}


}
