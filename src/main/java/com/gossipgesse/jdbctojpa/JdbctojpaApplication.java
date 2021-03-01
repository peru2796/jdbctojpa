package com.gossipgesse.jdbctojpa;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class JdbctojpaApplication implements CommandLineRunner{

	@Autowired
	private personDao dao;
		private Logger logging= LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(JdbctojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logging.info("getFromDatabase -->{}"+dao.findById(1));
//		logging.info("Insert Person --->{}"+dao.createPerson(new Person("vjfvndfjkvdfv",1)));
		logging.info("Insert Person --->{}"+dao.createPerson(new Person("ppdfndsknsd",1)));
//		dao.CheckingData();
//		dao.flushMode();
		logging.info("Find All Element --->{}"+dao.findAll());
	}

}
