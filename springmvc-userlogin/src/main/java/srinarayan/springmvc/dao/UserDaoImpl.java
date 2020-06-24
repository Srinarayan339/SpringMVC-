package srinarayan.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import srinarayan.springmvc.model.Login;
import srinarayan.springmvc.model.Moreinformation;
import srinarayan.springmvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int register(User user) { // Insert values in Users Table
		String sql = "insert into users values(?,?,?,?,?,?,?)";

		return jdbcTemplate.update(sql,
				new Object[] { user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone() });
	}

	public User validateUser(Login login) { // To Check login Id and Password
		String sql = "select * from users where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;
	}

	public int isValidPassword(User user) { // Validate password Pattern

		String regex = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\w\\d]).*$"; // Regex for password pattern

		Pattern p = Pattern.compile(regex);

		if (user.getPassword() == null) {
			return 0;
		}

		java.util.regex.Matcher m = p.matcher(user.getPassword());

		if (!m.matches()) {
			return 0;
		} else {
			return 1;
		}
	}

	public int moreinfo(Moreinformation moreinformation) throws Exception { // Insert information in Moreinfo and
																			// Moreinfo1 table
		String sql = "insert into moreinfo values(?,?,?,?,?,?)";

		String sqln = "insert into moreinfo1 values(?)";

		int Y = jdbcTemplate.update(sqln, new Object[] { moreinformation.getEngprof() });

		int X = jdbcTemplate.update(sql,
				new Object[] { moreinformation.getFirstname(), moreinformation.getLastname(),
						moreinformation.getMobile(), moreinformation.getAddress(), moreinformation.getQualification(),
						moreinformation.getEngprof() });

		return 1;
	}

	public int isValidNumber(Moreinformation moreinformation) { // validate user only enter numeric values in EngProf
																// field

		String regex1 = "^[0-9]*$"; // Regex for Numbers

		Pattern p = Pattern.compile(regex1);

		Matcher m = p.matcher(moreinformation.getEngprof());

		if (!m.matches()) {
			return 0;
		} else {
			return 1;
		}
	}
}
