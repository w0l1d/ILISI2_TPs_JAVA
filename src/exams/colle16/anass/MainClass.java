package exams.colle16.anass;


public class MainClass {
   public static boolean test = true;

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Thread A = new Thread(new ThreadA());
      ThreadB B = new ThreadB();

//		MyThread A = new MyThread("A");
//		MyThread B = new MyThread("B");
//
      A.start();
      B.start();
   }

}
