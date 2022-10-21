/**
 * Esta clase contiene los atributos y metodos de escalaVector, es decir, la versión secuencial
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see Runnable
 */


public class escalaVPar implements Runnable
{
    static private int N;
    private int escalar;
    private int i = 0;
    private int orden;
    private int ini;
    private int fin;
    static double[] vec;

    escalaVPar(int N, int escalar, int orden, double vec[])
    {
        this.N = N;
        this.escalar = escalar;
        this.orden = orden;

        int particion = N/8;

        switch (orden) 
        {
            case 0:
                this.ini = 0;
                this.fin = this.ini + particion;
                break;
            
            case 1:
                this.ini = particion;
                this.fin = this.ini + particion;
                break;
            
            case 2:
                this.ini = particion * 2;
                this.fin = this.ini + (particion * 2);
                break;
            
            case 3:
                this.ini = (particion * 3);
                this.fin = this.ini + this.ini + (particion * 3);
                break;
            
            case 4:
                this.ini = (particion * 4);
                this.fin = this.ini + this.ini + (particion * 4);
                break;

            case 5:
                this.ini = (particion * 5);
                this.fin = this.ini + (particion * 5);
                break;
            
            case 6:
                this.ini = (particion * 6);
                this.fin = this.ini + (particion * 6);
                break;
            
            case 7:
                this.ini = (particion * 7);
                this.fin = this.ini + (particion * 7);
                break;
            
            case 8:
                this.ini = (particion * 8);
                this.fin = this.ini + this.ini + (particion * 8);
                break;

            default:
                break;
        } 

    }

    public void rellena()
    {
        for (i = ini; i < fin; i++) {vec[i] = Math.random();};
    }


    public void escala()
    {
        for (i = ini; i < fin; i++) {vec[i] = vec[i] * escalar; System.out.println(vec[i--]);};
    }

    public void run()
    {
        rellena();
        escala();
    }


}
