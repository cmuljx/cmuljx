package cdc.jjs.control.inf.action;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.service.InfService;

public class InfDemoAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private InfService infService;
	public InfService getInfService() {
		return infService;
	}
	public void setInfService(InfService infService) {
		this.infService = infService;
	}
	
	@Override
	public String execute() throws Exception {
		
		
		return SUCCESS;
	}




	
	

}
