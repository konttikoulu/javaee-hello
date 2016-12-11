package com.tahonen.ocp.demos.hello.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tahonen.ocp.demos.hello.model.Customer;

@ApplicationScoped
public class CustomerRepo {

	@Inject
	private EntityManager em;

	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}

	public Customer findByEmail(String email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = cb.createQuery(Customer.class);
		Root<Customer> customer = criteria.from(Customer.class);
		criteria.select(customer).where(cb.equal(customer.get("email"), email));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Customer> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = cb.createQuery(Customer.class);
		Root<Customer> customer = criteria.from(Customer.class);
		criteria.select(customer).orderBy(cb.asc(customer.get("name")));
		return em.createQuery(criteria).getResultList();
	}
}
