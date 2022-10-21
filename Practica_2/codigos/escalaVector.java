/**
 * Esta clase contiene los atributos y metodos de escalaVector, es decir, la versión secuencial
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */


public class escalaVector 
{
    static private int N;
    private int escalar;
    private int i = 0;

    escalaVector(int N, int escalar)
    {
        this.N = N;
        this.escalar = escalar;

    }

    public void rellena(double vec[])
    {
        for (i = 0; i < vec.length; i++) {vec[i] = Math.random();};
        System.out.println("Vector relleno.");
        
    }


    public void escala(double vec[])
    {
        for (i = 0; i < vec.length; i++) {vec[i] = vec[i] * escalar; System.out.println(vec[i--]);};
    }

    public void funcPrinp(double vec[])
    {
        rellena(vec);
        escala(vec);
    }


}
