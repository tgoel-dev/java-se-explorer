package io;

import java.io.File;

/**
 * Streams are used to read/write data from a file in Java.
 */
public class StreamIO {

	/*
	 * Streams (belonging to java.io.*) are of two types:
	 * 
	 * (1) Byte streams (used for binary files, ex: images, audios, videos, etc).
	 * (2) Character streams (used for text files).
	 * 
	 * [Technically, char streams are binary streams too, but the differentiation is
	 * made due to high use-cases].
	 */

	/*
	 * The File class simply represents the path of the file, and not the contents
	 * of the file. It can used by many of the streams.
	 */
	@SuppressWarnings("unused")
	public static void fileClass(String filename) {
		try {
			File f = new File(filename);

			String path = f.getAbsolutePath();
			String sepr = File.separator; // returns \ (Windows) or / (MacOS/Linux)
			// Allows for platform independence.

			// Checking permissions:
			f.canRead();
			f.canExecute();
			f.canWrite();

			// Obtaining file/directory info:
			f.lastModified();
			f.isFile();
			f.isDirectory();
			f.list(); // ls -l; in case of files, returns null.

			// Craeting/Deleting files/folders (requires try-catch):
			(new File("test")).mkdir(); // Creates a folder named test
			// (new File("test.txt")).createNewFile(); // Creates a new file.
			f.renameTo(new File("new_dir/renamed.txt"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
