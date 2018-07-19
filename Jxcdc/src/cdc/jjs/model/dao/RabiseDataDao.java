package cdc.jjs.model.dao;

import java.util.Date;
import java.util.List;

import cdc.jjs.model.domain.RabiseData;

public interface RabiseDataDao extends BaseDao<RabiseData> {

	public List<RabiseData> findLaboratoryNumber(String laboratoryNumber);
	
	public int updateDetector(String laboratoryNumber,String detector);
	
	public List<RabiseData> findRabise(String laboratoryNumber , String name , Date time1 , Date time2);
	
	public List<RabiseData> findYear(String year);
	
	
}
