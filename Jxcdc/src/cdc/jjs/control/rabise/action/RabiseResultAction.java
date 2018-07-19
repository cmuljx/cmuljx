package cdc.jjs.control.rabise.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.rabise.vo.RabiseResultVO;
import cdc.jjs.model.service.RabiseService;

public class RabiseResultAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private List<RabiseResultVO> rabiseResults; 
	private String laboratoryNumberRead;
	private String specimeAmount;
	private String detector;
	public List<RabiseResultVO> getRabiseResults() {
		return rabiseResults;
	}
	public void setRabiseResults(List<RabiseResultVO> rabiseResults) {
		this.rabiseResults = rabiseResults;
	}
	public String getLaboratoryNumberRead() {
		return laboratoryNumberRead;
	}
	public void setLaboratoryNumberRead(String laboratoryNumberRead) {
		this.laboratoryNumberRead = laboratoryNumberRead;
	}
	public String getSpecimeAmount() {
		return specimeAmount;
	}
	public void setSpecimeAmount(String specimeAmount) {
		this.specimeAmount = specimeAmount;
	}
	public String getDetector() {
		return detector;
	}
	public void setDetector(String detector) {
		this.detector = detector;
	}
	
	private RabiseService rabiseService;	
	public void setRabiseService(RabiseService rabiseService) {
		this.rabiseService = rabiseService;
	}
	
	@Override
	public String execute() throws Exception {
		rabiseService.saveRabiseResult(laboratoryNumberRead , specimeAmount, rabiseResults, detector);
		return SUCCESS;
	}

}
