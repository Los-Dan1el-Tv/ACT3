import java.util.ArrayList;
import java.util.List;

public class Desafio3 {

    static int[] dFila = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static int minMovimientos = Integer.MAX_VALUE;
    static List<String> mejorRuta = new ArrayList<>();

    public static void main(String[] args) {
        // Matriz del laberinto (puedes modificarla para tomar las capturas de tus pruebas)
        char[][] laberinto = {
            {'S', '.', '.', '#', '.'},
            {'#', '#', '.', '#', '.'},
            {'.', '.', '.', '.', '.'},
            {'.', '#', '#', '#', '.'},
            {'.', '.', '.', '.', 'E'}
        };

        // Reiniciar datos
        minMovimientos = Integer.MAX_VALUE;
        mejorRuta = new ArrayList<>();

        int filas = laberinto.length;
        int columnas = laberinto[0].length;
        boolean[][] visitado = new boolean[filas][columnas];

        int inicioFila = -1, inicioCol = -1;

        // Búsqueda dinámica del punto de inicio 
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (laberinto[i][j] == 'S') {
                    inicioFila = i;
                    inicioCol = j;
                }
            }
        }

        List<String> rutaActual = new ArrayList<>();
        buscarRuta(laberinto, visitado, inicioFila, inicioCol, 0, rutaActual);

        System.out.println("=== DESAFÍO 3: RUTA DE ESCAPE ===");
        if (minMovimientos != Integer.MAX_VALUE) {
            System.out.println("¡Ruta más corta encontrada!");
            System.out.println("Movimientos: " + minMovimientos);
            System.out.println("Recorrido: " + mejorRuta);
        } else {
            System.out.println("No existe una ruta válida hacia la salida 'E'.");
        }
    }

    public static void buscarRuta(char[][] lab, boolean[][] visitado, int f, int c, int pasosActuales, List<String> rutaActual) {
        int filas = lab.length;
        int columnas = lab[0].length;

        //  interrumpe el camino si ya superó a la mejor ruta guardada
        if (pasosActuales >= minMovimientos) {
            return;
        }

        // Caso base
        if (lab[f][c] == 'E') {
            minMovimientos = pasosActuales;
            mejorRuta = new ArrayList<>(rutaActual);
            mejorRuta.add("(" + f + "," + c + ")");
            return;
        }

        visitado[f][c] = true;
        rutaActual.add("(" + f + "," + c + ")");

        // Explorar 4 direcciones
        for (int i = 0; i < 4; i++) {
            int nuevaFila = f + dFila[i];
            int nuevaCol = c + dCol[i];

            if (nuevaFila >= 0 && nuevaFila < filas && nuevaCol >= 0 && nuevaCol < columnas) {
                if (lab[nuevaFila][nuevaCol] != '#' && !visitado[nuevaFila][nuevaCol]) {
                    buscarRuta(lab, visitado, nuevaFila, nuevaCol, pasosActuales + 1, rutaActual);
                }
            }
        }

        // Backtracking
        visitado[f][c] = false;
        rutaActual.remove(rutaActual.size() - 1);
    }
}
