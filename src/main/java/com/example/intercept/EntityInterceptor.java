package com.example.intercept;

import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EntityInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(EntityInterceptor.class);
    
    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
        log.info("Saving entity of type {} with ID {}", entity.getClass(), id);
        return false;
    }
}
