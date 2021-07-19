package kh.com.petbreedding.common.model.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.dao.LoginDao;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public Client login(Client client) {
		Client result = null;
		
		try {
			result = loginDao.login(client);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public BPartner blogin(BPartner bP) {
		BPartner result = null;
		
		try {
			result = loginDao.blogin(bP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public Admin mLogin(Admin admin) {
		Admin result = null;
		
		try {
			result = loginDao.mLogin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<Client> selectMember(String nickname) {
		List<Client> list = null;
		try {
			list = loginDao.selectMember(nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
