package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parent;

@Embeddable
public class InfResult implements Serializable{
	
	private static final long serialVersionUID = 48L;
	
	@Column(name="inoculation_date")
	@Temporal(TemporalType.DATE)
	private Date inoculationDate;
	
	@Column(name="harvest_date")
	@Temporal(TemporalType.DATE)
	private Date harvestDate;
	
	@Column(name="blood_cell_type")
	private String bloodCellType;
	
	@Column(name="titer_HA")
	private String titerHA;
	
	@Column(name="identification_result")
	private String identificationResult;
	
	@Column(name="strain_name")
	private String strainName;
	
	@Column(name="identification_date")
	@Temporal(TemporalType.DATE)
	private Date identificationDate;
	
	@Column(name="separation_company")
	private String separationCompany;
	
	@Parent
	private InfSeparation infSeparation;

	public Date getInoculationDate() {
		return inoculationDate;
	}

	public void setInoculationDate(Date inoculationDate) {
		this.inoculationDate = inoculationDate;
	}

	public Date getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(Date harvestDate) {
		this.harvestDate = harvestDate;
	}

	public String getBloodCellType() {
		return bloodCellType;
	}

	public void setBloodCellType(String bloodCellType) {
		this.bloodCellType = bloodCellType;
	}

	public String getTiterHA() {
		return titerHA;
	}

	public void setTiterHA(String titerHA) {
		this.titerHA = titerHA;
	}

	public String getIdentificationResult() {
		return identificationResult;
	}

	public void setIdentificationResult(String identificationResult) {
		this.identificationResult = identificationResult;
	}

	public String getStrainName() {
		return strainName;
	}

	public void setStrainName(String strainName) {
		this.strainName = strainName;
	}

	public Date getIdentificationDate() {
		return identificationDate;
	}

	public void setIdentificationDate(Date identificationDate) {
		this.identificationDate = identificationDate;
	}

	public String getSeparationCompany() {
		return separationCompany;
	}

	public void setSeparationCompany(String separationCompany) {
		this.separationCompany = separationCompany;
	}

	public InfSeparation getInfSeparation() {
		return infSeparation;
	}

	public void setInfSeparation(InfSeparation infSeparation) {
		this.infSeparation = infSeparation;
	}

	

}
