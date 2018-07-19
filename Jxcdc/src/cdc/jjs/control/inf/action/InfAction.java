package cdc.jjs.control.inf.action;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.service.InfService;

public class InfAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private InfService infService;
	public void setInfService(InfService infService) {
		this.infService = infService;
	}
	
	@Override
	public String execute() throws Exception {
		long startTime = System.currentTimeMillis();
		infService.importInfData("D:\\�����ļ�\\����\\��������\\inf.csv");
		long endTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
		
		return SUCCESS;
	}


	
	
	
	

}
