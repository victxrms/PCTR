/**
 * Esta clase contiene los atributos y metodos de una hebra
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see hebra
 */

public class Usa_hebra
{
    
    /**
     * Método que ejecuta el cuerpo del ejercicio mostrando por pantalla el valor de n
     * @param args Argumentos que recibe con la ejecución del programa
     * @throws Exception Envía una excepción si no funciona correctamente
     */
    public static void main(String[] args)
        throws Exception
    {
        hebra p = new hebra(100000, 0);
        hebra q = new hebra(100000, 1);

        p.start();
        q.start();
        p.join();
        q.join();

        System.out.println(q.vDato());
    }
}

