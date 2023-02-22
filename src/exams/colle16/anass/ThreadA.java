package exams.colle16.anass;


public class ThreadA implements Runnable {

   @Override
   public void run() {
      // TODO Auto-generated method stub
      for (int k = 0; k < 6; k++) {
         synchronized (System.out) {
            while (!MainClass.test) {
               try {
                  System.out.wait();
               } catch (InterruptedException e) {
               }
            }
            System.out.println("Affichage du thread A :");
            for (int i = 2; i < 7; i++)
               System.out.println(i + "eme ligne du thread A");
            MainClass.test = false;
            System.out.notify();
         }
      }
   }

}
