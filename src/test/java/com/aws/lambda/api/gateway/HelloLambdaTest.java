package com.aws.lambda.api.gateway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.Context;

class HelloLambdaTest {

	@Test
	void testHandleRequestReturnsExpectedResponse() {
		// Arrange
		HelloLambda handler = new HelloLambda();
		Map<String, Object> input = new HashMap<>();
		Context context = new TestContext(); // mock context

		// Act
		Map<String, Object> result = handler.handleRequest(input, context);

		// Assert
		assertEquals(200, result.get("statusCode"));

		@SuppressWarnings("unchecked")
		Map<String, String> headers = (Map<String, String>) result.get("headers");
		assertNotNull(headers);
		assertEquals("application/json", headers.get("Content-Type"));

		String body = (String) result.get("body");
		assertEquals("{\"message\": \"Hello from AWS Lambda!\"}", body);
	}
}
