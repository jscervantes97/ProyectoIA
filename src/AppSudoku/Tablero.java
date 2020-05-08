package AppSudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tablero {
    private Integer[][] tablero;
    private Integer[][] nuevaGeneracion ;
    private Integer[][] original ;
    private ArrayList<Integer> vectorGeneral ;
    private ArrayList<Integer> amplitudes ;
    private ArrayList<Integer> ganadores ;
    private Double porcentajeCruza ;
    private Double porcentajeMutacion;
    public Tablero(int alto,int ancho,Double porcentajeCruza,Double porcentajeMutacion){
        this.tablero = new Integer[alto][ancho];
        original = tablero ;
        this.vectorGeneral = new ArrayList<>();
        this.amplitudes = new ArrayList<>();
        this.ganadores = new ArrayList<>();
        generarNuevoTablero(alto,ancho);
        this.porcentajeMutacion = porcentajeMutacion ;
        this.porcentajeCruza = porcentajeCruza ; 
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
        original = tablero ;
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

    public Integer[] obtenerFiloToArray(int origen,boolean izquierdaDerecha){
        Integer[] arreglo = new Integer[9];
        if(izquierdaDerecha){
            for(int j = 0; j < this.tablero[0].length; j++){
                arreglo[j] = this.tablero[origen][j];
            }
        }else{
            for(int j = 0; j < this.tablero[0].length; j++){
                arreglo[j] = this.tablero[j][origen];
            }
        }
        return arreglo ;
    }

    public void generarPoblaciones(){
        //son los vectores que se usan para saber que elementos hay por arriba y abajo
        ArrayList<Integer> vectorArribaAbajo = new ArrayList<>();
        ArrayList<Integer> vectorIzquierdaDerecha = new ArrayList<>();
        Random aleatorio = new Random();
        int generado = 0, var_iterator = 0, posicionArray = vectorGeneral.size()-1;
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
            //imprimirTablero();
        }
        nuevaGeneracion = tablero ;
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
        return matrizAVector.contains(numero) ;
    }

    public Integer cerosen3X3(Integer numero, Integer posicion){
        //ArrayList<Integer> matrizAVector = new ArrayList<>();
        Integer aptitud = 0 ;
        if((posicion >= 0 && posicion <= 2) || (posicion >= 9 && posicion <= 11) || (posicion >= 18 && posicion <= 20)){
            if(posicion >= 0){
                for(int j = 0 ; j <= 2; j++){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 9){
                for(int j = 9 ; j <= 11 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 18){
                for(int j = 18 ; j <= 20 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 3 && posicion <= 5) || (posicion >= 12 && posicion <= 14) || (posicion >= 21 && posicion <= 23)){
            if(posicion >= 3){
                for(int j = 3 ; j <= 5 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 12){
                for(int j = 12 ; j <= 14 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 21){
                for(int j = 21 ; j <= 23 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 6 && posicion <= 8) || (posicion >= 15 && posicion <= 17) || (posicion >= 24 && posicion <= 26)){
            if(posicion >= 6){
                for(int j = 6 ; j <= 8 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 15){
                for(int j = 15 ; j <= 17 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 24){
                for(int j = 24 ; j <= 26 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 27 && posicion <= 29) || (posicion >= 36 && posicion <= 38) || (posicion >= 45 && posicion <= 47)){
            if(posicion >= 27){
                for(int j = 27 ; j <= 29 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 36){
                for(int j = 36 ; j <= 38 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 45){
                for(int j = 45 ; j <= 47 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 30 && posicion <= 32) || (posicion >= 39 && posicion <= 41) || (posicion >= 48 && posicion <= 50)){
            if(posicion >= 30){
                for(int j = 30 ; j <= 32 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 39){
                for(int j = 39 ; j <= 41 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 48){
                for(int j = 48 ; j <= 50 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 33 && posicion <= 35) || (posicion >= 42 && posicion <= 44) || (posicion >= 51 && posicion <= 53)){
            if(posicion >= 33){
                for(int j = 33 ; j <= 35 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 42){
                for(int j = 44 ; j <= posicion ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 51){
                for(int j = 51 ; j <= 53 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 54 && posicion <= 56) || (posicion >= 63 && posicion <= 65) || (posicion >= 72 && posicion <= 74)){
            if(posicion >= 54){
                for(int j = 54 ; j <= 56 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 63){
                for(int j = 63 ; j <= 65 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 72){
                for(int j = 72 ; j <= 74 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 57 && posicion <= 59) || (posicion >= 66 && posicion <= 68) || (posicion >= 75 && posicion <= 77)){
            if(posicion >= 57){
                for(int j = 57 ; j <= 59 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 66){
                for(int j = 66 ; j <= 68 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 75){
                for(int j = 75 ; j <= 77 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        else if((posicion >= 60 && posicion <= 62) || (posicion >= 69 && posicion <= 71) || (posicion >= 78 && posicion <= 80)){
            if(posicion >= 60){
                for(int j = 60 ; j <= 62 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 69){
                for(int j = 69 ; j <= 71 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
            if(posicion >= 78){
                for(int j = 78 ; j <= 80 ; j++ ){
                    if(vectorGeneral.get(j) == 0){
                        aptitud++;
                    }
                }
            }
        }
        return aptitud;
    }

    public void calcularAmplitudMatriz(){
        amplitudes.clear();
        Integer numeroAmplitud = 0  ;
        Integer var_iterator = 0 ;
        ArrayList<Integer> listaUltimaPosiciones = new ArrayList<>();
        //contiene las posiciones de los elementos matriciales que representan el ultimo subcuadrito de abajo de una
        //submatriz 3 * 3
        listaUltimaPosiciones.add(20);
        listaUltimaPosiciones.add(23);
        listaUltimaPosiciones.add(26);
        listaUltimaPosiciones.add(47);
        listaUltimaPosiciones.add(50);
        listaUltimaPosiciones.add(53);
        listaUltimaPosiciones.add(74);
        listaUltimaPosiciones.add(77);
        listaUltimaPosiciones.add(80);
        for(int j = 0 ; j < tablero[0].length;  j++){
            for(int i = 0 ; i < tablero[0].length;  i++){
                if(tablero[j][i] == 0){
                    numeroAmplitud ++ ;
                }
            }
            numeroAmplitud += cerosen3X3(j,listaUltimaPosiciones.get(j));
            amplitudes.add(numeroAmplitud);
            numeroAmplitud = 0 ;
        }
    }

    public Integer generarGanador(int posicion){
        int numero1 = amplitudes.get(posicion);
        int numero2 = 0 ;
        int posicion2 = 0 ;
        Integer ganador = 0 ;
        if(posicion == 8){
            numero2 = amplitudes.get(posicion-1);
            posicion2 = posicion - 1;
        }
        else{
            numero2 = amplitudes.get(posicion+1);
            posicion2 = posicion + 1;
        }
        if(numero1 > numero2){
            ganador = posicion ;
        }else {
            ganador = posicion2 ;
        }
        return ganador ;
    }

    public void realizarTorneo(){
        ganadores.clear();
        for(int j = 0 ; j < 9 ; j++){
            ganadores.add(generarGanador(j));
        }
    }

    public void llenarNuevaMatriz(){
        ArrayList<Integer> izquierdaDerecha = new ArrayList<>();
        for(int j = 0 ; j < ganadores.size(); j++){
            izquierdaDerecha = obtenerFilatoList(ganadores.get(j),true);
            for(int k = 0; k < izquierdaDerecha.size(); k++){
                nuevaGeneracion[j][k] = izquierdaDerecha.get(k);
            }
        }
        tablero = nuevaGeneracion ;
    }

    public void cruzar7u7(){
        ArrayList<Integer> listaReproductores = new ArrayList<>();
        ArrayList<Integer[]> listaDeArreglos = new ArrayList<>();
        double porcentaje = 0.0;
        Random rd = new Random();
        for(int i = 0 ; i < tablero[0].length; i++){
            porcentaje = rd.nextDouble();
            if(porcentaje > porcentajeCruza){
                listaReproductores.add(i);
            }
        }
        if(listaReproductores.size()%2!=0)
        {
            listaReproductores.remove(listaReproductores.size()-1);
        }
        //System.out.println(listaReproductores);
        for(int j = 0 ; j < listaReproductores.size(); j=j+2){
            Integer[] padre1 = obtenerFiloToArray(j,true);
            Integer[] padre2 = obtenerFiloToArray(j+1,true);
            Integer[] hijo1 = new Integer[9];
            Integer[] hijo2 = new Integer[9];
            Integer[] aux1 = new Integer[9];
            Integer[] aux2 = new Integer[9];
            Integer punto = rd.nextInt(6) + 1 ;
            for(int i = 0; i < 9; i++) {
                aux1[i] = padre1[i];
                aux2[i] = padre2[i];

                if (i <= punto) {
                    aux1[i] = padre2[i];
                    aux2[i] = padre1[i];
                }
            }
            for(int i = 0; i <9; i++) {
                hijo1[i] = aux1[i];
                hijo2[i] = aux2[i];
            }
            listaDeArreglos.add(hijo1);
            listaDeArreglos.add(hijo2);
        }
        /*
        System.out.println("----MATRIZ SIN MUTAR-------");
        for(Integer[] iterator:listaDeArreglos){
            for(int j = 0 ; j < iterator.length; j++){
                System.out.print(iterator[j] + " ");
            }
            System.out.println();
        }*/
        int var_iterator = 0 ;
        ArrayList<Integer> izquierdaDerecha = new ArrayList<>();
        ArrayList<Integer> arribaAbajo = new ArrayList<>();
        Double psg = 0.0 ;
        for(Integer[] iterator:listaDeArreglos){
            psg = rd.nextDouble();
            if(psg > porcentajeMutacion){
                Integer numeroGenerado = rd.nextInt(8) + 1 ;
                Integer pos = rd.nextInt(9);
                izquierdaDerecha = obtenerFilatoList(listaReproductores.get(var_iterator),true);
                arribaAbajo = obtenerFilatoList(pos,false);
                Integer posicionMatricial = obtenerPosicionMatricial(var_iterator,pos);
                if(izquierdaDerecha.contains(numeroGenerado) || arribaAbajo.contains(numeroGenerado) || estaEn3X3(numeroGenerado,posicionMatricial)){
                    iterator[pos] = 0  ;
                }else {
                    iterator[pos] = numeroGenerado ;
                }
            }
            var_iterator++;
        }
        /*
        System.out.println("----MATRIZ MUTADA-------");
        for(Integer[] iterator:listaDeArreglos){
            for(int j = 0 ; j < iterator.length; j++){
                System.out.print(iterator[j] + " ");
            }
            System.out.println();
        }

        System.out.println("----Matriz Anterior------");
        imprimirTablero();*/
        // pasando datos de la matriz antiwa a la nueva
        var_iterator = 0 ;
        for(Integer[] iterator:listaDeArreglos){
            for(int j = 0 ; j < iterator.length; j++){
                tablero[listaReproductores.get(var_iterator)][j] = iterator[j];
            }
            var_iterator++;
        }
        /*
        System.out.println("----Matriz Mutada Full HD------");
        imprimirTablero();

         */
    }

    public Integer obtenerPosicionMatricial(Integer x, Integer y){
        Integer posicion= 0 ;
        for(int j = 0 ; j < tablero[0].length ; j++){
            for(int i = 0 ; i < tablero[0].length ; i++){
                posicion++;
                if(x == j && y == i){
                    break;
                }
            }
        }
        return posicion ;

    }

    public void imprimeSudokuOriginal(){
        System.out.println("============Inicia Impresion de Tablero Original============");
        for(int j = 0 ; j < original[0].length; j++){
            for(int i = 0 ; i <  original[0].length ; i++){
                System.out.print(original[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("===================================================");
    }


    public void imprimirTableroFull(){
        System.out.println("============Inicia Impresion de Tablero============");
        for(int j = 0 ; j < tablero[0].length; j++){
            for(int i = 0 ; i <  tablero[0].length ; i++){
                System.out.print(tablero[j][i] + " ");
            }
            System.out.print("Aptitud " + amplitudes.get(j) + "  ");
            //System.out.print("Ganador " + ganadores.get(j) + " ");
            System.out.println();
        }
        System.out.println("===================================================");
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


    public void generarPoblacionesResueltos(){
        //son los vectores que se usan para saber que elementos hay por arriba y abajo
        ArrayList<Integer> vectorArribaAbajo = new ArrayList<>();
        ArrayList<Integer> vectorIzquierdaDerecha = new ArrayList<>();
        Random aleatorio = new Random();
        int generado = 0, var_iterator = 0, posicionArray = vectorGeneral.size()-1;
        for(int j = 1 ; j < 9 ;j++){
            vectorArribaAbajo = obtenerFilatoList(var_iterator,false);
            while(vectorIzquierdaDerecha.size() < 9){
                generado = generarNumeroOuterJoin(vectorArribaAbajo,vectorIzquierdaDerecha,var_iterator);
                if(!vectorIzquierdaDerecha.contains(generado) && !vectorArribaAbajo.contains(generado) && !estaEn3X3(generado,posicionArray)){
                    tablero[j][vectorIzquierdaDerecha.size()] = generado ;
                    vectorIzquierdaDerecha.add(generado);
                    vectorGeneral.add(generado);
                    var_iterator++;
                    posicionArray++;
                    if(var_iterator < 9) {
                        vectorArribaAbajo = obtenerFilatoList(var_iterator,false);
                    }
                }
            }
            var_iterator = 0 ;
            vectorIzquierdaDerecha.clear();
            imprimirTablero();
        }
        nuevaGeneracion = tablero ;
    }


    public Integer[][] getTablero(){
        return this.tablero;
    }

    public Integer[][] getNuevaGeneracion(){
        return this.nuevaGeneracion;
    }

    public Integer[][] getOriginal(){
        return this.original ;
    }
}
