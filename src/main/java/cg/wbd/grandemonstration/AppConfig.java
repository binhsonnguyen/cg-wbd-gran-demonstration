package cg.wbd.grandemonstration;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cg.wbd.grandemonstration")
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Value( "${template.location.prefix}" ) private String templateLocationPrefix;
    @Value( "${template.location.suffix}" ) private String templateLocationSuffix;
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(templateLocationPrefix);
        viewResolver.setSuffix(templateLocationSuffix);
        return viewResolver;
    }

    @Bean
    public CustomerService customerService() {
        return new SimpleCustomerServiceImpl();
    }
}
