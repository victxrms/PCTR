/**
 * Esta clase contiene los atributos y metodos para implementar el servidor de la bono loto
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto
{   
    private int[] arrayLoteria= new int[6];

    /**
     * Constructor no parametrizado que inicializa el array.
     * @throws RemoteException
     */
    public sBonoLoto() throws RemoteException {resetServidor();}

    /**
     * Metodo compApuesta heredado de la interfaz 
     * @throws RemoteException
     */
    public boolean compApuesta(int[] apuesta) throws RemoteException 
    {
        int i, j;
        boolean estaBien = true;

        System.out.println("Los números correctos son: ");

        for (j = 0; j < 6; j++)
        {
            System.out.print(arrayLoteria[j] + " " );
        }

        System.out.println("\nTu apuesta es: ");

        for (j = 0; j < 6; j++)
        {
            System.out.print(apuesta[j] + " " );
        }

        System.out.println("\n");

        for (i = 0; i < 6 && estaBien; i++);
        {
            if (apuesta[i] != arrayLoteria[i])
            {
                estaBien = false;
            }
        }

        return estaBien;
    }

    /**
     * Método resetServidor heredado de la interfaz
     * @throws RemoteException
     */
    public void resetServidor() throws RemoteException 
    {
        int i = 0;

        Random r = new Random();

        for (i = 0; i < 6; i++)
        {   
            //arrayLoteria[i] = r.nextInt(49-1) + 1; 
            arrayLoteria[i] = i; //version de prueba
        }
    }

    /**
     * Método principal que inicializa el objeto de la clase interfaz e inicia el servidor
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        iBonoLoto objRemoto = new sBonoLoto();

        Naming.rebind("Servidor", objRemoto);
        System.out.println("Servidor remoto preparado");
    }   
}
