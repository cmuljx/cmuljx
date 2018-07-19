package cdc.jjs.model.dao.impl;

import java.util.Date;

import cdc.jjs.model.dao.RabiseResultDao;
import cdc.jjs.model.domain.RabiseResult;

public class RabiseResultDaoHibernate extends BaseDaoHibernate<RabiseResult> implements RabiseResultDao {
	
	public int CreateBySampleNumber(String specimeNumber,String result,Date detectionDate,String detector,Date modifyDate) {
				
		return updateHQL("update RabiseResult r set r.result=?1, r.detectionDate=?2, r.detector=?3, r.modifyDate=?4 where r.sampleNumber=?0", 
				specimeNumber,result,detectionDate,detector,modifyDate);
	}
	
	@Override
	public RabiseResult findSampleNumber(String sampleNumber) {
		
		return find("select r from RabiseResult r where r.sampleNumber=?0",sampleNumber).get(0);
	}

}
