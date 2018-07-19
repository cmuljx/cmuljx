package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rabise_data")
public class RabiseData implements Serializable{
	
	private static final long serialVersionUID = 48L;

	@Id
	@Column(name="rabise_data_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rabiseDataID;
	
	@Column(name="laboratory_Number" , nullable=false , unique=true)
	private String laboratoryNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="profession")
	private String profession;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="age_num")
	private Integer ageNum;
	
	@Column(name="age_unit")
	private String ageUnit;
	
	@Column(name="address")
	private String address;
	
	@Column(name="accident_Date")
	@Temporal(TemporalType.DATE)
	private Date accidentDate;
	
	@Column(name="sampling_date")
	@Temporal(TemporalType.DATE)
	private Date samplingDate;
	
	@Column(name="delivery_Date")
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	
	@Column(name="collection_Date")
	@Temporal(TemporalType.DATE)
	private Date collectionDate;
	
	@Column(name="specime_amount")
	private Integer specimeAmount;
	
	@Column(name="sampling_company")
	private String samplingCompany;
	
	@Column(name="sampling_person")
	private String samplingPerson;
	
	@Column(name="delivery_person")
	private String deliveryPerson;
	
	@Column(name="collection_person")
	private String collectionPerson;
	
	@Column(name="detector")
	private String detector;

	@Column(name="year")
	private String year;
	
	@Column(name="report_number")
	private String reportNumber;
	
	@Column(name="report_URL")
	private String reportURL;

	@Column(name="create_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="modify_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	@OneToMany(targetEntity=RabiseResult.class,mappedBy="rabiseData")
	@OrderBy("sampleNumber")
	private Set<RabiseResult> rabiseResults=new HashSet<>();
	
	public RabiseData() {
		
	}
	
	public RabiseData(String laboratoryNumber,String name,String samplingCompany,Integer specimeAmount,String collectionPerson) {
		this.laboratoryNumber = laboratoryNumber;
		this.name = name;
		this.samplingCompany = samplingCompany;
		this.specimeAmount = specimeAmount;
		this.collectionPerson = collectionPerson;
	}

	public Integer getRabiseDataID() {
		return rabiseDataID;
	}

	public void setRabiseDataID(Integer rabiseDataID) {
		this.rabiseDataID = rabiseDataID;
	}

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public String getReportURL() {
		return reportURL;
	}

	public void setReportURL(String reportURL) {
		this.reportURL = reportURL;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Set<RabiseResult> getRabiseResults() {
		return rabiseResults;
	}

	public void setRabiseResults(Set<RabiseResult> rabiseResults) {
		this.rabiseResults = rabiseResults;
	}
	
	public String getDetector() {
		return detector;
	}

	public void setDetector(String detector) {
		this.detector = detector;
	}

}
