package ssh.user.service;

import java.util.List;

import ssh.user.domain.User;

public interface IUserService {
	public void save(User entity);
	public User login(String userName,String password);
	public void update(int userId,String password);
}
