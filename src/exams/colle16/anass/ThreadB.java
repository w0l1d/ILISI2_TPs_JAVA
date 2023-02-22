package exams.colle16.anass;


public class ThreadB extends Thread {
   public void run() {
      // TODO Auto-generated method stub
      for (int k = 0; k < 6; k++) {
         synchronized (System.out) {
            while (MainClass.test) {
               try {
                  System.out.wait();
               } catch (InterruptedException e) {
               }
            }
            System.out.println("Affichage du thread B :");
            for (int i = 2; i < 7; i++)
               System.out.println(i + "eme ligne du thread B");
            MainClass.test = true;
            System.out.notify();
         }
      }
   }
}
