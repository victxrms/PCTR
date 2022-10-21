class metodoMathMonteCarlo
{
  private static void monteCarlo (int n)
  {
    double contadorExitosSeno = 0;
    double contadorExitosIgual = 0;


    for (int i=0; i<n; i++)
    {
      double coordenadaX = Math.random();
      double coordenadaY = Math.random();

      if (coordenadaY <= Math.sin(coordenadaX))
      {
        contadorExitosSeno++;
      }

      if (coordenadaY <= coordenadaX)
      {
        contadorExitosIgual++;
      }
    }
    System.out.println (contadorExitosSeno / n);
    System.out.println (contadorExitosIgual / n);
    
  }

  public static void main(String[] args)
  { 
    int dato;  	
    if (args.length == 0){
      System.out.println ("Debe dar un natural como argumento...");
      System.exit(-1);
    }

    dato = Integer.valueOf(args[0]).intValue();
    monteCarlo(dato);
  }
}
