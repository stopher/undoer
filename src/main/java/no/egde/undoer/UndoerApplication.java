package no.egde.undoer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UndoerApplication extends SpringBootServletInitializer  {


	public static void main(String[] args) {

		new UndoerApplication()
				.configure(new SpringApplicationBuilder(UndoerApplication.class))
				.run(args);


	}
}
