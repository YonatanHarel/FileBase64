package base64Example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class Base64Example {

	/**
	 * Decode string to file
	 * @param fileString - The string to decode
	 */
	public static void decode(String fileString) {
		FileOutputStream fos;
		byte[] bFileDecodeString = Base64.getDecoder().decode(fileString);

		try {
			fos = new FileOutputStream("test_decoded.txt");
			fos.write(bFileDecodeString);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Encode file to string
	 * @param file
	 * @return string
	 */
	public static String encode(File file) {
		byte[] bFile;
		byte[] bEncodedFile = null;
		try {
			bFile = Files.readAllBytes(file.toPath());
			bEncodedFile = Base64.getEncoder().encode(bFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(bEncodedFile);
	}

	public static void main (String args[]) {
		String encodedFileStr;
		File fileToEncode = new File("test.txt");

		encodedFileStr = encode(fileToEncode);
		System.out.println(encodedFileStr);
		decode(encodedFileStr);
	}
}
