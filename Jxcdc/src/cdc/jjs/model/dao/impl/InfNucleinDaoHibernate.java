package cdc.jjs.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;

import cdc.jjs.control.inf.vo.InfNucleinGenotypingVO;
import cdc.jjs.control.inf.vo.InfReportFieldVO;
import cdc.jjs.model.dao.InfNucleinDao;
import cdc.jjs.model.domain.InfNuclein;

public class InfNucleinDaoHibernate extends BaseDaoHibernate<InfNuclein> implements InfNucleinDao {

	public List<InfNucleinGenotypingVO> monthAnalysis(String company , Date startTime , Date endTime ){
		StringBuffer hql = new StringBuffer("select new cdc.jjs.control.inf.vo.InfNucleinGenotypingVO( "
				+ " concat(year(n.infData.samplingDate),'年',week(n.infData.samplingDate),'周') as month, "
				+ " count(case n.nucleinResult when '季H3' then 1 else null end) as H3, "
				+ " count(case n.nucleinResult when '新甲H1' then 1 else null end) as SH1, "
				+ " count(case n.nucleinResult when 'victoria' then 1 else null end) as victoria, "
				+ " count(case n.nucleinResult when 'yamagata' then 1 else null end) as yamagata, "
				+ " count(case n.nucleinResult when '阴性' then 1 else null end) as negative, "
				+ " count(n.nucleinResult) as total) "
				+ " from InfNuclein n  where 1=1 ");
		
		List<Object> list = new ArrayList<Object>();
		if(!company.equals("全部")){
			hql.append(" and n.nucleinDetectionCompany = ? ");
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
				+ " n.nucleinDetectionCompany as CDC, "
				+ " count(case n.nucleinResult when '季H3' then 1 else null end) as H3, "
				+ " count(case n.nucleinResult when '新甲H1' then 1 else null end) as SH1, "
				+ " count(case n.nucleinResult when 'victoria' then 1 else null end) as victoria, "
				+ " count(case n.nucleinResult when 'yamagata' then 1 else null end) as yamagata, "
				+ " count(case n.nucleinResult when '阴性' then 1 else null end) as negative, "
				+ " count(n.nucleinResult) as total) "
				+ " from InfNuclein n  where 1=1 ");
		
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
		
		hql.append(" group by n.nucleinDetectionCompany ");
		Query<InfNucleinGenotypingVO> query = getSessionFactory().getCurrentSession().createQuery(hql.toString(),InfNucleinGenotypingVO.class);
		for(int i = 0 , len = list.size() ; i < len ; i++)
		{
			query.setParameter(i , list.get(i));
		}
		
		return (List<InfNucleinGenotypingVO>)query.getResultList();
	}
	
	public int updateNuclein() {
		String hql = " UPDATE inf_nuclein INNER JOIN inf ON inf_nuclein.inf_id = inf.inf_id " + 
				" SET " + 
				" inf_nuclein.nuclein_result = inf.nuclein_result, " + 
				" inf_nuclein.nuclein_detection_date = case inf.real_date when '0000-00-00' then inf.RTPCR_date else inf.real_date end, " + 
				" inf_nuclein.nuclein_detection_company = inf.nuclein_detection_company " + 
				" WHERE inf.passage_history_egg = ''; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();	
	}
	
	public int saveNuclein() {
		String hql = " INSERT INTO " + 
				" inf_nuclein ( nuclein_result, nuclein_detection_date, nuclein_detection_company, inf_id) " + 
				" SELECT " + 
				" inf.nuclein_result, " + 
				" case inf.real_date when '0000-00-00' then inf.RTPCR_date else inf.real_date end, " + 
				" inf.nuclein_detection_company, " + 
				" inf.inf_id " + 
				" FROM inf LEFT JOIN inf_nuclein ON inf.inf_id = inf_nuclein.inf_id " + 
				" WHERE ((inf_nuclein.inf_id is null) AND (inf.passage_history_egg = '') and (inf.nuclein_result!='')); ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();	
	}
	
	public List<InfReportFieldVO> nucleinReport(Date collectionDate){
		String hql = "select new cdc.jjs.control.inf.vo.InfReportFieldVO( "
				+ " n.infData.laboratoryNumber, "
				+ " n.infData.name, "
				+ " n.infData.sex, "
				+ " n.infData.age, "
				+ " '委托检测', "
				+ " '流感病毒核酸', "
				+ " n.nucleinResult, "
				+ " n.infData.collectionDate, "
				+ " n.nucleinDetectionDate, "
				+ " year(n.infData.collectionDate), "
				+ " week(n.infData.collectionDate,3)) "
				+ " from InfNuclein n  "
				+ " where n.infData.collectionDate = ?0 and n.nucleinDetectionCompany='江西省疾病预防控制中心' "
				+ " order by n.infData.laboratoryNumber ";
		
		Query<InfReportFieldVO> query = getSessionFactory().getCurrentSession().createQuery(hql,InfReportFieldVO.class)
				.setParameter("0", collectionDate);
		
		return (List<InfReportFieldVO>)query.getResultList();
		
	}
	
}
