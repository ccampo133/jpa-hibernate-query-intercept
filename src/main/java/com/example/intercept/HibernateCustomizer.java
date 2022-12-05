package com.example.intercept;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HibernateCustomizer implements HibernatePropertiesCustomizer {

    private final EntityInterceptor interceptor;
    private final SqlStatementInspector inspector;

    public HibernateCustomizer(EntityInterceptor interceptor, SqlStatementInspector inspector) {
        this.interceptor = interceptor;
        this.inspector = inspector;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", interceptor);
        hibernateProperties.put("hibernate.session_factory.statement_inspector", inspector);
    }
}
