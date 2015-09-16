package com.firststep.dao;
import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.firststep.dao.entities.*;

import org.springframework.orm.hibernate3.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
@Repository
public class CourseDao {
	private HibernateTemplate hibernateTemplate;
	public CourseDao(){}
	public CourseDao(HibernateTemplate hibernateTemplate){
		this.hibernateTemplate = hibernateTemplate;
	}
	public void add(Course course){
		this.hibernateTemplate.save(course);
	}
	public List<String> readCourseStudent(final String courseName){
		List<String> studentList;
		HibernateCallback<List<String>> callback = new HibernateCallback<List<String>>(){

			@Override
			public List<String> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				List<String> students = new ArrayList<String>();
				Criteria criteria = session.createCriteria(Course.class)
						.add(Restrictions.eq("courseName", courseName))
						.createAlias("students","st")
						.addOrder(Order.asc("st.studentName"))
						.setProjection(Projections.property("st.studentName"));
				students = (List<String>) criteria.list();
				/**to select two columns one from entity and another from associated entity**/
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.property("st.studentName"))
					.add(Projections.property("courseName"));
				
				Criteria criteria1 = session.createCriteria(Course.class)
						.createAlias("students","st")
						.add(Restrictions.like ("st.studentName", "K"+"%"))
						//.addOrder(Order.asc("courseName"))
						//.addOrder(Order.asc("st.marks"));
						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
						//.setProjection(projectionList);
				System.out.println(criteria1.list().size());
				List<Course> courses = criteria1.list();
				Iterator it = courses.iterator();
				while(it.hasNext()){
					System.out.println(it.next());
				}
//				Iterator it = criteria1.list().iterator();
//				while (it.hasNext()){
//					Object[] record = (Object[])it.next();
//					for (int i=0;i<record.length;i++)
//					{
//						System.out.print(record[i]+"-");
//					}
//					System.out.println(";");
//				}
				return students;
			}
		};
		studentList = hibernateTemplate.execute(callback);
		return studentList;
	}
	
}
