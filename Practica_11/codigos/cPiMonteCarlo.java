/**
 * Esta clase contiene los atributos y metodos para implementar el cliente del calculo de pi a través del método montecarlo
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;

/**
 * Método principal de la clase cPiMonteCarlo en la que crea la referencia al objeto remoto y hace las diferentes llamadas a los métodos del mismo.
 * @param args Variable que determinará el número de vueltas que enviaremos con la llamada al métodos masPuntos.
 */
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
        System.out.println("Si deseas reiniciar el servidor introduce 0 cuando llames al ejecutable.\n");
    }
}
