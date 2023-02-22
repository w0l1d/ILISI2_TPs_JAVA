package exams.colle16;

public class ThreadB extends Thread {

   @Override
   public void run() {
      int cpt = 6;
      while (true) {
         synchronized (System.out) {
            System.out.println("Affichage du thread B :");
            for (int i = 2; i <= 6; i++) {
               try {
                  Thread.sleep(300);
               } catch (InterruptedException e) {
                  throw new RuntimeException(e);
               }
               System.out.println(i + "eme ligne du thread B");
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
