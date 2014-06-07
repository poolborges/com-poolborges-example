package com.poolborges.example.springjpa.employee;

/**
 *
 * @author Borges
 */
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void doExecute() {
        this.jdbcTemplate.execute("create table mytable(id integer, name varchar(100))");
    }

    public void doInsert() {
        this.jdbcTemplate.update("insert into mytable(id, name) values (?, ?)", 1, "Ankit");
    }
    
    public void doSelect() {
        this.jdbcTemplate.execute("SELECT * FROM mytable");
    }
}
