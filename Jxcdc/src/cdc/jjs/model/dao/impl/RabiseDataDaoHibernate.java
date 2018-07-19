package cdc.jjs.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cdc.jjs.model.dao.RabiseDataDao;
import cdc.jjs.model.domain.RabiseData;

public class RabiseDataDaoHibernate extends BaseDaoHibernate<RabiseData> implements RabiseDataDao {
	
	public List<RabiseData> findLaboratoryNumber(String laboratoryNumber) {
		return find("select r from RabiseData r where r.laboratoryNumber=?0",laboratoryNumber);				
	}
	
	public int updateDetector(String laboratoryNumber,String detector) {		
		return updateHQL("update RabiseData r set r.detector=?1 where r.laboratoryNumber=?0",laboratoryNumber,detector);					
	}
	
	public List<RabiseData> findRabise(String laboratoryNumber , String name , Date time1 , Date time2){
			
		StringBuffer sql = new StringBuffer("select r from RabiseData r where 1=1");
		List<Object> list = new ArrayList<Object>();
		if(laboratoryNumber != null && !laboratoryNumber.trim().isEmpty()){
			sql.append(" and r.laboratoryNumber = ?");
			list.add(laboratoryNumber);
		}
		if(name != null && !name.trim().isEmpty()){
			sql.append(" and r.name = ?");
			list.add(name);
		}
		if(time1 != null){
			sql.append(" and r.samplingDate >= ?");
			list.add(time1);
		}
		if(time2 != null){
			sql.append(" and r.samplingDate <= ?");
			list.add(time2);
		}
		return indefiniteQuery(sql.toString(),list.toArray());
	}
	
	public List<RabiseData> findYear(String year) {
		return find("select r from RabiseData r where r.year=?0",year);
	}

}
