import java.util.Scanner;

public class JuegosMix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        menu();

        int opc = sc.nextInt();

        switch (opc) {
            case 1 -> Juegos.Ahorcado.main();
            case 2 -> Juegos.Bingo.main();
            case 3 -> Juegos.HundirFlota.main();
            case 4 -> Juegos.PiedraPapelTijeras.main();
            case 5 -> Juegos.TresEnRaya.main();
            default -> System.out.println("Elija una opción");
        }
    }

    private static void menu(){
        System.out.println("Buenos días, ¿a qué quieres jugar hoy?");
        System.out.println("1.Ahorcado\n2.Bingo\n3.Hundir la flota\n4.Piedra, papel o tijeras\n5.Tres en raya");
    }
}
