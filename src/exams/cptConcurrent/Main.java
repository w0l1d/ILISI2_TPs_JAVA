package exams.cptConcurrent;

public class Main {

   private static final int TAILLE_MIN = 5;

   public static void main(String[] args) {
      Object[] objects = new Object[]{"0", "a", "5", "9", "c", "f", "9", "fe", "r", "9"};
      CompteurConcurrent cpt = new CompteurConcurrent();
      Object elem = "9";
      if (objects.length < TAILLE_MIN) {
         rechercher(objects, 0, objects.length, elem, cpt);
      } else {
         int milieu = objects.length / 2;
         Chercheur chercheur1 = new Chercheur(objects, 0, milieu, elem, cpt);
         Chercheur chercheur2 = new Chercheur(objects, milieu, objects.length, elem, cpt);

         chercheur1.start();
         chercheur2.start();
         try {
            chercheur1.join();
            chercheur2.join();
         } catch (InterruptedException ignored) {
         }
      }
      System.out.println("nombre d'occurance de " + elem + " : " + cpt);
   }


   public static void rechercher(Object[] objs, int debut, int fin, Object elem, CompteurConcurrent cpt) {
      for (int i = debut; i < fin; i++) {
         if (elem.equals(objs[i])) {
            System.out.println("Element" + elem + " trouve a l'indice : " + i);
            synchronized (cpt) {
               cpt.incremente();
            }
         }
      }

   }

}
