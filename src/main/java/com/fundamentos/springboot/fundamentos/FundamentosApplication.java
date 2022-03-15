package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWhitDependency;
import com.fundamentos.springboot.fundamentos.bean.TestDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER_ = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWhitDependency myBeanWhitDependency;
	private TestDependency testDependency;
	private MyBeanProperties myBeanProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, TestDependency testDependency, MyBeanProperties myBeanProperties, UserPojo userPojo, UserRepository userRepository, UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWhitDependency = myBeanWhitDependency;
		this.testDependency = testDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUserDb();
		//getInformationJPQLUser();
		saveWithErrorTransactional();
	}

	public void getInformationJPQLUser(){
		/*LOGGER_.info("Usuario findByUserEmail: " +
				userRepository.findByUserEmail("viviana@test.com")
						.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("Ju", Sort.by("id").ascending())
				.stream().forEach(user -> LOGGER_.info("Usuario con sort " + user));

		userRepository.findByName("Julian")
				.stream().forEach(user -> LOGGER_.info("Usuario con query method " + user));

		LOGGER_.info("Usuario findByEmailAndName: " +
				userRepository.findByEmailAndName("juliana@test.com", "Juliana")
						.orElseThrow(() -> new RuntimeException("No se encontro el usuario findByEmailAndName")));

		userRepository.findByNameLike("%Jul%")
				.stream().forEach(user -> LOGGER_.info("Usuario con findByNameLike " + user));

		userRepository.findByNameOrEmail("Julian", null)
				.stream().forEach(user -> LOGGER_.info("Usuario con findByNameOrEmail " + user));

		userRepository.findByBirthDateBetween(LocalDate.of(1995, 9,26), LocalDate.of(1996,10,10))
				.stream().forEach(user -> LOGGER_.info("Usuario con findByBirthDateBetween " + user));

		userRepository.findByNameLikeOrderByIdDesc("%Ju%")
				.stream().forEach(user -> LOGGER_.info("Usuario con findByNameLikeOrderByIdDesc " + user));

		userRepository.findByNameLikeOrderByIdAsc("%Ju%")
				//.stream().forEach(user -> LOGGER_.info("Usuario con findByNameLikeOrderByIdAsc " + user));

		userRepository.findByNameContainingOrderByIdDesc("Ju")
				.stream().forEach(user -> LOGGER_.info("Usuario con findByNameContainingOrderByIdDesc " + user));

		LOGGER_.info("Usuario getAllByBirthDateAndEmail: " +
				userRepository.getAllByBirthDateAndEmail(LocalDate.of(1997, 11, 28),"esteban@test.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario getAllByBirthDateAndEmail")));*/
	}

	private void saveWithErrorTransactional(){
		User user1 = new User("user1", "user1@test.com", LocalDate.now());
		User user2 = new User("user2", "user2@test.com", LocalDate.now());
		User user3 = new User("user3", "user3@test.com", LocalDate.now());
		User user4 = new User("user4", "user4@test.com", LocalDate.now());

		List<User> usersList = Arrays.asList(user1, user2, user3, user4);

		try{
			userService.saveTransactional(usersList);
		} catch (Exception e) {
			LOGGER_.error("Esta es una excepcion dentro del metodo trancctional " + e);
		}
		userService.getAllUsers()
				.stream().forEach(user -> LOGGER_.info("Usuario con getAllUsers " + user));
	}

	public void saveUserDb(){
		User user1 = new User("Viviana", "viviana@test.com", LocalDate.of(1995, 9, 26));
		User user2 = new User("Juliana", "juliana@test.com", LocalDate.of(1996, 10, 27));
		User user3 = new User("Esteban", "esteban@test.com", LocalDate.of(1997, 11, 28));
		User user4 = new User("Daniela", "daniela@test.com", LocalDate.of(1998, 12, 29));
		User user5 = new User("Andrea", "andrea@test.com", LocalDate.of(1999, 1, 10));
		User user6 = new User("Juan", "juan@test.com", LocalDate.of(1995, 2, 11));
		User user7 = new User("Pedro", "pedro@test.com", LocalDate.of(1996, 3, 12));
		User user8 = new User("Marco", "marco@test.com", LocalDate.of(1997, 4, 23));
		User user9 = new User("Amparo", "amparo@test.com", LocalDate.of(1998, 5, 31));
		User user10 = new User("Alejandro", "alejandro@test.com", LocalDate.of(1999, 6, 1));
		User user11 = new User("Julio", "julio@test.com", LocalDate.of(1995, 7, 12));
		User user12 = new User("Julian", "julian@test.com", LocalDate.of(1996, 8, 14));

		List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);

		//userList.stream().forEach(userRepository::save);
		userRepository.saveAll(userList);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.Print();
		myBeanWhitDependency.printWhitDependency();
		testDependency.print();
		System.out.println(myBeanProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		/*try {
			//error
			int value = 10 / 0;
			LOGGER_.info("El valor es: " + value);
		} catch (Exception e) {
			LOGGER_.error("Esto es un error diviendo en 0" + e.getMessage());
		}*/
	}
}
