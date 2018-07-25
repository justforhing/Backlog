package com.hing.util;

import java.nio.charset.Charset;

public class EncryptDecodeUtil {
	private static final String key0 = "FECOI()*&<MNCXZPKL";  
    private static final Charset charset = Charset.forName("UTF-8");  
    private static byte[] keyBytes = key0.getBytes(charset);  
	public static String Encrypt(String str) {
		byte[] b = str.getBytes(charset);  
        for(int i=0,size=b.length;i<size;i++){  
            for(byte keyBytes0:keyBytes){  
                b[i] = (byte) (b[i]^keyBytes0);  
            }  
        }  
        return new String(b);  
	}
	
	public static String Decode(String str) {
		 byte[] b = str.getBytes(charset);  
	        for(int i=0,size=b.length;i<size;i++){  
	            for(byte keyBytes0:keyBytes){  
	                b[i] = (byte) (b[i]^keyBytes0);  
	            }  
	        }  
	        return new String(b);  
	}
}
