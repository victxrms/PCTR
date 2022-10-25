/**
 * Esta clase contiene los atributos y metodos de tareaRunnable a través de la interfaz Runnable
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see tareaRunnable
 */

public class Usa_tareaRunnable
{   
    /**
     * Método que ejecuta el cuerpo del ejercicio, creando dos objetos de Usa_tareaRunnable y llamando a sus respectivos métodos run() y mostrando por pantalla el valor de n
     * @throws Exception Envía una excepción si no funciona correctamente
     */

    public static void main(String[] args)
        throws Exception
    {
        tareaRunnable r = new tareaRunnable(0);
        tareaRunnable s = new tareaRunnable(1);
        Thread u1 = new Thread(r);
        Thread u2 = new Thread(s);
        u1.start();
        u2.start();

        System.out.print(r.vDato());
    } 
}