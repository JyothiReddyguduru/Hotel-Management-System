package com.example.hms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.example.hms.models.Suite;
import com.example.hms.services.RoomService;
import com.example.hms.services.SuiteService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class LittleroomsApplication implements CommandLineRunner {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private SuiteService suiteService;
	
	@Autowired
	static ResourceLoader resourceLoader;
	
	public static void main(String[] args) {
		SpringApplication.run(LittleroomsApplication.class, args);
	}
	
	private void createRooms(String fileToImport) throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		RoomFile.read(fileToImport).forEach(entry -> {
			int pr = Integer.parseInt(entry.getPrice());
			roomService.createRoom(entry.getDescription(), entry.getName(), entry.getCode(), pr, entry.getSuite());	
		});	
	}

	private void createSuites(String fileToImport) throws IOException {
		SuiteFile.read(fileToImport).forEach(entry -> 
		suiteService.createSuite(entry.getLongDesc(), entry.getDescription(), entry.getName(), entry.getCode())
		);
	}

	@Override
	public void run(String... args) throws Exception {
		createSuites("suites.json");
		Suite suiteByCode = suiteService.getSuiteByCode("Harry Potter");
		Suite suite = suiteService.getSuiteByName("Harry Potter");
		createRooms("rooms.json");	
	}
	
	private static class SuiteFile {
		private String code, name, description, longDesc;
		
		static List<SuiteFile> read(String fileToImport) throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		    Resource resource1 = new ClassPathResource("suites.json");
			//Resource resource = resourceLoader.getResource("classpath:suites.json");
			List<SuiteFile> myObjects = Arrays.asList(new ObjectMapper().readValue(resource1.getInputStream(), SuiteFile[].class));
			return myObjects;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getLongDesc() {
			return longDesc;
		}
		
	}
	
	private static class RoomFile {
		private String code, name, description, price, suite;
		
		static List<RoomFile> read(String fileToImport) throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
			//Resource resource = resourceLoader.getResource("classpath:rooms.json");
		    Resource resource = new ClassPathResource("rooms.json");
			List<RoomFile> myObjects = Arrays.asList(new ObjectMapper().readValue(resource.getInputStream(), RoomFile[].class));
			return myObjects;
		}

		public String getSuite() {
			return suite;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getPrice() {
			return price;
		}

		
	}

}
