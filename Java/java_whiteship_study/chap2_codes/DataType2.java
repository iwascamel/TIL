package Java.java_whiteship_study.chap2_codes;

public class DataType2 {
    static int count;
    static class Car{
        int index = 0;
        String color;

        {
            count++;
        }

        public Car(){
            index = count;
            this.color = "white";
        }

        public Car(String color) {
            this.index = count;
            this.color = color;
        }
        
    }
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("red");

        System.out.println(c1.index);
        System.out.println(c2.index);
    }
}
