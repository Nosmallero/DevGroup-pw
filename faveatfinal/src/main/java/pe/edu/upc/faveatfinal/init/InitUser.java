package pe.edu.upc.faveatfinal.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.faveatfinal.model.entity.Segment;
import pe.edu.upc.faveatfinal.model.entity.User;
import pe.edu.upc.faveatfinal.model.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// ROLE_XXXXX	-> Segmento Objetivo
		// ACCESS_YYYYY
		
		// SIEMPRE DEBE DE ESTAR COMENTADO
		// SOLO SE DEBE DESBLOQUEAR CUANDO SE CREAN USUARIO
		/*User diego = new User();
		diego.setUsername("diego");
		diego.setPassword(bcpe.encode("diego"));	
		diego.setSegment(Segment.CUSTOMER);
		diego.setIdSegment(1);
		diego.addAuthority("ROLE_CUSTOMER");
		diego.addAuthority("ACCESS_VIEW_CREDITCARD");
		diego.addAuthority("ACCESS_EDIT_CREDITCARD");
		userRepository.save(diego);
		
		User julian = new User("julian", bcpe.encode("julian"), Segment.CUSTOMER, 2);
		julian.addAuthority("ROLE_CUSTOMER");
		julian.addAuthority("ACCESS_VIEW_CREDITCARD");
		userRepository.save(julian);
		
		User diegos = new User("diegos", bcpe.encode("diegos"), Segment.RESTAURANTOWNER, 1);
		diegos.addAuthority("ROLE_RESTAURANTOWNER");
		diegos.addAuthority("ACCESS_VIEW_FOOD");
		userRepository.save(diegos);
		
		User admin = new User("admin", bcpe.encode("admin"), Segment.RESTAURANTOWNER, 2);
		admin.addAuthority("ROLE_ADMINISTRATOR");
		admin.addAuthority("ACCESS_ALL");
		userRepository.save(admin);*/
				
	}

}
