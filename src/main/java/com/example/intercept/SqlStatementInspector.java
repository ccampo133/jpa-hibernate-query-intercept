package com.example.intercept;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SqlStatementInspector implements StatementInspector {

    private final Logger log = LoggerFactory.getLogger(SqlStatementInspector.class);

    private int numStatements;

    @Override
    public String inspect(String sql) {
        var comment = String.format("/* This is statement %d */ ", numStatements);
        numStatements++;
        log.debug("SQL: {}, Comment: {}", sql, comment);
        return comment + sql;
    }
}
