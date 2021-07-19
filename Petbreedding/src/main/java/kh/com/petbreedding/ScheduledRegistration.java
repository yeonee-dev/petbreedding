package kh.com.petbreedding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kh.com.petbreedding.Shop.model.dao.ShopPayDao;


@Component
public class ScheduledRegistration {
	@Autowired
	private ShopPayDao shopPayDao;

//	@Scheduled(cron = "0 0/10 9-18 * * *")   
	@Scheduled(cron = "0 0 0 * * *")   
	public void registration() {
		System.out.println("[ @Scheduled]registration 시작");
		shopPayDao.updateRevByScheduled();
		shopPayDao.updateRevByScheduled2();
		System.out.println("[ @Scheduled]registration 끝");
	}
}
