package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDAO {

	private SessionFactory sessionFactory;

	// @Autowired
	// public CountryDAO(@Qualifier("OracleDB") HibernateCUInterface hibernateobj) {
	// this.sessionFactory = hibernateobj.getSessionFactory();
	// }
	
	public List<Country> getAllCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = session.createQuery("from Country").list();
		return countryList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Country getCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, new Integer(id));
		return country;
	}

	public Country addCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		// session.beginTransaction();
		session.save(country);
		// session.getTransaction().commit();
		return country;
	}

	public void updateCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(country);
	}

	public void deleteCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country p = (Country) session.load(Country.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
}
