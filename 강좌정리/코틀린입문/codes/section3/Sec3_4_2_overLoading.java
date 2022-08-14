package 강좌정리.코틀린입문.codes.section3;

public class Sec3_4_2_overLoading {
    public static void main(String[] args) {
    }

    public void repeat(String str, int num, boolean useNewLine){
        for(int i=1;i<=num;i++){
            if(useNewLine){
                System.out.println(str);
            }else{
                System.out.println(str + "none");
            }
        }
    }

    public void repeat(String str, int num){
        repeat(str,num,true);
    }
    public void repeat(String str){
        repeat(str,3,true);
    }
}
