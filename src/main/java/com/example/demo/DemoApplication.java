package com.example.demo;

import com.example.demo.ui.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class DemoApplication extends VaadinWebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		setLoginView(http, LoginView.class);
	}

	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new InMemoryUserDetailsManager(
				User.withUsername("Paul210766@gmail.com")
						.password("{noop}abcdefg01010101010101")
						.roles("ADMIN")
						.build(),
				User.withUsername("Rory")
						.password("{noop}rory")
						.roles("ADMIN")
						.build()
		);
	}
}
// Paul210766@gmail.com
 // abcdefg01010101010101