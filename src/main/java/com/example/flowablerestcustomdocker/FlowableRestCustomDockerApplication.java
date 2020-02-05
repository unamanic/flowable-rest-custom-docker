package com.example.flowablerestcustomdocker;

import com.example.flowablerestcustomdocker.properties.RestAppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableConfigurationProperties({
		RestAppProperties.class
})
@SpringBootApplication()
public class FlowableRestCustomDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableRestCustomDockerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer swaggerDocsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/docs").setViewName("redirect:/docs/");
				registry.addViewController("/docs/").setViewName("forward:/docs/index.html");
			}
		};
	}

	@Bean
	public GrantedAuthorityDefaults grantedAuthorityDefaults(RestAppProperties commonAppProperties) {
		return new GrantedAuthorityDefaults(commonAppProperties.getRolePrefix());
	}
}
