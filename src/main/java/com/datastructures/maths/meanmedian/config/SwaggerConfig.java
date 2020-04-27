package com.datastructures.maths.meanmedian.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan({ "com.datastructures.maths.meanmedian.controller" })
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket userApi() {
		List<ResponseMessage> list = new java.util.ArrayList<>();
		list.add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Result")).build());
		list.add(new ResponseMessageBuilder().code(400).message("Unauthorized").responseModel(new ModelRef("Result")).build());
		list.add(new ResponseMessageBuilder().code(406).message("Unacceptable").responseModel(new ModelRef("Result")).build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiinfo()).select().apis(RequestHandlerSelectors.basePackage("com.datastructures.maths.meanmedian.controller"))
				.build()
				.securitySchemes(Collections.singletonList(apikey()))
				.securityContexts(Collections.singletonList(securitycontext()));
	}
	
	
	private ApiInfo apiinfo() {
		
		return new ApiInfoBuilder().title("API for finding the mean and median of given numbers").description("This proj is for mean and median finding").version("1.0.0").license("Apache2.0.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
	
	 @Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("swagger-ui.html")
		        .addResourceLocations("classpath:/META-INF/resources/");

		    registry.addResourceHandler("/webjars/**")
		        .addResourceLocations("classpath:/META-INF/resources/webjars/");
		  }
	 
	 
	 private ApiKey apikey() {
		 
		 return new ApiKey("Authorization", "Authorization", "header");
	 }
	 
	 private SecurityContext securitycontext() {
		 
		 return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/MeanMedian.*"))
				 .build();
	 }
	 
	 private List<SecurityReference> defaultAuth(){
		 
		 AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		 AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];		 
		 authorizationScopes[0] = authorizationScope;
		 return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
	 }

}
