package hook_files;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionTest2 {
    public static void main(String[] args) throws Exception {
        Class<?> dogClassReflection = Class.forName("hook_files.ReflectionTest2$Dog");

        Constructor<?> constructor = dogClassReflection.getDeclaredConstructor(String.class, int.class);
        Object object = constructor.newInstance("cherry", 5);
        Field[] declaredFields = dogClassReflection.getDeclaredFields();

        for(Field field : declaredFields){
            field.setAccessible(true);
            System.out.println(field);
            System.out.println("value = " + field.get(object));
            System.out.println("---------------------");
        }
    }
    static class Dog{
        private static final String CATEGORY = "동물";

        private String name = "defaultName";
        private int age  = 0;

        private Dog(){
            this.name = "누렁이";
            this.age = 0;
        }
        public Dog(final String name){
            this.name = name;
            this.age = 0;
        }
        public Dog(final String name, final int age){
            this.name = name;
            this.age = age;
        }
    }
}

