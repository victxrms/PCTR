/**
 * Esta clase contiene los atributos y metodos para realizar el tratamiento de una imagen de manera secuencial
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */

import java.util.*;

public class resImagen 
{
    private static int tam = 10000;
    private static int imagenMatrix[][];


    /**
     * Constructor parametrizado de la clase resImagenPar
     * @param imagenMatrix Matriz a tratar.
     */
    public resImagen(int imagenMatrix[][])
    {
        this.imagenMatrix = imagenMatrix;
    }


    /**
     * Función que rellena la matriz
     */
    public void rellenaMat ()
    {
        
        Random ran = new Random();

        for (int i=0; i<tam; i++)
        {
            for (int j=0; j<tam; j++)
            {
                imagenMatrix[i][j] = ran.nextInt(6) + 5;
            }
        }

    }
    
    /**
     * Función que aplica la operación de tratamiento.
     */
    public void tratamiento ()
    {
        for (int i=0; i<tam; i++)
            for (int j=0; j<tam; j++)
            {
                if (i == 0 || i == tam - 1 || j == 0 || j == tam - 1)
                    imagenMatrix[i][j] = 0;
                else 
                    imagenMatrix[i][j] = ( (4*imagenMatrix[i][j]) - imagenMatrix[i+1][j] - imagenMatrix[i][j+1] - imagenMatrix[i-1][j] - imagenMatrix[i][j-1]) / 8;

            }
        
    }

    /**
     * Función principal que llama a los métodos de la clase.
     * @throws Exception
     */
    public static void main(String[] args) 
       throws Exception
    {        
        int imagenMatrix [][] = new int[tam][tam]; 

        Date d = new Date();

        long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
        d.setTime(inicCronom); //se activa el cronometro

        resImagen rI =  new resImagen(imagenMatrix);

        rI.rellenaMat();
        rI.tratamiento();

        long finCronom = System.currentTimeMillis(); //se para el cronometro
        d.setTime(finCronom);

        System.out.println("El tiempo ha sido de " + (finCronom - inicCronom) + "ms");

    }    

}
