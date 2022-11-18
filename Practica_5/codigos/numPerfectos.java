/**
 * Esta clase contiene los atributos y metodos para realizar el calculo del números de números perfectos en un rango determinado.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */

import java.util.*;

public class numPerfectos 
{
    public static void main(String[] args) 
        throws Exception
    {

        Date d = new Date();

        if (args.length == 0)
        {
            System.out.print("Introduce el rango de números a analizar");
            System.exit(-1);
        }
        
        int ini = Integer.valueOf(args[0]);
        int fin = Integer.valueOf(args[1]);

        int cantidad = 0;

        long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
        d.setTime(inicCronom); //se activa el cronometro

        for (int i=ini; i<=fin; i++)
        {
            int sumadivisores = 0;
            for (int divisor=1; divisor<=i/2; divisor++)
            {
                if(i%divisor==0 && i!=divisor)
                {
                    sumadivisores+= divisor;
                }   
            }

            if (sumadivisores == i)
            cantidad++;
        }

        long finCronom = System.currentTimeMillis(); //se para el cronometro
        d.setTime(finCronom);

        System.out.println("La cantidad números perfectos en un rango de [" + ini + ", " + fin + "] números naturales es de " +  cantidad);
        System.out.println("El tiempo ha sido de " + (finCronom - inicCronom) + "ms");
        
    }    
}