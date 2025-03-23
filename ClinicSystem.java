import java.util.Scanner;

public class ClinicSystem {
    public static void main(String[] args) {
        TurnQueue turnQueue = new TurnQueue();
        Scanner scanner = new Scanner(System.in);

        // Cargar los turnos desde el archivo al iniciar el sistema
        turnQueue.loadTurnsFromFile();

        boolean running = true;
        while (running) {
            System.out.println("=== Clinic System ===");
            System.out.println("1. Añadir un nuevo turno");
            System.out.println("2. Siguiente turno");
            System.out.println("3. Salir");
            System.out.print("Elije una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Agregar un nuevo turno
                    System.out.print("Ingresa el ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Ingresa el nombre del paciente: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Ingresa la especialidad: ");
                    String specialty = scanner.nextLine();

                    Turn newTurn = new Turn(id, patientName, specialty);
                    turnQueue.addTurn(newTurn);
                    System.out.println("Turno guardado correctamente!\n");
                    break;

                case 2:
                    // Atender un turno
                    turnQueue.serveTurn();
                    System.out.println("Siguiente turno !\n");
                    break;

                case 3:
                    // Salir del sistema
                    running = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Número inválido, ingrese otro.\n");
                    break;
            }
        }

        // Guardar los turnos restantes en el archivo antes de salir
        turnQueue.saveTurnToFile();
        scanner.close();
    }
}
