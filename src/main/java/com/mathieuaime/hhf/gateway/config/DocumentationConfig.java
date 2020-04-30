package com.mathieuaime.hhf.gateway.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentationConfig {

  private final RouteDefinitionLocator locator;

  public DocumentationConfig(RouteDefinitionLocator locator) {
    this.locator = locator;
  }

  @Bean
  public GroupedOpenApi openApiBar() {
    return GroupedOpenApi.builder()
        .setGroup("bars")
        .pathsToMatch("/bars/**")
        .build();
  }

  @Bean
  public GroupedOpenApi openApiHappyHour() {
    return GroupedOpenApi.builder()
        .setGroup("happyhours")
        .pathsToMatch("/happyhours/**")
        .build();
  }

//  @Bean
//  public List<GroupedOpenApi> apis() {
//    return locator.getRouteDefinitions()
//        .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
//        .map(routeDefinition -> routeDefinition.getId().replaceAll("-service", ""))
//        .map(name -> name.replaceAll("-", "") + 's')
//        .map(name -> GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").setGroup(name)
//            .build())
//        .collectList().block();
//  }
}
