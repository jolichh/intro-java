/*
 * Joc del penjat
 *
 * Accedirà a un fitxer extern "paraules.txt" que conté paraules per al joc
 * De moment només acepta una paraula per linia
 *
 * El jugador perd quan no queden més oportunitats
 * i guanya quan es destapen totes les lletres de la paraula
 * 
 * El jugador pot abandonar partida si així ho demana, la paraula serà "prou" o "glups"
 * Qualsevol altra paraula serà error
 */
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Penjat {
    private static int encerts = 0;
    private static int perduts = 0;
    private static int glup = 0;    //contador de rendicion palabra
    private static int rendir = 0;
    private static int contador = 0;
    private static int finalitzar = 0;
    private static int guanya = 0;
    private static int jugades = 0;
    public static void main(String[] args) throws IOException {
        String text = "paraules.txt";
        FileReader fileReader = new FileReader(text);
        BufferedReader input = new BufferedReader(fileReader);
        
        String paraula = input.readLine();
        if (null == paraula) {
            System.out.println("No tinc paraules per jugar");
                return;
        }        
        System.out.println("    Comencem a jugar");
        while (true) {
            System.out.printf("    Per abandonar paraula: 'glups'%n    Per sortir de la partida: 'prou'%n");
            
            if (null == paraula) {
                System.out.println("No queden més paraules");
                break;
            }
            
            enPartida(paraula);
            jugades++;
            if (rendir >0) {
                rendir = 0;
                glup++;
            }
            
            if (finalitzar>0) {
                glup++;
                break;
            }
            if (guanya>0) {
                guanya = 0;
                encerts++;
                System.out.println("Has encertat! La paraula era " + paraula);
            }
            paraula = input.readLine();
        }
        mostraResum();
        System.out.println("Espero que t'hagis divertit");
    }
        
    public static void enPartida(String paraula) throws IOException {
        String paraulaJoc = UtilString.ocultaText(paraula); //enmascarar
        String utilitzat = "";  //aqui se guardan las palabras utilizadas
                
        int intents = 10;
        while (true) {
            System.out.println("Paraula: " + paraulaJoc);
                if (utilitzat.isEmpty()) {
                    System.out.println("Utilitzades: cap");
                } else {
                
                String tmpUt = String.valueOf(utilitzat.charAt(0));
                for (int i=1; i<=utilitzat.length()-1; i++) {
                    if (i<utilitzat.length()-1) {
                        tmpUt = tmpUt + ", " + utilitzat.charAt(i);
                    }
                    else {
                        tmpUt = tmpUt + " i " + utilitzat.charAt(i);
                    }
                }
            System.out.println("Utilitzades: " +  tmpUt);
            }
            System.out.println("Intents disponibles: " +  intents);
            System.out.println("Introdueix una lletra");
            String input = Entrada.readLine();
            input = input.toUpperCase();
            
            if (input.equalsIgnoreCase("PROU")) {
                //indica que vol abandonar, preguntarem per confirmar
                System.out.println("Vols finalitzar?");
                String lletra = Entrada.readLine();
                boolean confirma = UtilitatsConfirmacio.respostaABoolean(lletra);
                if (confirma) {
                    finalitzar++;
                    break;
                }
                continue;
            }
            
            if (input.equalsIgnoreCase("GLUPS")) {
                rendir++;
                break;
            } 
            
            if (input.length() != 1) {
                System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
                continue; //torna a demanar input
            }
            //comprovamos que no es una letra ya introducida antes
            if (!utilitzat.isBlank()) {
                boolean esRepeteix = UtilString.esRepeteixLletra(input, utilitzat);
                if (esRepeteix) {
                    System.out.println("La lletra ja ha estat utilitzada");
                    continue;
                }
            }
            
            utilitzat = utilitzat + input.toUpperCase();
            
            char caracter = Character.toLowerCase(input.charAt(0));
            //reemplazamos letra en la palabra del juego
            String tmp = "";
            int hiha = 0;
            int conte = 0;
            for (int i= 0; i<paraula.length(); i++) {
                if(paraula.charAt(i) == caracter) {
                    tmp = tmp + caracter;
                    conte++;
                } else {
                    tmp = tmp + paraulaJoc.charAt(i);
                    hiha++;
                }
            }
            paraulaJoc = tmp;
            //comprovar si están todas destapadas
            if (paraulaJoc.contains(paraula)) {
                guanya++;
                break;
            }
            if (conte == 0) {
                intents = intents -1;
                mostraFigura(intents);
                if (intents == 0) {
                    System.out.println("Has mort");
                    perduts++;
                    break;
                }
            }
        }
    }
    
    public static void mostraFigura(int intents) throws IOException {
        String ubi;
        
        switch (intents) {
            case 9: ubi = "recursos/figura0.txt";
                    break;
            case 8: ubi = "recursos/figura1.txt";
                    break;
            case 7: ubi = "recursos/figura2.txt";
                    break;
            case 6: ubi = "recursos/figura3.txt";
                    break;
            case 5: ubi = "recursos/figura4.txt";
                    break;
            case 4: ubi = "recursos/figura5.txt";
                    break;
            case 3: ubi = "recursos/figura6.txt";
                    break;
            case 2: ubi = "recursos/figura7.txt";
                    break;
            case 1: ubi = "recursos/figura8.txt";
                    break; 
            case 0: ubi = "recursos/figura9.txt";
                    break;
            default: return;
        }
        FileReader file = new FileReader(ubi);
        BufferedReader dibuix = new BufferedReader(file);
        //dibuixa figura linia per linia
        while (true) {
            String linia = dibuix.readLine();
            if (null == linia) break;
            System.out.printf("%s%n",linia);
        }
        dibuix.close();
    }
    
    public static void mostraResum() throws IOException {
        System.out.println("Paraules jugades: " +  jugades);
        System.out.println("Paraules encertades: " + encerts);
        System.out.println("Paraules fallades: " + perduts);
        System.out.println("Paraules cancel·lades: " + glup);
    }
    
      
}
