/**
 * Esta clase contiene los atributos y metodos para implementar el servidor del calculo de pi a través del método montecarlo
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class sPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo
{
    private double cX, cY;
    private int intentos = 0;
    private int nVueltas = 1;

    public sPiMonteCarlo() throws RemoteException {}
    public void masPuntos(int nPuntos)  throws RemoteException
    {
        nVueltas += nPuntos;
    }
    public double aproxActual() throws RemoteException
    {
        for(long i=0; i<nVueltas; i++)
        {
            cX = Math.random();
            cY = Math.random();
            if(Math.sqrt(Math.pow(cX, 2)+Math.pow(cY, 2))<=1)
              intentos++;
        }

        return (4.0*intentos/nVueltas);
    }

    public void reset()
    {
        intentos = 0;
        nVueltas = 0;
    }

    public static void main(String[] args) 
        throws Exception
    {
        iPiMonteCarlo objRemoto = new sPiMonteCarlo();

        Naming.rebind("Servidor", objRemoto);
        System.out.println("Servidor remoto preparado");
    }
}