/**
 * Esta clase contiene los atributos y metodos para realizar el producto de dos matrices de forma secuencial
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */

import java.util.*;
 

 public class prodMatricesSecuencial 
 {
    private int tam = 1000;
    private double mat1[][] = new double [tam][tam];
    private double mat2[][] = new double [tam][tam];
    private double mult[][] = new double [tam][tam];

    /**
     * Función que rellena las matrices
     */
    public void rellenaMat()
    {
        Random  r = new Random();

        for (int i=0; i<tam; i++)
        {
            for (int j=0; j<tam; j++)
            {
                mat1[i][j] = r.nextDouble();
                mat2[i][j] = r.nextDouble();
            }
        }

        System.out.println("Matrices rellenadas");
    }

    /**
     * Función que multiplica las matrices
     */
    public void multiplicaMat()
    {
        for (int i=0; i<tam; i++)
            for (int j=0; j<tam; j++)
                for (int k=0; k<tam;k++)
                     mult[i][j] += mat1[i][k] * mat2[k][j];

        System.out.println("Matrices multiplicadas");
    }

    /**
     * Función principal de la clase que llama al resto para calcular el producto entre las dos matrices
     */
    public void funcPrinp()
    {
        rellenaMat();
        multiplicaMat();
    }

    public static void main(String[] args) 
        throws Exception
    {
        Date d = new Date();
        
        long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
        d.setTime(inicCronom); //se activa el cronometro

        prodMatricesSecuencial main = new prodMatricesSecuencial();
        main.funcPrinp();

        long finCronom = System.currentTimeMillis(); //se para el cronometro
        d.setTime(finCronom);

        System.out.println("El tiempo ha sido de " + (finCronom - inicCronom) + "ms");
    }
    
 }