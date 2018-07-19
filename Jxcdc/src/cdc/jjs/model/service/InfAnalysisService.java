package cdc.jjs.model.service;

import java.util.List;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;

public interface InfAnalysisService {
	
	public List<InfNucleinGenotypingVO> monthAnalysis(String company , String startTime , String endTime , String flag);
	
	public List<InfNucleinGenotypingVO> companyAnalysis(String year , String week , String startTime , String endTime , String flag);

}
