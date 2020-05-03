import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sudoku {
    public Sudoku(){

    }

    public static int[][] generarNuevoTablero(int alto, int ancho){
        int[][] matriz = new int[alto][ancho];
        for(int j = 0 ; j < alto ; j++){
            for(int i = 0 ; i < alto ; i++){
                matriz[j][i] = 0 ;
            }
        }
        return matriz;
    }

    public static void imprimirTablero(int[][] tablero){
        for(int j = 0 ; j < tablero[0].length; j++){
            for(int i = 0 ; i <  tablero[0].length ; i++){
                System.out.print(tablero[j][i] + "  ");
            }
            System.out.println();
        }
    }

    //este metodo sirve para convertir una fila a una lista
    //
    public static ArrayList<Integer> obtenerFilatoList(int[][] matriz,int origen, boolean izquierdaDerecha) {
        ArrayList<Integer> listaConvertida = new ArrayList<>();
        if(izquierdaDerecha){
            for(int j = 0; j < matriz[0].length; j++){
                listaConvertida.add(matriz[origen][j]);
            }
        }else{
            for(int j = 0; j < matriz[0].length; j++){
                listaConvertida.add(matriz[j][origen]);
            }
        }
        return listaConvertida;
    }

    public static int generarNumeroOuterJoin(ArrayList<Integer> leftJoin, ArrayList<Integer> righttJoin, Integer iterator ){
        ArrayList<Integer> innerJoin = new ArrayList<>();
        while(innerJoin.size() < 9){
            innerJoin.add(innerJoin.size()+1);
        }
        innerJoin.removeIf(n -> (leftJoin.contains(n)));
        innerJoin.removeIf(n -> (righttJoin.contains(n)));
        Random aleatorio = new Random();
        System.out.println("Listas en la iteracion : " + iterator);
        System.out.println(leftJoin );
        System.out.println(righttJoin);
        System.out.println(innerJoin);
        int numeroGenerado = innerJoin.get(aleatorio.nextInt(innerJoin.size()));
        return numeroGenerado;
    }

    public static void crearTableroResuelto(){
        int[][] tablero = generarNuevoTablero(9,9);
        imprimirTablero(tablero);
        ArrayList<Integer> listaAux  = new ArrayList<>();
        ArrayList<Integer> listaAux2  = new ArrayList<>();
        Random aleatorio = new Random();
        int generado = 0 ;
        while(listaAux.size() < 9){
            listaAux.add(listaAux.size()+1);
        }
        imprimirTablero(tablero);
        listaAux = obtenerFilatoList(tablero,0,false);
        Integer var_iterator = 0 ;
        for(int j = 0 ; j < tablero[0].length; j++){
            while(listaAux2.size() < 9){
                generado = generarNumeroOuterJoin(listaAux,listaAux2,var_iterator);
                if(!listaAux2.contains(generado) && !listaAux.contains(generado)){
                    listaAux2.add(generado);
                    tablero[j][var_iterator] = generado;
                    var_iterator++ ;
                    if(var_iterator != 9) {
                        listaAux = obtenerFilatoList(tablero, var_iterator, false);
                    }else {
                        var_iterator = 0 ;
                    }
                }
                //System.out.println("Lista de momento " + listaAux2) ;
                //System.out.println("de arriba hacia abajo" + listaAux);
            }
            System.out.println("Vuelta numero: " + (j+1));
            imprimirTablero(tablero);
            var_iterator = 0 ;
            listaAux2.clear();
            listaAux.clear();
        }
        imprimirTablero(tablero);
        System.out.println("Llegue al fin??");
        //System.out.println(listaAux);


    }

    public static void main(String[] args){

        crearTableroResuelto();

        int[][] tablero = new int[9][9];
        ArrayList<Integer> listaAux  = new ArrayList<>();
        Random aleatorio = new Random();
        int generado = 0 ;
        while(listaAux.size() < 9){
            generado = aleatorio.nextInt(9);
            System.out.println(generado);
            if(listaAux.contains(generado)){
                listaAux.add(0);
            }else {
                listaAux.add(generado);
            }
        }
        System.out.println("tamaño de la lista" + listaAux.size());
        System.out.println("Poblacion Generada " + listaAux);

    }


}
