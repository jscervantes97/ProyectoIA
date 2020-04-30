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

    public static int generarNumeroOuterJoin(ArrayList<Integer> leftJoin, ArrayList<Integer> righttJoin ){
        ArrayList<Integer> innerJoin = new ArrayList<>();
        while(innerJoin.size() < 9){
            innerJoin.add(innerJoin.size()+1);
        }
        innerJoin.removeIf(n -> (leftJoin.contains(n)));
        innerJoin.removeIf(n -> (righttJoin.contains(n)));
        Random aleatorio = new Random();
        return innerJoin.get(aleatorio.nextInt(innerJoin.size()));
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
        System.out.println("tamaño de la lista" + listaAux.size());
        System.out.println("Poblacion generada ordenada "+ listaAux);
        Collections.shuffle(listaAux);
        System.out.println("Poblacion Generada Desordenada " + listaAux);
        for(int j = 0 ; j < tablero[0].length; j++){
            tablero[0][j] = listaAux.get(j);
        }
        imprimirTablero(tablero);
        listaAux = obtenerFilatoList(tablero,0,false);
        Integer var_iterator = 0 ;
        for(int j = 1 ; j < tablero[0].length; j++){
            while(listaAux2.size() < 9){
                generado = aleatorio.nextInt(9)+1;
                generado = aleatorio.nextInt(9)+1;
                System.out.print(generado + " ");
                if(!listaAux2.contains(generado) && !listaAux.contains(generado)){
                    listaAux2.add(generado);
                    tablero[j][var_iterator] = generado;
                    var_iterator++ ;
                    if(var_iterator == 9){
                        break;
                    }
                    listaAux = obtenerFilatoList(tablero,var_iterator,false);
                }
                System.out.println("Lista de momento " + listaAux2) ;
                System.out.println("de arriba hacia abajo" + listaAux);
            }
            var_iterator = 0 ;
            listaAux2.clear();;
        }
        imprimirTablero(tablero);
        System.out.println("Llegue al fin??");
        //System.out.println(listaAux);


    }

    public static void main(String[] args){
        ArrayList<Integer> innerJoin = new ArrayList<>();
        while(innerJoin.size() < 9){
            innerJoin.add(innerJoin.size()+1);
        }
        ArrayList<Integer> outerJoin = new ArrayList<>();
        outerJoin.add(1);
        outerJoin.add(4);
        outerJoin.add(6);
        outerJoin.add(9);
        innerJoin.removeIf(n -> (outerJoin.contains(n)));
        //crearTableroResuelto();
        /*
        Random aleatorio = new Random();
        int generado = 0 ;
        while(generado != 9){
            generado = aleatorio.nextInt(10);
            System.out.println(generado);
        }

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
        */
    }


}
