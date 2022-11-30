package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@EnableSwagger2
@Configuration
public class ConfigureFile {
	
	@Bean
	ModelMapper modelMapper() {
	
		return new ModelMapper();
	}

}