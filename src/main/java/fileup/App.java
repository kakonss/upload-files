package fileup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import fileup.storage.StorageService;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}

}
