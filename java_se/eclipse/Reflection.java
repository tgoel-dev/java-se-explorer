package eclipse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Reflection allows JVM to read metadata (and annotations) about java programs,
 * and its methods.
 * 
 * (+) Reflections allows IDEs to recommend method completions, and issue
 * resolution suggestions. Reflection is also used by dynamic proxies. (-)
 * Slower than non-reflection.
 */
@SuppressWarnings({ "unused", "rawtypes" })
public class Reflection {

	/*
	 * Class Objects are used to store the metadata.
	 */
	public static <T> void ObtainingClassObjects(T input) {

		// Obtaining class object using a reference.
		Class classObj1 = input.getClass();
		System.out.println(classObj1.toString());

		try {
			// Obtaining class object using the Class.forName() factory method.
			Class string = Class.forName("[Ljava.lang.String;"); // arg must be a FQ class name.
			Class doubleArray = Class.forName("[[D"); // [[D = 2D Array of primitive double.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Obtaining class object using "class literals".
		Class clazz = Reflection.class; // clazz is convention for class objects.
		Class primitiveInt = int.class;
		Class primitiveVoid = void.class;
		Class wrapperVoid = Void.TYPE;
	}

	public static <T> void classObjectMethods(T input) {

		Class clazz = input.getClass();

		System.out.println(clazz.getName());
		System.out.println(clazz.isInterface()); // returns boolean.
		System.out.println(clazz.getInterfaces()); // returns implemented interfaces.
		System.out.println(clazz.getSuperclass().getName());

		// Method class: used for method metadata information.
		for (Method m : clazz.getDeclaredMethods()) {

			System.out.println(m.getReturnType());
			System.out.println(m.getParameterCount());
			System.out.println(m.getModifiers());

			if (m.getReturnType() == void.class) {
				System.out.println("Void");
			}
		}

		// Constructor class: used for constructor metadata information.
		for (Constructor c : clazz.getConstructors()) {
			System.out.println(c.getParameterTypes());
		}
	}

}
