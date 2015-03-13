/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aquezada.processor.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hibernate Dao.
 * 
 * @author Alfredo Quezada
 */
public class GenericHibernateDao<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	/**
	 * The session factory.
	 */
	protected SessionFactory sessionFactory;
	
	/**
	 * The persistent class.
	 */
	private Class<T> persistentClass;
	
	/**
	 * Constructor.
	 */
	@SuppressWarnings({"unchecked"})
	public GenericHibernateDao() {
		try {
			persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (ClassCastException e) {
			persistentClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}
	
	/**
	 * Constructor that receives the type.
	 * @param type The class type.
	 */
	public GenericHibernateDao(Class<T> type){
		this.persistentClass = type;
	}
	
	/**
	 * Gets the class.
	 * @return The class.
	 */
	protected Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	/**
	 * Gets the session.
	 * @return The session.
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T entidad) {
		getSession().delete(entidad);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({"unchecked"})
	@Override
	public T get(ID id) {
		return (T)getSession().get(persistentClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		final StringBuffer queryString = new StringBuffer("SELECT o FROM ")
				.append(getPersistentClass().getSimpleName())
				.append(" o ");

		final Query query = getSession().createQuery(queryString.toString());
		return query.list();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T save(T entidad) {
		getSession().save(entidad);
		return entidad;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T update(T entidad) {
		getSession().update(entidad);
		return entidad;
	}
	
	/**
	 * Sets the session factory.
	 * @param sessionFactory The session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}