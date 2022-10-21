class NewtonRaphson
{
    private static void NewtonRaphsonMethod(int x0, int iteraciones)
    {
        double xN = x0;
        double xN2 = x0;
        for (int i=0; i <= iteraciones; i++)
        {
            if (-Math.sin(xN) - 3* Math.pow(xN, 3) != 0)
            {
                xN = xN - ((Math.cos(xN) -  Math.pow(xN, 3)) / (Math.sin(xN) - 3* Math.pow(xN, 2)));
                System.out.println ( "[x^2 - 5]      -> " + "Iteración: " +  i + " | Aproximación: " + xN);

            }

            if ((xN2 * 2) != 0)
            {
                xN2 = xN2 - ((Math.pow(xN2, 2) - 5) / ((2 * xN2)));
                System.out.println ("[cos(x) - x^3] -> " + "Iteración: " +  i + " | Aproximación: " + xN2);
 
            }
        }
        
        System.out.println ("\nResultado para f(x) = cos(x) - x^3: " + xN);
        System.out.println ("\nResultado para f(x) = x^2 - 5:      " + xN2);
    }
    
    public static void main(String[] args)
    { 
      int x0;
      int iteraciones;  	
      if (args.length == 0){
        System.out.println ("Debe dar un natural como argumento...");
        System.exit(-1);
       }
      x0 = Integer.valueOf(args[0]).intValue();
      iteraciones = Integer.valueOf(args[1]).intValue();
      NewtonRaphsonMethod(x0, iteraciones);  
    }
  }
  




