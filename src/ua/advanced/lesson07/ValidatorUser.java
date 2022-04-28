package ua.advanced.lesson07;

import java.lang.reflect.Method;

public class ValidatorUser {
    private static void rangeMethodObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Range.class)) {
                method.setAccessible(true);
                method.invoke(object);
            //    getKey(field), (String) field.get(object)
            }
        }
    }
    private static boolean isRangeFieldObject(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Range.class)) {
                field.setAccessible(true);
                Range range = field.getAnnotation(Range.class);
                int value = (int)field.get(object);
                if (value < range.min() || value>range.max()) throw new IllegalArgumentException();
            }
        }
        return true;
    }
    private static void notNullObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (var field : clazz.getFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
            }
        }
    }
    public static boolean validate(User user) throws Exception {
        return isRangeFieldObject(user);
    }
}
