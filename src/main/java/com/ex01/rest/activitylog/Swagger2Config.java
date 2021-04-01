package com.ex01.rest.activitylog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nguyendee
 *
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        Set<String> protocols = new HashSet<String>();
        protocols.add("http");
        protocols.add("https");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                    .apiInfo(apiEndPointsInfo())
                    .protocols(protocols)
                    .tags(new Tag("Student Activity Log", "Service Student Activity Log"));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Account REST API").description("Account REST API")
                .contact(new Contact("Cong Hau", "https://www.facebook.com/profile.php?id=100009018005795", "hau2803nch@gmail.com")).license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
    }
}
