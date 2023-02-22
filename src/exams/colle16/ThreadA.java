package exams.colle16;

public class ThreadA implements Runnable {
   @Override
   public void run() {
      int cpt = 6;
      while (true) {
         synchronized (System.out) {
            System.out.println("Affichage du thread A :");
            for (int i = 2; i <= 6; i++) {
               try {
                  Thread.sleep(200);
               } catch (InterruptedException e) {
                  throw new RuntimeException(e);
               }
               System.out.println(i + "eme ligne du thread A");
            }
            System.out.notifyAll();
            cpt--;
            if (cpt == 0)
               break;

            try {
               System.out.wait();
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
         }
      }
   }
}
