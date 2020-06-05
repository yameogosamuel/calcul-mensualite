package org.sid.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.sid.dao.UserRepository;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ServiceBanque {
	
	@Autowired
	UserRepository userRepository;
	
		public double calcul(double montant, int duree, double taux){
			
			double t1= montant*(taux/1200);
			double t2= 1-(Math.pow((1+taux/1200), -1*duree));
			return t1/t2;
			
		}

		public boolean connexion(String email, String password) {
			List<User> users =userRepository.findAll();
			boolean mess=false;
			for (User user : users) {
				if(user.getEmail().equals(email)&&user.getPassword().equals(password))
					mess=true;
			}
			return mess;
		}
		
		public void addUser(User user) {
			userRepository.save(user);
		}
		
		public void deleteUser(Long id) {
			userRepository.deleteById(id);
		}

}
