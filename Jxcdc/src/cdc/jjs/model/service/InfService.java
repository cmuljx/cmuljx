package cdc.jjs.model.service;

import java.util.List;

import cdc.jjs.control.inf.vo.InfReportFieldVO;

public interface InfService {
	
	public void importInfData(String CSVFile) throws Exception;
	
	public List<Integer> saveAndUpdateInf(String filePath);
	
	@SuppressWarnings("rawtypes")
	public List<List> findCollectionDate(String collectionDate);
	
	public int updateInfDataName(String laboratoryNumber , String name);
	
	public List<InfReportFieldVO> nucleinReport(String collectionDate , String flag);

}
