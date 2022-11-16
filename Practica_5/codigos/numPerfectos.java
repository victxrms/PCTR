/**
 * Esta clase contiene los atributos y metodos para realizar el calculo del números de números perfectos en un rango determinado.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */


public class numPerfectos 
{
    public static void main(String[] args) 
        throws Exception
    {
        if (args.length == 0)
        {
            System.out.print("Introduce el rango de números a analizar");
            System.exit(-1);
        }
        
        int ini = Integer.valueOf(args[0]);
        int fin = Integer.valueOf(args[1]);

        int cantidad = 0;

        for (int i=ini; i<=fin; i++)
        {
            int sumadivisores = 0;
            for (int divisor=1; divisor<i/2; divisor++)
            {
                if(i%divisor==0 && i!=divisor)
                {
                    sumadivisores+= divisor;
                }   
            }

            if (sumadivisores == i)
            cantidad++;
        }

        System.out.println("La cantidad números perfectos en un total de [" + ini + ", " + fin + "] números naturales es de " +  cantidad);
        
    }    
}