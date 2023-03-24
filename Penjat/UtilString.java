/*
 *
 * =========================
 *        BIBLIOTECA
 *    Utilitats de String
 * =========================
 * Aquesta Biblioteca guarda
 * diferents utilitats per treballar Strings
 *
 *
 */

public class UtilString {

    //detecta vocals
    public static boolean esVocal(String text) {
        
        String vocals = "aeiouàèéíïòóúü";
        text = text.toLowerCase();
        for (int i = 0; i < vocals.length(); i++) {
            if (text.charAt(0) == vocals.charAt(i) || text.charAt((text.length()-1)) == vocals.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    
    //separa lletres amb coma
    public static String lletresSeparades(String paraula) {
        String text = "";
        for (int i = 0; i <= paraula.length() - 1; i++) {
            if (i == 0) { 
                text = text + paraula.charAt(i);
            } else {
                text = text + ", " + paraula.charAt(i);
            }
        }
        return text;
    }
    
    //agafa només les lletres
    public static String nomesLletres(String text) {
        String paraula = "";
        for (int i = 0; i <= text.length() -1; i++) {
            if (Character.isLetter(text.charAt(i))) {
            paraula = paraula + text.charAt(i);
            }
        }
        return paraula;
    }
    
    //troba els caracters del text dintre de l'interval introduit
    public static String intervalString(String text, int inici, int fi) {
        
        //si supera la paraula equival a la paraula
        if (fi > text.length()-1) {
            fi = text.length()-1;
        }
        if (inici > text.length()-1) {
            inici = text.length() -1;
        }
        
        //si es negatiu
        if (inici < 0) {
            inici = 0;
        }
        if (fi < 0) {
            fi = 0;
        }
        
        //pasem a extreure el tros de text
        String textNet = "";
        if (inici <= fi) {
            for (int i = inici; i<= fi; i++) {
                textNet= textNet + text.charAt(i);
            }
        } else {
            for (int i = inici; i >= fi; i--) {
                textNet= textNet + text.charAt(i);
            }
        }
        return textNet;
    }
    
    //permet averiguar si el text es enter o no (numero valid)
    public static boolean esEnter(String text) {
        
        if (!text.isBlank()) {
            int signo = 0;
            String text2 = ""; //aquí es guarda el text valid (signes)
            //ens asegurem que no tingui més d'un signe
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '+' || text.charAt(i) == '-') {
                    signo = signo + 1;
                    //si no es un signe, guardem el caracter
                } else {
                    text2 = text2 + text.charAt(i); 
                }
            }
            if (signo <= 1) {
                //treballem sobre el text sense signes
                for (int i = 0; i < text2.length(); i++) {
                    //detectem si porta alguna otra cosa que no sigui numero
                    if (!Character.isDigit(text2.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    //versio estricte o no estricte
    /*public static boolean esEnter(String text, boolean estricte) {
        boolean enter;
        if (estricte) {
            enter = esEnter(text);
        } else {
            text = text.strip();
            enter = esEnter(text);
        }
        return enter;
    } */
    
    public static int aEnter(String text, boolean estricte) {
        int numero;
        if (estricte) {
            numero = Integer.parseInt(text);
        } else {
            text = text.strip();
            numero = Integer.parseInt(text);
        }
        return numero;
    }
    
    //cadena continua
    public static String cadenaContinua(String text, int num) {
        String var = text;
        String texto = "";
            
        //arreglem problemes de length i numero
        if (text.length() < num) {
            while (var.length() <= num) {
                var = var + text;
            }
            text = var;
        }
        //procedim a fer el calcul
        if (num <= 0) {
            System.out.println("");
        } else {
            for (int i = 0; i < num; i++) {
                texto = texto + text.charAt(i);
            }
        }
        return texto;
    }
    
    public static String entreComes(int[] numeros, char separa) {
        
        //pasem a printejar els numeros amb comes
        String text = "";

        if (numeros.length > 0) {
            text = String.valueOf(numeros[0]);
            for (int i = 1; i < numeros.length; i++) {
                text = text + separa + " " + numeros[i];
            }
            return text;
        }
        return text;
    }
    
    //modulo que devuelve el mismo texto enmascarado
    public static String ocultaText(String paraula) {
        String txt = "";
        for (int i=0; i<paraula.length(); i++) {
            txt = txt + '*';
        }
        return txt;
    }
    
    //comprueba si las letras de la primera palabra están en la segunda palabra
    public static boolean esRepeteixLletra(String primer, String segon) {
        primer = primer.toUpperCase();
        segon = segon.toUpperCase();
        for (int i=0; i<segon.length(); i++) {
            for (int e=0; e<primer.length(); e++) {
                if (segon.charAt(i) == primer.charAt(e)) {
                    return true;
                }
            }
        }
        return false;
    }
}
