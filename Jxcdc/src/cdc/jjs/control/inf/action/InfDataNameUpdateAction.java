package cdc.jjs.control.inf.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.model.service.InfService;

public class InfDataNameUpdateAction extends ActionSupport {
	
	private static final long serialVersionUID = 48L;
	
	private InfService infService;
	public void setInfService(InfService infService) {
		this.infService = infService;
	}
	
	private String collectionDate;
	private String laboratoryNumber;
	private String name;
	private Integer number;
	public String getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getLaboratoryNumber() {
		return laboratoryNumber;
	}
	public void setLaboratoryNumber(String laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public String execute() throws Exception {
		
		@SuppressWarnings("rawtypes")
		List<List> list= infService.findCollectionDate(collectionDate);
		
		if(list.isEmpty()) {
			flag = false;
		}else {
			flag = true;
			laboratoryNumber = (String)list.get(0).get(0);
			name = (String)list.get(0).get(1);
			number = 1;
		}
		return SUCCESS;
	}
	
	public String pre() throws Exception {
		
		@SuppressWarnings("rawtypes")
		List<List> list= infService.findCollectionDate(collectionDate);
		
		if(number > 1) {
			infService.updateInfDataName(laboratoryNumber, name);
			flag = true;
			laboratoryNumber = (String)list.get(number-2).get(0);
			name = (String)list.get(number-2).get(1);
			number--;
		}else {
			infService.updateInfDataName(laboratoryNumber, name);
			flag = false;
		}
		
		return SUCCESS;
	}

	public String next() throws Exception {
		
		@SuppressWarnings("rawtypes")
		List<List> list= infService.findCollectionDate(collectionDate);
		
		int length = list.size();
		if(number < length) {
			infService.updateInfDataName(laboratoryNumber, name);
			flag = true;
			laboratoryNumber = (String)list.get(number).get(0);
			name = (String)list.get(number).get(1);
			number++;	
		}else {
			infService.updateInfDataName(laboratoryNumber, name);
			flag = false;
		}
		
		return SUCCESS;
	}
}
