package exams.bufferProdConsum;

public class Producer extends Thread {

   private final Buffer buffer;

   public Producer(Buffer buffer) {
      this.buffer = buffer;
   }

   @Override
   public void run() {
      while (true)
         buffer.put(produceData());
   }

   private String produceData() {
      return "tsomething produced";
   }
}
