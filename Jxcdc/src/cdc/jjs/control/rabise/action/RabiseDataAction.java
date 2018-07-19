package cdc.jjs.control.rabise.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.domain.RabiseData;
import cdc.jjs.model.domain.RabiseResult;
import cdc.jjs.model.service.RabiseService;

public class RabiseDataAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private String laboratoryNumber;
	private String name;
	private String profession;
	private String sex;
	private Integer ageNum;
	private String ageUnit;
	private String address;
	private Date accidentDate;
	private Date samplingDate;
	private Date deliveryDate;
	private Date collectionDate;
	private Integer specimeAmount;
	private String samplingCompany;
	private String samplingPerson;
	private String deliveryPerson;
	private String collectionPerson;
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	public String getLaboratoryNumber() {
		return laboratoryNumber;
	}
	public void setLaboratoryNumber(String laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAgeNum() {
		return ageNum;
	}
	public void setAgeNum(Integer ageNum) {
		this.ageNum = ageNum;
	}
	public String getAgeUnit() {
		return ageUnit;
	}
	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}
	public Date getSamplingDate() {
		return samplingDate;
	}
	public void setSamplingDate(Date samplingDate) {
		this.samplingDate = samplingDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}
	public Integer getSpecimeAmount() {
		return specimeAmount;
	}
	public void setSpecimeAmount(Integer specimeAmount) {
		this.specimeAmount = specimeAmount;
	}
	public String getSamplingCompany() {
		return samplingCompany;
	}
	public void setSamplingCompany(String samplingCompany) {
		this.samplingCompany = samplingCompany;
	}
	public String getSamplingPerson() {
		return samplingPerson;
	}
	public void setSamplingPerson(String samplingPerson) {
		this.samplingPerson = samplingPerson;
	}
	public String getDeliveryPerson() {
		return deliveryPerson;
	}
	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}
	public String getCollectionPerson() {
		return collectionPerson;
	}
	public void setCollectionPerson(String collectionPerson) {
		this.collectionPerson = collectionPerson;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	@Override
	public String execute() throws Exception {
		
		List<RabiseResult> rabiseResults = new ArrayList<>();
		
		RabiseData rabiseData = new RabiseData(laboratoryNumber, name, samplingCompany, specimeAmount, collectionPerson);		
		rabiseData.setAddress(address);
		rabiseData.setProfession(profession);
		rabiseData.setAgeNum(ageNum);
		rabiseData.setAgeUnit(ageUnit);
		rabiseData.setSex(sex);
		rabiseData.setAccidentDate(accidentDate);
		rabiseData.setCollectionDate(collectionDate);
		rabiseData.setDeliveryDate(deliveryDate);
		rabiseData.setSamplingDate(samplingDate);
		rabiseData.setSamplingPerson(samplingPerson);
		rabiseData.setCollectionPerson(collectionPerson);
		rabiseData.setDeliveryPerson(deliveryPerson);
		rabiseData.setYear(laboratoryNumber.substring(0, 4));
		rabiseData.setReportNumber(laboratoryNumber);	
		rabiseData.setCreateDate(new Date());
		rabiseData.setModifyDate(new Date());
		rabiseData.setReportNumber("J" + laboratoryNumber.substring(0, 4) +"60" + laboratoryNumber.substring(6, 8));
		
		RabiseResult rabiseResult = new RabiseResult(laboratoryNumber, type1,"Î´¼ì²â");
		rabiseResult.setCreateDate(new Date());
		rabiseResult.setModifyDate(new Date());
		RabiseResult rabiseResult1 = new RabiseResult(laboratoryNumber+"-1", type1,"Î´¼ì²â");
		rabiseResult1.setCreateDate(new Date());
		rabiseResult1.setModifyDate(new Date());
		RabiseResult rabiseResult2 = new RabiseResult(laboratoryNumber+"-2", type2,"Î´¼ì²â");
		rabiseResult2.setCreateDate(new Date());
		rabiseResult2.setModifyDate(new Date());
		RabiseResult rabiseResult3 = new RabiseResult(laboratoryNumber+"-3", type3,"Î´¼ì²â");
		rabiseResult3.setCreateDate(new Date());
		rabiseResult3.setModifyDate(new Date());
		RabiseResult rabiseResult4 = new RabiseResult(laboratoryNumber+"-4", type4,"Î´¼ì²â");
		rabiseResult4.setCreateDate(new Date());
		rabiseResult4.setModifyDate(new Date());
		switch (specimeAmount) {
		case 1:
			rabiseResults.add(rabiseResult);
			break;
		case 2:
			rabiseResults.add(rabiseResult1);
			rabiseResults.add(rabiseResult2);
			break;
		case 3:
			rabiseResults.add(rabiseResult1);
			rabiseResults.add(rabiseResult2);
			rabiseResults.add(rabiseResult3);
			break;
		case 4:
			rabiseResults.add(rabiseResult1);
			rabiseResults.add(rabiseResult2);
			rabiseResults.add(rabiseResult3);
			rabiseResults.add(rabiseResult4);
			break;
		}
		
		if(rabiseService.saveRabiseData(rabiseData, rabiseResults)) {
			return SUCCESS;
		}else{
			return ERROR;
		}
			
	}
	
	
	
	
	
}
