package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parent;

@Embeddable
public class InfProvince implements Serializable{
	
	private static final long serialVersionUID = 48L;
	
	@Column(name="inspection_date_province")
	@Temporal(TemporalType.DATE)
	private Date inspectionDateProvince;
	
	@Column(name="received_date_province")
	@Temporal(TemporalType.DATE)
	private Date receivedDateProvince;
	
	@Column(name="identify_method_province")
	private String identifyMethodProvince;
	
	@Column(name="identify_result_province")
	private String identifyResultProvince;

	@Column(name="identify_date_province")
	@Temporal(TemporalType.DATE)
	private Date identifyDateProvince;	
	
	@Parent
	private InfSeparation infSeparation;

	public Date getInspectionDateProvince() {
		return inspectionDateProvince;
	}

	public void setInspectionDateProvince(Date inspectionDateProvince) {
		this.inspectionDateProvince = inspectionDateProvince;
	}

	public Date getReceivedDateProvince() {
		return receivedDateProvince;
	}

	public void setReceivedDateProvince(Date receivedDateProvince) {
		this.receivedDateProvince = receivedDateProvince;
	}

	public String getIdentifyMethodProvince() {
		return identifyMethodProvince;
	}

	public void setIdentifyMethodProvince(String identifyMethodProvince) {
		this.identifyMethodProvince = identifyMethodProvince;
	}

	public String getIdentifyResultProvince() {
		return identifyResultProvince;
	}

	public void setIdentifyResultProvince(String identifyResultProvince) {
		this.identifyResultProvince = identifyResultProvince;
	}

	public Date getIdentifyDateProvince() {
		return identifyDateProvince;
	}

	public void setIdentifyDateProvince(Date identifyDateProvince) {
		this.identifyDateProvince = identifyDateProvince;
	}

	public InfSeparation getInfSeparation() {
		return infSeparation;
	}

	public void setInfSeparation(InfSeparation infSeparation) {
		this.infSeparation = infSeparation;
	}
	
}
