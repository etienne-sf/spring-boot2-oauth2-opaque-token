package org.oauth2.opaque.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 
 * Largely inspired from <a href=
 * "https://www.reddit.com/r/javahelp/comments/jpzg3o/howto_use_spring_boot_webclient_to_access_an/">https://www.reddit.com/r/javahelp/comments/jpzg3o/howto_use_spring_boot_webclient_to_access_an/</a>
 * 
 * 
 * @see https://www.reddit.com/r/javahelp/comments/jpzg3o/howto_use_spring_boot_webclient_to_access_an/
 */
@SpringBootApplication
public class ClientApp implements CommandLineRunner {

	@Autowired
	private WebClient webClient;

	public static void main(String[] args) {
		SpringApplication.run(ClientApp.class, args);
	}

	/**
	 * This method is started by Spring, once the Spring context has been loaded. This is run, as this class implements
	 * {@link CommandLineRunner}
	 */
	@Override
	public void run(String... args) throws Exception {

		String response = webClient.get()//
				.uri("http://localhost:9101/api")//
				.retrieve()//
				.bodyToMono(String.class)//
				.doOnError((e) -> System.out.println("An error occured: " + e.getMessage()))//
				.block();

		System.out.println("The API responded: ");
		System.out.println(response);
	}
}
