package com.firststep.dao.entities;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.*;
import org.junit.runner.*;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.hibernate.*;
import org.junit.*;

import java.io.*;
@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
@Transactional
public class EmployeeTester {

	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession;
	
	@Before
	public void openSession(){
		currentSession = sessionFactory.getCurrentSession();
	}
	
	@Test
	public void m1shouldHaveSessionFactory(){
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void m2shouldHaveNoObjectAtStart(){
		assertEquals("Already some data is present", 0,sessionFactory.openSession().createQuery("from Employee").list().size());
	}
	@Test
	@Rollback(false)
	public void m3shouldBeAbleToPersistAnObject(){
		Employee e1 = new Employee("Kanna",23,"CSE"); //creating employee record
		//e1.setId(1);
		TaskItems t1 = new TaskItems(1,"learning contact centre", 23, e1); // creating task item
		Set<TaskItems> etlist = new HashSet<TaskItems>();
		etlist.add(t1);
		e1.setTaskItems(etlist);
		
		System.out.println("value"+e1.toString());
		//presist and check the table row count 
		Serializable id = currentSession.save(e1);
		System.out.println(id+"value stored in presistent class"+e1.getId());
		currentSession.flush();
		assertEquals("record is not saved", 1, currentSession.createQuery("from Employee").list().size());
	}
	@Test
	public void m4shouldBeAbleToQueryForObjects(){
		List<Employee> elist = currentSession.createQuery("from Employee where name='Kanna'").list();
		assertEquals("Employee Kanna is missing", 1, currentSession.createQuery("from Employee where name='Kanna'").list().size());
	}
	
	@Test
	public void m5printAllRecords(){
		System.out.println("List of Employees"+ currentSession.createQuery("from Employee").list());
		System.out.println("List of TaskItems"+ currentSession.createQuery("from TaskItems").list());
		
	}
}