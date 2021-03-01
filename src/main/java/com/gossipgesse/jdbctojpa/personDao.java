package com.gossipgesse.jdbctojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class personDao{

	@Autowired
	private EntityManager em;
	private Logger logging= LoggerFactory.getLogger(this.getClass());
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
	
	public List<Person> findAll() {
		 TypedQuery<Person> TypePerson= em.createNamedQuery("select_person",Person.class);
		 return TypePerson.getResultList();
	}
	
	public Person createPerson(Person person) {
		if(person.getNpersoncode()==0) {
			em.persist(person);
		}else {
			em.merge(person);
		}
		return findById(person.getNpersoncode());
	}
	
	public void CheckingData() {
		logging.info("checking started--->");
		Person pp = new Person("peruuu",1);
		em.persist(pp);
		logging.info("checking started--->{}"+pp);
		em.flush();
		
		pp.setSpersonname("Sathish...");
		em.refresh(pp);
		Person pp1 = new Person("Thanuja",1);
		em.persist(pp1);
		pp1.setSpersonname("Bhavani..");
	}
	public void flushMode() {
		logging.info("Flush mode-->{}");
	}
}
