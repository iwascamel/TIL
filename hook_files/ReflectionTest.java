package hook_files;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Class<?> dogClassReflection = Class.forName("hook_files.ReflectionTest$Dog");

        Constructor<?> constructor1 = dogClassReflection.getDeclaredConstructor();
        Constructor<?> constructor2 = dogClassReflection.getDeclaredConstructor(String.class);
        Constructor<?> constructor3 = dogClassReflection.getDeclaredConstructor(String.class, int.class);

        constructor1.setAccessible(true);
        Object dog1 = constructor1.newInstance();
        Object dog2 = constructor2.newInstance("호두");
        Object dog3 = constructor3.newInstance("cherry",5);

        System.out.println("dog1 = " + dog1);

    }
    static class Dog{
        private static final String CATEGORY = "동물";

        private String name;
        private int age;

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

