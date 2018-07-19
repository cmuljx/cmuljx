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
		infService.importInfData("D:\\工作文件\\流感\\流感数据\\inf.csv");
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
		
		return SUCCESS;
	}


	
	
	
	

}
