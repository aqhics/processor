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
import java.util.List;


/**
 * Generic Dao interface.
 * 
 * @author Alfredo Quezada
 */
public interface GenericDao<T, ID extends Serializable> {
	
	/**
	 * Deletes the entity.
	 * @param entity The entity.
	 */
	void delete(T entity);

	/**
	 * Gets the entity.
	 * @param id The entity id.
	 * @return The entity.
	 */
	T get(ID id);

	/**
	 * Returns a list of all the entities.
	 * @return The list of entities.
	 */
	List<T> getAll();

	/**
	 * Saves an entity.
	 * @param entity The entity.
	 * @return The entity.
	 */
	T save(T entity);

	/**
	 * Updates an entity.
	 * @param entity The entity.
	 * @return The updated entity.
	 */
	T update(T entity);
	
}
