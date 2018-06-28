package com.app.utils;

import java.util.concurrent.ThreadLocalRandom;

import static com.app.base.AppConfig.*;

public class RandomCode {
	
	/**
	 * 使用系统默认字符源生成验证码
	 * @return
	 */
	public static String getCode() {
		int verifySize = COED_SIZE;
		String sources = CODE_SOURCES;
		int codesLen = sources.length();
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		StringBuilder verifyCode = new StringBuilder(verifySize);
		for (int i = 0; i < verifySize; i++) {
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}

		return verifyCode.toString();
	}
}
