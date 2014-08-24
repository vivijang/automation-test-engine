/*******************************************************************************
 * ATE, Automation Test Engine
 *
 * Copyright 2014, Montreal PROT, or individual contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Montreal PROT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.bigtester.ate.model.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Getter;
import lombok.Setter;

import org.bigtester.ate.model.data.dbtable.ElementInputData;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * This class ElementInputDataDaoImpl defines ....
 * @author Peidong Hu
 *
 */
@Transactional
public class ElementInputDataDaoImpl {
	
	
	/** The db em. */
	@PersistenceContext
    
    /**
     * Gets the db em.
     *
     * @return the db em
     */
    
    /**
     * Gets the db em.
     *
     * @return the db em
     */
    @Getter 
    
    /**
     * Sets the db em.
     *
     * @param dbEM the new db em
     */
    
    /**
     * Sets the db em.
     *
     * @param dbEM the new db em
     */
    @Setter
    
    private EntityManager dbEM;//NOPMD
     
    /**
     * Save.
     *
     * @param eid the eid
     * @return the long
     */
    public Long save(ElementInputData eid) {
        dbEM.persist(eid);
        return eid.getId();
    }
     
    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<ElementInputData>getAll() {
        return dbEM.createQuery("SELECT p FROM ElementInputData p", ElementInputData.class).getResultList();
    }
    
    /**
     * Gets the value.
     *
     * @param inputDataID the input data id
     * @return the value
     */
    public String getValue(Long inputDataID) {
    	ElementInputData eid = dbEM.find(ElementInputData.class, inputDataID);
    	return eid.getDataValue();
    }
}
