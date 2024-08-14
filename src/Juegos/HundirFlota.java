package Juegos;

import java.util.Objects;
import java.util.Scanner;

public class HundirFlota {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int i;
        int j;
        int col = 0;
        int fila = 0;
        String[][] tablero = new String[4][4];
        String[][] barco = new String[4][4];
        tablero[0][0] = "/";
        tablero[0][1] = "1";
        tablero[1][0] = "1";
        tablero[0][2] = "2";
        tablero[2][0] = "2";
        tablero[0][3] = "3";
        tablero[3][0] = "3";


        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                tablero[i][j] = "0";
            }
        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        int aleat1A;
        int aleat2A;
        int aleat1B;
        int aleat2B;

        do {
            aleat1A = (int) ((Math.random() * 3) + 1);  //Multiplico por 3 para que abarca los cuatro valores (0-3)
            aleat2A = (int) ((Math.random() * 3) + 1);

            aleat1B = (int) ((Math.random() * 3) + 1);
            aleat2B = (int) ((Math.random() * 3) + 1);
        } while (aleat1A == aleat1B || aleat2A == aleat2B);

        barco[aleat1A][aleat2A] = "X";
        barco[aleat1B][aleat2B] = "X";

        System.out.println("Introduzca una posición.");
        while (true) {

            boolean inputValido = false;
            while (!inputValido) {
                try {
                    System.out.println("Fila:");
                    fila = sc.nextInt();
                    inputValido = true; // Si se introduce un número válido, salir del bucle
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    sc.next(); // Limpiar la entrada no válida
                }
            }

            inputValido = false;
            while (!inputValido) {
                try {
                    System.out.println("Columna:");
                    col = sc.nextInt();
                    inputValido = true; // Si se introduce un número válido, salir del bucle
                } catch (Exception e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número.");
                    sc.next(); // Limpiar la entrada no válida
                }
            }

            if ((aleat1A == fila && aleat2A == col)) {
                System.out.println("HUNDIDO\n");
                tablero[fila][col] = barco[aleat1A][aleat2A];
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            if ((aleat1B == fila && aleat2B == col)) {
                System.out.println("HUNDIDO");
                tablero[fila][col] = barco[aleat1B][aleat2B];
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println();
                }
            } else if (aleat1A != fila || aleat2A != col) {
                System.out.println("AGUA");
                tablero[fila][col] = "~";
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        System.out.print(tablero[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            if ((Objects.equals(tablero[aleat1A][aleat2A], "X")) && (Objects.equals(tablero[aleat1B][aleat2B], "X"))) {
                System.out.println("GANASTE!");
                return;
            }
        }
    }
}
