/**
 * @Date          2019年6月6日 上午11:42:00 

 * @version    V1.0 
 */
package utils.AES;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author MML
 * @Date 2019-06-06
 * @version V1.0
 */
public class AES2 {
	
	public static final String AES_KEY = "2019gdjy";

	public static Key genKey() {
		Key key = null;
		try {
			// 生成Key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			keyGenerator.init(128);
			 keyGenerator.init(128, new SecureRandom("seed".getBytes()));
			// 使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			// Key转换
			key = new SecretKeySpec(keyBytes, "AES");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return key;
	}

	public static String jdkAESEncode(String password) {
		String encodePwd = "";
		try {
			// 生成Key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			keyGenerator.init(128);
			 keyGenerator.init(128, new SecureRandom("seed".getBytes()));
			// 使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			// Key转换
			Key key  = new SecretKeySpec(keyBytes, "AES");
			// 加密
			Cipher cipher = Cipher.getInstance("AES"); /// ECB/PKCS5Padding
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encodeResult = cipher.doFinal(password.getBytes());
//			encodePwd = parseByte2HexStr(encodeResult);
			encodePwd = byteArrayToHex(encodeResult);
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException  e) {
			e.printStackTrace();
		}
		return encodePwd;
	}
	
	 /**
     * 加密
     * 
     * @param content
     *            需要加密的内容
     * @param password
     *            加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
	
    /**
     * 解密
     * 
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

	public static String  jdkAESDecode(String encodeStr) {
		
		String password = "";
		try {
			// 生成Key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			keyGenerator.init(128);
			 keyGenerator.init(128, new SecureRandom("seed".getBytes()));
			// 使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			// Key转换
			Key key  = new SecretKeySpec(keyBytes, "AES");

			// 解密
			Cipher cipher = Cipher.getInstance("AES"); 
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodeResult = cipher.doFinal(hexToByteArray(encodeStr));
			password = new String(decodeResult);
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return  password;
	}
	
	/**
	 * 对密码进行加密
	 * @param password
	 * @return
	 * @Date    2019-06-06
	 * @version 1.0
	 */
	public static String AESEncrypt(String password) {
		try {
			String keyword = "gdjy2019";
			byte[] encode = AES.encrypt(password, keyword);
			password = AES.byteArrayToHex(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
		
		
	}
	
	/**
	 * 对密码进行解密
	 * @param password
	 * @return
	 * @Date    2019-06-06
	 * @version 1.0
	 */
	public static String AESDecrypt(String password) {
		try {
			String keyword = "gdjy2019";
			byte[] encode = AES.hexToByteArray(password);
			byte[] decode = AES.decrypt(encode, keyword);
//			byte[] debyte = parseHexStr2Byte(decode);
			password = new String(decode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
	
	public static boolean  checkPassword(String password, String encodeStr) throws Exception {
		boolean result = false;
		byte[] decode = AES.hexToByteArray(encodeStr);
		byte[] deResult = AES.decrypt(decode, AES_KEY);
		String decodeStr = new String(deResult);
		if(password.equals(decodeStr)) {
			result = true;
		}
		return result;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}
	
    /**
     * 将16进制转换为二进制
     * 
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
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
	
	public static void main(String[] args) throws Exception {

		String pwd = "123456";
		String keyword = "gdjy2019";
		byte[] encode = AES.encrypt(pwd, AES_KEY);  //加密和解密要使用同一个key
		String code = AES.byteArrayToHex(encode);  //把加密后的字符数组转成16进制字符串
		System.out.println(code);
		System.out.println(AES.byteArrayToHex(AES.encrypt(pwd, AES_KEY)));
//		byte[] content = AES.hexToByteArray("CB53B966BB008522E33737F44C63B4E7");
		byte[] decode = AES.hexToByteArray("82DB7256C6646A282CE845B9B5671AC6");  //解密时，先把要解密的字符串转成2进制数组
//		byte[] deResult = AES.decrypt(decode, AES_KEY);  //解密时不能使用全局静态变量？
		byte[] deResult = AES.decrypt(decode, keyword);  //解密后的结果也是二进制数组
		System.out.println(new String(deResult));  //把二进制转成字符串（还原）
//		String de = AESDecrypt(code);
		System.out.println(11);
//		System.out.println(de);
		
//		 String content = "123456";  //这个是加密的
//	        String password = "flag";
//	        // 加密
//	        System.out.println("加密前：" + content);
//	        byte[] encode = encrypt(content, password);
//	        
//	        //传输过程,不转成16进制的字符串，就等着程序崩溃掉吧
//	        String code = parseByte2HexStr(encode);
//	        System.out.println("密文字符串：" + code);
//	        byte[] decode = parseHexStr2Byte(code);
//	        // 解密
//	        byte[] decryptResult = decrypt(decode, password);
//	        System.out.println("解密后：" + new String(decryptResult, "UTF-8")); //不转码会乱码
	}
	
	
	
	

}
