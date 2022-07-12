package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

@SuppressWarnings({"unused", "resource"})
public class CharStreams {

	public static void charStreams(String fileToRead, String fileToWrite) {
		// Character Streams mostly mirror Byte Streams.

		String path = "/home/t008/eclipse-workspace/Java/test_files/";
		String iFile = path + fileToRead;
		String oFile = path + fileToWrite;

		try (InputStream in = new FileInputStream(iFile); OutputStream out = new FileOutputStream(oFile)) {
			// Reader and Writer are abstract classes with abstract read/write methods.

			/*
			 * FileReader/Writer classes use the default encoding scheme of the current
			 * system; (-) making the code platform-dependent (not recommended).
			 */
			Reader inp = new FileReader(iFile);
			Writer outp = new FileWriter(oFile);

			/*
			 * Instead, most commonly, I/OStreamReader/Writer classes are used. They specify
			 * the encoding scheme being used (UTF-16 by default).
			 */
			Reader charIn = new InputStreamReader(in);
			Writer charOut = new OutputStreamWriter(out, "UTF-16");

			int byteRead;
			while ((byteRead = in.read()) != -1) {
				/*
				 * this.read() reads a char and returns an int [-1, 65535]; and advances the
				 * cursor to the next byte (thus int byteRead is used to store the byte). -1 is
				 * returned if there is no next byte to read.
				 */

				out.write(byteRead);
				// this.write(b) writes the char, and advances the cursor.
			}

			try (BufferedReader bufferedIn = new BufferedReader(charIn); 
					BufferedWriter bufferedOut = new BufferedWriter(charOut)) {

				String line;
				
				while ((line = bufferedIn.readLine()) != null) {
					bufferedOut.write(line);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
