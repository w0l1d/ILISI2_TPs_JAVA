package exams.cptConcurrent;

public class CompteurConcurrent {

   private int cpt = 0;

   public int getValue() {
      return cpt;
   }

   public void incremente() {
      cpt++;
   }

   @Override
   public String toString() {
      return cpt + "";
   }
}
