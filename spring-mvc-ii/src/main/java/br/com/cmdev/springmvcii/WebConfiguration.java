package br.com.cmdev.springmvcii;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.cmdev.springmvcii.interceptor.InterceptorAccess;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getInterceptorAccess()).addPathPatterns("/**").excludePathPatterns("/**/*.js", "/**/*.css");
	}
	
	@Bean
	public InterceptorAccess getInterceptorAccess() {
	    return  new InterceptorAccess();
	}
	
}
