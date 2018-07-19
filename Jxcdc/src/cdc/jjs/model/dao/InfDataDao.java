package cdc.jjs.model.dao;

import java.util.Date;
import java.util.List;

import cdc.jjs.model.domain.InfData;

public interface InfDataDao extends BaseDao<InfData>{
	
	public InfData findInfID(String infID);
	
	@SuppressWarnings("rawtypes")
	public List<List> findCollectionDate(Date collectionDate);
	
	public int updateInfDataName(String laboratoryNumber , String name);
	
	public int updateData();
	
	public int saveData();
	
	public int deleteInf();
	
	public int importInf(String filePath);
	
	public void updataInf();
	
	public boolean findInfEgg();

}
