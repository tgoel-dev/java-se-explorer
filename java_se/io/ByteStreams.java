package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreams {

	public static void byteStreams(String fileToRead, String fileToWrite) {

		String path = "/home/t008/eclipse-workspace/Java/test_files/";
		String iFile = path + fileToRead;
		String oFile = path + fileToWrite;

		// IO is typically enclosed with try-with-resources to auto-close IO objects.
		try (InputStream in = new FileInputStream(iFile); OutputStream out = new FileOutputStream(oFile)) {

			/*
			 * I/OStream are abstract classes with abstract read/write methods.
			 * FileI/OStream classes are the most commonly used concrete classes from the
			 * I/OStream JRE library.
			 */
			int byteRead;

			while ((byteRead = in.read()) != -1) {
				/*
				 * this.read() reads a raw byte and returns an int [-1, 255]; and advances the
				 * cursor to the next byte (thus int byteRead is used to store the byte). -1 is
				 * returned if there is no next byte to read.
				 */

				out.write(byteRead);
				// this.write(b) writes the raw byte, and advances the cursor.
			}

			/*
			 * The read/write methods read one byte at a time. To increase efficiency a
			 * memory buffer {similar to a cache} is used.
			 * 
			 * Classes BufferedI/OStream are used to add this functionality. Note:
			 * BufferedI/OStream are wrapper classes that simply add a buffer; FileI/OStream
			 * instances are still required to implement the read/write.
			 * 
			 * (+) Far more efficient.
			 */
			try (InputStream bufferedIn = new BufferedInputStream(in);
					OutputStream bufferedOut = new BufferedOutputStream(out)) {
				// Decorator Pattern.

				byte[] bufferedBytes = new byte[8192];
				int bufferedByteRead;

				/*
				 * BufferedI/OStream read/write methods use a byte[] as parameter.
				 */
				while ((bufferedByteRead = bufferedIn.read(bufferedBytes)) != -1) {
					bufferedOut.write(bufferedBytes, 0, bufferedByteRead);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
