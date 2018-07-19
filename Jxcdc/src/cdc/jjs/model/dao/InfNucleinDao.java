package cdc.jjs.model.dao;

import java.util.Date;
import java.util.List;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;
import cdc.jjs.control.inf.vo.InfReportFieldVO;
import cdc.jjs.model.domain.InfNuclein;

public interface InfNucleinDao extends BaseDao<InfNuclein>{
	
	public List<InfNucleinGenotypingVO> monthAnalysis(String company , Date startTime , Date endTime );
	
	public List<InfNucleinGenotypingVO> companyAnalysis(Integer year , Integer week , Date startTime , Date endTime );
	
	public int updateNuclein();
	
	public int saveNuclein();
	
	public List<InfReportFieldVO> nucleinReport(Date collectionDate);

}
