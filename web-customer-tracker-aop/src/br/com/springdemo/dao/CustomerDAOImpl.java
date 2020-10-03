package br.com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private final SessionFactory sessionFactory;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);
		return query.getResultList();
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer find(Long customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void delete(Long customerId) {
		Session session = sessionFactory.getCurrentSession();

//		Query query = session.createQuery("DELETE FROM Customer WHERE id =: customerId");
//		query.setParameter("customerId", customerId);
//		query.executeUpdate();
		
		Customer customer = find(customerId);
		session.delete(customer);
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
	}

}
