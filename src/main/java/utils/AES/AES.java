package utils.AES;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	
	public static byte[] encrypt(String content, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		byte[] byteContent = content.getBytes("utf-8");
		cipher.init(1, key);
		return cipher.doFinal(byteContent);
	}

	public static byte[] decrypt(byte[] content, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(2, key);
		return cipher.doFinal(content);
	}

	public static byte[] hexToByteArray(String hex) {
		String digital = "0123456789ABCDEF";
		char[] hex2char = hex.toCharArray();
		byte[] bytes = new byte[hex.length() / 2];

		for (int i = 0; i < bytes.length; ++i) {
			int temp = digital.indexOf(hex2char[2 * i]) * 16;
			temp += digital.indexOf(hex2char[2 * i + 1]);
			bytes[i] = (byte) (temp & 255);
		}

		return bytes;
	}

	public static String byteArrayToHex(byte[] byteArray) {
		char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] resultCharArray = new char[byteArray.length * 2];
		int index = 0;
		byte[] arg6 = byteArray;
		int arg5 = byteArray.length;

		for (int arg4 = 0; arg4 < arg5; ++arg4) {
			byte b = arg6[arg4];
			resultCharArray[index++] = hexDigits[b >>> 4 & 15];
			resultCharArray[index++] = hexDigits[b & 15];
		}

		return new String(resultCharArray);
	}

	public static void main(String[] args) {
		

	}
}