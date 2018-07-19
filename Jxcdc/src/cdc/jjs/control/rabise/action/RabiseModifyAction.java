package cdc.jjs.control.rabise.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.domain.RabiseData;
import cdc.jjs.model.domain.RabiseResult;
import cdc.jjs.model.service.RabiseService;

public class RabiseModifyAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private String queryLaboratoryNumber;
	private String queryName;
	private String queryTime1;
	private String queryTime2;
	private RabiseData rabiseData;
	private List<RabiseResult> rabiseResults; 
	public String getQueryLaboratoryNumber() {
		return queryLaboratoryNumber;
	}
	public void setQueryLaboratoryNumber(String queryLaboratoryNumber) {
		this.queryLaboratoryNumber = queryLaboratoryNumber;
	}
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public String getQueryTime1() {
		return queryTime1;
	}
	public void setQueryTime1(String queryTime1) {
		this.queryTime1 = queryTime1;
	}
	public String getQueryTime2() {
		return queryTime2;
	}
	public void setQueryTime2(String queryTime2) {
		this.queryTime2 = queryTime2;
	}
	public RabiseData getRabiseData() {
		return rabiseData;
	}
	public void setRabiseData(RabiseData rabiseData) {
		this.rabiseData = rabiseData;
	}
	public List<RabiseResult> getRabiseResults() {
		return rabiseResults;
	}
	public void setRabiseResults(List<RabiseResult> rabiseResults) {
		this.rabiseResults = rabiseResults;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	@Override
	public String execute() throws Exception {
		
		rabiseService.updateRabise(rabiseData, rabiseResults);

		
		return SUCCESS;
	}

}
