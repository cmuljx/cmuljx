package cdc.jjs.control.inf.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;
import cdc.jjs.model.service.InfAnalysisService;

public class InfNucleinAnalysisAction extends ActionSupport {

	private static final long serialVersionUID = 48L;
	
	private String company;
	private String startTime;
	private String endTime;
	private String weekNum;
	private String yearNum;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(String weekNum) {
		this.weekNum = weekNum;
	}
	public String getYearNum() {
		return yearNum;
	}
	public void setYearNum(String yearNum) {
		this.yearNum = yearNum;
	}


	private InfAnalysisService infAnalysisService;
	public void setInfAnalysisService(InfAnalysisService infAnalysisService) {
		this.infAnalysisService = infAnalysisService;
	}
	
	List<InfNucleinGenotypingVO> listWeek;
	public List<InfNucleinGenotypingVO> getListWeek() {
		return listWeek;
	}
	public void setListWeek(List<InfNucleinGenotypingVO> listWeek) {
		this.listWeek = listWeek;
	}	
	
	List<InfNucleinGenotypingVO> listCompany;
	public List<InfNucleinGenotypingVO> getListCompany() {
		return listCompany;
	}
	public void setListCompany(List<InfNucleinGenotypingVO> listCompany) {
		this.listCompany = listCompany;
	}
	
	@Override
	public String execute() throws Exception {
		listWeek = infAnalysisService.monthAnalysis(company , startTime , endTime , "nuclein");
		listCompany = infAnalysisService.companyAnalysis(yearNum , weekNum, startTime, endTime , "nuclein");
		
		int leng = listCompany.size() ;
		for(int i = 0; i < 13 - leng ; i++) {
			InfNucleinGenotypingVO vo = new InfNucleinGenotypingVO();
			listCompany.add(vo);
		}
		return SUCCESS;
	}

}
