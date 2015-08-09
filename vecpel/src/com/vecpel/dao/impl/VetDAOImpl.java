package com.vecpel.dao.impl;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vecpel.dao.converter.VetBeanConverter;
import com.vecpel.dao.intf.VetDAO;
import com.vecpel.model.beans.ProfileBean;
import com.vecpel.model.beans.VetBean;

public class VetDAOImpl implements VetDAO{

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private Properties queries;
	   
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertNewVet(VetBean vetBean) {	
		
		ProfileBean profile = vetBean.getVetProfileBean();
		
		// Insert Vet_Profile
		String sql = queries.getProperty("insertNewVetProfile");
		int result = jdbcTemplate.update(sql, new Object[]{profile.getProfileID(), profile.getFirstName() + " " + profile.getLastName(), profile.getAddr1(), profile.getAddr2(), profile.getAddr3(), profile.getCity(), profile.getPinCode(), profile.getState(), vetBean.getVetQualification(), vetBean.getVetSpecialization()});
		
		System.out.println("Data Insertion Status in Vet_Profile Table is " + result);
		// Insert Vet_Main
		sql = queries.getProperty("insertNewVetMain");
		result = jdbcTemplate.update(sql, new Object[]{vetBean.getVetId(), vetBean.getVetProfID(), vetBean.getVetPhoto(), vetBean.getVetScore()});
		System.out.println("Data Insertion Status in Vet_Main Table is " + result);
	}

	@Override
	public VetBean getVetInfo(String id) {
		String sql = queries.getProperty("getVetById");
		VetBean vetBean = jdbcTemplate.queryForObject(sql, new Object[]{id}, new VetBeanConverter());
		System.out.println(vetBean.toString());
		return vetBean;
	}

	@Override
	public List<VetBean> listOfActiveVets() {
		String sql = queries.getProperty("getAllVets");
		List<VetBean> allVets = jdbcTemplate.query(sql, new VetBeanConverter());
		for(VetBean bean : allVets){
			System.out.println(bean.toString());
		}
		return null;
	}

	@Override
	public void deleteVet(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVetInfo(List<Object> values) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the queries
	 */
	public Properties getQueries() {
		return queries;
	}

	/**
	 * @param queries the queries to set
	 */
	public void setQueries(Properties queries) {
		this.queries = queries;
	}

}
