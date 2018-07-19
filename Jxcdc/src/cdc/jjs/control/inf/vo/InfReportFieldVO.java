package cdc.jjs.control.inf.vo;

import java.util.Date;

public class InfReportFieldVO {
	
	private String specimenNumber;
	private String name;
	private String sex;
	private String age;
	private String detectionType;
	private String detetionProject;
	private String result;
	private Date collectionDate;
	private Date nucleinDetectionDate;
	private Integer year;
	private Integer week;
	private Date inoculationDate;
	private Date identificationDate;
	
	public InfReportFieldVO() {
		
	}
	
	public InfReportFieldVO(String specimenNumber,String name,String sex,String age,
			String detectionType,String detetionProject,String result,Date collectionDate,
			Date nucleinDetectionDate,Integer year,Integer week) {
		this.specimenNumber = specimenNumber;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.detectionType = detectionType;
		this.detetionProject = detetionProject;
		this.result = result;
		this.collectionDate = collectionDate;
		this.nucleinDetectionDate = nucleinDetectionDate;
		this.year = year;
		this.week = week;
	}
	
	public InfReportFieldVO(String specimenNumber,String name,String sex,String age,
			String detectionType,String detetionProject,String result,Date collectionDate,
			Date inoculationDate , Date identificationDate,Integer year,Integer week) {
		this.specimenNumber = specimenNumber;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.detectionType = detectionType;
		this.detetionProject = detetionProject;
		this.result = result;
		this.collectionDate = collectionDate;
		this.inoculationDate = inoculationDate;
		this.identificationDate = identificationDate;
		this.year = year;
		this.week = week;
	}
	
	public String getSpecimenNumber() {
		return specimenNumber;
	}
	public void setSpecimenNumber(String specimenNumber) {
		this.specimenNumber = specimenNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDetectionType() {
		return detectionType;
	}
	public void setDetectionType(String detectionType) {
		this.detectionType = detectionType;
	}
	public String getDetetionProject() {
		return detetionProject;
	}
	public void setDetetionProject(String detetionProject) {
		this.detetionProject = detetionProject;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}
	public Date getNucleinDetectionDate() {
		return nucleinDetectionDate;
	}
	public void setNucleinDetectionDate(Date nucleinDetectionDate) {
		this.nucleinDetectionDate = nucleinDetectionDate;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public Date getInoculationDate() {
		return inoculationDate;
	}

	public void setInoculationDate(Date inoculationDate) {
		this.inoculationDate = inoculationDate;
	}

	public Date getIdentificationDate() {
		return identificationDate;
	}

	public void setIdentificationDate(Date identificationDate) {
		this.identificationDate = identificationDate;
	}
}
