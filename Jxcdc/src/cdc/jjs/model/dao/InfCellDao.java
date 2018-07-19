package cdc.jjs.model.dao;

import java.util.Date;
import java.util.List;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;
import cdc.jjs.control.inf.vo.InfReportFieldVO;
import cdc.jjs.model.domain.InfCell;

public interface InfCellDao extends BaseDao<InfCell>{
	
	public int updateCell();
	
	public int saveCell();
	
	public List<InfNucleinGenotypingVO> monthAnalysis(String company , Date startTime , Date endTime );
	
	public List<InfNucleinGenotypingVO> companyAnalysis(Integer year , Integer week , Date startTime , Date endTime );
	
	public List<InfReportFieldVO> separationReport(Date collectionDate);
}
