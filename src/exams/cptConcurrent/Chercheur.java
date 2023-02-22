package exams.cptConcurrent;

public class Chercheur extends Thread {

   private final Object[] objects;
   private final int debut;
   private final int fin;
   private final Object elem;
   private final CompteurConcurrent cpt;

   public Chercheur(Object[] objects, int debut, int fin, Object elem, CompteurConcurrent cpt) {
      this.objects = objects;
      this.debut = debut;
      this.fin = fin;
      this.elem = elem;
      this.cpt = cpt;
   }

   @Override
   public void run() {
      Main.rechercher(objects, debut, fin, elem, cpt);
   }
}
