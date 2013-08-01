package bbstorespringmvc.utile;

import java.lang.reflect.ParameterizedType;

public class ClassUtile {

	public static Class getClassType(Object springBean, Object baseSpringBean) {

		Class<?> beanRepositoryClass = null;

		if (springBean.getClass().getSuperclass() == baseSpringBean) {

			beanRepositoryClass = springBean.getClass();

		} else {

			beanRepositoryClass = springBean.getClass().getSuperclass()
					.getClass();

		}

		return (Class) ((ParameterizedType) beanRepositoryClass.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

	}

}
