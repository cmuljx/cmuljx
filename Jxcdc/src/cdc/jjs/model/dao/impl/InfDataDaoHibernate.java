package cdc.jjs.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;

import cdc.jjs.model.dao.InfDataDao;
import cdc.jjs.model.domain.InfData;

public class InfDataDaoHibernate extends BaseDaoHibernate<InfData> implements InfDataDao {

	public InfData findInfID(String infID) {
		
		List<InfData> list = find("select i from InfData i where i.infID=?0",infID);
		
		if(!list.isEmpty()) {	
			return list.get(0);
		}else {
			return null;
		}		
	}

	@SuppressWarnings("rawtypes")
	public List<List> findCollectionDate(Date collectionDate) {
		
		String hql = " select new List(i.laboratoryNumber , i.name) from InfData i where i.collectionDate=?0 and i.collectionCompany = '江西省疾病预防控制中心' order by i.laboratoryNumber ";
		
		@SuppressWarnings("unchecked")
		Query<List> query = getSessionFactory().getCurrentSession().createQuery(hql).setParameter("0", collectionDate);
		return (List<List>)query.getResultList();
		
	}
	
	public int updateInfDataName(String laboratoryNumber , String name) {
		
		return updateHQL(" update InfData i set i.name = ?0 where i.laboratoryNumber=?1 and i.collectionCompany = '江西省疾病预防控制中心' " , name , laboratoryNumber);
		
	}
	
	public int updateData() {
		String hql = " UPDATE inf_data INNER JOIN inf ON inf_data.inf_id = inf.inf_id " + 
				" SET " + 
				" inf_data.inf_id = inf.inf_id, " + 
				" inf_data.laboratory_number = inf.laboratory_number, " + 
				" inf_data.name = inf.name, " + 
				" inf_data.sex = inf.sex, " + 
				" inf_data.age = inf.age, " + 
				" inf_data.profession = inf.profession, " + 
				" inf_data.address = inf.address, " + 
				" inf_data.accident_date = inf.accident_date, " + 
				" inf_data.sampling_date = inf.sampling_date, " + 
				" inf_data.sampling_company = inf.sampling_company, " + 
				" inf_data.specimen_species = inf.specimen_species, " + 
				" inf_data.specimen_source = inf.specimen_source, " + 
				" inf_data.collection_date = inf.collection_date, " + 
				" inf_data.collection_company = inf.collection_company " + 
				" WHERE inf.passage_history_egg = ''; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();	
	}
	
	public int saveData() {
		String hql = " INSERT INTO " + 
				" inf_data ( inf_id, laboratory_number, name, sex, age, profession, address, " + 
				" accident_date, sampling_date, sampling_company, specimen_species, " + 
				" specimen_source, collection_date, collection_company ) " + 
				" SELECT " + 
				" inf.inf_id, inf.laboratory_number, inf.name, inf.sex, inf.age, inf.profession, " + 
				" inf.address, inf.accident_date, inf.sampling_date, inf.sampling_company, " + 
				" inf.specimen_species, inf.specimen_source, inf.collection_date, inf.collection_company " + 
				" FROM inf LEFT JOIN inf_data ON inf.inf_id = inf_data.inf_id " + 
				" WHERE ((inf_data.inf_id is null) AND (inf.passage_history_egg = '')); ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();
	}
	
	public int deleteInf() {
		String hql = " delete from inf; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();	
	}
	
	public int importInf(String filePath) {
		String hql = " load data local infile ?0 " + 
				" into table inf character set gb2312 " + 
				" fields terminated by ',' optionally enclosed by '\"' escaped by '\"' " + 
				" lines terminated by '\\r\\n' " + 
				" ignore 1 lines; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql).setParameter("0", filePath);
		return query.executeUpdate();	
		
	}
	
	public void updataInf() {
		String hql1 = " UPDATE inf SET inspection_date_cnic = null WHERE inspection_date_cnic = 0000-00-00; ";
		Query<?> query1 = getSessionFactory().getCurrentSession().createNativeQuery(hql1);
		query1.executeUpdate();	
		
		String hql2 = " UPDATE inf SET received_date_cnic = null WHERE received_date_cnic = 0000-00-00; ";
		Query<?> query2 = getSessionFactory().getCurrentSession().createNativeQuery(hql2);
		query2.executeUpdate();
		
		String hql3 = " UPDATE inf SET identify_date_cnic = null WHERE identify_date_cnic = 0000-00-00; ";
		Query<?> query3 = getSessionFactory().getCurrentSession().createNativeQuery(hql3);
		query3.executeUpdate();
		
		String hql4 = " UPDATE inf SET inspection_date_province = null WHERE inspection_date_province = 0000-00-00; ";
		Query<?> query4 = getSessionFactory().getCurrentSession().createNativeQuery(hql4);
		query4.executeUpdate();
		
		String hql5 = " UPDATE inf SET received_date_province = null WHERE received_date_province = 0000-00-00; ";
		Query<?> query5 = getSessionFactory().getCurrentSession().createNativeQuery(hql5);
		query5.executeUpdate();
		
		String hql6 = " UPDATE inf SET identify_date_province = null WHERE identify_date_province = 0000-00-00; ";
		Query<?> query6 = getSessionFactory().getCurrentSession().createNativeQuery(hql6);
		query6.executeUpdate();
		/**
		String hql7 = " UPDATE inf SET inoculation_date = null WHERE inoculation_date = 0000-00-00; ";
		Query<?> query7 = getSessionFactory().getCurrentSession().createNativeQuery(hql7);
		query7.executeUpdate();
		
		String hql8 = " UPDATE inf SET harvest_date = null WHERE harvest_date = 0000-00-00; ";
		Query<?> query8 = getSessionFactory().getCurrentSession().createNativeQuery(hql8);
		query8.executeUpdate();
		
		String hql9 = " UPDATE inf SET identification_date = null WHERE identification_date = 0000-00-00; ";
		Query<?> query9 = getSessionFactory().getCurrentSession().createNativeQuery(hql9);
		query9.executeUpdate();
		*/
	}
	
	public boolean findInfEgg() {
		String hql = " select inf_id from inf where passage_history_egg != '' ; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.getResultList().isEmpty();	
	}
	
	
	
	
	
	
	
}
