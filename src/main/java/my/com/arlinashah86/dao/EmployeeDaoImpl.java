package my.com.arlinashah86.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import my.com.arlinashah86.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Employee findByName(String name) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);

		String sql = "SELECT * FROM employees WHERE name=:name";

		Employee result = namedParameterJdbcTemplate.queryForObject(sql, params, new EmployeeMapper());

		return result;

	}

	@Override
	public List<Employee> findAll() {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM employees";

		List<Employee> result = namedParameterJdbcTemplate.query(sql, params, new EmployeeMapper());

		return result;

	}

	public static final class EmployeeMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
			return employee;
		}
	}

}
