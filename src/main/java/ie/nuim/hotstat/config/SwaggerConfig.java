package ie.nuim.hotstat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.regex("/api/.*"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        
        ApiInfo apiInfo = new ApiInfo(
            "HOTstat REST API",
            "This is a description of the REST API for HOTstat, a library for assessing the humaniterian preparedness of regions in OpenStreetMap.",
            "Version 0.1.0",
            "API TOS",
            "a.i.abdelghany@gmail.com",
            "This API is licenceds under MIT license",
            "API License URL"
        );
        return apiInfo;
    }
}