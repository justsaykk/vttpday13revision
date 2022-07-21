package day13revision.day13revision;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day13revisionApplication {

	public static void main(String[] args) {
		String PORT = "3000";
		SpringApplication app = new SpringApplication(Day13revisionApplication.class);
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		System.out.println(">> appArgs contains port: " + appArgs.containsOption("port"));

		if (appArgs.containsOption("port"))
			PORT = appArgs.getOptionValues("port").get(0);

		System.out.println(">> Starting on PORT: " + PORT);
		app.setDefaultProperties(Collections.singletonMap("server.port", PORT));
		app.run(args);
	}

}
