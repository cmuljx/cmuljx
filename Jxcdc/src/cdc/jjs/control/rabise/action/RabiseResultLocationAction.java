package cdc.jjs.control.rabise.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.rabise.vo.RabiseVO;
import cdc.jjs.model.domain.RabiseResult;
import cdc.jjs.model.service.RabiseService;

public class RabiseResultLocationAction extends ActionSupport{

	private static final long serialVersionUID = 48L;
	
	private String laboratoryNumber;
	public String getLaboratoryNumber() {
		return laboratoryNumber;
	}
	public void setLaboratoryNumber(String laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	private String name;
	private String samplingCompany;
	private Integer specimeAmount;
	private List<RabiseResult> rabiseResults;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSamplingCompany() {
		return samplingCompany;
	}
	public void setSamplingCompany(String samplingCompany) {
		this.samplingCompany = samplingCompany;
	}
	public Integer getSpecimeAmount() {
		return specimeAmount;
	}
	public void setSpecimeAmount(Integer specimeAmount) {
		this.specimeAmount = specimeAmount;
	}
	public List<RabiseResult> getRabiseResults() {
		return rabiseResults;
	}
	public void setRabiseResults(List<RabiseResult> rabiseResults) {
		this.rabiseResults = rabiseResults;
	}


	@Override
	public String execute() throws Exception {
		RabiseVO rabiseResultLocationResult = rabiseService.rabiseResultLocation(laboratoryNumber);
		if(rabiseResultLocationResult==null) {
			this.specimeAmount = 0;		
		}else {
			this.name = rabiseResultLocationResult.getRabiseData().getName();
			this.samplingCompany = rabiseResultLocationResult.getRabiseData().getSamplingCompany();
			this.specimeAmount = rabiseResultLocationResult.getRabiseData().getSpecimeAmount();		
			this.rabiseResults = rabiseResultLocationResult.getRabiseResults();
		}

		return SUCCESS;
	}


	
}
