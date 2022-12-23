/**
 * Esta clase contiene los atributos y metodos para implementar el servidor de la bono loto
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;

public class cPiMonteCarlo throws Exception
{
    public static void main(String[] args) 
    {
        iPiMonteCarlo refObjRemoto = (iPiMonteCarlo) Naming.lookup("//localhost/Servidor");
        
        int puntos = Integer.parseInt(args[0]);
        double aproxPi;

        refObjRemoto.masPuntos(puntos);

        aproxPi = refObjRemoto.aproxActual();

        System.out.println("El valor aproximado de Pi es: " + aproxPi + "\n");
    }
    
}
