package cFIL;

import java.util.Scanner;

public class cFilPrincipal {

  private static final int max_fills = 20;

  public static void main (String [] pArguments) {

    Scanner sc = new Scanner(System.in);

    System.out.println("fil principal iniciat");

    int n;

    if (pArguments.length > 0) {
      n = Integer.parseInt(pArguments[0]);
    } else {
      System.out.print("quants processos fills vols crear (1-" + max_fills + "): ");
      n = sc.nextInt();
    }

    if (n < 1 || n > max_fills) {
      System.out.println("nombre invalid");
      return;
    }

    Thread[] fils = new Thread[n];

    int base = 200;
    int salt = 200;

    for (int i = 0; i < n; i++) {

      cFil obj = new cFil("#" + (i + 1));
      obj.sTemporitzacio(base + i * salt);

      fils[i] = new Thread(obj);
      fils[i].start();

      System.out.println("iniciant fil #" + (i + 1));
    }

    try {
      for (int i = 0; i < 10; i++) {
        Thread.sleep(500);
        System.out.println("proces principal treballant " + i);
      }

      // esperar tots els fills
      for (int i = 0; i < n; i++) {
        fils[i].join();
      }

    } catch (InterruptedException e) {
      System.out.println("interrompent execucio proces principal");
    }

    System.out.println("acabant execucio proces principal");
  }
}
