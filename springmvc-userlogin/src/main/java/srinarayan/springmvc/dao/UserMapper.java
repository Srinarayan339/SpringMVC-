package srinarayan.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import srinarayan.springmvc.model.User;

class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getInt("phone"));

		return user;
	}
}