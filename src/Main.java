import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n==========================================");
            System.out.println("    .----- ESCAPE ROOM--------,");
            System.out.println("==========================================");
            System.out.println("1. Desafio 1: El codigo fragmentado Recursividad");
            System.out.println("2. Desafio 2:  Divide y Venceras");
            System.out.println("3. Desafio 3: Backtracking");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                System.out.println();

                switch (opcion) {
                    case 1:
                        Desafio1.main(new String[]{});
                        break;
                    case 2:
                        Desafio2.main(new String[]{});
                        break;
                    case 3:
                        Desafio3.main(new String[]{});
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } else {
                System.out.println("Ingresa un numero valido.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
