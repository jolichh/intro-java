/*
 *
 * Programa que dibuixa la Torre Eiffel amb el signe $
 *
 * Aquesta activitat em permet practicar els bucles for
 *
 */

public class TorreEiffel {
    public static void main (String[] args) {
        //punta torre
        for (int i = 0; i < 2; i++) {    
            //punts incials
            for (int e = 0; e <= 18; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 2; e++) {
                System.out.print("$");
            } 
            //puntos izq
            for (int e = 0; e <= 18; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //primer trozo de la torre
        for (int i = 0; i < 2; i++) {
            for (int e = 0; e <= 17; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 4; e++) {
                System.out.print("$");
            }
            //punt izq
            for (int e = 0; e <= 17; e++) {
                System.out.print("_");
            }
            //salt linea
            System.out.println();
        }
        //bajando punta
        for (int i = 0; i < 4; i++) {    
            //punts incials
            for (int e = 0; e <= 18; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 2; e++) {
                System.out.print("$");
            } 
            //punts izq
            for (int e = 0; e <= 18; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //añadir grosor
        for (int i = 0; i < 7; i++) {    
            //punts incials
            for (int e = 0; e <= 17; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 4; e++) {
                System.out.print("$");
            } 
            //punts izzq
            for (int e = 0; e <= 17; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //añadir otro grosor
        for (int i = 0; i < 4; i++) {    
            //punts incials
            for (int e = 0; e <= 16; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 6; e++) {
                System.out.print("$");
            } 
            //punts izq
            for (int e = 0; e <= 16; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //un poco más de grosor
        for (int i = 0; i < 3; i++) {    
            //punts incials
            for (int e = 0; e <= 15; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 8; e++) {
                System.out.print("$");
            } 
            //punts izq
            for (int e = 0; e <= 15; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //pieza antes de la base superior
        for (int i = 0; i < 2; i++) {    
            //punts incials
            for (int e = 0; e <= 14 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 10; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 14 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //base superior
        for (int i = 0; i < 2; i++) {    
            //punts incials
            for (int e = 0; e <= 12 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 14; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 12 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //part inferior de la base superior
        for (int i = 0; i < 1; i++) {    
            //punts incials
            for (int e = 0; e <= 14 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 10; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 14 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //linea antes del hueco
        for (int i = 0; i < 2; i++) {    
            //punts incials
            for (int e = 0; e <= 13 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 12; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 13 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        // linea hueco
        for (int i = 0; i < 3; i++) { 
            //punts incials creixents lado derecho
            for (int e = 0; e <= (11 -i) ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 6; e++) {
                System.out.print("$");
            }
            //lineas del hueco derecho
            for (int e = 0; e < (2+i); e++) {
                System.out.print("_");
            }
            //lineas hueco zquierda
            for (int e = 0; e < (2+i); e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 6; e++) {
                System.out.print("$");
            }
            //izq
            for (int e = 0; e <= (11 -i) ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
            
        }
         for (int i = 0; i < 1; i++) { 
            //punts incials creixents lado derecho
            for (int e = 0; e <= (8 -i) ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 7; e++) {
                System.out.print("$");
            }
            //lineas del hueco derecho
            for (int e = 0; e < (4+i); e++) {
                System.out.print("_");
            }
            //lineas hueco zquierda
            for (int e = 0; e < (4+i); e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 7; e++) {
                System.out.print("$");
            }
            //izq
            for (int e = 0; e <= (8 -i) ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //primera linea despues del hueco(barandilla)
        for (int i = 0; i < 1; i++) {    
            //punts incials
            for (int e = 0; e <= 6 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 9; e++) {
                System.out.print("$");
            } 
            //barandilla del hueco
            for (int e = 0; e < 4; e++) {
                System.out.print("_$");
            }
            for (int e = 0; e < 9; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 6 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //base de las patas
        for (int i = 0; i < 2; i++) {    
            //punts incials
            for (int e = 0; e <= 6 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 26; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 6 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //linea larga continua antes de la pata
        for (int i = 0; i < 2; i++) {    
            //punts incials
            for (int e = 0; e <= 4 ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 30; e++) {
                System.out.print("$");
            } 
            //izq
            for (int e = 0; e <= 4 ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
        //primera linea pata torre
        for (int i = 0; i < 1; i++) {
            //puntos iniciales
            for (int e = 0; e < 4; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 12; e++) {
                System.out.print("$");
            }
            //puntos centrales
            for (int e = 0; e < 8; e++) {
                System.out.print("_");
            }
            //puntos finales
            for (int e = 0; e < 12; e++) {
                System.out.print("$");
            }
            //izq
            for (int e = 0; e < 4; e++) {
                System.out.print("_");
            }
            System.out.println();
        }
        //patas de la torre
        for (int i = 0; i < 4; i++) { 
            //punts incials creixents lado derecho
            for (int e = 0; e < (3 -i) ; e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 11; e++) {
                System.out.print("$");
            }
            //lineas del hueco derecho
            for (int e = 0; e < (8+i); e++) {
                System.out.print("_");
            }
            //lineas hueco zquierda
            for (int e = 0; e < (4+i); e++) {
                System.out.print("_");
            }
            for (int e = 0; e < 11; e++) {
                System.out.print("$");
            }
            //izq
            for (int e = 0; e < (3 -i) ; e++) {
                System.out.print("_");
            }
            //salto linea
            System.out.println();
        }
    }
}
