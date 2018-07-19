package cdc.jjs.control.rabise.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.rabise.vo.RabiseVO;
import cdc.jjs.model.service.RabiseService;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RabiseReportAction extends ActionSupport {
	
	private static final long serialVersionUID = 48L;
	
	private String laboratoryNumber;
	public String getLaboratoryNumber() {
		return laboratoryNumber;
	}
	public void setLaboratoryNumber(String laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}
	
	private String specimenSpecification;
	private String specimenNum;
	private String specimenState;
	private String specimenPacking;
	public String getSpecimenSpecification() {
		return specimenSpecification;
	}
	public void setSpecimenSpecification(String specimenSpecification) {
		this.specimenSpecification = specimenSpecification;
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
	public String getSpecimenNum() {
		return specimenNum;
	}
	public void setSpecimenNum(String specimenNum) {
		this.specimenNum = specimenNum;
	}

	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	private Map<String, Object> map = new HashMap<String, Object>();
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	
	@Override
	public String execute() throws Exception {
		
		RabiseVO rabise = rabiseService.rabiseResultLocation(laboratoryNumber);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ"); 
		
		Set<String> type =new HashSet<String>();
		for(int i=0 ; i < rabise.getRabiseData().getSpecimeAmount() ; i++) {
			type.add(rabise.getRabiseResults().get(i).getType());
		}	
		StringBuffer types = new StringBuffer();
		Iterator<String> iter = type.iterator();	
		while(iter.hasNext()) {
			types.append(iter.next());
			types.append("¡¢");
		}
		types.deleteCharAt(types.length() - 1);		
				
		map.put("reportNumber", rabise.getRabiseData().getReportNumber());
		map.put("laboratoryNumber", rabise.getRabiseData().getLaboratoryNumber());
		map.put("samplingCompany", rabise.getRabiseData().getSamplingCompany());
		map.put("deliveryDate", sdf.format(rabise.getRabiseData().getDeliveryDate()));
		map.put("specimenType", types.toString());
		map.put("detectionDate", sdf.format(rabise.getRabiseResults().get(0).getDetectionDate()));
		map.put("detectionPrinciple", "È«¹ú¿ñÈ®²¡¼à²â·½°¸£¨¸½¼þ2)");
		map.put("detectionMethod", "ºËËá¼ì²â");
		map.put("specimenSpecification", specimenSpecification + "\n" + specimenNum);
		map.put("specimenState", specimenState);
		map.put("specimenPacking", specimenPacking);
		map.put("reportDate", sdf.format(new Date()));
		map.put("detector", rabise.getRabiseResults().get(0).getDetector());
		
		Map<String, Object> maps;
		for(int i=0 ; i < rabise.getRabiseData().getSpecimeAmount() ; i++) {
			maps = new HashMap<String, Object>();
			maps.put("specimenNumber", rabise.getRabiseResults().get(i).getSampleNumber());
			maps.put("name", rabise.getRabiseData().getName());
			maps.put("sex", rabise.getRabiseData().getSex());
			maps.put("age", rabise.getRabiseData().getAgeNum()+rabise.getRabiseData().getAgeUnit());
			maps.put("detectionType", "Î¯ÍÐ¼ì²â");
			maps.put("detetionProject", "¿ñÈ®²¡¶¾");
			maps.put("result", rabise.getRabiseResults().get(i).getResult());	
			list.add(maps);
		}	
		
		if(rabise.getRabiseData().getSpecimeAmount() < 4) {
			maps = new HashMap<String, Object>();
			maps.put("specimenNumber","ÒÔÏÂ¿Õ°×");
			maps.put("name", " ");
			maps.put("sex", " ");
			maps.put("age", " ");
			maps.put("detectionType", " ");
			maps.put("detetionProject", " ");
			maps.put("result", " ");
			list.add(maps);
		}
		
		for(int i=0 ; i < 4-rabise.getRabiseData().getSpecimeAmount()-1 ; i++) {
			maps = new HashMap<String, Object>();
			maps.put("specimenNumber","");
			maps.put("name", " ");
			maps.put("sex", " ");
			maps.put("age", " ");
			maps.put("detectionType", " ");
			maps.put("detetionProject", " ");
			maps.put("result", " ");
			list.add(maps);
		}
		
		String sourceURL = (String) ActionContext.getContext().getApplication().get("sourceURL");		
		String sourceFileName = ServletActionContext.getServletContext().getRealPath("/") + "/source/jasperreports/rabiseReport.jasper";
		String destFileName = sourceURL + "rabise/report/"  + rabise.getRabiseData().getReportNumber() + ".pdf";
		JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(list);
		JasperRunManager.runReportToPdfFile(sourceFileName, destFileName, map, jrDataSource);	
		
		return SUCCESS;
	}
	
}
