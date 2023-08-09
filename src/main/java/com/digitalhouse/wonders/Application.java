package com.digitalhouse.wonders;

import com.digitalhouse.wonders.model.*;
import com.digitalhouse.wonders.service.AccommodationServiceImpl;
import com.digitalhouse.wonders.service.CategoryService;
import com.digitalhouse.wonders.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService, AccommodationServiceImpl accommodationService, CategoryService categoryService){
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new AppUser(null,"Anderson","Ribeiro","andersonemail@gmail.com","123456",new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Andressa","Ribeiro","andressaemail@gmail.com","123456",new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new AppUser(null,"Denny","Ribeiro","dennyemail@gmail.com","123456", new ArrayList<>(), new ArrayList<>()));

			categoryService.saveCategory(new Category(null,"Ilhas","Ilhas maravilhosas em localizações privilegiadas", "https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/1db5e3c8-6149-460f-9f23-695d9dd7a468.webp", new ArrayList<>()));
			categoryService.saveCity(new City(null,"Provincia de Cartagena", "Bolívar", "Colombia", new ArrayList<>()));


			Collection<String> linksHeader = new ArrayList<>();
			linksHeader.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/1db5e3c8-6149-460f-9f23-695d9dd7a468.webp");
			Image header = new Image(null,"Header", linksHeader);
			Collection<String> linksLivingRoom = new ArrayList<>();
			linksLivingRoom.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/1ddc5828-cea0-4225-ab49-84f4186e73ad.webp");
			linksLivingRoom.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/6d6e7241-7113-4009-9d30-a65dfd9bac8c.webp");
			linksLivingRoom.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/3e42480b-5df1-4e64-b41e-fdd58ac9e4bc.webp");
			Image livingRoom = new Image(null,"Bedrooms", linksLivingRoom);
			Collection<String> linksToilets = new ArrayList<>();
			linksToilets.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/21456fac-8f90-4655-a25c-b0a5a1d51481.webp");
			Collection<String> linksOutside = new ArrayList<>();
			linksOutside.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/2d3bdedf-6ffc-4c17-9a3a-a6cb02e2974f.webp");
			linksOutside.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/5b50ac57-8eca-4b8b-be51-43a7155ed37a.webp");
			linksOutside.add("https://7wondersbucket.s3.amazonaws.com/Stunning+Island+in+Blue+Sea+with+Pool+KALUA/da933719-effb-448e-8732-e7fdc5e0951a.webp");
			Image toilet = new Image(null,"Toilet", linksToilets);
			Image outside = new Image(null, "Outside View", linksOutside);


			//accommodationService.saveImage(header);
			//accommodationService.saveImage(livingRoom);

			Set<Image> images = new HashSet<>();
			images.add(header);
			images.add(livingRoom);
			images.add(toilet);
			images.add(outside);

			accommodationService.saveAccommodation("Ilhas", "Provincia de Cartagena", new Accommodation(null,"Stunning Island in Blue Sea with Pool KALUA", "Enjoy our exclusive private island located in the Rosario Islands. The place has a tropical style that combines with the beautiful landscape, perfect to disconnect from everyday life while surrounded by a sea of \u200B\u200Bseven colors. The island has 4 rooms from which you can feel the smell of the sea, and a swimming pool to enjoy the paradisiacal place while you feel the wind on your face... Enjoy our Oasis.", "Provincia de Cartagena, Bolívar, Colombia","No carbon monoxide alarm\n" +
					"\uDB86\uDC03\n" +
					"No smoke alarm\n" +
					"\uDB86\uDC03\n" +
					"Nearby lake, river, other body of water "," Check-in: After 2:00 PM\n" +
					"Checkout: 12:00 PM\n" +
					"Self check-in with building staff\n" +
					"Not suitable for infants (under 2 years)\n" +
					"No pets\n" +
					"No parties or events", new ArrayList<>() ,4, 12, 15, 11699, images,new ArrayList<>(), new ArrayList<>(), null));


			userService.addRoleToUser("andersonemail@gmail.com", "ROLE_ADMIN");
			//userService.addRoleToUser("andressaemail@gmail.com", "ROLE_USER");
			userService.addRoleToUser("dennyemail@gmail.com","ROLE_ADMIN");
			Reservation reservation1 = new Reservation(null,LocalDate.parse("2022-07-07"),LocalDate.parse("2022-07-20"), null, null);

			userService.saveReservation("andersonemail@gmail.com", reservation1, 1);
		};
	}
}
