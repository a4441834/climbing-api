package nl.redrock.climbersapi.swagger;

import static com.google.common.collect.Lists.newArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket climberApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/climber.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Climber API",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur consequat congue dignissim. Donec non fermentum nunc, quis sagittis nibh. Vestibulum ut ullamcorper ante. Pellentesque porttitor posuere dui, vel fringilla ex maximus vitae. Pellentesque facilisis orci et dictum finibus. Sed quis fermentum ligula, et posuere enim. Nulla ultricies a ex at elementum. Pellentesque tempor sit amet est eget blandit. Sed aliquam neque sed ante commodo, eget commodo turpis interdum. Praesent hendrerit accumsan enim, sed pellentesque dolor sollicitudin hendrerit. Suspendisse posuere libero in lectus egestas, quis imperdiet urna mollis.",
                "1.0",
                "Terms of service",
                new Contact("", "", "hugo@redrock-it.nl"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0"
        );
        return apiInfo;
    }


}
