package cdc.jjs.control.inf.vo;

public class InfReportParameterVO {
	
	private String reportNumber;
	private String laboratoryNumber;
	private String samplingCompany;
	private String deliveryDate;
	private String specimenType;
	private String detectionDate;
	private String detectionPrinciple;
	private String detectionMethod;
	private String specimenSpecification;
	private String specimenState;
	private String specimenPacking;
	private String reportDate;
	private String detector;
	
	public InfReportParameterVO() {
		
	}
	
	public InfReportParameterVO(String reportNumber,String laboratoryNumber,String samplingCompany,String deliveryDate,
			String specimenType,String detectionDate,String detectionPrinciple,String detectionMethod,
			String specimenSpecification,String specimenState,String specimenPacking,String reportDate,String detector) {
		this.reportNumber = reportNumber;
		this.laboratoryNumber = laboratoryNumber;
		this.samplingCompany = samplingCompany;
		this.deliveryDate = deliveryDate;
		this.specimenType = specimenType;
		this.detectionDate = detectionDate;
		this.detectionPrinciple = detectionPrinciple;
		this.detectionMethod = detectionMethod;
		this.specimenSpecification = specimenSpecification;
		this.specimenState = specimenState;
		this.specimenPacking = specimenPacking;
		this.reportDate = reportDate;
		this.detector = detector;
	}

	public String getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
	public String getLaboratoryNumber() {
		return laboratoryNumber;
	}
	public void setLaboratoryNumber(String laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}
	public String getSamplingCompany() {
		return samplingCompany;
	}
	public void setSamplingCompany(String samplingCompany) {
		this.samplingCompany = samplingCompany;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getSpecimenType() {
		return specimenType;
	}
	public void setSpecimenType(String specimenType) {
		this.specimenType = specimenType;
	}
	public String getDetectionDate() {
		return detectionDate;
	}
	public void setDetectionDate(String detectionDate) {
		this.detectionDate = detectionDate;
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
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getDetector() {
		return detector;
	}
	public void setDetector(String detector) {
		this.detector = detector;
	}
	
}
