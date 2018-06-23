package example.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Rimantas Jacikevičius on 18.6.23.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .select().apis(RequestHandlerSelectors.basePackage("example.swagger.controllers"))
                .paths(regex(Endpoints.PRODUCTS + ".*"))
                .build();

    }

}
