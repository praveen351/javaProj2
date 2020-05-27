package com.OAS.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.OAS.entity.CandidateStatus;
import com.OAS.entity.TestQuestionAnswer;
import com.OAS.entity.TestQuestionOption;
import com.OAS.entity.TestSubject;
import com.OAS.entity.Users;

@Component("H2DB")
public class HibernateConnect implements HibernateCUInterface {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:mem:test");
				settings.put(Environment.USER, "sa");
				settings.put(Environment.PASS, "");
				settings.put(Environment.POOL_SIZE, 1);
				settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.C3P0_MIN_SIZE, 5);
				settings.put(Environment.C3P0_MAX_SIZE, 20);
				settings.put(Environment.C3P0_MAX_STATEMENTS, 300);
				settings.put(Environment.C3P0_TIMEOUT, 50);
				settings.put(Environment.C3P0_IDLE_TEST_PERIOD, 3000);

				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Users.class);
				configuration.addAnnotatedClass(CandidateStatus.class);
				configuration.addAnnotatedClass(TestSubject.class);
				configuration.addAnnotatedClass(TestQuestionAnswer.class);
				configuration.addAnnotatedClass(TestQuestionOption.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public void shutdown() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
