package AppSudoku;

public class sudokuApplication {

    public static void main(String args[]){
        Tablero tablero = new Tablero(9,9);
        tablero.imprimirTablero();
        tablero.generarPrimerPoblacion();
        tablero.imprimirTablero();
        tablero.generarPoblaciones();
        tablero.imprimirPosicionesMatriz();
    }

}
