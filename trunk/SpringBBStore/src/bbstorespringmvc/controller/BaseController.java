package bbstorespringmvc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import bbstorespringmvc.model.BaseEntity;

@Transactional
public class BaseController {
    
    @PersistenceContext
    EntityManager em;
    
    protected Object getRequiredEntity(long id, Class<? extends BaseEntity> clazz) {
        Object obj =  em.find(clazz, id );
        if (obj == null) {
            throw new RuntimeException("Indvalid URL. The " + clazz.getName() + " with id '"+id+"' is not found.");
        }
        return obj;
    }    
    
    protected Object getRequiredDetachedEntity(long id, Class<? extends BaseEntity> clazz) {
    	Object entity = getRequiredEntity(id, clazz);
    	em.detach(entity);
    	return entity;
    }

}
