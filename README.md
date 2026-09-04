# Escape Room Algoritmico - Sistema de Seguridad

Este repositorio contiene la solucion al reto de programacion tipo escape room. El objetivo es desactivar el sistema de seguridad de un laboratorio resolviendo 3 desafios utilizando Recursividad, Divide y Venceras y Backtracking en Java.

---

## 1. Descripcion del Problema y Desafios

El sistema de seguridad del laboratorio requiere resolver tres modulos para permitir el escape:
1. Desafio 1: Reduccion de bloques numericos a un solo digito mediante Recursividad.
2. Desafio 2: Busqueda de la lectura de radar maxima mediante Divide y Venceras.
3. Desafio 3: Encontrar la ruta mas corta de escape en un laberinto usando Backtracking.

---

## 2. Como Funciona Cada Desafio

### Desafio 1 - El codigo fragmentado (Recursividad)
* Tecnica: Recursividad pura.
* Funcionamiento: Se recibe un numero entero y se suman sus digitos de forma recursiva extrayendo el ultimo digito con modulo 10 (`n % 10`) y reduciendo el numero con division entre 10 (`n / 10`). Si la suma resultante tiene mas de un digito, el proceso se repite recursivamente hasta obtener una cifra individual.
* Obtencion de la clave: Se aplican los bloques 84729 (da 3), 56318 (da 5) y 92746 (da 1), obteniendo la CLAVE 1 = 351.

### Desafio 2 - El radar de emergencia (Divide y Venceras)
* Tecnica: Divide y Venceras.
* Funcionamiento: Se busca el valor maximo en un arreglo sin usar ciclos tradicionales ni metodos de ordenamiento.
  * Dividir: El arreglo se parte a la mitad con el indice medio `(inicio + fin) / 2`.
  * Resolver: Se obtiene el maximo de la subparte izquierda y derecha.
  * Combinar: Se comparan ambos lados y se retorna el mayor con `Math.max()`.
* Obtencion de la clave: Al evaluar las lecturas, la cifra mayor encontrada es 947, obteniendo la CLAVE 2 = 947.

* Contrasena final de acceso: 351-947

### Desafio 3 - La ruta de escape (Backtracking)
* Tecnica: Backtracking con Poda de Busqueda.
* Funcionamiento: Explora casillas en 4 direcciones (arriba, abajo, izquierda, derecha) buscando salir desde 'S' hasta 'E'.
* Toma de decisiones importantes: Para evitar ciclos se usa una matriz de booleanos `visitado[][]`. Para garantizar que sea la ruta mas corta, la busqueda no se detiene en la primera salida encontrada, sino que sigue evaluando ramas y guarda la que requiera menos movimientos. Se aplico una poda (`if (pasosActuales >= minMovimientos) return;`) para cancelar inmediatamente rutas que igualen o superen la mejor distancia ya encontrada.

---

## 3. Como Ejecutar el Programa

1. Abrir la terminal en la carpeta raiz del proyecto.
2. Compilar los archivos java:
   javac src/*.java
3. Ejecutar el menu principal:
   java -cp src Main

---

## 4. Explicacion Tecnica

¿Cual es el caso base del desafio 1?
Ocurre cuando el numero es menor a 10 (`n < 10`). Al ser de un solo digito, se devuelve el numero directamente sin realizar mas llamadas recursivas.

¿Cual es el caso recursivo?
Ocurre cuando `n >= 10`. Se extrae el ultimo digito con `(n % 10)` y se suma a la llamada recursiva pasandole el resto del numero `(n / 10)`. Si el resultado de la suma completa vuelve a ser mayor o igual a 10, la funcion de reduccion se vuelve a invocar a si misma.

¿Como se aplica divide y vencerás en el desafio 2?
Se aplica dividiendo el arreglo por la mitad recursivamente hasta obtener subproblemas simples de resolver.

¿Como se divide el problema?
Se calcula el indice medio `(inicio + fin) / 2` para partir el arreglo en una mitad izquierda y una mitad derecha hasta llegar a subarreglos de tamaño 1 o 2.

¿Como se combinan los resultados?
Al regresar de las llamadas recursivas, se comparan los valores maximos obtenidos de la parte izquierda y derecha utilizando `Math.max()`, devolviendo el valor mayor al nivel anterior.

¿Como funciona el backtracking del desafio 3?
Funciona explorando las 4 direcciones posibles (arriba, abajo, izquierda, derecha). Si el algoritmo llega a un muro `#` o a un camino sin salida, desmarca la casilla actual haciendo `visitado[f][c] = false` y retrocede un paso en la pila de llamadas para probar otra alternativa.

¿Como evitas ciclos?
Se utiliza una matriz booleana `visitado[][]` del mismo tamaño que el laberinto. Cada casilla pisada se marca en `true`. Si el algoritmo intenta moverse a una casilla que ya esta en `true`, la instruccion se ignora para evitar dar vueltas en circulo.

¿Como determinas cual ruta es la mas corta?
El algoritmo no se detiene al encontrar la primera salida. Cada vez que llega a 'E', compara la cantidad de pasos de la ruta actual contra una variable global `minMovimientos`. Si la ruta actual tomo menos pasos, actualiza el valor y guarda la nueva mejor ruta.

¿Que optimizacion aplicaste y por que?
Aplique una poda de busqueda (Branch and Bound) con la instruccion `if (pasosActuales >= minMovimientos) return;`. Se aplico porque si un camino en exploracion ya lleva la misma cantidad o mas pasos que la mejor ruta encontrada previamente, es imposible que sea mas corta, por lo que se aborta de inmediato esa rama ahorrando tiempo y memoria.

---

## 5. Pruebas y Evidencia

1. Caso 1 (Ruta directa): Muestra el laberinto resolviendo la ruta con movimientos normales.
2. Caso 2 (Callejon sin salida): El algoritmo topa con pared `#`, hace backtracking desmarcando casillas y encuentra la salida por otra via.
3. Caso 3 (Varias rutas): Se evaluan multiples caminos hacia la salida y el programa selecciona el de menor pasos.
4. Caso 4 (Primera ruta no es la mas corta): El algoritmo encuentra una primera salida pero continua hasta registrar la mas corta.
5. Caso 5 (Sin solucion): Se rodea la salida 'E' con muros `#` y el programa reporta correctamente que no existe una ruta valida.

---

## 6. Reflexion Final

¿Que diferencia existe entre una solucion recursiva y una solucion iterativa?
La solucion iterativa utiliza ciclos explicitos (`for`, `while`) para repetir un bloque de codigo. La solucion recursiva se llama a si misma dividiendo el problema en subproblemas mas pequeños y utiliza la pila de llamadas del sistema (call stack) en lugar de bucles.

¿Por que divide y vencerás puede facilitar la resolucion de ciertos problemas?
Porque reduce la complejidad del problema dividiendolo en partes independientes mas pequeñas. Resolver varias partes chicas por separado y combinar sus resultados suele ser mas sencillo que intentar procesar todo el problema de golpe.

¿Por que encontrar una solucion con backtracking no significa necesariamente que sea la mejor solucion?
Porque backtracking se detiene en la primera ruta valida que encuentra si no se le indica lo contrario. Esa primera ruta puede ser muy larga o dar muchos rodeos; para asegurar que sea la mejor, se necesita seguir explorando las demas ramas o usar una variable para comparar longitudes.

¿Que problema podria presentarse si el algoritmo no controla las posiciones ya visitadas?
El algoritmo entraria en un bucle infinito moviendose ida y vuelta entre las mismas casillas. Esto provocaria que la memoria de la computadora se llene rapidamente y el programa truene con un error de desbordamiento de pila (`StackOverflowError`).

¿Que aprendiste al tener que encontrar la ruta mas corta en lugar de simplemente encontrar una ruta?
Aprendi que encontrar cualquier solucion solo requiere llegar al objetivo, pero encontrar la solucion optima exige comparar todas las alternativas posibles y aplicar tecnicas como la poda para evitar exploraciones innecesarias que alenten el programa.
