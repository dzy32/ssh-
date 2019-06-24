package ssh.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ssh.user.domain.User;

@Repository
public interface UserDao extends PagingAndSortingRepository<User,Long>,JpaSpecificationExecutor<User>{
	@Query("from User u where u.userName=?1 and u.password=?2")
	public User login(String name,String password);
	
	@Modifying
	@Query("update User u set u.password=?2 where u.userId=?1")
	public void update(int userId,String password);
}
