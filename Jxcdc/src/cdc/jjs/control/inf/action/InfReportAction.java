package cdc.jjs.control.inf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.inf.vo.InfReportFieldVO;
import cdc.jjs.model.service.InfService;

public class InfReportAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private InfService infService;
	public InfService getInfService() {
		return infService;
	}
	public void setInfService(InfService infService) {
		this.infService = infService;
	}
	private String collectionDate;
	private String samplingCompany;
	private String specimenType;
	private String detectionPrinciple;
	private String detectionMethod;
	private String specimenSize;
	private String specimenNum;
	private String specimenState;
	private String specimenPacking;
	private String detector;
	private String flag;
	public String getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getSamplingCompany() {
		return samplingCompany;
	}
	public void setSamplingCompany(String samplingCompany) {
		this.samplingCompany = samplingCompany;
	}
	public String getSpecimenType() {
		return specimenType;
	}
	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}
	public String getDetectionPrinciple() {
		return detectionPrinciple;
	}
	public void setDetectionPrinciple(String detectionPrinciple) {
		this.detectionPrinciple = detectionPrinciple;
	}
	public String getDetectionMethod() {
		return detectionMethod;
	}
	public void setDetectionMethod(String detectionMethod) {
		this.detectionMethod = detectionMethod;
	}
	public String getSpecimenSize() {
		return specimenSize;
	}
	public void setSpecimenSize(String specimenSize) {
		this.specimenSize = specimenSize;
	}
	public String getSpecimenNum() {
		return specimenNum;
	}
	public void setSpecimenNum(String specimenNum) {
		this.specimenNum = specimenNum;
	}
	public String getSpecimenState() {
		return specimenState;
	}
	public void setSpecimenState(String specimenState) {
		this.specimenState = specimenState;
	}
	public String getSpecimenPacking() {
		return specimenPacking;
	}
	public void setSpecimenPacking(String specimenPacking) {
		this.specimenPacking = specimenPacking;
	}
	public String getDetector() {
		return detector;
	}
	public void setDetector(String detector) {
		this.detector = detector;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	List<InfReportFieldVO> field;
	private Map<String, Object> paremeter = new HashMap<String, Object>();
	public List<InfReportFieldVO> getField() {
		return field;
	}
	public void setField(List<InfReportFieldVO> field) {
		this.field = field;
	}
	public Map<String, Object> getParemeter() {
		return paremeter;
	}
	public void setParemeter(Map<String, Object> paremeter) {
		this.paremeter = paremeter;
	}
	
	public boolean returnFlag;
	public boolean isReturnFlag() {
		return returnFlag;
	}
	public void setReturnFlag(boolean returnFlag) {
		this.returnFlag = returnFlag;
	}
	
	@Override
	public String execute() throws Exception {
		if(flag.equals("N")) {
			field = infService.nucleinReport(collectionDate , flag);
			System.out.println(flag);
			int size = field.size();
			SimpleDateFormat df = new SimpleDateFormat("yyyy年M月d日");		
			
			String reportNumber = "J" + field.get(0).getYear() + "35" + StringUtils.leftPad(field.get(0).getWeek()+"", 2, "0");
			String laboratoryNumber = field.get(0).getSpecimenNumber() + "~" + field.get(size-1).getSpecimenNumber();
			String deliveryDate = df.format(field.get(0).getCollectionDate());
			String detectionDate = df.format(field.get(0).getNucleinDetectionDate());
			String specimenSpecification = specimenSize + "\n" + specimenNum;
			String reportDate = df.format(new Date());
			
			paremeter.put("reportNumber", reportNumber);
			paremeter.put("laboratoryNumber", laboratoryNumber);
			paremeter.put("samplingCompany", samplingCompany);
			paremeter.put("deliveryDate", deliveryDate);
			paremeter.put("specimenType", specimenType);
			paremeter.put("detectionDate", detectionDate);
			paremeter.put("detectionPrinciple", detectionPrinciple);
			paremeter.put("detectionMethod", detectionMethod);
			paremeter.put("specimenSpecification", specimenSpecification);
			paremeter.put("specimenState", specimenState);
			paremeter.put("specimenPacking", specimenPacking);
			paremeter.put("reportDate", reportDate);
			paremeter.put("detector", detector);
			
			if(size<12) {
				InfReportFieldVO infReportFieldVO = new InfReportFieldVO();
				infReportFieldVO.setSpecimenNumber("以下空白");
				field.add(infReportFieldVO);
				for(int i = 0 ; i < 11-size ; i++) {
					infReportFieldVO = new InfReportFieldVO();
					field.add(infReportFieldVO);
				}
				return "nuclein12";
			}else if(size == 12){
				return "nuclein12";
			}else if(size < 26) {
				InfReportFieldVO infReportFieldVO = new InfReportFieldVO();
				infReportFieldVO.setSpecimenNumber("以下空白");
				field.add(infReportFieldVO);
				for(int i = 0 ; i < 25-size ; i++) {
					infReportFieldVO = new InfReportFieldVO();
					field.add(infReportFieldVO);
				}
				return "nuclein26";
			}else if(size == 26){
				return "nuclein26";
			}
		}else if(flag.equals("C")){
			field = infService.nucleinReport(collectionDate , flag);
			int size = field.size();
			SimpleDateFormat df = new SimpleDateFormat("yyyy年M月d日");
					
			String reportNumber = "J" + field.get(0).getYear() + "30" + StringUtils.leftPad(field.get(0).getWeek()+"", 2, "0");
			String laboratoryNumber = "/";
			String deliveryDate = df.format(field.get(0).getCollectionDate());
			String detectionDate = df.format(field.get(0).getInoculationDate()) + "~" + df.format(field.get(0).getIdentificationDate());
			String specimenSpecification = specimenSize + "\n" + specimenNum;
			String reportDate = df.format(new Date());
			
			paremeter.put("reportNumber", reportNumber);
			paremeter.put("laboratoryNumber", laboratoryNumber);
			paremeter.put("samplingCompany", samplingCompany);
			paremeter.put("deliveryDate", deliveryDate);
			paremeter.put("specimenType", specimenType);
			paremeter.put("detectionDate", detectionDate);
			paremeter.put("detectionPrinciple", detectionPrinciple);
			paremeter.put("detectionMethod", detectionMethod);
			paremeter.put("specimenSpecification", specimenSpecification);
			paremeter.put("specimenState", specimenState);
			paremeter.put("specimenPacking", specimenPacking);
			paremeter.put("reportDate", reportDate);
			paremeter.put("detector", detector);
			
			if(size<15) {
				InfReportFieldVO infReportFieldVO = new InfReportFieldVO();
				infReportFieldVO.setSpecimenNumber("以下空白");
				field.add(infReportFieldVO);
				for(int i = 0 ; i < 11-size ; i++) {
					infReportFieldVO = new InfReportFieldVO();
					field.add(infReportFieldVO);
				}
				return "separation15";
			}else if(size == 15){
				return "separation15";
			}else if(size < 26) {
				InfReportFieldVO infReportFieldVO = new InfReportFieldVO();
				infReportFieldVO.setSpecimenNumber("以下空白");
				field.add(infReportFieldVO);
				for(int i = 0 ; i < 25-size ; i++) {
					infReportFieldVO = new InfReportFieldVO();
					field.add(infReportFieldVO);
				}
				return "separation26";
			}else if(size == 26){
				return "separation26";
			}
		}
		return "other";
	}
	
	public String collectionDateFind() throws Exception {
		
			if(infService.nucleinReport(collectionDate , flag) == null) {
				returnFlag = false;
			}else {
				returnFlag = true;
			}
		return SUCCESS;
	}
	


}
