package my.com.arlinashah86;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import junit.framework.Assert;
import my.com.arlinashah86.dao.EmployeeDao;
import my.com.arlinashah86.dao.EmployeeDaoImpl;
import my.com.arlinashah86.model.Employee;

public class EmployeeDaoTest {

    private EmbeddedDatabase db;

    EmployeeDao employeeDao;
    
    
    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-data.sql")
    		.build();
    }

    @Test
    public void testFindByname() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    	employeeDao.setNamedParameterJdbcTemplate(template);
    	
    	Employee employee = employeeDao.findByName("eleanor");
  
    	Assert.assertNotNull(employee);
    	Assert.assertEquals(2, employee.getId().intValue());
    	Assert.assertEquals("eleanor", employee.getName());
    	Assert.assertEquals("eleanor@yahoo.com", employee.getEmail());

    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
