package exams.colle16;

public class Main {


   public static void main(String[] args) throws InterruptedException {
      Thread threadA = new Thread(new ThreadA());
      Thread threadB = new ThreadB();


      threadA.start();
      threadB.start();


      threadA.join();
      threadB.join();


   }
}
