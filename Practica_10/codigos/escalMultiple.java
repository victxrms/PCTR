/**
 * Esta clase contiene los atributos y metodos para realizar escalados de un vector dependiendo del rank del proceso.
 * Orden de compilación: javac -cp .:$MPJ_HOME/lib/mpj.jar escalMultiple.java
 * Orden de ejecución: mpjrun.sh -np 5 escalMultiple 
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import mpi.*;

public class escalMultiple 
{
    /**
     * Método principal de la clase escalMultiple que se encarga de hacer diferentes escalados en función del rank del proceso para posteriormente mostrarlo por pantalla.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int tag = 100; int unitSize = 10;
        int master = 0;

        int bufer[] = new int[10];

        for (int i = 0; i<10; i++)
        {
            bufer[i] = i + 1;
        }

        MPI.COMM_WORLD.Bcast(bufer, 0, unitSize, MPI.INT, master);

        if (rank != 0)
        {
            System.out.println("Proceso numero " + rank);
    
            for (int i = 0; i < 10; i++)
            {
                System.out.print("[" + bufer[i] * rank + "] ");
            }

            System.out.println("\n");
        }

        MPI.Finalize();
    }
}
