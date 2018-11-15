package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Configuration
@ConfigurationProperties("message")
class MyConfiguration
{
	private String special2;
	private String special3;
	private String special4;
	
	
	MyConfiguration()
	{
		
	}
	
	@Override
	public String toString() {
		return "MyConfiguration [special2=" + special2 + ", special3=" + special3 + ", special4=" + special4 + "]";
	}
	public String getSpecial2() {
		return special2;
	}
	public void setSpecial2(String special2) {
		this.special2 = special2;
	}
	public String getSpecial3() {
		return special3;
	}
	public void setSpecial3(String special3) {
		this.special3 = special3;
	}
	public String getSpecial4() {
		return special4;
	}
	public void setSpecial4(String special4) {
		this.special4 = special4;
	}
	
}