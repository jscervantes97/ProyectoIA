package AppSudoku;

public class sudokuApplication {

    public static void main(String args[]){
        Tablero tablero = new Tablero(9,9,0.2);
        tablero.imprimirTablero();
        tablero.generarPrimerPoblacion();
        tablero.imprimirTablero();
        tablero.generarPoblaciones();
        tablero.calcularAmplitudMatriz();
        tablero.realizarTorneo();
        tablero.imprimirTableroFull();
        tablero.llenarNuevaMatriz();
        tablero.imprimirTablero();
        tablero.cruzar7u7();
    }

}
