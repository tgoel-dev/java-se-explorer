package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Serialization, "transient".
 * 
 * Serialization can save the state of an Object.
 * 
 * Especially useful for saving objects that are read much more often than they
 * are written; for passing objects over a network, and; for post-mortem
 * analysis (critical errors).
 */
public class Serialization implements Serializable {

	public int criticalData;
	public static int staticVar = 0;
	public transient int nonCriticalData = 0;
	
	/*
	 * transient variables are skipped during serialization, and given the default
	 * value during deserialization.
	 */

	private static final long serialVersionUID = 1L;
	/*
	 * Keeps the serialVersionUID constant, regardless of changes to the class;
	 * allows for deserialization of legacy objects.
	 * 
	 * Note: Deserialization can still fail: making a serializable class
	 * non-serializable or changing the type of an instance variable.
	 */

	public Serialization(int criticalData1, int nonCriticalData) {
		this.criticalData = criticalData1;
		this.nonCriticalData = nonCriticalData;
		staticVar++;
	}

	public void serialize() {
		/*
		 * Note: Serialization can fail if any of the referenced objects being
		 * serialized are not serializable.
		 */

		// ObjectOutputStream is used for serialization.
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("object1.ser")))) {
			// .ser files are simply a convention for serialization.

			out.writeObject(this);
			out.writeObject("Date/time of error: ");
			out.writeObject(new Date()); // Logs the date/time of the object serialization.

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unused", "static-access" })
	public void deserialize() {
		/*
		 * Note: Deserialization can fail due to various reasons. Most commonly: version
		 * mismatch, which can be handled via serialVersionUID.
		 */

		// ObjectInputStream is used for deserialization.
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("object1.ser")))) {

			// Read in the order written.
			Serialization obj = (Serialization) in.readObject(); // Stores the object.
			String info = (String) in.readObject();
			Date dateTime = (Date) in.readObject();

			int recoverableData = obj.criticalData; // Data recovered.
			int staticData = obj.staticVar; // Data not recovered. 
			int nonRecoverableData = obj.nonCriticalData; // Data not recovered; returns default value;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
