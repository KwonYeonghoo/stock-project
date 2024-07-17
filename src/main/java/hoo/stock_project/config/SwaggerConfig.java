package hoo.stock_project.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hoo.stock_project.controller.detailController;
import hoo.stock_project.controller.mainController;
import hoo.stock_project.controller.portfolioController;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("API Test")
                .description("Let's practice Swagger UI")
                .version("v1");
    }

    @Bean
    public GroupedOpenApi chatOpenApi() {
        // "/v1/**" 경로에 매칭되는 API를 그룹화하여 문서화한다.

        return GroupedOpenApi.builder()
                .group("나스닥나랑해 API v1")  // 그룹 이름을 설정한다.
                .pathsToMatch("/**")     // 그룹에 속하는 경로 패턴을 지정한다.
                .build();
    }

    static {
        SpringDocUtils.getConfig().addRestControllers(detailController.class, mainController.class, portfolioController.class);
    }
}
