package com.app.utils;

import java.util.concurrent.ThreadLocalRandom;

import static com.app.base.AppConfig.*;

public class RandomCode {

	public static String getCode() {
		return CreateCode(CODE_SOURCES);
	}

	public static String getNumCode() {
		return CreateCode(NUM_SOURCES);
	}

	private static String CreateCode(String sources) {
		int verifySize = COED_SIZE;
		int codesLen = sources.length();
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		StringBuilder verifyCode = new StringBuilder(verifySize);
		for (int i = 0; i < verifySize; i++) {
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}

		return verifyCode.toString();
	}
}
