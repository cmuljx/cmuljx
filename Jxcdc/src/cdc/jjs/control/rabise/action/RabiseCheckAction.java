package cdc.jjs.control.rabise.action;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.rabise.vo.RabiseVO;
import cdc.jjs.model.service.RabiseService;

public class RabiseCheckAction extends ActionSupport {
	
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
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	private String checkNum;
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	
	private RabiseVO rabiseVO;
	private String flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public RabiseVO getRabiseVO() {
		return rabiseVO;
	}
	public void setRabiseVO(RabiseVO rabiseVO) {
		this.rabiseVO = rabiseVO;
	}
	
	@Override
	public String execute() throws Exception {		
		rabiseVO = rabiseService.rabiseResultLocation(checkNum);
		flag="check";
		
		return SUCCESS;
	}
	
	public String modify() throws Exception {
		rabiseVO = rabiseService.rabiseResultLocation(checkNum);
		flag="modify";
		
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		rabiseService.deleteRabise(checkNum);
		
		return SUCCESS;
	}

	
	
}
