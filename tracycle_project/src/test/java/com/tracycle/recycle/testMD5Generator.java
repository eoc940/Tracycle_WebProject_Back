package com.tracycle.recycle;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.tracycle.recycle.util.MD5Generator;

public class testMD5Generator {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String input = "C:\board-server\files\23523n2n423l4";
		MD5Generator generator = new MD5Generator(input);
		System.out.println(generator.toString());
	
	}
}
