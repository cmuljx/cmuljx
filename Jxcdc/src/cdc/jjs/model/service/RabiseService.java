package cdc.jjs.model.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cdc.jjs.control.rabise.vo.RabiseCollectionAndResultFormVO;
import cdc.jjs.control.rabise.vo.RabiseQueryList;
import cdc.jjs.control.rabise.vo.RabiseResultVO;
import cdc.jjs.control.rabise.vo.RabiseVO;
import cdc.jjs.model.domain.RabiseData;
import cdc.jjs.model.domain.RabiseResult;

public interface RabiseService {

	public boolean saveRabiseData(RabiseData rabiseData, List<RabiseResult> rabiseResults);
	
	public RabiseVO rabiseResultLocation(String laboratoryNumber) ;
	
	public Boolean saveRabiseResult(String laboratoryNumber,String specimeAmount,List<RabiseResultVO> rabiseResults,String detector);
	
	public List<RabiseQueryList> rabiseQuery(String laboratoryNumber,String name,String time1,String time2);
	
	public void deleteRabise(String laboratoryNumber);
	
	public void updateRabise(RabiseData rabiseData , List<RabiseResult> rabiseResults);
	
	public HSSFWorkbook rabiseDataToExcel(String laboratoryNumber,String name,String time1,String time2); 
	
	public List<RabiseCollectionAndResultFormVO> RabiseCollectionAndResultForm(String year);
	
}
