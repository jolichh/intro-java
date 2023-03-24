/*
 * No funciona com a traductor d'idiomes. Tradueix el text reemplaçant les paraules.
 *
 * Programa que permet traduir un text
 * Necessesita un altre fitxer on contingui la traduccio(paraules)
 * Mostra resultat traducció del text
 * Distingueix majúscules i minúscules
 * La traducció es realitza per linies
 *
 */
 
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Traduccio {
    public static void main(String[] args) throws IOException {
    
        if (args.length > 2 ) {
            String origen = args[0];    //texto original
            String traduccio = args[1];  //csv, separadas por 1 coma (ignorar si hay más
            String destinacio = args[2];  //aqui escribe el texto traducido;
            //crida a traduir
            tradueix(origen, traduccio, destinacio);
        } else {
            System.out.println("ERROR: Cal especificar els fitxers origen, traduccio i destinació");
            return;
        }
    }
    
    //tradueix
    public static void tradueix(String fitxerOrigen, String fitxerTraduccio, String fitxerDestinacio) throws IOException { 
        FileReader origen = new FileReader(fitxerOrigen);
        BufferedReader readOrigen = new BufferedReader(origen);
        
        FileWriter desti = new FileWriter(fitxerDestinacio);
        BufferedWriter destinacio = new BufferedWriter(desti);
        int contador = 0;
        while (true) {
            String linia = readOrigen.readLine();    //lee linia del origen
            if (null == linia && contador == 0) {
                System.out.println("No hi ha contingut");
                break;
            }
            contador++;
            if (null == linia && contador != 0) break;
            //crida a tradueixLinia para que traduzca la linia
            String resultat = tradueixLinia(linia, fitxerTraduccio);
        
            //escribe traduccion de linia al fichero destinacio
            destinacio.write(String.format("%s%n",resultat));
        
        }
        destinacio.close();
        readOrigen.close();
    
    }
    
    //agafa una linia per a tradueir
    //reemplaça els primers valors(clau) per el valor al nou fitxer
    //en cada crida processa de nou el fitxer traducció
    public static String tradueixLinia(String linia, String fitxerTraduccio) throws IOException {
        FileReader traduccio = new FileReader(fitxerTraduccio);
        BufferedReader readTradu = new BufferedReader(traduccio);
        
        String nowText = "";
        nowText = linia;
        //separa la primera coma, si existen más se ignora
        while (true) {
            String input = readTradu.readLine();            
            if (null == input) break;
            //separamos la linia del ficheroTradu donde primera es clau i segona es valor
            String[] separado = input.split(", ",2);  //coma y un espacio para que no guarde espacios de más, el 2 es para que separe en dos y por defecto coge la primera coma e ignora las otras
            nowText = nowText.replace(separado[0], separado[1]);
        }
        readTradu.close();
        return nowText;
    }
}
