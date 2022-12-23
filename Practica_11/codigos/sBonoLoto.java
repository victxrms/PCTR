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
    sBonoLoto() throws RemoteException {resetServidor();}

    /**
     * Metodo compApuesta heredado de la interfaz 
     * @throws RemoteException
     */
    public boolean compApuesta(int[] apuesta) throws RemoteException 
    {
        boolean estaBien = true;

        System.out.println("Los números correctos son: ");

        for (int i = 0; i < 6; i++)
        {
            System.out.print(arrayLoteria[i] + " " );
        }

        System.out.println("\nTu apuesta es: ");

        for (int i = 0; i < 6; i++)
        {
            System.out.print(apuesta[i] + " " );
        }

        System.out.println("\n");

        for (int i = 0; i < 6 && estaBien; i++)
        {
            if (arrayLoteria[i] != apuesta[i])
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
            arrayLoteria[i] = r.nextInt(49-1) + 1; 
            //arrayLoteria[i] = i; //version de prueba
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
        sBonoLoto objRemoto = new sBonoLoto();
        Naming.rebind("Servidor", objRemoto);
        System.out.println("Servidor remoto preparado");
    }   
}
