package org.sid;

import org.sid.dao.UserRepository;
import org.sid.entities.User;
import org.sid.service.ServiceBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HerokuBanqueApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ServiceBanque serviceBanque;
	public static void main(String[] args) {
		SpringApplication.run(HerokuBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		  userRepository.save(new User(1L,"YAMEOGO", "Samuel",
		  "samuel@gmail.com","123456")); userRepository.save(new User(2L,"YAMEOGO",
		  "Nathalie", "nathalie@gmail.com","123456")); userRepository.save(new
		  User(2L,"YAMEOGO", "Augustin", "augustin@gmail.com","123456"));
		 
		   boolean res1 = serviceBanque.connexion("samuel@gmail.com", "123456");
		   boolean	res2 = serviceBanque.connexion("ok@gmail.com", "123456");
		   boolean	res3 = serviceBanque.connexion("samuel@gmail.com", "123987");
			
			System.out.println(res1);
			System.out.println(res2);
			System.out.println(res3);
	}

}
