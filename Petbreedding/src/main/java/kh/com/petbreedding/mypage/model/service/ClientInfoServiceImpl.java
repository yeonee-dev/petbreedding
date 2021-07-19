package kh.com.petbreedding.mypage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.dao.ClientInfoDao;

@Service("clientInfoService")
public class ClientInfoServiceImpl implements ClientInfoService {

	@Autowired
	private ClientInfoDao clientInfoDao;
	
	
	@Override
	public String selectClientInfo(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateClientInfo(Client client) {
		int result = -1;
		try {
			result = clientInfoDao.updateClientInfo(client);				
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!error!!!!!!!!!! : "+ e);
		}
		return result;
	}

	@Override
	public void deleteClient(String email) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<HairShopReservation> myReservationList(String cl_num) {
		List<HairShopReservation> result = null;
		try {
			result = clientInfoDao.myReservationList(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<HairShopReservation> myRevDateList(Map<String, String> list) {
		List<HairShopReservation> result = null;
		try {
			result = clientInfoDao.myRevDateList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	@Override
	public int status0(String cl_num) {
		int result = -1;
		try {
			result = clientInfoDao.status0(cl_num);
			if(result == -1 ) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int status1(String cl_num) {
		int result = -1;
		try {
			result = clientInfoDao.status1(cl_num);
			if(result == -1) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int status2(String cl_num) {
		int result = -1;
		try {
			result = clientInfoDao.status2(cl_num);
			if(result == -1) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HairShopReservation> myRevDetail(String har_rnum) {
		List<HairShopReservation> result = null;
		try {
			result = clientInfoDao.myRevDetail(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String anotherMenu(String har_rnum) {
		String result = null;
		try {
			result = clientInfoDao.anotherMenu(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getPrice(String har_rnum) {
		int result = -1;
		try {
			result = clientInfoDao.getPrice(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int cancleRev(String har_rnum) {
		int result = -1;
		try {
			result = clientInfoDao.cancleRev(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HospitalReservation> myRevDetail2(String hos_rnum) {
		List<HospitalReservation> list = null;
		try {
			list = clientInfoDao.myRevDetail2(hos_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int cancleRev2(String hos_rnum) {
		int result = -1;
		try {
			result = clientInfoDao.cancleRev2(hos_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
