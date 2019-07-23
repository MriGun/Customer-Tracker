package com.mrinmoy.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mrinmoy.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Customer> getCustomer() {

		//get a current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name",Customer.class);
		//execute query and get result set
		List<Customer> customers = theQuery.getResultList();
		//return results
		
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {

		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//get or retrieve date base on the id
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {

			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession(); 
			//delete object
			Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
			theQuery.setParameter("customerId",theId);
			theQuery.executeUpdate();
	}

}
