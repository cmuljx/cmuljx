package cdc.jjs.model.dao;

import cdc.jjs.model.domain.InfEgg;

public interface InfEggDao extends BaseDao<InfEgg>{
	
	public InfEgg findSqlByInfID(String infID);
	
	public int updateEgg();
	
	public int saveEgg();

}
