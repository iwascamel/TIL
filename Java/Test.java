package Java;

public class Test{
    public static void main(String[] args)  {
        ThisType<Animal> animalThisType = new ThisType<>();
    }

    static class ThisType<T>{
        T data;
    }

    static class Animal{

    }
    static class Dog extends Animal{

    }
}