package taskTwo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Saver a = new Saver();
		Class<?> someClass = a.getClass();
		try {
			Method method = someClass.getDeclaredMethod("savingSomeTextToFile", String.class);
			SaveTo saveTo = method.getAnnotation(SaveTo.class);
			method.invoke(a, saveTo.path() );
		} catch (NoSuchMethodException | 
				 IllegalAccessException |
				 IllegalArgumentException |
				 InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
