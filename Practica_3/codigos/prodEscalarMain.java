/**
 * Esta clase contiene los atributos y metodos para ejecutar los cálculos de un producto escalar entre dos vectores.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see prodEscalarParalelo
 */

import java.util.*;
import java.text.*;

public class prodEscalarMain 
{
    private int N;
    static private double valorProd;
    static private int tam = 1000000;
    static private double vec1[] = new double[tam];
    static private double vec2[] = new double[tam];
    static private double productoParcial[] = new double[10];
    static private prodEscalarParalelo vHebras[];

    /**
     * Main de la clase prodEscalarMain en la que se llamarán a las diferentes clases y sus respectivos métodos
     * @param args Parametros que determinaran el tipo de la función y el número de hebras a emplear.
     * @throws Exception
     */
    public static void main(String[] args)
    throws Exception
    {
        if (args.length == 0)
        {
            System.out.print("Introduce en orden los siguientes argumentos - tipoFuncion (0) Secuencial (1) Paralelismo / El número de hebras 1 | 2 | 4 | 8 | 10 ");
            System.exit(-1);
        }

        int func = Integer.valueOf(args[0]);
        int N = Integer.valueOf(args[1]);

        int particion = tam/N;

        Date d = new Date();

        switch (func) 
        {
            case 0:
                long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
                d.setTime(inicCronom); //se activa el cronometro
                    
                prodEscalar pE = new prodEscalar(vec1, vec2, tam);
                pE.funcPrinp();
                    
                long finCronom = System.currentTimeMillis(); //se para el cronometro
                d.setTime(finCronom);
                System.out.println("Acabando trabajo tras " + (finCronom - inicCronom) + " milisegundos");
                break;
            
            case 1:
                long inicCron = System.currentTimeMillis(); //se prepara el cronometro
                d.setTime(inicCron); //se activa el cronometro
                
                vHebras = new prodEscalarParalelo[N];
        
                for (int i=0; i<N; i++)
                {
                    vHebras[i] = new prodEscalarParalelo(i, particion * i, particion * (i + 1), vec1, vec2, productoParcial);
                }
        
                for (int i=0; i<N; i++)
                {
                    vHebras[i].start();
                }
        
                for (int i=0; i<N; i++)
                {
                    vHebras[i].join();
                }
            
                for (int i = 0; i < N; i++){valorProd += productoParcial[i];}
                System.out.println("El valor del producto escalar de los dos vectores es: " + valorProd);
                long finCron = System.currentTimeMillis(); //se para el cronometro
                d.setTime(finCron);
                System.out.println("Acabando trabajo tras " + (finCron - inicCron) + " milisegundos");
        
            default:
                break;
            
        }
    }
}

