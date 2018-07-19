package cdc.jjs.control.rabise.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.rabise.vo.RabiseQueryList;
import cdc.jjs.model.service.RabiseService;

public class RabiseQueryAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private String queryLaboratoryNumber;
	private String queryName;
	private String queryTime1;
	private String queryTime2;	
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
	
	private String checkNum;
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}

	private List<RabiseQueryList> rabiseQueryLists = new ArrayList<>();
	public List<RabiseQueryList> getRabiseQueryLists() {
		return rabiseQueryLists;
	}
	public void setRabiseQueryLists(List<RabiseQueryList> rabiseQueryLists) {
		this.rabiseQueryLists = rabiseQueryLists;
	}
	
	@Override
	public String execute() throws Exception {
		if(queryLaboratoryNumber.trim().isEmpty() && queryName.trim().isEmpty() && queryTime1.trim().isEmpty() && queryTime2.trim().isEmpty()){
			
		}else {
			rabiseQueryLists = rabiseService.rabiseQuery(queryLaboratoryNumber, queryName, queryTime1, queryTime2);
		}
		return SUCCESS;
	}

	

}
