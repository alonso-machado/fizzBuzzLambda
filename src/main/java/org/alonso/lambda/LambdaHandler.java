package org.alonso.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.stream.IntStream;

public class LambdaHandler implements RequestHandler<String, String> {
	public String handleRequest(String input, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("Input: " + input +"\n");
		try {
			Integer value = Integer.parseInt(input);
			if(value <= 150) {
				IntStream.rangeClosed(1, value).forEach(i -> {
					StringBuilder sb = new StringBuilder();
					if (i % 3 == 0 && i % 5 == 0) {
						sb.append(i + " C\n");
					} else if (i % 3 == 0) {
						sb.append(i + " A\n");
					} else if (i % 5 == 0) {
						sb.append(i + " B\n");
					} else {
						sb.append(i+"\n");
					}

					logger.log(sb.toString());
				});
				return input.toUpperCase();
			} else {
				logger.log("Input is greater than 150");
				return "Input is greater than 150";
			}
		} catch (NumberFormatException e) {
			logger.log("Input is not a number");
			return "Input is not a number";
		}
	}

}
