package ssh.user.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

import ssh.user.domain.User;
import ssh.user.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserContreller {
	@Autowired
	private IUserService userService;
	
	@PostMapping(value="/save")
	public String save(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("type") String type,@RequestParam("avatar") String avatar) {
		User user=new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setType(type);
		user.setAvatar(avatar);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setCreatetime(df.format(new Date()));
		userService.save(user);
		return "index";
	}
	
	@GetMapping(value="/login")
	public String login(@RequestParam("name") String name,@RequestParam("password") String password,HttpSession session) {
		User user=userService.login(name, password);
		session.setAttribute("user", user);
		User user1=(User) session.getAttribute("user");
		System.out.println(user1.getUserId());
		return "index";
	}
	
	@PutMapping(value="/update")
	public String update(@RequestParam("password") String password,HttpSession session) {
		//User user=(User) session.getAttribute("user");
		userService.update(1, password);
		return "index";
	}
}
