package com.skillstorm.group8.taxprep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.Version;

@SpringBootApplication
public class TaxprepApplication {

	public static void main(String[] args) {
		Version version = com.fasterxml.jackson.core.json.PackageVersion.VERSION;
		System.out.println("###########");
		System.out.println(version);
		System.out.println("###########");
		SpringApplication.run(TaxprepApplication.class, args);
	}

}
