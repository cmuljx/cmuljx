package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="inf_nuclein")
public class InfNuclein implements Serializable{

	private static final long serialVersionUID = 48L;
	
	@Id
	@Column(name="nuclein_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer nucleinID;
	
	@Column(name="nuclein_result")
	private String nucleinResult;
	
	@Column(name="nuclein_detection_date")
	@Temporal(TemporalType.DATE)
	private Date nucleinDetectionDate;
	
	@Column(name="nuclein_detection_company")
	private String nucleinDetectionCompany;
	
	@OneToOne(targetEntity=InfData.class)
	@JoinColumn(name="inf_id" , referencedColumnName="inf_id" , unique=true)
	private InfData infData;

	public Integer getNucleinID() {
		return nucleinID;
	}

	public void setNucleinID(Integer nucleinID) {
		this.nucleinID = nucleinID;
	}

	public String getNucleinResult() {
		return nucleinResult;
	}

	public void setNucleinResult(String nucleinResult) {
		this.nucleinResult = nucleinResult;
	}

	public Date getNucleinDetectionDate() {
		return nucleinDetectionDate;
	}

	public void setNucleinDetectionDate(Date nucleinDetectionDate) {
		this.nucleinDetectionDate = nucleinDetectionDate;
	}

	public String getNucleinDetectionCompany() {
		return nucleinDetectionCompany;
	}

	public void setNucleinDetectionCompany(String nucleinDetectionCompany) {
		this.nucleinDetectionCompany = nucleinDetectionCompany;
	}

	public InfData getInfData() {
		return infData;
	}

	public void setInfData(InfData infData) {
		this.infData = infData;
	}

}
