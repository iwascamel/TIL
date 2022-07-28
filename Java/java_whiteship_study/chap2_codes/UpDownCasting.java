package Java.java_whiteship_study.chap2_codes;

public class UpDownCasting {
    static class Person{
        String sex;
        public Person(String sex) {
            this.sex = sex;
        }
        
    }

    static class Student extends Person{
        String role;
        public Student(String sex) {
            super(sex);
        }
        public Student(String sex, String role) {
            super(sex);
            this.role = role;
        }
    }
    static class Gamer extends Person{
        String role;
        public Gamer(String sex) {
            super(sex);
        }
        public Gamer(String sex, String role) {
            super(sex);
            this.role = role;
        }
    }

    static void check(Person p){
        if(p instanceof Student){
            Student s = (Student) p;
            System.out.println(s.role);
        }
    }
    public static void main(String[] args) {
        Person g = new Gamer("남자","발로란트 타격대");
        Person s = new Student("여자","대학생");

        check(g);
        check(s);
    }
}
