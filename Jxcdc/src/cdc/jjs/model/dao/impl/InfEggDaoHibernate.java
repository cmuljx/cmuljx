package cdc.jjs.model.dao.impl;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import cdc.jjs.model.dao.InfEggDao;
import cdc.jjs.model.domain.InfEgg;

public class InfEggDaoHibernate extends BaseDaoHibernate<InfEgg> implements InfEggDao {

	public InfEgg findSqlByInfID(String infID) {
		
		NativeQuery<InfEgg> sqlQuery = getSessionFactory().getCurrentSession()
					.createNativeQuery("select * from inf_separation where inf_id_egg = ?0",InfEgg.class).setParameter("0", infID);
		
		List<InfEgg> list = sqlQuery.getResultList();
		
		if(!list.isEmpty()) {	
			return list.get(0);
		}else {
			return null;
		}
	}

	public int updateEgg() {
		String hql = " UPDATE inf INNER JOIN inf_separation ON inf_separation.inf_id_egg = inf.inf_id " + 
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
				" WHERE inf.passage_history_cell = ''; ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();	
	}
	
	public int saveEgg() {
		String hql = " INSERT INTO " + 
				" inf_separation ( passage_history_egg, inf_id_egg, inoculation_date, harvest_date, blood_cell_type, " + 
				" titer_HA, identification_result, strain_name, identification_date, separation_company, " + 
				" inspection_date_cnic,received_date_cnic, identify_method_cnic, identify_result_cnic, identify_date_cnic, " + 
				" inspection_date_province, received_date_province, identify_method_province, " + 
				" identify_result_province, identify_date_province, separation_method ) " + 
				" SELECT " + 
				" inf.passage_history_egg, inf.inf_id, inf.inoculation_date, inf.harvest_date, inf.blood_cell_type, inf.titer_HA, " + 
				" inf.identification_result, inf.strain_name, inf.identification_date, inf.separation_company, " + 
				" inf.inspection_date_cnic, inf.received_date_cnic, inf.identify_method_cnic, inf.identify_result_cnic, inf.identify_date_cnic, " + 
				" inf.inspection_date_province, inf.received_date_province, inf.identify_method_province, " + 
				" inf.identify_result_province, inf.identify_date_province,'E' " + 
				" FROM inf LEFT JOIN inf_separation ON inf.inf_id = inf_separation.inf_id_egg " + 
				" WHERE ((inf_separation.inf_id_egg is null) AND (inf.passage_history_egg != '')); ";
		Query<?> query = getSessionFactory().getCurrentSession().createNativeQuery(hql);
		return query.executeUpdate();
	}

}
