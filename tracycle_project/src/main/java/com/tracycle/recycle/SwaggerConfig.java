package com.tracycle.recycle;
	import static com.google.common.base.Predicates.or;
	import static springfox.documentation.builders.PathSelectors.regex;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	import com.google.common.base.Predicate;

	import springfox.documentation.builders.ApiInfoBuilder;
	import springfox.documentation.service.ApiInfo;
	import springfox.documentation.service.Contact;
	import springfox.documentation.spi.DocumentationType;
	import springfox.documentation.spring.web.plugins.Docket;
	import springfox.documentation.swagger2.annotations.EnableSwagger2;

	@Configuration
	@EnableSwagger2
	public class SwaggerConfig {
		@Bean
		public Docket postsApi() {
			return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
					.apiInfo(apiInfo()).select().paths(postPaths()).build();
		}

		private Predicate<String> postPaths() {
			return or(regex("/api/posts.*"), regex("/api.*"));
		}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("Encore API")
				.description("Encore API Reference for Data Scientists Developers")
				.termsOfServiceUrl("https://playdata.io")
				.contact(
					new Contact("Ha Seung Hyun", "https://playdata.io",
					"sueup@daum.net"))
				.license("Encore License 0.9")
				.licenseUrl("https://www.en-core.com/consult/consult1")
				.version("0.9")
				.build();
		}
	}