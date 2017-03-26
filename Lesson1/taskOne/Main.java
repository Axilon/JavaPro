package taskOne;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Test a = new Test();
		Class<?> someClass = a.getClass();
		try {
			Method method = someClass.getDeclaredMethod("printSum",
					int.class,int.class);
			if(method.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
				method.invoke(a, myAnnotation.paramOne(),myAnnotation.paramTwo());
			}
		} catch (NoSuchMethodException   | 
				IllegalAccessException   | 
				IllegalArgumentException | 
				InvocationTargetException e) {
			System.out.println(e);
		}

	}

}
