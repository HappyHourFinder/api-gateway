package com.mathieuaime.hhf.gateway.config;

import org.springframework.context.annotation.Configuration;

/*
  TODO

  If we set a list of GroupedOpenApi, we don't have the list of definitions
  and /v3/api-docs/bars does not redirect to /bars/v3/api-docs

  If we set the GroupedOpenApi one by one, we have the list of definitions
  and /v3/api-docs/bars does not redirect to /bars/v3/api-docs

  If we set nothing, we don't have the list of definitions
  and /v3/api-docs/bars redirect well to /bars/v3/api-docs
 */
@Configuration
public class DocumentationConfig {
//  private final RouteDefinitionLocator locator;
//
//  public DocumentationConfig(RouteDefinitionLocator locator) {
//    this.locator = locator;
//  }
//
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
