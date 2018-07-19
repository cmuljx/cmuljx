package cdc.jjs.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;
import cdc.jjs.control.inf.vo.InfReportFieldVO;
import cdc.jjs.model.dao.InfCellDao;
import cdc.jjs.model.domain.InfCell;

public class InfCellDaoHibernate extends BaseDaoHibernate<InfCell> implements InfCellDao {

	public int updateCell() {
		String hql = " UPDATE inf INNER JOIN inf_separation ON inf_separation.inf_id_cell = inf.inf_id " + 
				" SET " + 
				" inf_separation.inoculation_date = inf.inoculation_date, " + 
				" inf_separation.harvest_date = inf.harvest_date, " + 
				" inf_separation.blood_cell_type = inf.blood_cell_type, " + 
				" inf_separation.titer_HA = inf.titer_HA, " + 
				" inf_separation.identification_result = inf.identification_result, " + 
				" inf_separation.strain_name = inf.strain_name, " + 
				" inf_separation.identification_date = inf.identification_date, " + 
				" inf_separation.separation_company = inf.separation_company, " + 
				" inf_separation.inspection_date_cnic = inf.inspection_date_cnic, " + 
				" inf_separation.received_date_cnic = inf.received_date_cnic, " + 
				" inf_separation.identify_method_cnic = inf.identify_method_cnic, " + 
				" inf_separation.identify_result_cnic = inf.identify_result_cnic, " + 
				" inf_separation.identify_date_cnic = inf.identify_date_cnic, " + 
				" inf_separation.inspection_date_province = inf.inspection_date_province, " + 
				" inf_separation.received_date_province = inf.received_date_province, " + 
				" inf_separation.identify_method_province = inf.identify_method_province, " + 
				" inf_separation.identify_result_province = inf.identify_result_province, " + 
				" inf_separation.identify_date_province = inf.identify_date_province " + 
				" WHERE inf.passage_history_egg = ''; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();	
	}
	
	public int saveCell() {
		String hql = " INSERT INTO " + 
				" inf_separation ( passage_history_cell, inf_id_cell, inoculation_date, harvest_date, blood_cell_type, " + 
				" titer_HA, identification_result, strain_name, identification_date, separation_company, " + 
				" inspection_date_cnic,received_date_cnic, identify_method_cnic, identify_result_cnic, identify_date_cnic, " + 
				" inspection_date_province, received_date_province, identify_method_province, " + 
				" identify_result_province, identify_date_province, separation_method ) " + 
				" SELECT " + 
				" inf.passage_history_cell, inf.inf_id, inf.inoculation_date, inf.harvest_date, inf.blood_cell_type, inf.titer_HA, " + 
				" inf.identification_result, inf.strain_name, inf.identification_date, inf.separation_company, " + 
				" inf.inspection_date_cnic, inf.received_date_cnic, inf.identify_method_cnic, inf.identify_result_cnic, inf.identify_date_cnic, " + 
				" inf.inspection_date_province, inf.received_date_province, inf.identify_method_province, " + 
				" inf.identify_result_province, inf.identify_date_province,'C' " + 
				" FROM inf LEFT JOIN inf_separation ON inf.inf_id = inf_separation.inf_id_cell " + 
				" WHERE ((inf_separation.inf_id_cell is null) AND (inf.passage_history_cell != '')); ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();
	}

	public List<InfNucleinGenotypingVO> monthAnalysis(String company , Date startTime , Date endTime ){
		StringBuffer hql = new StringBuffer("select new cdc.jjs.control.inf.vo.InfNucleinGenotypingVO( "
				+ " concat(year(n.infData.samplingDate),'年',week(n.infData.samplingDate),'周') as month, "
				+ " count(case n.infResult.identificationResult when '季H3' then 1 else null end) as H3, "
				+ " count(case n.infResult.identificationResult when '新甲H1' then 1 else null end) as SH1, "
				+ " count(case n.infResult.identificationResult when 'victoria' then 1 else null end) as victoria, "
				+ " count(case n.infResult.identificationResult when 'yamagata' then 1 else null end) as yamagata, "
				+ " count(case n.infResult.identificationResult when '阴性' then 1 else null end) as negative, "
				+ " count(n.infResult.identificationResult) as total) "
				+ " from InfCell n  where 1=1 ");
		
		List<Object> list = new ArrayList<Object>();
		if(!company.equals("全部")){
			hql.append(" and n.infResult.separationCompany = ? ");
			list.add(company);
		}
		
		if(startTime != null){
			hql.append(" and n.infData.samplingDate >= ? ");
			list.add(startTime);
		}
		if(endTime != null){
			hql.append(" and n.infData.samplingDate <= ? ");
			list.add(endTime);
		}
		
		hql.append(" group by year(n.infData.samplingDate) , week(n.infData.samplingDate) ");
		Query<InfNucleinGenotypingVO> query = getSessionFactory().getCurrentSession().createQuery(hql.toString(),InfNucleinGenotypingVO.class);
		for(int i = 0 , len = list.size() ; i < len ; i++)
		{
			query.setParameter(i , list.get(i));
		}
		
		return (List<InfNucleinGenotypingVO>)query.getResultList();
	}
	
	public List<InfNucleinGenotypingVO> companyAnalysis(Integer year , Integer week , Date startTime , Date endTime ){
		StringBuffer hql = new StringBuffer("select new cdc.jjs.control.inf.vo.InfNucleinGenotypingVO( "
				+ " n.infResult.separationCompany as CDC, "
				+ " count(case n.infResult.identificationResult when '季H3' then 1 else null end) as H3, "
				+ " count(case n.infResult.identificationResult when '新甲H1' then 1 else null end) as SH1, "
				+ " count(case n.infResult.identificationResult when 'victoria' then 1 else null end) as victoria, "
				+ " count(case n.infResult.identificationResult when 'yamagata' then 1 else null end) as yamagata, "
				+ " count(case n.infResult.identificationResult when '阴性' then 1 else null end) as negative, "
				+ " count(n.infResult.identificationResult) as total) "
				+ " from InfCell n  where 1=1 ");
		
		List<Object> list = new ArrayList<Object>();
		if(week != 0){
			hql.append(" and week(n.infData.samplingDate) = ? ");
			list.add(week);
		}
		
		if(year != 0){
			hql.append(" and year(n.infData.samplingDate) = ? ");
			list.add(year);
		}
		
		if(startTime != null){
			hql.append(" and n.infData.samplingDate >= ? ");
			list.add(startTime);
		}
		if(endTime != null){
			hql.append(" and n.infData.samplingDate <= ? ");
			list.add(endTime);
		}
		
		hql.append(" group by n.infResult.separationCompany ");
		Query<InfNucleinGenotypingVO> query = getSessionFactory().getCurrentSession().createQuery(hql.toString(),InfNucleinGenotypingVO.class);
		for(int i = 0 , len = list.size() ; i < len ; i++)
		{
			query.setParameter(i , list.get(i));
		}
		
		return (List<InfNucleinGenotypingVO>)query.getResultList();
	}
	
	public List<InfReportFieldVO> separationReport(Date collectionDate){
		String hql = "select new cdc.jjs.control.inf.vo.InfReportFieldVO( "
				+ " n.infData.laboratoryNumber, "
				+ " n.infData.name, "
				+ " n.infData.sex, "
				+ " n.infData.age, "
				+ " '委托检测', "
				+ " '流感分离', "
				+ " n.infResult.identificationResult, "
				+ " n.infData.collectionDate, "
				+ " n.infResult.inoculationDate, "
				+ " n.infResult.identificationDate, "
				+ " year(n.infData.collectionDate), "
				+ " week(n.infData.collectionDate,3)) "
				+ " from InfCell n  "
				+ " where n.infData.collectionDate = ?0 and n.infResult.separationCompany='江西省疾病预防控制中心' "
				+ " order by n.infData.laboratoryNumber ";
		
		Query<InfReportFieldVO> query = getSessionFactory().getCurrentSession().createQuery(hql,InfReportFieldVO.class)
				.setParameter("0", collectionDate);
		
		return (List<InfReportFieldVO>)query.getResultList();
	}
}
