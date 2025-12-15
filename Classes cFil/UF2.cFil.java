package cFIL;

public class cFilPrincipal {

  public static void main (String [] pArguments) {

    System.out.println("fil principal iniciat");
    System.out.println("fil secundari iniciat");

    cFil vObjecteFil = new cFil("#1");

    // el fill va molt lent
    vObjecteFil.sTemporitzacio(2000);

    Thread vFil = new Thread(vObjecteFil);
    vFil.start();

    System.out.println("iniciant execucio proces principal");

    try {
      for (int vComptador = 0; vComptador < 10; vComptador++) {
        Thread.sleep(500);
        System.out.println("despertant aturada " + vComptador + " proces principal");
      }
    } catch (InterruptedException pExcepcio) {
      System.out.println("interrompent execucio proces principal");
    }

    System.out.println("acabant execucio proces principal");
  }
}
