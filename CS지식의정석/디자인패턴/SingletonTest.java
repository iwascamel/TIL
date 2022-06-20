package CS지식의정석.디자인패턴;

/*
 * date: 22.06.20
 */

public class SingletonTest {

    static class Singleton{
        private static class singletonHolder{
            private static final Singleton INSTANCE = new Singleton();
        }
        public static synchronized Singleton getInstance(){
            return singletonHolder.INSTANCE;
        }
    }

    public static void main(String[] args) {
        
    }
}
