package cdc.jjs.model.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;
import cdc.jjs.model.dao.InfCellDao;
import cdc.jjs.model.dao.InfDataDao;
import cdc.jjs.model.dao.InfEggDao;
import cdc.jjs.model.dao.InfNucleinDao;
import cdc.jjs.model.dao.InfSeparationDao;
import cdc.jjs.model.service.InfAnalysisService;

public class InfAnalysisServiceImpl implements InfAnalysisService {
	
	private InfCellDao infCellDao;
	private InfDataDao infDataDao;
	private InfEggDao infEggDao;
	private InfNucleinDao infNucleinDao;
	private InfSeparationDao infSeparationDao;
	public InfCellDao getInfCellDao() {
		return infCellDao;
	}
	public void setInfCellDao(InfCellDao infCellDao) {
		this.infCellDao = infCellDao;
	}
	public InfDataDao getInfDataDao() {
		return infDataDao;
	}
	public void setInfDataDao(InfDataDao infDataDao) {
		this.infDataDao = infDataDao;
	}
	public InfEggDao getInfEggDao() {
		return infEggDao;
	}
	public void setInfEggDao(InfEggDao infEggDao) {
		this.infEggDao = infEggDao;
	}
	public InfNucleinDao getInfNucleinDao() {
		return infNucleinDao;
	}
	public void setInfNucleinDao(InfNucleinDao infNucleinDao) {
		this.infNucleinDao = infNucleinDao;
	}
	public InfSeparationDao getInfSeparationDao() {
		return infSeparationDao;
	}
	public void setInfSeparationDao(InfSeparationDao infSeparationDao) {
		this.infSeparationDao = infSeparationDao;
	}
	
	public List<InfNucleinGenotypingVO> monthAnalysis(String company , String startTime , String endTime , String flag){
		
		Date dateTime1 = null;
		Date dateTime2 = null;
		
		if(!startTime.trim().isEmpty()) {
			dateTime1 = java.sql.Date.valueOf(startTime);
		}
		if(!endTime.trim().isEmpty()) {
			dateTime2 = java.sql.Date.valueOf(endTime);
		}
		
		List<InfNucleinGenotypingVO> list = null;
		if(flag.equals("nuclein")) {
			list = infNucleinDao.monthAnalysis(company , dateTime1 , dateTime2); 
		}else if(flag.equals("cell")) {
			list = infCellDao.monthAnalysis(company, dateTime1, dateTime2);		
		}
		
		Iterator<InfNucleinGenotypingVO> iter = list.iterator();
		while(iter.hasNext()) {
			InfNucleinGenotypingVO vo = iter.next();
			
			vo.setGroup(vo.getGroup());
			vo.setPositiveRate((vo.getH3()+vo.getSH1()+vo.getVictoria()+vo.getYamagata())*100/(double)vo.getTotal());
		}		
		return list;			
	}
	
	public List<InfNucleinGenotypingVO> companyAnalysis(String year , String week , String startTime , String endTime , String flag){
		
		Date dateTime1 = null;
		Date dateTime2 = null;
		Integer weekNum = 0;
		Integer yearNum = 0;
		
		if(!startTime.trim().isEmpty()) {
			dateTime1 = java.sql.Date.valueOf(startTime);
		}
		if(!endTime.trim().isEmpty()) {
			dateTime2 = java.sql.Date.valueOf(endTime);
		}
		
		if(!week.trim().isEmpty()) {
			weekNum = Integer.parseInt(week);
		}
		
		if(!year.trim().isEmpty()) {
			yearNum = Integer.parseInt(year);
		}
		
		List<InfNucleinGenotypingVO> list = null;
		
		if(flag.equals("nuclein")) {
			list = infNucleinDao.companyAnalysis(yearNum , weekNum, dateTime1, dateTime2);
		}else if(flag.equals("cell")) {
			list = infCellDao.companyAnalysis(yearNum , weekNum, dateTime1, dateTime2);		
		} 
		
		Iterator<InfNucleinGenotypingVO> iter = list.iterator();
		while(iter.hasNext()) {
			InfNucleinGenotypingVO vo = iter.next();
			
			vo.setPositiveRate((vo.getH3()+vo.getSH1()+vo.getVictoria()+vo.getYamagata())*100/(double)vo.getTotal());
			
			if(vo.getGroup().contains("¼²²¡Ô¤·À¿ØÖÆÖÐÐÄ")) {
				vo.setGroup(vo.getGroup().replace("¼²²¡Ô¤·À¿ØÖÆÖÐÐÄ", "").trim());
			}
		}		
		return list;	
	}
	

}
