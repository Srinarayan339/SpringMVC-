
// Implementaions of Services

package srinarayan.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import srinarayan.springmvc.dao.UserDao;
import srinarayan.springmvc.model.Login;
import srinarayan.springmvc.model.Moreinformation;
import srinarayan.springmvc.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public int register(User user) { // For Registration of User
		return userDao.register(user);
	}

	public User validateUser(Login login) { // For validate user Id and Password
		return userDao.validateUser(login);
	}

	public int isValidPassword(User user) { // Check user enter valid password or not
		return userDao.isValidPassword(user);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int moreinfo(Moreinformation moreinformation) throws Exception { // To insert more value
		return userDao.moreinfo(moreinformation);
	};

	public int isValidNumber(Moreinformation moreinformation) { // To Check user enter valid number(English Proficiency)
		return userDao.isValidNumber(moreinformation);
	}

}
