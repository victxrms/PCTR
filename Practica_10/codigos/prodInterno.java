/**
 * Esta clase contiene los atributos y metodos para realizar el producto escalar de dos vectores usando MPJExpress
 * Orden de compilación: javac -cp .:$MPJ_HOME/lib/mpj.jar prodInterno.java
 * Orden de ejecución: mpjrun.sh -np 2 prodInterno 
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.Random;

import mpi.*;

public class prodInterno 
{
    /**
     * Método principal de la clase prodInterno que realiza el producto escalar de dos vectores de 4 posiciones, unidos en 1 de 8 posiciones, por parte
     * de un solo esclavo que enviará de vuelta el valor que será mostrado por pantalla por el master.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int tag = 100; int unitSize = 8;
        int master = 0; int slave = 1;

        if(rank==0)
        {
            int bufer[] = new int[8];

            Random r = new Random();

            for (int i = 0; i<8; i++)
            {
                bufer[i] = r.nextInt(10 - 1) + 1;
            }

            int prodVectorial[] = new int[1];
            
            MPI.COMM_WORLD.Send(bufer, 0, unitSize, MPI.INT, slave, tag);
            MPI.COMM_WORLD.Recv(prodVectorial, 0, 1, MPI.INT, slave, tag);

            System.out.println("Recibido! El resultado es: " + prodVectorial[0]);

        }

        else if (rank == 1)
        {
            int prodVectorial [] = new int [1];
            prodVectorial[0] = 0;
            int recvBuffer[] = new int[8];

            MPI.COMM_WORLD.Recv(recvBuffer, 0, unitSize, MPI.INT, master, tag);
            
            for (int i = 0; i < 4; i++)
            {
                for (int j = 4; j < 8; j++)
                {
                    prodVectorial[0] += recvBuffer[i] * recvBuffer[j];
                }
            }

            MPI.COMM_WORLD.Send(prodVectorial, 0, 1, MPI.INT, master, tag);


        }

        MPI.Finalize();
    }
}
