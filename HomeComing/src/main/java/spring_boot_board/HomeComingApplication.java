package spring_boot_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class HomeComingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeComingApplication.class, args);
	}
	@GetMapping("/")
	public String index() {
		return "thymeleaf/index";
	}

}
