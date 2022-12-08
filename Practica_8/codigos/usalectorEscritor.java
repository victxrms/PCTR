
/**
 * Esta clase contiene los atributos y metodos para implementar varias hebras lectoras y escritoras
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/
public class usalectorEscritor extends Thread
{
   private int tipo;
   public static recurso R;
   private static lectorEscritor lE;

   /**
    * Constructor parametrizado de la calse usalectorEscritor
    * @param tipo Entero que definirá el tipo de la hebra
    * @param R Objeto de tipo recurso que se incrementará y decrementará
    * @param lE Objeto de la clase lectorEscritor que se usará para acceder a los diferentes métodos
    */
   usalectorEscritor(int tipo, recurso R, lectorEscritor lE)
   {
      this.tipo = tipo;
      this.R = R;
      this.lE = lE;
   }

   /**
    * Función que ejecturá los métodos en función del tipo de la hebra, escritora o lectora
    */
   public void run()
   {
        switch (tipo) 
        {
            case 0:
                for(long i = 0; i<10000; i++)
                {
                    lE.iniciaLectura();
                    R.observer();
                    lE.acabarLectura();
                }

                break;
            
            case 1:
                for (long i = 0; i<10000; i++)
                {
                    lE.iniciaEscritura();
                    R.inc();
                    lE.acabarEscritura();
                }

                break;
        
            default:
                break;
        }
   }
 public static void main(String[] args) 
 throws Exception
 {
    recurso R = new recurso();
    lectorEscritor lEObjeto = new lectorEscritor();
    usalectorEscritor h1 = new usalectorEscritor(1, R, lEObjeto);
    usalectorEscritor h2 = new usalectorEscritor(1, R, lEObjeto);
    usalectorEscritor h3 = new usalectorEscritor(0, R, lEObjeto);
    usalectorEscritor h4 = new usalectorEscritor(0, R, lEObjeto);

    h1.start(); h2.start(); h3.start(); h4.start();
    h1.join(); h2.join(); h3.join(); h4.join();

    System.out.println(R.observer());
 }   
}
