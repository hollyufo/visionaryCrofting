package com.visionaryCrofting.demo;

import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.repositories.StockRepository;
import com.visionaryCrofting.demo.service.StockService;
import com.visionaryCrofting.demo.service.implementation.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private StockServiceImpl stockService;
	@Override
	public void run(String... args) throws Exception {
		 String status="validate";
		 stockService.search("",status,"");
	}
}
