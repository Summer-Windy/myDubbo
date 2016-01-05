package wusc.edu.facade.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wusc.edu.facade.user.service.PmsUserReportFacade;
import wusc.edu.service.user.biz.PmsUserBiz;

@Service("pmsUserReportFacade")
public class PmsUserReportFacadeImpl implements PmsUserReportFacade {
	
	@Autowired
	private PmsUserBiz pmsUserBiz;

	@Override
	public String report() {
		
		return pmsUserBiz.report();
	}
	
	
	
}
