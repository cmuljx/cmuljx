package cdc.jjs.control.rabise.vo;

import java.util.List;

import cdc.jjs.model.domain.RabiseData;
import cdc.jjs.model.domain.RabiseResult;

public class RabiseVO {
	
	private RabiseData rabiseData;
	private List<RabiseResult> rabiseResults;
	
	public List<RabiseResult> getRabiseResults() {
		return rabiseResults;
	}
	public void setRabiseResults(List<RabiseResult> rabiseResults) {
		this.rabiseResults = rabiseResults;
	}
	public RabiseData getRabiseData() {
		return rabiseData;
	}
	public void setRabiseData(RabiseData rabiseData) {
		this.rabiseData = rabiseData;
	}

}
