package Juegos;

import java.util.Scanner;

public class TresEnRaya {

    public static void main() {
        Scanner sc = new Scanner(System.in);

        String[][] tablero = new String[3][3];
        int i;
        int j;
        int[] fila = new int[3];
        int[] col = new int[3];
        int filaPC;
        int colPC;
        int turn;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                tablero[i][j] = "-";
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Que comience la partida");

        for (turn = 0; turn < 3; turn++) {
            System.out.println("Le toca jugar. Introduzca la posición de su ficha");
            System.out.print("Fila: ");

            boolean inputValido = false;
            while (!inputValido) {
                try {
                    System.out.println("Columna:");
                    fila[turn] = sc.nextInt();
                    inputValido = true;
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    sc.next();
                }
            }

            inputValido = false;
            while (!inputValido) {
                try {
                    System.out.println("Columna:");
                    col[turn] = sc.nextInt();
                    inputValido = true;
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    sc.next();
                }
            }

            if (fila[turn] < 1 || fila[turn] > 3 || col[turn] < 1 || col[turn] > 3) {
                System.out.println("Posición no válida. Introduzca una posición válida (1~3)");
                System.out.print("Fila: ");
                fila[turn] = sc.nextInt();
                System.out.print("\nColumna: ");
                col[turn] = sc.nextInt();
            }

            while (!tablero[fila[turn] - 1][col[turn] - 1].equals("-")) {
                System.out.println("Posición ocupada. Introduzca otra posición");
                System.out.print("Fila: ");
                fila[turn] = sc.nextInt();
                System.out.print("\nColumna: ");
                col[turn] = sc.nextInt();
            }

            tablero[fila[turn] - 1][col[turn] - 1] = "X";

            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Le toca a tu oponente:");
            do {
                filaPC = (int) (Math.random() * 3) + 1;
                colPC = (int) (Math.random() * 3) + 1;
            } while (!tablero[filaPC - 1][colPC - 1].equals("-"));

            tablero[filaPC - 1][colPC - 1] = "O";

            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
        }

        boolean alguienGana = false;

        if (tablero[0][0].equals("X")) {
            if ((tablero[0][1].equals("X") && tablero[0][2].equals("X")) || (tablero[1][0].equals("X") && tablero[2][0].equals("X")) || (tablero[1][1].equals("X") && tablero[2][2].equals("X"))) {
                System.out.println("Has ganado!");
                alguienGana = true;
            }
        } else if (tablero[1][0].equals("X")) {
            if (tablero[1][1].equals("X") && tablero[1][2].equals("X")) {
                System.out.println("Has ganado!");
                alguienGana = true;
            }
        } else if (tablero[2][0].equals("X")) {
            if ((tablero[2][1].equals("X") && tablero[2][2].equals("X")) || (tablero[1][1].equals("X") && tablero[0][2].equals("X"))) {
                System.out.println("Has ganado!");
                alguienGana = true;
            }
        } else if (tablero[0][1].equals("X")) {
            if ((tablero[1][1].equals("X") && tablero[2][1].equals("X"))) {
                System.out.println("Has ganado!");
                alguienGana = true;
            }
        } else if (tablero[0][2].equals("X")) {
            if ((tablero[1][2].equals("X") && tablero[2][2].equals("X"))) {
                System.out.println("Has ganado!");
                alguienGana = true;
            }
        }
        if (tablero[0][0].equals("O")) {
            if ((tablero[0][1].equals("O") && tablero[0][2].equals("O")) || (tablero[1][0].equals("O") && tablero[2][0].equals("O")) || (tablero[1][1].equals("O") && tablero[2][2].equals("O"))) {
                System.out.println("Has perdido :(");
                alguienGana = true;
            }
        } else if (tablero[1][0].equals("O")) {
            if (tablero[1][1].equals("O") && tablero[1][2].equals("O")) {
                System.out.println("Has perdido :(");
                alguienGana = true;
            }
        } else if (tablero[2][0].equals("O")) {
            if ((tablero[2][1].equals("O") && tablero[2][2].equals("O")) || (tablero[1][1].equals("O") && tablero[0][2].equals("O"))) {
                System.out.println("Has perdido :(");
                alguienGana = true;
            }
        } else if (tablero[0][1].equals("O")) {
            if ((tablero[1][1].equals("O") && tablero[2][1].equals("O"))) {
                System.out.println("Has perdido :(");
                alguienGana = true;
            }
        } else if (tablero[0][2].equals("O")) {
            if ((tablero[1][2].equals("O") && tablero[2][2].equals("O"))) {
                System.out.println("Has perdido :(");
                alguienGana = true;
            }
        }

        if (!alguienGana) {
            System.out.println("Empate");
        }
    }
}
