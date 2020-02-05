package com.example.flowablerestcustomdocker.conf;

import org.activiti.compatibility.spring.SpringFlowable5CompatibilityHandlerFactory;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineConfiguration {
    @Bean
    EngineConfigurationConfigurer<SpringProcessEngineConfiguration> processEngineConfigurationEngineConfigurationConfigurer(){
        return engineConfiguration -> {
            //Enabling Flowable 5 Compatibility
            engineConfiguration.setFlowable5CompatibilityEnabled(true);
            engineConfiguration.setFlowable5CompatibilityHandlerFactory( flowable5CompatibilityFactory());
        };
    }

    @Bean
    SpringFlowable5CompatibilityHandlerFactory flowable5CompatibilityFactory() {
        return new SpringFlowable5CompatibilityHandlerFactory();
    }
}
