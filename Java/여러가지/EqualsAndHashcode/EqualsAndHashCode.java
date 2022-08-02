package Java.EqualsAndHashcode;

import java.util.Objects;

/**
 * date: 22.07.01
 */

public class EqualsAndHashCode {
    public static void main(String[] args) {
        
    }

    static class A{
        int index;
        String name;

        public boolean equals(Object o){
            // 1. 객체 주소값이 같으면 볼 것 없이 true
            if(this == o) return true;
            
            // 2. parameter가 null이거나, 현재 classType이 parameter의 classType과 일치하지 않으면 false
            if( o == null || this.getClass() != o.getClass()) return false;

            // 3. 이제부터 비교. 다운캐스팅
            A a = (A) o;

            // 4. 인자값들이 같으면 true . 이 때 String은 Objects.equals를 사용
            return index == a.index && Objects.equals(this.name, a.name);
        }

        // Objects.hash를 사용. 그냥 parameter값들을 넘겨주면 된다.
        public int hashCode(){
            return Objects.hash(index,name);
        }
    }
}
