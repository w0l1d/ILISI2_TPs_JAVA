package exams.bufferProdConsum;

public class Consumer extends Thread {


   private final Buffer buffer;

   public Consumer(Buffer buffer) {
      this.buffer = buffer;
   }

   @Override
   public void run() {
      while (true)
         consumeData(buffer.get());
   }

   private void consumeData(String data) {
      System.out.println(data);
   }


}
