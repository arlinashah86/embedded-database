package my.com.arlinashah86;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import my.com.arlinashah86.dao.EmployeeDao;
import my.com.arlinashah86.dao.EmployeeDaoImpl;
import my.com.arlinashah86.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:db-config.xml")
public class EmployeeDaoWithConfigTest {
	
	EmployeeDao employeeDao;
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	
	@Test
	public void test() {
		
    	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    	employeeDao.setNamedParameterJdbcTemplate(jdbcTemplate);
    	
    	Employee employee = employeeDao.findByName("eleanor");
    	
    	Assert.assertEquals("eleanor@yahoo.com", employee.getEmail());
	}

}
