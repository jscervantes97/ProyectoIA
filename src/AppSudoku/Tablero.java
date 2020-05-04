package AppSudoku;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private Integer[][] tablero;
    private ArrayList<Integer> vectorGeneral ;
    public Tablero(int alto,int ancho){
        this.tablero = new Integer[alto][ancho];
        this.vectorGeneral = new ArrayList<>();
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
            vectorGeneral.add(listaAux.get(j));
        }
    }

    public void imprimirTablero(){
        System.out.println("============Inicia Impresion de Tablero============");
        for(int j = 0 ; j < tablero[0].length; j++){
            for(int i = 0 ; i <  tablero[0].length ; i++){
                System.out.print(tablero[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("===================================================");
    }

    public void imprimirPosicionesMatriz(){
        int var = 0 ;
        for(int j = 0 ; j < tablero[0].length; j++){
            for(int i = 0 ; i <  tablero[0].length ; i++){
                System.out.print(var + " ");
                var++ ;
            }
            System.out.println();
        }
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
        int generado = 0, var_iterator = 0, posicionArray = vectorGeneral.size();
        for(int j = 1 ; j < 9 ;j++){
            vectorArribaAbajo = obtenerFilatoList(var_iterator,false);
            while(vectorIzquierdaDerecha.size() < 9){
                generado = aleatorio.nextInt(9) + 1 ;
                if(vectorIzquierdaDerecha.contains(generado) || vectorArribaAbajo.contains(generado) || estaEn3X3(generado,posicionArray)){
                    tablero[j][vectorIzquierdaDerecha.size()] = 0 ;
                    vectorIzquierdaDerecha.add(0);
                    vectorGeneral.add(0);
                }else {
                    tablero[j][vectorIzquierdaDerecha.size()] = generado ;
                    vectorIzquierdaDerecha.add(generado);
                    vectorGeneral.add(generado);
                }
                var_iterator++;
                posicionArray++;
                if(var_iterator < 9) {
                    vectorArribaAbajo = obtenerFilatoList(var_iterator,false);
                }
            }
            var_iterator = 0 ;
            vectorIzquierdaDerecha.clear();
            imprimirTablero();
        }

    }

    public boolean estaEn3X3(Integer numero, Integer posicion){
        ArrayList<Integer> matrizAVector = new ArrayList<>();
        if((posicion >= 0 && posicion <= 2) || (posicion >= 9 && posicion <= 11) || (posicion >= 18 && posicion <= 20)){
            if(posicion >= 0){
                for(int j = 0 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 9){
                for(int j = 9 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 18){
                for(int j = 18 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 3 && posicion <= 5) || (posicion >= 12 && posicion <= 14) || (posicion >= 21 && posicion <= 23)){
            if(posicion >= 3){
                for(int j = 3 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 12){
                for(int j = 12 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 21){
                for(int j = 21 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 6 && posicion <= 8) || (posicion >= 15 && posicion <= 17) || (posicion >= 24 && posicion <= 26)){
            if(posicion >= 6){
                for(int j = 6 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 15){
                for(int j = 15 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 24){
                for(int j = 24 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 27 && posicion <= 29) || (posicion >= 36 && posicion <= 38) || (posicion >= 45 && posicion <= 47)){
            if(posicion >= 27){
                for(int j = 27 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 36){
                for(int j = 36 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 45){
                for(int j = 45 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 30 && posicion <= 32) || (posicion >= 39 && posicion <= 41) || (posicion >= 48 && posicion <= 50)){
            if(posicion >= 30){
                for(int j = 30 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 39){
                for(int j = 39 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 48){
                for(int j = 48 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 33 && posicion <= 35) || (posicion >= 42 && posicion <= 44) || (posicion >= 51 && posicion <= 53)){
            if(posicion >= 33){
                for(int j = 33 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 42){
                for(int j = 42 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 51){
                for(int j = 51 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 54 && posicion <= 56) || (posicion >= 63 && posicion <= 65) || (posicion >= 72 && posicion <= 74)){
            if(posicion >= 54){
                for(int j = 54 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 63){
                for(int j = 63 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 72){
                for(int j = 72 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 57 && posicion <= 59) || (posicion >= 66 && posicion <= 68) || (posicion >= 75 && posicion <= 77)){
            if(posicion >= 57){
                for(int j = 57 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 66){
                for(int j = 66 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 75){
                for(int j = 75 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        else if((posicion >= 60 && posicion <= 62) || (posicion >= 69 && posicion <= 71) || (posicion >= 78 && posicion <= 80)){
            if(posicion >= 60){
                for(int j = 60 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 69){
                for(int j = 69 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
            if(posicion >= 78){
                for(int j = 78 ; j <= posicion ; j++ ){
                    matrizAVector.add(vectorGeneral.get(j));
                }
            }
        }
        System.out.println(matrizAVector);
        return matrizAVector.contains(numero) ;
    }

}