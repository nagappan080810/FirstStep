package com.firststep.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.*;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.hibernate.transform.DistinctResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.*;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.firststep.dao.entities.DestNumber;
import com.firststep.dao.pojo.*;
@Repository
public class CallLogDao {
	private EntityManager entityManager;
	private HibernateTemplate hibernateTemplate;
	@Autowired
	public CallLogDao(HibernateTemplate hibernateTemplate){
		System.out.println("hibernate template constructor"+hibernateTemplate);
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void save(CallLog callLog){
		System.out.println("*****"+hibernateTemplate);
		System.out.println("*****"+callLog);
		hibernateTemplate.save(callLog);
	}
	
	public void readUniqueDestinationNumberList2(){
		HibernateCallback<List<CallLog>> CallLogRead = new HibernateCallback<List<CallLog>>(){
			public List<CallLog> doInHibernate(Session session){
				//EntityManager em = session.criteria builder
				//EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
				EntityManager entityManager= getEntityManager();
				//criteriabuilder
				CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
				
				javax.persistence.Query subquery = entityManager.createQuery("select max(callId) from CallLog group by destinationNumber");
				
				CriteriaQuery criteriaQuery1 = criteriaBuilder.createQuery(CallLog.class);
				Root<CallLog> callLog1 = criteriaQuery1.from(CallLog.class);
				criteriaQuery1.select(callLog1).where(callLog1.get("callId").in(subquery.getResultList()));
				//creating query
				TypedQuery<CallLog> query = entityManager.createQuery(criteriaQuery1);
				List<CallLog> callLogList = query.getResultList();
				return callLogList;
			}
		};
		List<CallLog> callLogList = hibernateTemplate.execute(CallLogRead);
		//HashSet<CallLog> callLogSets = new HashSet<CallLog>(callLogList);
		Iterator<CallLog> CallLogIterator = callLogList.iterator();
		Table columnList = CallLog.class.getAnnotation(Table.class);
		String name = columnList.name();
		System.out.println("value"+name);
		while(CallLogIterator.hasNext()){
			System.out.println(CallLogIterator.next().toString());
		}
	}
	
	public void readUniqueDestinationNumberList1(){
		HibernateCallback<List<CallLog>> CallLogRead = new HibernateCallback<List<CallLog>>(){
			public List<CallLog> doInHibernate(Session session){
				Criteria CallLogCriteria = session.createCriteria(CallLog.class);
				//set distinct projections on destination number and transformaing to call log bean.
				ProjectionList projectionList1 = Projections.projectionList();
				//projectionList1.add(Projections.distinct(Projections.projectionList()
				//projectionList1.add(Projections.groupProperty("destinationNumber"), "destinationNumber");
				//projectionList1.add(Projections.groupProperty("callId"),"callId");
				//projectionList1.add(Projections.groupProperty("sourceNumber"),"sourceNumber");
				//CallLogCriteria.setProjection(projectionList1);
				CallLogCriteria
						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				@SuppressWarnings("unchecked")
				List<CallLog> CallLogList = CallLogCriteria.list();
				return CallLogList;
			}
		};
		List<CallLog> callLogList = hibernateTemplate.execute(CallLogRead);
		//HashSet<CallLog> callLogSets = new HashSet<CallLog>(callLogList);
		Iterator<CallLog> CallLogIterator = callLogList.iterator();
		Table columnList = CallLog.class.getAnnotation(Table.class);
		String name = columnList.name();
		System.out.println("value"+name);
		while(CallLogIterator.hasNext()){
			System.out.println(CallLogIterator.next().toString());
		}
	}
	public void readUniqueDestinationNumberList(){
		HibernateCallback<List<DestNumber>> DestNumberRead = new HibernateCallback<List<DestNumber>>(){
			public List<DestNumber> doInHibernate(Session session){
				Criteria DestNumberCriteria = session.createCriteria(CallLog.class);
				//set distinct projections on destination number and transformaing to call log bean.
				ProjectionList projectionList1 = Projections.projectionList();
				//projectionList1.add(Projections.distinct(Projections.projectionList()
						projectionList1.add(Projections.groupProperty("destinationNumber"), "destinationNumber");
				//projectionList1.add(Projections.groupProperty("callId"),"callId");
				//projectionList1.add(Projections.groupProperty("sourceNumber"),"sourceNumber");
				DestNumberCriteria.setProjection(projectionList1);
				DestNumberCriteria
						.setResultTransformer(Transformers.aliasToBean(DestNumber.class));
				@SuppressWarnings("unchecked")
				List<DestNumber> DestNumberList = DestNumberCriteria.list();
				return DestNumberList;
			}
		};
		List<DestNumber> DestNumberList = hibernateTemplate.execute(DestNumberRead);
		Iterator<DestNumber> DestNumberIterator = DestNumberList.iterator();
		while(DestNumberIterator.hasNext()){
			System.out.println(DestNumberIterator.next().toString());
		}
	}
}
