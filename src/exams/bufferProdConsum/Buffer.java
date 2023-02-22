package exams.bufferProdConsum;

public class Buffer {
   private String data;

   public Buffer() {
      data = null;
   }

   public synchronized String get() {
      while (data == null) {
         try {
            wait();
         } catch (InterruptedException ignored) {
         }
      }
      String tmp = data;
      data = null;
      notifyAll();
      return tmp;
   }

   public synchronized void put(String dt) {
      while (data != null) {
         try {
            wait();
         } catch (InterruptedException ignored) {
         }
      }
      data = dt;
      notifyAll();
   }

}
