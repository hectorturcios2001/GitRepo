package com.vecpel.test;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vecpel.dao.impl.VetDAOImpl;
import com.vecpel.model.beans.ProfileBean;
import com.vecpel.model.beans.VetBean;

public class Test {

	static ApplicationContext context = new ClassPathXmlApplicationContext("com/vecpel/model/beans/xml/spring.xml");
	
	public static void main(String[] args) {
		VetDAOImpl vetDB = (VetDAOImpl) context.getBean("vetDAO");
		//vetDB.insertNewVet(FillVetBean(2));
		//System.out.println(vetDB.getVetInfo("VET0002").toString());
		vetDB.listOfActiveVets();
	}
	
	public static VetBean FillVetBean(int index){
		
		VetBean vetBean = (VetBean) context.getBean("vet");
		
		vetBean.setVetId("VET000"+index);
		vetBean.setVetProfID("VETPROF000"+index);
		
		File image = new File("C:\\Users\\ankita\\Pictures\\TestPic.JPG");
		vetBean.setVetPhoto(image);
		
		ProfileBean profile = (ProfileBean) context.getBean("profile");
		profile.setProfileID(vetBean.getVetProfID());
		profile.setFirstName("Sourabh");
		profile.setLastName("Mishra");
		profile.setAddr1("Koramangala");
		profile.setCity("Bangalore");
		profile.setPinCode(560095L);
		profile.setState("Karnataka");
		
		vetBean.setVetProfileBean(profile);
		vetBean.setVetQualification("MBBS");
		vetBean.setVetSpecialization("Dogs");
		vetBean.setVetQualification("10");
		
		return vetBean;
	}

}
