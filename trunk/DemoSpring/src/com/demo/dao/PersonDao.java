package com.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.demo.dom.Person;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PersonDao  extends BaseRepository<Person>{


	public  List<Person> getAllPerson(){
		return em.createQuery("select p from Person p").getResultList();
	}



}

