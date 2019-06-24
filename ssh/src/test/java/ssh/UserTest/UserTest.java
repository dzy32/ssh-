package ssh.UserTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.user.domain.User;
import ssh.user.service.IUserService;

public class UserTest {
	private IUserService userService;
	
	@Before
	public void beforeTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml","applicationContext-jpa.xml");
		userService=context.getBean("userService",IUserService.class);
	}
	
	@Test
	public void save() {
		for(int i=1;i<10;i++) {
			User user=new User();
			user.setUserName("ryan");
			user.setPassword("123");
			//System.out.println(user.getUserName());
			userService.save(user);
		}	
	}
}
