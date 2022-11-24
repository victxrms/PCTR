/**
 * Esta clase contiene los atributos y metodos para llamar a los métodos de la clase prodCon.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

public class usaProdCon
{   
    /**
     * Método main de la clase que en funcion del parametro introducido por pantalla ejecutará una de las tres versiones que nos pide el ejercicio
     * @param args Entero que determinará el ejercicio a realizar por el programa, siendo 0 - un productor varios consumidores, 1 - varios prodcutores un consumidor y 2 un productor un consumidor y buffer de 1
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        int tam = 100;
        int ejercicio = Integer.parseInt(args[0]);
        
        double buffer[] = new double[tam];

        Object block = new Object();

        switch (ejercicio) 
        {
            case 0:

                double bufferUnico[] = new double[1];

                prodCon productorUnico = new prodCon(0, block, bufferUnico, 1);
                Thread tProdUnico = new Thread(productorUnico);

                prodCon consumidorUnico = new prodCon(1, block, bufferUnico, 1);
                Thread tConUnico = new Thread(consumidorUnico);
                
                tProdUnico.start();
                tConUnico.start();

                tProdUnico.join();
                tConUnico.join();
                
                break;

            case 1:

                prodCon productor = new prodCon(0, block, buffer, tam);
                Thread tProd = new Thread(productor);

                prodCon consumidor1 = new prodCon(1, block, buffer, tam);
                prodCon consumidor2 = new prodCon(1, block, buffer, tam);
                prodCon consumidor3 = new prodCon(1, block, buffer, tam);
                Thread tCon1 = new Thread(consumidor1);
                Thread tCon2 = new Thread(consumidor2);
                Thread tCon3 = new Thread(consumidor3);

                tProd.start();
                tCon1.start();
                tCon2.start();
                tCon3.start();

                tProd.join();
                tCon1.join();
                tCon2.join();
                tCon3.join();

                break;

            case 2:

                prodCon productor1 = new prodCon(0, block, buffer, tam);
                prodCon productor2 = new prodCon(0, block, buffer, tam);
                prodCon productor3 = new prodCon(0, block, buffer, tam);
                Thread tProd1 = new Thread(productor1);
                Thread tProd2 = new Thread(productor2);
                Thread tProd3 = new Thread(productor3);

                prodCon consumidor = new prodCon(1, block, buffer, tam);
                Thread tCon = new Thread(consumidor);

                tProd1.start();
                tProd2.start();
                tProd3.start();
                tCon.start();

                tProd1.join();
                tProd2.join();
                tProd3.join();
                tCon.join();
                
                break;
            
            default:
                break;
        }
        
    }
}