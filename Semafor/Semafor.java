/*
 * 
 * Programa que ajuda a decidir que fer davant un semàfor ('vermell', verd o groc).
 * El programa preguntarà de quin color està el semàfor i segons la resposta recomanarà respectivament 'espera', passa, o corre!.
 *
 * En cas que el color introduït no sigui cap d'aquests, el programa respondrà amb el missatge "ves a l'oculista".
 *
 * De moment només funciona en català.
 *
 */

public class Semafor {
    public static void main(String[] args) {
    
    System.out.println("Color?");
    String color = Entrada.readLine();
    
    if (color.equalsIgnoreCase("groc")) {
        System.out.println("Corre!");
    } else if (color.equalsIgnoreCase("verd")) {
        System.out.println("Passa");
    } else if (color.equalsIgnoreCase("vermell")) {
        System.out.println("Espera");
    } else {
        System.out.println("Ves a l'oculista");
    }
    
    }
}
