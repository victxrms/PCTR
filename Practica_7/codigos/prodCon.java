/**
 * Esta clase contiene los atributos y metodos para implementar un problema de productor-consumidor.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.*;
import java.util.concurrent.Semaphore;

public class prodCon
  extends Thread
 {
    private static int tam = 100;
    private static int productos = 100;
    private static int huecos = 0;
    private static double [] buffer;
    private static int InPtr = 0;
    private static int OutPtr = 0;
    private int tipoHilo;

    private static Object block;

    public prodCon(int tipo, Object block, double[] buffer, int tam) 
    {
        this.tipoHilo = tipo;
        this.block = block;
        this.buffer = buffer;
        this.tam = tam;
        this.productos = tam;
    }

    public void run()
    {
        switch(tipoHilo)
        {
      		case 0:
            {
              try
              {
                while(true)
                {
                  synchronized(block)
                  {
                  while(huecos == 0){block.wait();};
                    buffer[InPtr] = Math.random();
                    System.out.println("Hilo productor insertando " + buffer[InPtr] + " en buffer");
                    InPtr = (InPtr + 1) % tam;
                    productos++;
                    huecos--;
                    block.notifyAll();
                  }
                }
              } catch (InterruptedException iE){System.out.println(iE);};
      		}

      		case 1:
            {
              try
              {
                while(true)
                {
                  synchronized(block)
                  {
                  while(productos == 0){block.wait();};
                    buffer[InPtr] = Math.random();
                    System.out.println("Hilo consumidor extrayendo " + buffer[OutPtr] + " de buffer"); 
                    OutPtr = (OutPtr + 1) % tam;
                    huecos++;
                    productos--;
                    block.notifyAll();
                  }
                }
              } catch (InterruptedException iE){System.out.println(iE);};
      		}
      	}
      }
}
