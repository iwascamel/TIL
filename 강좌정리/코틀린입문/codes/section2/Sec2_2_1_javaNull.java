package 강좌정리.코틀린입문.codes.section2;

public class Sec2_2_1_javaNull {
    public static void main(String[] args) {

    }

    // null이 들어올 수 있기 때문에 안전 x
    public boolean startsWithA(String str){
        return str.startsWith("a");
    }

    // 1. throw
    public boolean startWithAV1(String str){
        if(str == null){
            throw new IllegalArgumentException("null");
        }
        return str.startsWith("a");
    }

    // 2. Boolean, null
    public Boolean startWithAV2(String str){
        if(str == null){
            return null;
        }
        return str.startsWith("a");
    }

    // 3. true false
    public boolean startWithAV3(String str){
        if(str == null){
            return false;
        }
        return str.startsWith("a");
    }
}
