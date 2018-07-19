package cdc.jjs.control.rabise.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.rabise.vo.RabiseCollectionAndResultFormVO;
import cdc.jjs.model.service.RabiseService;

public class RabiseCollectionAndResultFormAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private String year;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	private List<RabiseCollectionAndResultFormVO> list = new ArrayList<>();
	public List<RabiseCollectionAndResultFormVO> getList() {
		return list;
	}
	public void setList(List<RabiseCollectionAndResultFormVO> list) {
		this.list = list;
	}
	
	@Override
	public String execute() throws Exception {
		
		list = rabiseService.RabiseCollectionAndResultForm(year);
		
		return SUCCESS;
	}
	

}
