package com.audio.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {

	public static void main(String[] args) {
		
		char k = '가';
		
		byte by = (byte) k;
		System.out.println("k is "+by);
		
		byte back = by;
		char da = (char)back;
		System.out.println("da is " + da);
		
		String korean = "가";
		byte[] kb = korean.getBytes(StandardCharsets.UTF_8);
		for(int i = 0; i<kb.length; i++) {
			System.out.print(kb[i] + " ");
		}
		
		String rsea = new String(kb);
		System.out.println("\n"+rsea);
		
		byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };
		String ori = new String(byteArray1);
		String str = new String(byteArray1, 0, 3, StandardCharsets.UTF_8);
		System.out.println(ori);
		System.out.println(str);
		
		System.out.printf("%010d\n",010);
		// 10앞의 0은 : 8진수flag로 인식
	}
	
	public static byte[] sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		
		return md.digest();
	}
	
	public static String bytesToHex1(byte[] bytes) {
		
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		
		return builder.toString();
		
	}
	
}
