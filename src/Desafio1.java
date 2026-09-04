public class Desafio1 {

    // 1. Función para sumar los dígitos de un número
    public static int sumarDigitos(int n) {
        //  si solo queda un dígito
        if (n < 10) {
            return n;
        }
        // último dígito + suma del resto del número
        return (n % 10) + sumarDigitos(n / 10);
    }

    // 2. Función para reducir a un solo dígito
    public static int reducirAUnDigito(int n) {
        //  ya es de un solo dígito
        if (n < 10) {
            return n;
        }
        // vuelvo a llamar a la función con la suma de los dígitos
        int suma = sumarDigitos(n);
        return reducirAUnDigito(suma);
    }

    public static void main(String[] args) {
        int b1 = 84729;
        int b2 = 56318;
        int b3 = 92746;

        int d1 = reducirAUnDigito(b1);
        int d2 = reducirAUnDigito(b2);
        int d3 = reducirAUnDigito(b3);

        System.out.println("Bloque 1: " + d1);
        System.out.println("Bloque 2: " + d2);
        System.out.println("Bloque 3: " + d3);
        System.out.println("CLAVE 1: " + d1 + d2 + d3);
    }
}
