/**
 * Esta clase contiene los atributos y metodos de tablaCPU, con la que crear la tabla de rendimiento
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see escalaVector escalaVPar
 */

public class tablaCPU  
{
    int N;
    static private double[] vec;

    /**
     * Main de la clase tablaCPU en la que se llamarán a las diferentes clases y sus respectivos métodos
     * @param args Parámetros con los que llamarán a las diferentes clases, con los respectivos valores de la magnitud del vector y el escalar siguiendo la siguiente regla: tipoFuncion [(0) Secuencial (1) Paralelismo] || [La magnitud del vector] || [El escalar]
     * @throws Exception
     */
    public static void main(String[] args)
    throws Exception
    {
        if (args.length == 0)
        {
            System.out.print("Introduce en orden los siguientes argumentos - tipoFuncion (0) Secuencial (1) Paralelismo / La magnitud del vector / El escalar");
            System.exit(-1);
        }

        int argsInt = Integer.valueOf(args[0]);
        int N = Integer.valueOf(args[1]);
        int escalar = Integer.valueOf(args[2]);

        switch (argsInt) {
            case 0:
                vec = new double[N];
                escalaVector sec = new escalaVector(N, escalar);
                sec.funcPrinp(vec);
                break;

            case 1:
                vec = new double[N];
                escalaVPar r = new escalaVPar(N, escalar, 0, vec);
                escalaVPar s = new escalaVPar(N, escalar, 1, vec);
                escalaVPar t = new escalaVPar(N, escalar, 2, vec);
                escalaVPar u = new escalaVPar(N, escalar, 3, vec);
                escalaVPar v = new escalaVPar(N, escalar, 4, vec);
                escalaVPar w = new escalaVPar(N, escalar, 5, vec);
                escalaVPar x = new escalaVPar(N, escalar, 6, vec);
                escalaVPar y = new escalaVPar(N, escalar, 7, vec);

                Thread u1 = new Thread(r);
                Thread u2 = new Thread(s);
                Thread u3 = new Thread(t);
                Thread u4 = new Thread(u);
                Thread u5 = new Thread(v);
                Thread u6 = new Thread(w);
                Thread u7 = new Thread(x);
                Thread u8 = new Thread(y);

                u1.start();
                u2.start();
                u3.start();
                u4.start();
                u5.start();
                u6.start();
                u7.start();
                u8.start();

                break;
        
            default:
                break;
        }

    }   
}
