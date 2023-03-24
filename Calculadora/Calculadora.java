/*
 *
 * Programa que farà calculs senzills
 *
 * Demana dos operands i un operador binari (+, -, * , /)
 * i mostra el resultat del càlcul corresponent.
 *
 * Demana numero, operador i un altre numero. En aquest ordre. Si l'usuari introdueix un valor no vàlid s'indicarà per pantalla.
 *
 */
public class Calculadora {
    public static void main(String[] args) {
        System.out.println("Numero?");
        double operand1 = Double.parseDouble(Entrada.readLine());
        System.out.println("Operador?");
        char operador = Entrada.readLine().charAt(0);
        System.out.println("Segundo numero?");
        double operand2 = Double.parseDouble(Entrada.readLine());

        if (operador == '+') {
            double resultat = operand1 + operand2;
            System.out.println(operand1 + " + " + operand2 + " = " + resultat);
        } else if (operador == '-') {
            double resultat = operand1 - operand2;
            System.out.println(operand1 + " - " + operand2 + " = " + resultat);
        } else if (operador == '*') {
            double resultat = operand1 * operand2;
            System.out.println(operand1 + " * " + operand2 + " = " + resultat);
        } else if (operador == '/') {
            double resultat = operand1 / operand2;
            if (operand1 == 0 || operand2 == 0) {
            System.out.println("No es pot dividir entre 0");
            } else {
            System.out.println(operand1 + " / " + operand2 + " = " + resultat);
            }
        } else { System.out.println("L'operador " + operador + " no està disponible");
        }
    }
}
