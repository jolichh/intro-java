/*
 *
 * Programa que permet jugar al tres en ratlla entre dos usuaris alternativament
 *
 * Sempre començarà el jugador X
 * 
 * Les coordenades s'indiquen amb dos xifres sense espais, la primera equival a fila i la segona, columna
 *
 * Si la casella esta ocupada es torna a demanar moviment
 * 
 * El joc finalitza quan:
 *  - s'introdueix valor "a"/"A"
 *  - victoria del jugador
 *  - empat
 *
 */
 
public class TresEnRatlla {

    // mòduls de suport
    public static void mostraTaulell(char[][] taulell) {
        for (int fila=0; fila < 3; fila++) {
            for(int col = 0; col <3; col++) {
                System.out.print(taulell[fila][col]);
            }
            System.out.println();
        }
    }    
    //retorna cert quan esta ocupada (no sigui '·')
    public static boolean casellaOcupada(char[][] taulell, int fila, int columna) {
        if (taulell[fila][columna] != '·') {
            return true;
        }
        return false;
    }    
    //cert quan hi ha tres en ratlla
    public static boolean jugadorGuanya(char[][] taulell, char jugador) {
        //comprovar guanyador fila
        if (taulell[0][0] == jugador && taulell[0][1] == jugador && taulell[0][2] == jugador) {
            return true;
        }
        if (taulell[1][0] == jugador && taulell[1][1] == jugador && taulell[1][2] == jugador) {
            return true;
        }
        if (taulell[2][0] == jugador && taulell[2][1] == jugador && taulell[2][2] == jugador) {
            return true;
        }
        
        //comprovar guanyador per columnes
        if (taulell[0][0] == jugador && taulell[1][0] == jugador && taulell[2][0] == jugador) {
            return true;
        }
        if (taulell[0][1] == jugador && taulell[1][1] == jugador && taulell[2][1] == jugador) {
            return true;
        }
        if (taulell[0][2] == jugador && taulell[1][2] == jugador && taulell[2][2] == jugador) {
            return true;
        }
        
        //comprovar guanyador per diagonals
        if (taulell[0][0] == jugador && taulell[1][1] == jugador && taulell[2][2] == jugador) {
            return true;
        }
        if (taulell[0][2] == jugador && taulell[1][1] == jugador && taulell[2][0] == jugador) {
            return true;
        }
        return false;
    }
    
    //cert quan no queden més moviments
    public static boolean hiHaEmpat(char[][] taulell) {
        //comprovar si queden caselles buides
        for (int fila= 0; fila<3; fila++){
            for (int col =0; col<3; col++) {
                if (taulell[fila][col] == '·') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
    // declara i inicialitza el taulell
        char[][] taulell = new char[3][3];
        taulell[0][0] = '·';
        taulell[0][1] = '·';
        taulell[0][2] = '·';
        
        taulell[1][0] = '·';
        taulell[1][1] = '·';
        taulell[1][2] = '·';
        
        taulell[2][0] = '·';
        taulell[2][1] = '·';
        taulell[2][2] = '·';

        System.out.println("Comença el joc");
        System.out.println("    Per abandonar: 'a'");

        // indica quin és el jugador que té el torn
        char jugador = 'X';

        while (true) {

            mostraTaulell(taulell);

            // obté el moviment del jugador actual
            System.out.println(jugador + "?");
            String text = Entrada.readLine();

            // comprova abandonament
            if (text.equals("a")) {
                System.out.println(jugador + " abandona");
                break;
            }

            // obté coordenades del moviment
            if (text.length() != 2) {
                System.out.println("Error");
                continue;
            } 
            if (!Character.isDigit(text.charAt(0)) && !Character.isDigit(text.charAt(1))) {
                System.out.println("Error");
                continue;
            }

            // comprova si la casella està ocupada
            int fila = Integer.parseInt(Character.toString(text.charAt(0)));
            int col = Integer.parseInt(Character.toString(text.charAt(1)));
            boolean ocupada = casellaOcupada(taulell, fila, col);
            
            if (ocupada) {
                System.out.println("Ocupada");
                continue;
            }
            
            // realitza el moviment
            taulell[fila][col] = jugador;

            // comprova jugador guanya
            boolean guanya = jugadorGuanya(taulell, jugador);
            
            if (guanya) {
                mostraTaulell(taulell);
                System.out.println(jugador + " guanya");
                break;
            }

            // comprova empat
            boolean empat = hiHaEmpat(taulell);
            if (empat) {
                System.out.println("Empat");
                break;
            }

            // passa torn a l'altre jugador
            if (jugador == 'X') {
                jugador = 'O';
            } else {
                jugador = 'X';
            }
        }
    }
}
