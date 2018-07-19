package cdc.jjs.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@DiscriminatorColumn(name="separation_method" , discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("S")
@Table(name = "inf_separation")
public class InfSeparation implements Serializable{
	
	private static final long serialVersionUID = 48L;
	
	@Id
	@Column(name="separation_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer SeparationID;
	
	private InfResult infResult;
	
	private InfCNIC infCNIC;
	
	private InfProvince infProvince;

	public Integer getSeparationID() {
		return SeparationID;
	}

	public void setSeparationID(Integer separationID) {
		SeparationID = separationID;
	}

	public InfResult getInfResult() {
		return infResult;
	}

	public void setInfResult(InfResult infResult) {
		this.infResult = infResult;
	}

	public InfCNIC getInfCNIC() {
		return infCNIC;
	}

	public void setInfCNIC(InfCNIC infCNIC) {
		this.infCNIC = infCNIC;
	}

	public InfProvince getInfProvince() {
		return infProvince;
	}

	public void setInfProvince(InfProvince infProvince) {
		this.infProvince = infProvince;
	}

}
