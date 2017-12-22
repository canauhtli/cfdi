package com.canauhtli.cfdi.utils;

import java.util.prefs.Preferences;

import org.jasypt.util.text.BasicTextEncryptor;

public class AppConfig {

	private static final String ENC_PASSWORD = "C4mb1am3";
	private static Preferences userPrefs = Preferences.userRoot().node("/com/canauhtli/cfdi/config");
	
	public static void setUserValEnc(String key, String value) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(ENC_PASSWORD);
		String encValue = textEncryptor.encrypt(value);
		userPrefs.put(key, encValue);
	}
	
	public static String getUserValEnc(String key) {
		String value = "";
		String encValue = userPrefs.get(key, key);
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(ENC_PASSWORD);
		if (!key.equals(encValue)) {
			value = textEncryptor.decrypt(encValue);
		}
		return value;
	}
	
	public static void setUserVal(String key, String value) {
		userPrefs.put(key, value);
	}
	
	public static String getUserVal(String key) {
		String value = "";
		String kval = userPrefs.get(key, key);
		if (!key.equals(kval)) {
			value = kval;
		}
		return value;
	}
}
