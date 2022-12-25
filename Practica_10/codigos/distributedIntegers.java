/**
 * Esta clase contiene los atributos y metodos para hacer la búsqueda de números primos paralelizando los datos entre los diferentes procesos.
 * Orden de compilación: javac -cp .:$MPJ_HOME/lib/mpj.jar distributedIntegers.java
 * Orden de ejecución: mpjrun.sh distributedIntegers
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import mpi.*;

public class distributedIntegers 
{
    /**
     * Método principal de la clase distributedIntegers que se encarga de hacer un reparto de los datos a los que accederan los diferentes procesos
     * para conseguir una ejeccución mas rápida del problema.
     * En este caso dividimos el número total de los datos entre los procesos (MPI.COMM_WORLD.Size()) y le dejamos al último de los procesos que llegue 
     * hasta el último de los datos. Asignamos como inicio el último de los datos que leerá el proceso anterior y guardamos el número de números primos en
     * el vector de tamaño 1, primos, que posteriormente, el master leerá haciendo uso del método Reduce.
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

        long tam[] = new long[size - 1];
        int bufer[] = new int[1];
        int primos[] = new int[1];

        if (rank == master)
        {
            long t = 10000000 / size - 1;

            int i;

            for (i = 0; i < size - 3; i++)
            {
                tam[i] = t;
                t += 10000000 / size - 1;
            }

            tam[i] = 10000000;
        }

        MPI.COMM_WORLD.Bcast(tam, 0, size-1, MPI.LONG, master);

        if (rank != master)
        {
            long ini;
            boolean esPrimo = true;

            primos[0] = 0;

            if (rank == 1)
            {
                ini = 2;
            }
            else {ini = tam[rank - 2];}

            for (long i = ini; i < tam[rank - 1]; i++)
            {
                esPrimo = true;

                for (long j = 2; j <= Math.sqrt(i); j++)
                {
                    if (i%j == 0 && i!=j)
                    {
                        esPrimo = false;
                    }
                }

                if (esPrimo)
                {
                    primos[0]++;
                }
            }
        }

        MPI.COMM_WORLD.Reduce(primos, 0, bufer, 0, 1, MPI.INT, MPI.SUM, master);

        if (rank == master)
        {
            System.out.println("Los procesos han encontrado " + bufer[0] + " numeros primos.");
        }
        
        MPI.Finalize();
    }
}
