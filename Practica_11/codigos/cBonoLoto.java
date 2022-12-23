/**
 * Esta clase contiene los atributos y metodos para implementar el cliente de la bono loto
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;

public class cBonoLoto 
{
    /**
     * Método main de la clase cBonoLoto en la crearemos un vector de enteros que recibiremos en args separados por un espacio
     * para posteriormente comprobar su corrección.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)
        throws Exception
    {
        iBonoLoto refObjRemoto = (iBonoLoto) Naming.lookup("//localhost/Servidor");
        int[] arrayCliente = new int[6];
        boolean comprobarApuesta;

        for (int i = 0; i < 6; i++) 
        {
            arrayCliente[i] = Integer.parseInt(args[i]);// ((int)(Math.random()*50)%49)+1;
        }

        comprobarApuesta = refObjRemoto.compApuesta(arrayCliente);
        
        if (comprobarApuesta)
        {
            System.out.println("¡Enhorabuena! Has acertado tu apuesta");
        }
        else
        {
            System.out.println(":(  Has fallado, tendrás mas suerte la próxima vez");
        }

        refObjRemoto.resetServidor();


    }
}
