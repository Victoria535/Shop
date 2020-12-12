package com.shop.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/registration").setViewName("registration");
		registry.addViewController("/shopping-cart").setViewName("shopping-cart");
		registry.addViewController("/product").setViewName("product");

		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

}
