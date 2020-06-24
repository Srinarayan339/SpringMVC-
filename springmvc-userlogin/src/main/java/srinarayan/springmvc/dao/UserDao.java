package srinarayan.springmvc.dao;

import srinarayan.springmvc.model.Login;
import srinarayan.springmvc.model.Moreinformation;
import srinarayan.springmvc.model.User;

public interface UserDao {

	int register(User user); // For Registration of User

	User validateUser(Login login); // For validate user Id and Password

	int isValidPassword(User user); // Check user enter valid password or not

	int moreinfo(Moreinformation moreinformation) throws Exception; // To insert more value

	int isValidNumber(Moreinformation moreinformation); // To Check user enter valid number(English Proficiency)

}
