package demo;

public class MainThread {
    public static void main(String[] args){
        Sub1 s1=new Sub1(0,30);
        s1.run();
        Sub2 s2=new Sub2();
        Thread t=new Thread(s2);
        t.start();
        Runnable r=()->{
            for (int i=0;i<20;i++){
                System.out.println("Main i="+i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        };
        Thread t2=new Thread(r);
        t2.start();
        // tạo thread chạy luôn mà ko cần khai báo biến
        new Thread(()->{
            // cần chạy gì thì code vào đây
            for (int i = 0; i < 20; i++) {
                System.out.println("Main2 i = " + i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }).start();
//        Sub1 s2=new Sub1();
//        s2.run();
//        for (int i=0;i<20;i++){
//                System.out.println("Main i = "+i);
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//
//                }
//        }
    }
}
