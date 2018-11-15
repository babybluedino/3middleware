package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("select * from users ", new UserMapper());
		
	}

	@Override
	public User findUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	
}


//RowMapper :an interface to map the database columns and the data members
//has a method which need to be overriden: mapRow()

class UserMapper implements RowMapper<User>
{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		User user = new User();
		user.setId(rs.getInt("cid"));   //cid : column name
		user.setEmail(rs.getString("cemail"));
		user.setName(rs.getString("cname"));
		user.setAddress(rs.getString("caddress"));
		
		return null;
}
}