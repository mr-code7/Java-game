import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Game g = new Game(20, 20);
        int input = 0;
        int passi = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                    "\nScegli un opzione: \n\t1.muovi su \n\t2.muovi giù \n\t3.muovi a destra\n\t4.muovi a sinistra\n\t5.abbassa la penna\n\t6.alza la penna\n\t9.esci");
            input = sc.nextInt();
            if (input <= 4 && input >= 0) {
                System.out.println("Quanti passi vuoi fare?");
                passi = sc.nextInt();
            }
            switch (input) {
                case 1:
                    g.muovi(-1 * passi, 0);
                    break;
                case 2:
                    g.muovi(passi, 0);
                    break;
                case 3:
                    g.muovi(0, passi);
                    break;
                case 4:
                    g.muovi(0, -passi);
                    break;
                case 5:
                    g.penna(true);
                    break;
                case 6:
                    g.penna(false);
                    break;
                default:
                    break;
            }
            g.stampa();

        } while (input != 9);
    }
}
