package cdc.jjs.model.dao;

import java.util.Date;

import cdc.jjs.model.domain.RabiseResult;

public interface RabiseResultDao extends BaseDao<RabiseResult> {
	
	public int CreateBySampleNumber(String simpleNumber,String result,Date detectionDate,String detector,Date modifyDate) ;
	
	public RabiseResult findSampleNumber(String sampleNumber);

}
