package di_javaConfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("di_annotation.pokedex.di")
public class AppConfigWithComponentScan {
}
