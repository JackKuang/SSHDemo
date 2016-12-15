

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hurenjieee.entity.Userr;
import com.hurenjieee.service.AdminService;
import com.hurenjieee.service.LoginService;
import com.hurenjieee.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class StudentTest {
	
	@Autowired
	LoginService loginService;
	@Autowired
	AdminService adminService;

	@Autowired
	TeacherService teacherService;
	
	public static void main(String[] args){
		
		Userr user = new Userr();
		user.setUserName("zhang");
		user.setPassWord("123456");
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
	   	
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sf.close();		
	}
	
	
	@Test
	public void test2(){
		adminService.login("admin", "123");
		teacherService.login("tea", "tea");
//		loginService.save(userr);
	}
}