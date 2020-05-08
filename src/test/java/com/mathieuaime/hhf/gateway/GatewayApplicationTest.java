package com.mathieuaime.hhf.gateway;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockOidcLogin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureWebTestClient
@AutoConfigureWireMock(port = 18090)
class GatewayApplicationTest {

  @Autowired
  private WebTestClient client;

  @Test
  void testGetAnonymously() {
    client.get().uri("/test").exchange()
        .expectStatus().isNotFound();
  }

  @Test
  void testPostAnonymously() {
    client.post().uri("/test").exchange()
        .expectStatus().is3xxRedirection()
        .expectHeader().value(HttpHeaders.LOCATION, is("/oauth2/authorization/keycloak"));
  }

  @Test
  void testPostAuthenticated() {
    client.mutateWith(mockOidcLogin().idToken(builder -> builder.subject("Subject A")))
        .post().uri("/test").exchange()
        .expectStatus().isNotFound();
  }
}