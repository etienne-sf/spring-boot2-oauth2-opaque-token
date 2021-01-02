package org.oauth2.opaque.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.UnAuthenticatedServerOAuth2AuthorizedClientRepository;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "api")
public class APIConfiguration {

	private String url;
	private String username;
	private String password;

	// @Bean
	// public OAuth2AuthorizedClientManager authorizedClientManager(
	// ClientRegistrationRepository clientRegistrationRepository,
	// OAuth2AuthorizedClientService authorizedClientService) {
	// OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
	// .password().build();
	//
	// AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = new
	// AuthorizedClientServiceOAuth2AuthorizedClientManager(
	// clientRegistrationRepository, authorizedClientService);
	// authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
	//
	// Map<String, Object> passwordAttributes = new HashMap<>();
	// passwordAttributes.put(OAuth2AuthorizationContext.USERNAME_ATTRIBUTE_NAME, getUsername());
	// passwordAttributes.put(OAuth2AuthorizationContext.PASSWORD_ATTRIBUTE_NAME, getPassword());
	//
	// authorizedClientManager.setContextAttributesMapper(request -> passwordAttributes);
	//
	// return authorizedClientManager;
	// }
	//
	// @Bean
	// public WebClient salesForceWebClient(
	// @Qualifier("salesForceAuthorizedClientManager") OAuth2AuthorizedClientManager authorizedClientManager) {
	// ServletOAuth2AuthorizedClientExchangeFilterFunction oAuth2Filer = new
	// ServletOAuth2AuthorizedClientExchangeFilterFunction(
	// authorizedClientManager);
	// oAuth2Filer.setDefaultClientRegistrationId("provider_test");
	// return WebClient.builder().filter(oAuth2Filer).baseUrl(getUrl()).build();
	// }

	@Bean
	WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
		ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
				clientRegistrations, new UnAuthenticatedServerOAuth2AuthorizedClientRepository());
		oauth.setDefaultClientRegistrationId("provider_test");
		return WebClient.builder().filter(oauth).build();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
