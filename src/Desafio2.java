public class Desafio2 {

    // Función recursiva usando Divide y Vencerás
    public static int buscarMaximo(int[] arr, int inicio, int fin) {
        // Caso base 1: Si solo hay un elemento en la subparte
        if (inicio == fin) {
            return arr[inicio];
        }

        //  Si hay dos elementos, los comparamos directamente
        if (fin == inicio + 1) {
            return Math.max(arr[inicio], arr[fin]);
        }

        // 1. DIVIDIR: Encontramos el punto medio
        int medio = (inicio + fin) / 2;

        // 2. RESOLVER: Buscamos el máximo en la mitad izquierda y derecha
        int maxIzquierda = buscarMaximo(arr, inicio, medio);
        int maxDerecha = buscarMaximo(arr, medio + 1, fin);

        // 3. COMBINAR: Retornamos el mayor entre la izquierda y la derecha
        return Math.max(maxIzquierda, maxDerecha);
    }

    public static void main(String[] args) {
        int[] lecturas = {
            418, 732, 156, 894, 327, 641, 285, 519,
            763, 204, 947, 386, 675, 128, 856, 493
        };

        // Llamamos a la función con el rango completo del arreglo
        int clave2 = buscarMaximo(lecturas, 0, lecturas.length - 1);

        System.out.println("Lectura máxima encontrada: " + clave2);
        System.out.println("CLAVE 2: " + clave2);
    }
}
