package AppSudoku;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private Integer[][] tablero;
    public Tablero(int alto,int ancho){
        this.tablero = new Integer[alto][ancho];
        generarNuevoTablero(alto,ancho);
    }

    public void generarPrimerPoblacion(){
        ArrayList<Integer> listaAux  = new ArrayList<>();
        Random aleatorio = new Random();
        int generado = 0 ;
        while(listaAux.size() < 9){
            generado = aleatorio.nextInt(9) + 1;
            if(listaAux.contains(generado)){
                listaAux.add(0);
            }else {
                listaAux.add(generado);
            }
        }
        for (int j = 0 ; j < tablero[0].length ; j++) {
            tablero[0][j] = listaAux.get(j);
        }
    }

    public void imprimirTablero(){
        System.out.println("============Inicia Impresion de Tablero============");
        for(int j = 0 ; j < tablero[0].length; j++){
            for(int i = 0 ; i <  tablero[0].length ; i++){
                System.out.print(tablero[j][i] + "  ");
            }
            System.out.println();
        }
        System.out.println("===================================================");
    }

    public void generarNuevoTablero(int alto, int ancho){
        for(int j = 0 ; j < alto ; j++){
            for(int i = 0 ; i < alto ; i++){
                this.tablero[j][i] = 0 ;
            }
        }
    }

    public  ArrayList<Integer> obtenerFilatoList(int origen, boolean izquierdaDerecha) {
        ArrayList<Integer> listaConvertida = new ArrayList<>();
        if(izquierdaDerecha){
            for(int j = 0; j < this.tablero[0].length; j++){
                listaConvertida.add(this.tablero[origen][j]);
            }
        }else{
            for(int j = 0; j < this.tablero[0].length; j++){
                listaConvertida.add(this.tablero[j][origen]);
            }
        }
        return listaConvertida;
    }

    public void generarPoblaciones(){
        //son los vectores que se usan para saber que elementos hay por arriba y abajo
        ArrayList<Integer> vectorArribaAbajo = new ArrayList<>();
        ArrayList<Integer> vectorIzquierdaDerecha = new ArrayList<>();
        Random aleatorio = new Random();
        int generado = 0, var_iterator = 0;
        for(int j = 1 ; j < 9 ;j++){
            vectorArribaAbajo = obtenerFilatoList(var_iterator,false);
            while(vectorIzquierdaDerecha.size() < 9){
                generado = aleatorio.nextInt(9) + 1 ;
                if(vectorIzquierdaDerecha.contains(generado) || vectorArribaAbajo.contains(generado)){
                    tablero[j][vectorIzquierdaDerecha.size()] = 0 ;
                    vectorIzquierdaDerecha.add(0);
                }else {
                    tablero[j][vectorIzquierdaDerecha.size()] = generado ;
                    vectorIzquierdaDerecha.add(generado);
                }
                var_iterator++;
                if(var_iterator < 9) {
                    vectorArribaAbajo = obtenerFilatoList(var_iterator,false);
                }
            }
            var_iterator = 0 ;
            vectorIzquierdaDerecha.clear();
            imprimirTablero();
        }

    }

}
