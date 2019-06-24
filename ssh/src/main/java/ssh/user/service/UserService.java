package ssh.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssh.user.dao.UserDao;
import ssh.user.domain.User;

@Service
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void save(User entity) {
		userDao.save(entity);
	}
	
	@Transactional
	public User login(String userName,String password) {
		return userDao.login(userName, password);
	}
	
	@Transactional
	public void update(int userId,String password) {
		userDao.update(userId, password);
	}
}
