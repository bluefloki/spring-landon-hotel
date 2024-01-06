package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.controllers.WelcomeController;
import edu.wgu.d387_sample_code.utils.DisplayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {
	static ExecutorService executorService=newFixedThreadPool(2);

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);


//		WelcomeController welcomeController = context.getBean(WelcomeController.class);

		// Thread 1
		Future<String> englishMessageFuture = executorService.submit(() -> {
			try {
				Locale locale = new Locale("en", "US");
				DisplayMessage message = new DisplayMessage(locale);
				return message.getWelcomeMessage();
			} catch (Exception e) {
				e.printStackTrace();
				return "Error loading English message";
			}
		});

		// Thread 2
		Future<String> frenchMessageFuture = executorService.submit(() -> {
			try {
				Locale locale = new Locale("fr", "CA");
				DisplayMessage message = new DisplayMessage(locale);
				return message.getWelcomeMessage();
			} catch (Exception e) {
				e.printStackTrace();
				return "Error loading English message";
			}
		});

		executorService.shutdown();


		// set messages for controller
		try {
			String englishResult = englishMessageFuture.get();
			String frenchResult = frenchMessageFuture.get();

			WelcomeController.setEnglishGreeting(englishResult);
			WelcomeController.setFrenchGreeting(frenchResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
