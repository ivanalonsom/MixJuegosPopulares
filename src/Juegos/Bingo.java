package Juegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bingo {


    public static void main() {
        Scanner sc = new Scanner(System.in);
        int opciones;
        int[][] cartonActual = new int[3][9];

        do {
            menu();
            opciones = sc.nextInt();
            switch (opciones) {
                case 1 -> cartonActual = generarCarton();
                case 2 -> verCarton(cartonActual);
                case 3 -> {
                    int bola = sacarbola();
                    escribeCarton(bola, cartonActual);
                }
                case 4 -> System.out.println("Fin del juego.");
            }
        } while (opciones != 4);
    }

    public static void menu() {
        System.out.println("Elija una opción");
        System.out.println("1- Generar cartón.");
        System.out.println("2- Mostrar estado del cartón.");
        System.out.println("3- Sacar bola.");
        System.out.println("4- Salir del juego.");
    }

    public static int[][] generarCarton() {
        int[][] carton = cartonHuecos(cartonOrdenado());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] != 0) {
                    System.out.print(carton[i][j] + "\t");
                } else if (carton[i][j] == 0) {
                    System.out.print("■ \t");
                }
            }
            System.out.println(" ");
        }
        System.out.println("\n");
        return carton;
    }

    public static void verCarton(int[][] carton) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] == -1) {
                    System.out.print("X \t");
                } else if (carton[i][j] == 0) {
                    System.out.print("■ \t");
                } else if (carton[i][j] != -1) {
                    System.out.print(carton[i][j] + "\t");
                }
            }
            System.out.println(" ");
        }
        System.out.println("\n");
    }

    private static boolean linea1 = false;                          //Esto mantiene el valor (true or false) entre cada llamada a la funcion, si lo declaraba dentro de la funcion me salia siempre LINEA una vez tenia linea por primera vez)
    private static boolean linea2 = false;
    private static boolean linea3 = false;

    public static void escribeCarton(int bola, int[][] carton) {
        int contLinea;
        int contBingo = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (bola == carton[i][j]) {
                    carton[i][j] = -1;
                    contBingo++;
                }
                if (contBingo == 15) {
                    System.out.println("BINGO \n");
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            contLinea = 0;
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] == -1) {
                    contLinea++;
                }
                if (contLinea == 5 && i == 0 && !linea1) {
                    linea1 = true;
                    System.out.println("LINEA \n");
                }
                if (contLinea == 5 && i == 1 && !linea2) {
                    linea2 = true;
                    System.out.println("LINEA \n");
                }
                if (contLinea == 5 && i == 2 && !linea3) {
                    linea3 = true;
                    System.out.println("LINEA \n");
                }
            }
        }
    }

    private static final List<Integer> bolasSacadas = new ArrayList<>();

    public static int sacarbola() {
        Random random = new Random();
        int bola;
        do {
            bola = random.nextInt(1, 89);
        } while (bolasSacadas.contains(bola));

        bolasSacadas.add(bola);
        System.out.println("\n" + bola + "\n");
        return bola;
    }

    public static int[][] cartonOrdenado() {
        Random random = new Random();
        boolean repe;
        int[][] carton = new int[4][10];
        int i, j, k;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                do {
                    carton[i][j] = random.nextInt(10 * j, 10 * j + 9);
                    repe = false;
                    for (k = 0; k < 10 * i + j; k++) {
                        if (carton[i][j] == carton[k / 10][k % 10]) {
                            repe = true;
                            break;                                  //Una vez es true ya se que el numero esta repe, no tiene sentido seguir comprobando, uso break y que vuelva al do para dar otro valor
                        }
                    }
                } while (repe);
            }
        }

        int temp;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                for (int l = 0; l <= i - 1; l++) {
                    if (carton[i][j] < carton[l][j]) {
                        temp = carton[i][j];
                        carton[i][j] = carton[l][j];
                        carton[l][j] = temp;
                    }
                }
            }

        }
        return carton;
    }

    public static int[][] cartonHuecos(int[][] cartonOrdenado) {
        Random random = new Random();

        int i, j;

        int huecos = 4;
        int posHueco;

        for (i = 0; i < 3; i++) {
            while (huecos > 0) {
                posHueco = random.nextInt(9);
                if (cartonOrdenado[i][posHueco] != 0 && i < 2) {
                    cartonOrdenado[i][posHueco] = 0;
                    huecos--;
                } else if (cartonOrdenado[i][posHueco] != 0 && i == 2) {
                    if (cartonOrdenado[i - 1][posHueco] != 0 || cartonOrdenado[i - 2][posHueco] != 0) {
                        cartonOrdenado[i][posHueco] = 0;
                        huecos--;
                    }
                }
            }
            huecos = 4;
        }

        boolean repetir;

        for (j = 0; j < 9; j++) {
            repetir = true;         // Lo pongo para que bucle while vuelva a ocurrir en caso de que tenga más de una situacion con tres unos en columna
            if (cartonOrdenado[0][j] != 0 && cartonOrdenado[1][j] != 0 && cartonOrdenado[2][j] != 0) {
                cartonOrdenado[2][j] = 0;
                while (repetir) {
                    posHueco = random.nextInt(0, 8);
                    if (cartonOrdenado[2][posHueco] == 0 && (cartonOrdenado[0][posHueco] == 0 || cartonOrdenado[1][posHueco] == 0)) {
                        if (posHueco == 0) {
                            cartonOrdenado[2][posHueco] = random.nextInt(1, 9);
                        } else {
                            cartonOrdenado[2][posHueco] = random.nextInt(posHueco * 10, posHueco * 10 + 9);
                        }
                        repetir = false;

                    }
                }
            }
        }
        return cartonOrdenado;
    }
}
