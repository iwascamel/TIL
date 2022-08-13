package 강좌정리.코틀린입문.codes.section2;

public class JavaMoney implements Comparable<JavaMoney>{
    private int money;

    public JavaMoney(int money) {
        this.money = money;
    }

    @Override
    public int compareTo(JavaMoney o) {
        return Integer.compare(this.money,o.money);
    }
}
