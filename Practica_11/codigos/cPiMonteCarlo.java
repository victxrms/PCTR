/**
 * Esta clase contiene los atributos y metodos para implementar el cliente del calculo de pi a través del método montecarlo
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;

public class cPiMonteCarlo 
{
    public static void main(String[] args) 
        throws Exception
    {
        iPiMonteCarlo refObjRemoto = (iPiMonteCarlo) Naming.lookup("//localhost/Servidor");
        
        int puntos = Integer.parseInt(args[0]);
        double aproxPi;

        refObjRemoto.masPuntos(puntos);

        aproxPi = refObjRemoto.aproxActual();

        System.out.println("El valor aproximado de Pi es: " + aproxPi + "\n");
    }
}
