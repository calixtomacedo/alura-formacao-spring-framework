package br.com.cmdev.springmvcii;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.cmdev.springmvcii.interceptor.InterceptorAccess;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getInterceptorAccess()).addPathPatterns("/**");
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InterceptorAccess getInterceptorAccess() {
	    return  new InterceptorAccess();
	}
	
}
