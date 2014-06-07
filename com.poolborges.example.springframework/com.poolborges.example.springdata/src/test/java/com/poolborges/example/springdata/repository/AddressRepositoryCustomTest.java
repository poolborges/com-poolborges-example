/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.repository;


import com.poolborges.example.springdata.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@Transactional
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class AddressRepositoryCustomTest {

	@Autowired
	private AddressRepository personRepository;

	@Test
	public void testSomeMethod() {

		Assert.assertEquals(143L, personRepository.someRandomMethod().longValue());
	}

}
