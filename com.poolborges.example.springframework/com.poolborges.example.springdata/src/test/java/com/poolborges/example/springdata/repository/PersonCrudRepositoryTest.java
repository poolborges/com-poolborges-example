/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.poolborges.example.springdata.domain.Person;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@Transactional
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class PersonCrudRepositoryTest {

    @Autowired
    private PersonCrudRepository personRepository;

    @Test
    @Rollback(false)
    public void testCreate() {
        Person p = new Person();
        p.setFirstName("Test");
        p.setLastName("Data");
        p.setGenderCode("M");

        p = personRepository.save(p);
        Assert.assertNotNull(p.getId());
        System.out.println("Created Id: " + p.getId());
    }

    @Test
    public void testFindByLastName() {

        List<Person> lastNameList = personRepository.findByLastName("Doe");
        Assert.assertEquals(2, lastNameList.size());
    }
    
    @Test
	public void testGetLastNameCount() {

		Long count = personRepository.getLastNameCount("Doe");
		Assert.assertEquals(2L, count.longValue());
	}

}
