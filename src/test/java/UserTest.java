import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.songgaochao.common.utils.RandomUtil;
import com.songgaochao.common.utils.StringUtil;
import com.songgc.redis.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/redis.xml")
public class UserTest {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	@Test
	@SuppressWarnings("unchecked")
	public void name1() {
		
	User user = new User();
	ArrayList<User> list = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			//ID使用1-10万的顺序号	
				Integer id =+ 1;
				user.setId(id);
				//姓名使用3个随机汉字模拟，可以使用以前自己编写的工具方法
				String string = StringUtil.randomChineseName();
				user.setName(string);
				//性别在女和男两个值中随机
				if (i==i+2) {
					user.setSex("男");
				} else {
					user.setSex("女");
				}
			//手机以13开头+9位随机数模拟				
				String mun="";
				int[] random = RandomUtil.random(1, 8, 9);
				 for (int si : random) {
					 mun+=si;
				 }				 
				 user.setPhone(13+mun);
		 //邮箱以3-20个随机字母 + @qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com模拟
				 String randomChar="";
					String[] split = null;		
				for (int ii = 0; ii <10; ii++) {
				 randomChar = StringUtil.getRandomChar(20);
				String ff="@qq.com|@163.com|@sian.com|@gmail.com|@sohu.com|@hotmail.com|@foxmail.com";		
				 split = ff.split("\\|");									
				}
				int j = RandomUtil.random(0, 6);
				user.setMail(randomChar + split[j]);
		//	生日要模拟18-70岁之间，即日期从1949年到2001年之间		
					int i2 = RandomUtil.random(18,70);						   
				    user.setShengr(i2);
				   list.add(user);
		}
				
		long millis = System.currentTimeMillis();
	    redisTemplate.opsForList().leftPushAll("user", list.toArray());
			
		long millis2 = System.currentTimeMillis();
		System.out.println("系列化方式");
		System.out.println("添加10万数据");
		System.out.println("所用时间"+(millis-millis2)+"毫秒");
		
	}
	@Test
	@SuppressWarnings("unchecked")
	public void name2() {
		
	User user = new User();
	ArrayList<User> list = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			//ID使用1-10万的顺序号	
				Integer id =+ 1;
				user.setId(id);
				//姓名使用3个随机汉字模拟，可以使用以前自己编写的工具方法
				String string = StringUtil.randomChineseName();
				user.setName(string);
				//性别在女和男两个值中随机
				if (i==i+2) {
					user.setSex("男");
				} else {
					user.setSex("女");
					
				}
			//手机以13开头+9位随机数模拟				
				String mun="";
				int[] random = RandomUtil.random(1, 8, 9);
				 for (int si : random) {
					 mun+=si;
				 }				 
				 user.setPhone(13+mun);
		 //邮箱以3-20个随机字母 + @qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com模拟
				 String randomChar="";
					String[] split = null;		
				for (int ii = 0; ii <10; ii++) {
				 randomChar = StringUtil.getRandomChar(20);
				String ff="@qq.com|@163.com|@sian.com|@gmail.com|@sohu.com|@hotmail.com|@foxmail.com";		
				 split = ff.split("\\|");									
				}
				int j = RandomUtil.random(0, 6);
				user.setMail(randomChar + split[j]);
		//	生日要模拟18-70岁之间，即日期从1949年到2001年之间		
					int i2 = RandomUtil.random(18,70);						   
				    user.setShengr(i2);
				   list.add(user);
		}
				
		long millis = System.currentTimeMillis();
	    redisTemplate.opsForList().leftPushAll("user2", list.toArray());
			
		long millis2 = System.currentTimeMillis();
		System.out.println("系列化方式");
		System.out.println("添加10万数据");
		System.out.println("所用时间"+(millis+millis2)+"毫秒");
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void naem3() {
			
		User user = new User();
		HashMap<String, Object>  map = new HashMap<>();
			for (int i = 0; i < 100000; i++) {
				//ID使用1-10万的顺号	
					Integer id =+ 1;
					user.setId(id);
					//姓名使用3个随机汉字模拟，可以使用以前自己编写的工具方法
					String string = StringUtil.randomChineseName();
					user.setName(string);
					//性别在女和男两个值中随机
					if (i==i+2) {
						user.setSex("男");
					} else {
						user.setSex("女");
					}
				//手机以13开头+9位随机数模拟				
					String mun="";
					int[] random = RandomUtil.random(1, 8, 9);
					 for (int si : random) {
						 mun+=si;
					 }				 
					 user.setPhone(13+mun);
			 //邮箱以3-20个随机字母 + @qq.com  | @163.com | @sian.com | @gmail.com | @sohu.com | @hotmail.com | @foxmail.com模拟
					 String randomChar="";
						String[] split = null;		
					for (int ii = 0; ii <10; ii++) {
					 randomChar = StringUtil.getRandomChar(20);
					String ff="@qq.com|@163.com|@sian.com|@gmail.com|@sohu.com|@hotmail.com|@foxmail.com";		
					 split = ff.split("\\|");									
					}
					int j = RandomUtil.random(0, 6);
					user.setMail(randomChar + split[j]);
			//	生日要模拟18-70岁之间，即日期从1949年到2001年之间		
						int i2 = RandomUtil.random(19, 70);						   
					    user.setShengr(i2);
					    map.put("user"+i, user);
			}
					
			long millis = System.currentTimeMillis();
		    redisTemplate.opsForHash().putAll("hash", map);	
		    redisTemplate.opsForHash().entries("hash");
			long millis2 = System.currentTimeMillis();
			System.out.println("系列化方式");
			System.out.println("添加10万数据");
			System.out.println("所用时间"+(millis2-millis)+"毫秒");
			
		
	}
		
}
