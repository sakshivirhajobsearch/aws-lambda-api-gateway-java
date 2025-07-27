package com.aws.lambda.api.gateway;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambda implements RequestHandler<Map<String, Object>, Map<String, Object>> {

	@Override
	public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
		Map<String, Object> response = new HashMap<>();

		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");

		response.put("statusCode", 200);
		response.put("headers", headers);
		response.put("body", "{\"message\": \"Hello from AWS Lambda!\"}");

		return response;
	}
}