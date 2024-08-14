package Juegos;

import java.util.Scanner;

public class PiedraPapelTijeras {

    public static void main() {
        Scanner sc = new Scanner(System.in);

        String PC[] = {"Piedra", "Papel", "Tijera"};

        int aleat = (int) ((Math.random() * 3));
        boolean repetir = false;

        do {
            System.out.println("Elija: Piedra, Papel o Tijera");
            String user = sc.nextLine();
            System.out.println("Tú: " + user);
            System.out.println("Oponente: " + PC[aleat]);

            if (user.equalsIgnoreCase(PC[aleat])) {
                System.out.println("Empate, vuelva a jugar");
                repetir = true;
            } else if ((user.equalsIgnoreCase("Piedra") && PC[aleat].equalsIgnoreCase("Tijera")) || (user.equalsIgnoreCase("Tijera") && PC[aleat].equalsIgnoreCase("Papel")) || (user.equalsIgnoreCase("Papel") && PC[aleat].equalsIgnoreCase("Piedra"))) {
                System.out.println("Has ganado!");
                repetir = false;
            } else if ((user.equalsIgnoreCase("Papel") && PC[aleat].equalsIgnoreCase("Tijera")) || (user.equalsIgnoreCase("Piedra") && PC[aleat].equalsIgnoreCase("Papel")) || (user.equalsIgnoreCase("Tijera") && PC[aleat].equalsIgnoreCase("Piedra"))) {
                System.out.println("Has perdido");
                repetir = false;
            } else {
                System.out.println("No ha introducido una opción válida, vuelva a intentarlo");
                repetir = true;
            }
        } while (repetir == true);
    }

}
