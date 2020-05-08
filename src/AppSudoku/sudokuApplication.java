package AppSudoku;

import java.util.Scanner;

public class sudokuApplication {

    public static void main(String args[]){
        Scanner lee = new Scanner(System.in);
        System.out.println("Ingresa el numero de poblaciones");
        Integer poblaciones = lee.nextInt() ;
        System.out.println("Ingresa el porcentaje de cruza");
        Double porcentajeCruza = lee.nextDouble();
        System.out.println("Ingresa el porcentaje de Mutacion");
        Double porcentajeMutacion = lee.nextDouble() ;
        Tablero tablero = new Tablero(9,9,porcentajeCruza,porcentajeMutacion);

        tablero.generarPrimerPoblacion();
        //tablero.generarPoblacionesResueltos();
        tablero.generarPoblaciones();
        tablero.calcularAmplitudMatriz();
        tablero.imprimirTableroFull();
        tablero.realizarTorneo();
        tablero.imprimirTablero();
        for(int j = 0 ; j < poblaciones -1 ; j++){
            tablero.generarPoblaciones();
            tablero.calcularAmplitudMatriz();
            tablero.realizarTorneo();
            tablero.llenarNuevaMatriz();
            tablero.cruzar7u7();
        }
        tablero.imprimirTablero();
        tablero.calcularResultados();

    }

}
