package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rabise_result")
public class RabiseResult implements Serializable{
	
	private static final long serialVersionUID = 48L;

	@Id
	@Column(name="rabise_result_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rabiseResultID;
	
	@Column(name="sample_Number" , nullable=false , unique=true)
	private String sampleNumber;
	
	@Column(name="type")
	private String type;
	
	@Column(name="result")
	private String result;
	
	@Column(name="detection_Date")
	@Temporal(TemporalType.DATE)
	private Date detectionDate;
	
	@Column(name="detector")
	private String detector;
	
	@Column(name="create_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="modify_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	@ManyToOne(targetEntity=RabiseData.class)
	@JoinColumn(name="laboratory_Number", referencedColumnName="laboratory_Number",nullable=false)
	private RabiseData rabiseData;
	
	public RabiseResult() {
		
	}
	
	public RabiseResult(String sampleNumber,String type,String result) {
		this.sampleNumber = sampleNumber;
		this.type = type;
		this.result = result;
	}
	
	public Integer getRabiseResultID() {
		return rabiseResultID;
	}

	public void setRabiseResultID(Integer rabiseResultID) {
		this.rabiseResultID = rabiseResultID;
	}

	public String getSampleNumber() {
		return sampleNumber;
	}

	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getDetectionDate() {
		return detectionDate;
	}

	public void setDetectionDate(Date detectionDate) {
		this.detectionDate = detectionDate;
	}

	public String getDetector() {
		return detector;
	}

	public void setDetector(String detector) {
		this.detector = detector;
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

	public RabiseData getRabiseData() {
		return rabiseData;
	}

	public void setRabiseData(RabiseData rabiseData) {
		this.rabiseData = rabiseData;
	}

}
