package cdc.jjs.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Parent;

@Embeddable
public class InfCNIC implements Serializable{
	
	private static final long serialVersionUID = 48L;
	
	@Column(name="inspection_date_cnic")
	@Temporal(TemporalType.DATE)
	private Date inspectionDateCNIC;
	
	@Column(name="received_date_cnic")
	@Temporal(TemporalType.DATE)
	private Date receivedDateCNIC;
	
	@Column(name="identify_method_cnic")
	private String identifyMethodCNIC;
	
	@Column(name="identify_result_cnic")
	private String identifyResultCNIC;

	@Column(name="identify_date_cnic")
	@Temporal(TemporalType.DATE)
	private Date identifyDateCNIC;
	
	@Parent
	private InfSeparation infSeparation;

	public Date getInspectionDateCNIC() {
		return inspectionDateCNIC;
	}

	public void setInspectionDateCNIC(Date inspectionDateCNIC) {
		this.inspectionDateCNIC = inspectionDateCNIC;
	}

	public Date getReceivedDateCNIC() {
		return receivedDateCNIC;
	}

	public void setReceivedDateCNIC(Date receivedDateCNIC) {
		this.receivedDateCNIC = receivedDateCNIC;
	}

	public String getIdentifyMethodCNIC() {
		return identifyMethodCNIC;
	}

	public void setIdentifyMethodCNIC(String identifyMethodCNIC) {
		this.identifyMethodCNIC = identifyMethodCNIC;
	}

	public String getIdentifyResultCNIC() {
		return identifyResultCNIC;
	}

	public void setIdentifyResultCNIC(String identifyResultCNIC) {
		this.identifyResultCNIC = identifyResultCNIC;
	}

	public Date getIdentifyDateCNIC() {
		return identifyDateCNIC;
	}

	public void setIdentifyDateCNIC(Date identifyDateCNIC) {
		this.identifyDateCNIC = identifyDateCNIC;
	}

	public InfSeparation getInfSeparation() {
		return infSeparation;
	}

	public void setInfSeparation(InfSeparation infSeparation) {
		this.infSeparation = infSeparation;
	}

}
