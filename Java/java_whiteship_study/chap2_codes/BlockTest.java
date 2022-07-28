package Java.java_whiteship_study.chap2_codes;

public class BlockTest {
    public static void main(String[] args) {
        BlockTest bt1= new BlockTest();
        BlockTest bt2= new BlockTest();

    }

    static {
        System.out.println("static block");
    }

    {
        System.out.println("instance block");
    }

    public BlockTest(){
        System.out.println("constructor");
    }
}
