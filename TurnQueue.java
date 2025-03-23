import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class TurnQueue {
    private final String TURNS_FILE = "src/assets/files/turns_file.txt";
    private final String SERVED_FILE = "src/assets/files/served_file.txt";
    private Queue<Turn> queue = new LinkedList<>();

    // Añade un nuevo turno a la cola y lo guarda en archivo
    public void addTurn(Turn turn) {
        queue.offer(turn);
        saveTurnToFile();
    }

    // Atiende un turno si hay disponible
    public void serveTurn() {
        if (queue.isEmpty()) {
            System.out.println("No hay turnos.");
            return;
        }
        Turn servedTurn = queue.poll();  // Elimina el turno atendido de la cola
        System.out.println(servedTurn);
        saveServedTurnToFile(servedTurn);
        saveTurnToFile();
    }

    // Carga los turnos pendientes desde el archivo
    public void loadTurnsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(TURNS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {  // Verifica que el formato sea correcto
                    int id = Integer.parseInt(data[0]);
                    String patientName = data[1];
                    String specialty = data[2];
                    queue.offer(new Turn(id, patientName, specialty));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Turns file not found. A new one will be created.");
        } catch (IOException e) {
            System.out.println("Error reading turns file: " + e.getMessage());
        }
    }

    // Guarda los turnos pendientes en el archivo
    public void saveTurnToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TURNS_FILE))) {
            for (Turn turn : queue) {
                bw.write(turn.turnInfo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving turns to file: " + e.getMessage());
        }
    }

    // Guarda un turno atendido en el archivo de turnos servidos
    public void saveServedTurnToFile(Turn turn) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SERVED_FILE, true))) {
            bw.write(turn.turnInfo());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving served turn: " + e.getMessage());
        }
    }
}
