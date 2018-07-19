package cdc.jjs.model.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("E")
public class InfEgg extends InfSeparation{
	
	private static final long serialVersionUID = 48L;

	@Column(name="passage_history_egg")
	private String passageHistoryEgg;
	
	@OneToOne(targetEntity=InfData.class)
	@JoinColumn(name="inf_id_egg" , referencedColumnName="inf_id" , unique=true)
	private InfData infData;

	public String getPassageHistoryEgg() {
		return passageHistoryEgg;
	}

	public void setPassageHistoryEgg(String passageHistoryEgg) {
		this.passageHistoryEgg = passageHistoryEgg;
	}

	public InfData getInfData() {
		return infData;
	}

	public void setInfData(InfData infData) {
		this.infData = infData;
	}


}
