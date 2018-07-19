package cdc.jjs.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cdc.jjs.control.inf.vo.InfReportFieldVO;
import cdc.jjs.model.dao.InfCellDao;
import cdc.jjs.model.dao.InfDataDao;
import cdc.jjs.model.dao.InfEggDao;
import cdc.jjs.model.dao.InfNucleinDao;
import cdc.jjs.model.dao.InfSeparationDao;
import cdc.jjs.model.service.InfService;

public class InfServiceImpl implements InfService {
	
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
	
	public void importInfData(String CSVFile) throws Exception {
		
	}
	
	public List<Integer> saveAndUpdateInf(String filePath) {
		List<Integer> list = new ArrayList<>();
		
		list.add(infDataDao.importInf(filePath));
		infDataDao.updataInf();
		list.add(infDataDao.saveData());
		list.add(infDataDao.updateData());
		list.add(infNucleinDao.saveNuclein());
		list.add(infNucleinDao.updateNuclein());
		list.add(infCellDao.saveCell());
		list.add(infCellDao.updateCell());
		
		if(!infDataDao.findInfEgg()) {
			list.add(infEggDao.saveEgg());
			list.add(infEggDao.updateEgg());
		}
		list.add(infDataDao.deleteInf());
		
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List<List> findCollectionDate(String collectionDate){
			
		Date dateTime = java.sql.Date.valueOf(collectionDate);
		
		return infDataDao.findCollectionDate(dateTime);
		
	}
	
	public int updateInfDataName(String laboratoryNumber , String name){
		
		return infDataDao.updateInfDataName(laboratoryNumber, name);
		
	}
	
	public List<InfReportFieldVO> nucleinReport(String collectionDate , String flag){
				
		Date date = java.sql.Date.valueOf(collectionDate);	
		
		List<InfReportFieldVO> list = new ArrayList<>();
		if(flag.equals("N")) {
			list = infNucleinDao.nucleinReport(date);		
		}else if(flag.equals("C")) {
			list = infCellDao.separationReport(date);	
		}

		for(int i = 0 ; i < list.size() ; i++) {	
			String laboratoryNumber = list.get(i).getSpecimenNumber().substring(7, 11) + "LGY" + list.get(i).getSpecimenNumber().substring(2, 6);	
			list.get(i).setSpecimenNumber(laboratoryNumber);
		}
		
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
	}
	
	
	
	
	
	
}
