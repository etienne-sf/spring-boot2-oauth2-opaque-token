package com.marcosbarbero.lab.sec.oauth.opaque.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
curl -u "clientId:secret" -X POST "http://localhost:9001/oauth/token?grant_type=password&username=user&password=pass" --noproxy "*" -i
 * </pre>
 * 
 * <pre>
curl -i "http://localhost:9101/me" -H "Authorization: Bearer 8c8e4a5b-d903-4ed6-9738-6f7f364b87ec" --noproxy "*"
 * </pre>
 * 
 */
@SpringBootApplication
public class ResourceServerOpaqueApplication {

	public static void main(String... args) {
		SpringApplication.run(ResourceServerOpaqueApplication.class, args);
	}
}
