package com.app.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	/**
	 * 将指定的字符串用MD5加密 originstr 需要加密的字符串
	 * 
	 * @param originstr
	 * @return
	 */

	public static String ecodeByMD5(String originstr) {
		String result = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		if (originstr != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] source = originstr.getBytes("utf-8");
				md.update(source);
				byte[] tmp = md.digest();
				char[] str = new char[32];
				for (int i = 0, j = 0; i < 16; i++) {
					byte b = tmp[i];
					str[j++] = hexDigits[b >>> 4 & 0xf];
					str[j++] = hexDigits[b & 0xf];
				}

				result = new String(str);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static final String str2MD5(String _str) {
		char[] hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
				'f' };
		try {
			byte[] strTemp = _str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; ++i) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 15];
				str[k++] = hexDigits[byte0 & 15];
			}

			return new String(str);
		} catch (Exception var10) {
			return null;
		}
	}

}