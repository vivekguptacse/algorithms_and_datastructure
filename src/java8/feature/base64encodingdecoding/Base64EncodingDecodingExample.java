package java8.feature.base64encodingdecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.List;

public class Base64EncodingDecodingExample
{
	public static void main(String[] args)
	{
		System.out.println("****************** Example 1 *******************");
		// Example 1 : Basic Encoding and Decoding
		basicEncodingDecoding();
		
		System.out.println("****************** Example 2 *******************");
		// Example 2 : URL Encoding and Decoding
		urlEncodingAndDecoding();
		 
		System.out.println("****************** Example 3 *******************");
		// Example 3 : MIME Encoding and Decoding
		mineEncodingDecoding();
		
	}
	
	/**
	 * MIME Encoding and Decoding
	 */
	private static void mineEncodingDecoding()
	{
		// Getting MIME encoder
		Base64.Encoder encoder = Base64.getMimeEncoder();

		String message = "Hello, \nYou are informed regarding your inconsistency of work";

		String eStr = encoder.encodeToString(message.getBytes());

		System.out.println("Encoded MIME message: " + eStr);

		// Getting MIME decoder
		Base64.Decoder decoder = Base64.getMimeDecoder();
		// Decoding MIME encoded message
		String dStr = new String(decoder.decode(eStr));
		System.out.println("Decoded message: " + dStr);
	}

	/**
	 * URL Encoding and Decoding
	 */
	private static void urlEncodingAndDecoding()
	{
		Encoder urlEncoder = Base64.getUrlEncoder();
		
		String url = "www.google.com";
		
		byte[] encode = urlEncoder.encode(url.getBytes());
		
		System.out.println("encoded URL -> " + Arrays.toString(encode));
		
		Decoder urlDecoder = Base64.getUrlDecoder();
		
		byte[] decode = urlDecoder.decode(encode);
		
		System.out.println("decoded url -> "+ new String(decode));
	}

	/**
	 * Basic Encoding and Decoding 
	 */
	private static void basicEncodingDecoding()
	{
		Encoder encoder = Base64.getEncoder();
		String textToEncode = "Vivek Base 64 Example";
		
		// encoding the byte array 
		byte[] encode = encoder.encode(textToEncode.getBytes());
		
		System.out.println("encoded byte array :" + Arrays.toString(encode));
		System.out.println(textToEncode.getBytes().length * 2);
		byte []byteArr = new byte[28];
		int encode2 = encoder.encode(textToEncode.getBytes(), byteArr);
		
		 System.out.println("Encoded byte array written to another array: " + Arrays.toString(byteArr));  
		
		System.out.println("Byte copied : " + encode2);
		
		// Decoding 
		
		Decoder decoder = Base64.getDecoder();
		
		byte[] decode = decoder.decode(encode);
		System.out.println(new String(decode));

		byte[] decode2 = decoder.decode(byteArr);
		
		System.out.println("decoded String : " + new String(decode2));
	}
}
