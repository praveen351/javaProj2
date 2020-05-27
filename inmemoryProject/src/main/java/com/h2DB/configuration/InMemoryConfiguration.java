package com.h2DB.configuration;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.h2DB.model.CreditCardEligibility;
import com.h2DB.service.CreditCardEligibilityService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.h2DB.configuration", "com.h2DB.controller", "com.h2DB.imp" , "com.h2DB.serviceImp" , "com.h2DB.util" })
public class InMemoryConfiguration {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	@Bean
	@Autowired
	public Object insertData(CreditCardEligibilityService service) {
		List<CreditCardEligibility> bulkData = Arrays.asList(
							new CreditCardEligibility("AXSSP1122H" , 3.10f) , 
							new CreditCardEligibility("APPSA3355P" , 8.50f ) , 
							new CreditCardEligibility("APPXA2244X" , 9.50f) ,
							new CreditCardEligibility("AXVPS7766V" , 1.50f) ,
							new CreditCardEligibility("ASXPS2121S" , 5.10f)
							);
		service.addBulkInsertData(bulkData);
		return new Object();
	}
	@Bean(initMethod="start",destroyMethod="stop")
	public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
	   return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8092");
	}
}
