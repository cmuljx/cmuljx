package cdc.jjs.model.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("C")
public class InfCell extends InfSeparation{
	
	private static final long serialVersionUID = 48L;
	
	@Column(name="passage_history_cell")
	private String passageHistoryCell;
	
	@OneToOne(targetEntity=InfData.class)
	@JoinColumn(name="inf_id_cell" , referencedColumnName="inf_id" , unique=true)
	private InfData infData;

	public String getPassageHistoryCell() {
		return passageHistoryCell;
	}

	public void setPassageHistoryCell(String passageHistoryCell) {
		this.passageHistoryCell = passageHistoryCell;
	}

	public InfData getInfData() {
		return infData;
	}

	public void setInfData(InfData infData) {
		this.infData = infData;
	}

	

}
