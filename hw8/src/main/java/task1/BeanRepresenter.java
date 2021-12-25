package task1;

import java.lang.reflect.*;

public class BeanRepresenter {
    private Object object;
    private Class<?> objectClass;

    public BeanRepresenter(Object object) {
        this.object = object;
        objectClass = object.getClass();
    }

    public void representFields() throws IllegalAccessException {
        Field[] fields = objectClass.getDeclaredFields();
        System.out.println(objectClass.getSimpleName() + " has got such characteristics:");
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);
            System.out.println(field.getName() + " = " + value);
            field.setAccessible(false);
        }
    }

    public void representConstructors() {
        Constructor<?>[] constructors = objectClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print("Constructor's " + constructor.getDeclaringClass().getSimpleName() + " parameter types: ");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getTypeName() + " ");
            }
            System.out.println();
        }
    }

    public void representMethods() {
        Method[] methods = objectClass.getDeclaredMethods();
        System.out.println(objectClass.getSimpleName() + " has got such methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Ignore.class)) {
                System.out.println(method.getName() +  " has got annotation: " + method.getAnnotation(Ignore.class));
            } else {
                System.out.println(method.getName());
            }
        }
    }
}
