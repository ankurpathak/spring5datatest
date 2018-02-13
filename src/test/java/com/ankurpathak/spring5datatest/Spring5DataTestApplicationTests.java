package com.ankurpathak.spring5datatest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5DataTestApplicationTests {

	@Autowired
	private INameRepository nameRepository;

	@Autowired
	private MongoTemplate mongoTemplate;


	@Test
	public void contextLoads() {

		//should save to names0
		Name.i = 0;
		assert Name.i == 0;
		nameRepository.save(new Name("Ankur", "Pathak"));
		Query queryNamesFirst = new Query(Criteria.where("firstName").in(Arrays.asList("Ankur")));
		//names 0 is not empty test by specifying collection name
		assert !mongoTemplate.find(queryNamesFirst, Name.class, String.format("names%s",Name.i)).isEmpty();



		//should save to names1
		Name.i = 1;
		assert Name.i == 1;
		nameRepository.save(new Name("Ashish", "Nipane"));
		Query queryNamesSecond = new Query(Criteria.where("firstName").in(Arrays.asList("Ashish")));
		//names 1 is not empty test by specifying collection name
		assert !mongoTemplate.find(queryNamesSecond, Name.class, String.format("names%s",Name.i)).isEmpty();


		Name.i = 0;
		assert Name.i == 0;
		//names 0 is not empty by repository method
		assert !nameRepository.findByFirstName("Ankur").isEmpty();

		Name.i = 1;
		assert Name.i == 1;
		//names 1 is not empty by repository method
		assert !nameRepository.findByFirstName("Ashish").isEmpty();


		Name.i = 2;
		assert Name.i == 2;
		//names 1 is empty by repository method
		assert nameRepository.findByFirstName("Ashish").isEmpty();



	}




}
