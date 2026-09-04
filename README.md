# Escape Room Algoritmico - Sistema de Seguridad

Este repositorio contiene la solucion al reto de programacion tipo escape room. El objetivo es desactivar el sistema de seguridad de un laboratorio resolviendo 3 desafios utilizando Recursividad, Divide y Venceras y Backtracking en Java.

---

## Como funciona cada desafio?

### 1. Desafion 1 - El codigo fragmentado (Recursividad)
* Que hace?: Toma un numero y suma sus digitos recursivamente hasta reducirlo a un solo digito.
* Caso Base: Si el numero es menor a 10 (n < 10), ya no se puede reducir mas y se regresa tal cual.
* Caso Recursivo: Toma el ultimo digito con % 10 y lo suma llamando a la misma funcion con el resto del numero (n / 10). Si la suma vuelve a dar mas de 9, se repite la reduccion.

### 2. Desafio 2 - El radar de emergencia (Divide y Venceras)
* Que hace?: Busca la lectura maxima dentro de un arreglo de numeros sin usar loops normales ni ordenar el arreglo.
* Dividir: Corta el arreglo a la mitad buscando el indice medio (inicio + fin) / 2.
* Resolver: Busca recursivamente el numero mas alto de la mitad izquierda y de la mitad derecha.
* Combinar: Compara los dos resultados con Math.max() y regresa el mas grande hacia arriba.

### 3. Desafio 3 - La ruta de escape (Backtracking)
* Que hace?: Encuentra la ruta mas corta para salir de un laberinto desde el punto 'S' (inicio) hasta 'E' (salida).
* Como evita ciclos?: Usa una matriz de booleanos visitado[][] para no volver a pisar casillas por las que ya paso.
* Backtracking: Si llega a un muro '#' o a un camino cerrado, limpia la casilla (visitado[f][c] = false), se regresa un paso atras y prueba por otra direccion.
* Poda (Optimizacion): Si el camino actual que esta explorando ya lleva mas pasos que la mejor ruta que habia encontrado antes, se detiene de inmediato esa busqueda para no gastar memoria a lo menso.

---

## Estructura del Proyecto

* Desafio1.java - Solucion del primer reto.
* Desafio2.java - Solucion del segundo reto.
* Desafio3.java - Algoritmo del laberinto y busqueda de la ruta mas corta.
* Main.java - Menu en consola para probar cualquiera de los programas.

---

## Como correrlo?

1. Abre la terminal en la carpeta donde estan los archivos.
2. Compila todo:
   javac *.java
3. Corre el programa principal:
   java Main
