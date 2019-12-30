package com.demo.crud.crudservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class CrudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudServiceApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
		return acceptHeaderLocaleResolver;

	}
	
	
	@Bean(name="messageSource")
	public ResourceBundleMessageSource bundleMessageSource() {
	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	
	messageSource.setBasename("messages");
	return messageSource;
	}

}
