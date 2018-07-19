package cdc.jjs.model.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cdc.jjs.control.rabise.vo.RabiseCollectionAndResultFormVO;
import cdc.jjs.control.rabise.vo.RabiseQueryList;
import cdc.jjs.control.rabise.vo.RabiseResultVO;
import cdc.jjs.control.rabise.vo.RabiseVO;
import cdc.jjs.model.dao.RabiseDataDao;
import cdc.jjs.model.dao.RabiseResultDao;
import cdc.jjs.model.domain.RabiseData;
import cdc.jjs.model.domain.RabiseResult;
import cdc.jjs.model.service.RabiseService;

public class RabiseServiceImpl implements RabiseService {
	
	private RabiseDataDao rabiseDataDao;
	private RabiseResultDao rabiseResultDao;
	public void setRabiseDataDao(RabiseDataDao rabiseDataDao) {
		this.rabiseDataDao = rabiseDataDao;
	}
	public void setRabiseResultDao(RabiseResultDao rabiseResultDao) {
		this.rabiseResultDao = rabiseResultDao;
	}

	public boolean saveRabiseData(RabiseData rabiseData, List<RabiseResult> rabiseResults) {
		
		rabiseDataDao.save(rabiseData);
		for (RabiseResult rabiseResult : rabiseResults) {
			rabiseResult.setRabiseData(rabiseData);
			rabiseResultDao.save(rabiseResult);			
		}		
		return true;
	}
	
	public RabiseVO rabiseResultLocation(String laboratoryNumber) {
		
		RabiseVO rabiseResultLocationResult = new RabiseVO();
		
		List<RabiseData> rabiseDatas = rabiseDataDao.findLaboratoryNumber(laboratoryNumber);
		if(rabiseDatas.isEmpty()) {
			return null;
		}else {	
			RabiseData rabiseData = rabiseDatas.get(0);
			
			rabiseResultLocationResult.setRabiseData(rabiseData);
				
			List<RabiseResult> rabiseResults = new ArrayList<RabiseResult>();							
			Iterator<RabiseResult> iter = rabiseData.getRabiseResults().iterator();	
			while(iter.hasNext()){
				rabiseResults.add(iter.next());
		    }
			rabiseResultLocationResult.setRabiseResults(rabiseResults);
			
			return rabiseResultLocationResult;
		}
	}
		
	public Boolean saveRabiseResult(String laboratoryNumber,String specimeAmount,List<RabiseResultVO> rabiseResults,String detector) {
		
		rabiseDataDao.updateDetector(laboratoryNumber, detector);	
		for(int i=0;i<Integer.parseInt(specimeAmount);i++) {	
			rabiseResultDao.CreateBySampleNumber(rabiseResults.get(i).getSpecimeNumber(), rabiseResults.get(i).getResult(), rabiseResults.get(i).getTime(), detector, new Date());		
		}
		return true;
	}
	
	public List<RabiseQueryList> rabiseQuery(String laboratoryNumber,String name,String time1,String time2){
		List<RabiseQueryList> lists = new ArrayList<>();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTime1 = null;
		Date dateTime2 = null;
		
		if(!time1.trim().isEmpty()) {
			dateTime1 = java.sql.Date.valueOf(time1);
		}
		if(!time2.trim().isEmpty()) {
			dateTime2 = java.sql.Date.valueOf(time2);
		}
		
		List<RabiseData> rabiseDatas = rabiseDataDao.findRabise(laboratoryNumber, name, dateTime1 , dateTime2);
		Iterator<RabiseData> iter = rabiseDatas.iterator();
		while(iter.hasNext()) {
			RabiseData rabiseData = iter.next();
			RabiseQueryList list = new RabiseQueryList();
			list.setLaboratoryNumber(rabiseData.getLaboratoryNumber());
			list.setName(rabiseData.getName());
			list.setSex(rabiseData.getSex());
			list.setAge(rabiseData.getAgeNum() == null ? "" : rabiseData.getAgeNum()+rabiseData.getAgeUnit());			
			list.setAccidentDate(rabiseData.getAccidentDate() == null ?  "": sdf.format(rabiseData.getAccidentDate()));
			list.setSamplingDate(rabiseData.getSamplingDate() == null ?  "": sdf.format(rabiseData.getSamplingDate()));
			list.setDeliveryDate(rabiseData.getDeliveryDate() == null ?  "": sdf.format(rabiseData.getDeliveryDate()));
			list.setSamplingCompany(rabiseData.getSamplingCompany());
			lists.add(list);			
		}
		return lists;		
	}
	
	public void deleteRabise(String laboratoryNumber) {
		RabiseData rabiseData = rabiseDataDao.findLaboratoryNumber(laboratoryNumber).get(0);
		Set<RabiseResult> rabiseResults = rabiseData.getRabiseResults();
		Iterator<RabiseResult> iter = rabiseResults.iterator();
		while(iter.hasNext()) {
			rabiseResultDao.delete(iter.next());
		}
		rabiseDataDao.delete(rabiseData);
	}
	
	public void updateRabise(RabiseData rabiseData , List<RabiseResult> rabiseResults) {

		RabiseData hRabiseData = rabiseDataDao.findLaboratoryNumber(rabiseData.getLaboratoryNumber()).get(0);
		updateRabiseData(hRabiseData, rabiseData);
		
		for(int i = 0 ; i < rabiseData.getSpecimeAmount() ; i++) {
			RabiseResult rabiseResult = rabiseResults.get(i);
			RabiseResult hRabiseResult =rabiseResultDao.findSampleNumber(rabiseResult.getSampleNumber());	
			updateRabiseResult(hRabiseResult , rabiseResult , rabiseData);
		}
	}
	
	protected void updateRabiseData(RabiseData hRabiseData , RabiseData rabiseData) {
		hRabiseData.setName(rabiseData.getName());
		hRabiseData.setProfession(rabiseData.getProfession());
		hRabiseData.setSex(rabiseData.getSex());
		hRabiseData.setAgeNum(rabiseData.getAgeNum());
		hRabiseData.setAgeUnit(rabiseData.getAgeUnit());
		hRabiseData.setAddress(rabiseData.getAddress());
		hRabiseData.setAccidentDate(rabiseData.getAccidentDate());
		hRabiseData.setSamplingDate(rabiseData.getSamplingDate());
		hRabiseData.setDeliveryDate(rabiseData.getDeliveryDate());
		hRabiseData.setCollectionDate(rabiseData.getCollectionDate());
		hRabiseData.setSamplingCompany(rabiseData.getSamplingCompany());
		hRabiseData.setSamplingPerson(rabiseData.getSamplingPerson());
		hRabiseData.setDeliveryPerson(rabiseData.getDeliveryPerson());
		hRabiseData.setCollectionPerson(rabiseData.getCollectionPerson());
		hRabiseData.setDetector(rabiseData.getDetector());
		rabiseDataDao.update(hRabiseData);	
	}
	
	protected void updateRabiseResult(RabiseResult hRabiseResult , RabiseResult rabiseResult , RabiseData rabiseData) {
		hRabiseResult.setType(rabiseResult.getType());
		hRabiseResult.setResult(rabiseResult.getResult());
		hRabiseResult.setDetectionDate(rabiseResult.getDetectionDate());
		hRabiseResult.setDetector(rabiseData.getDetector());
		hRabiseResult.setModifyDate(new Date());
		rabiseResultDao.update(hRabiseResult);
		
	}
	
	public HSSFWorkbook rabiseDataToExcel(String laboratoryNumber,String name,String time1,String time2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTime1 = null;
		Date dateTime2 = null;
		if(!time1.trim().isEmpty()) {
			dateTime1 = java.sql.Date.valueOf(time1);
		}
		if(!time2.trim().isEmpty()) {
			dateTime2 = java.sql.Date.valueOf(time2);
		}
		List<RabiseData> rabiseDatas = rabiseDataDao.findRabise(laboratoryNumber, name, dateTime1 , dateTime2);
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("rabise");
        HSSFRow row=sheet.createRow(0);
        row.createCell(0).setCellValue("病例编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("年龄");
        row.createCell(4).setCellValue("职业");
        row.createCell(5).setCellValue("家庭地址");
        row.createCell(6).setCellValue("发病日期");
        row.createCell(7).setCellValue("采集日期");
        row.createCell(8).setCellValue("送样单位");
        row.createCell(9).setCellValue("送样日期");
        row.createCell(10).setCellValue("接收日期");
        row.createCell(11).setCellValue("样本编号");
        row.createCell(12).setCellValue("样本类型");
        row.createCell(13).setCellValue("检测结果");
        row.createCell(14).setCellValue("检测日期");
        int rows = 1;
        Iterator<RabiseData> iterData = rabiseDatas.iterator();
        while(iterData.hasNext()) {
			RabiseData rabiseData = iterData.next();
			Set<RabiseResult> rabiseResults = rabiseData.getRabiseResults();
			Iterator<RabiseResult> iter = rabiseResults.iterator();
			while(iter.hasNext()) {
				RabiseResult rabiseResult = iter.next();
				row=sheet.createRow(rows);
				row.createCell(0).setCellValue(rabiseData.getLaboratoryNumber());
		        row.createCell(1).setCellValue(rabiseData.getName());
		        row.createCell(2).setCellValue(rabiseData.getSex());
		        row.createCell(3).setCellValue(rabiseData.getAgeNum() == null ? "" : rabiseData.getAgeNum()+rabiseData.getAgeUnit());		        
		        row.createCell(4).setCellValue(rabiseData.getProfession());
		        row.createCell(5).setCellValue(rabiseData.getAddress());
		        row.createCell(6).setCellValue(rabiseData.getAccidentDate() == null ?  "": sdf.format(rabiseData.getAccidentDate()));
		        row.createCell(7).setCellValue(rabiseData.getSamplingDate() == null ?  "": sdf.format(rabiseData.getSamplingDate()));
		        row.createCell(8).setCellValue(rabiseData.getSamplingCompany());
		        row.createCell(9).setCellValue(rabiseData.getDeliveryDate() == null ?  "": sdf.format(rabiseData.getDeliveryDate()));
		        row.createCell(10).setCellValue(rabiseData.getCollectionDate() == null ?  "": sdf.format(rabiseData.getCollectionDate()));
		        row.createCell(11).setCellValue(rabiseResult.getSampleNumber());
		        row.createCell(12).setCellValue(rabiseResult.getType());
		        row.createCell(13).setCellValue(rabiseResult.getResult());
		        row.createCell(14).setCellValue(rabiseResult.getDetectionDate() == null ?  "": sdf.format(rabiseResult.getDetectionDate()));
		        rows = rows+1;
			}
		}			
		return wb;	
	}
	
	public List<RabiseCollectionAndResultFormVO> RabiseCollectionAndResultForm(String year){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<RabiseCollectionAndResultFormVO> list = new ArrayList<>();
		
		List<RabiseData> rabiseDatas = rabiseDataDao.findYear(year);
		
		Iterator<RabiseData> iterRabiseData = rabiseDatas.iterator();
		while(iterRabiseData.hasNext()) {
			RabiseCollectionAndResultFormVO vo = new RabiseCollectionAndResultFormVO();
			RabiseData rabiseData = iterRabiseData.next();
			
			Set<RabiseResult> rabiseResults = rabiseData.getRabiseResults();
			Iterator<RabiseResult> iterRabiseResult = rabiseResults.iterator();
			Set<String> types = new HashSet<>();
			Set<String> results = new HashSet<>();
			String result = new String();
			while(iterRabiseResult.hasNext()) {
				RabiseResult rabiseResult = iterRabiseResult.next();
				types.add(rabiseResult.getType());
				results.add(rabiseResult.getResult());			
			}
			
			if(results.contains("阳性")) {
				result = "阳性";
			}else if(results.contains("未检测")) {
				result = "未检测";	
			}else {
				result = "阴性";
			}
		
			vo.setLaboratoryNumber(rabiseData.getLaboratoryNumber());
			vo.setName(rabiseData.getName());
			vo.setSex(rabiseData.getSex());
			vo.setAge(rabiseData.getAgeNum() == null ? "" : rabiseData.getAgeNum()+rabiseData.getAgeUnit());
			vo.setProfession(rabiseData.getProfession());
			vo.setAddress(rabiseData.getAddress());
			vo.setAccidentDate(rabiseData.getAccidentDate() == null ?  "": sdf.format(rabiseData.getAccidentDate()));
			vo.setSamplingDate(rabiseData.getSamplingDate() == null ?  "": sdf.format(rabiseData.getSamplingDate()));
			vo.setSamplingCompany(rabiseData.getSamplingCompany());
			vo.setType(types.toString().substring(1, types.toString().length()-1));
			vo.setSpecimeAmount(rabiseData.getSpecimeAmount());
			vo.setDeliveryPerson(rabiseData.getDeliveryPerson());
			vo.setCollectionPerson(rabiseData.getCollectionPerson());
			vo.setCollectionDate(rabiseData.getCollectionDate() == null ?  "": sdf.format(rabiseData.getCollectionDate()));
			vo.setResult(result);
			
			list.add(vo);
		}
	
		return list;	
	}

	
	
	
	
	
}
