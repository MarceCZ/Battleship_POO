package Package.Gestion;

import Package.Clases.*;
import java.util.Scanner;

public class Tablero{
    private String[][] tablero;
    private String[][] tablerooculto;
    private Barco[] lista;
    private int cont;
    private int fila;
    private int columna;
    private int aux;
    private int puntos;

    public Tablero() {
        tablero = new String[10][10];
        tablerooculto= new String[10][10];
        lista = new Barco[5];
        cont = 0;
        puntos = 0;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public Barco[] getLista() {
        return lista;
    }

    public void setLista(Barco[] lista) {
        this.lista = lista;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String[][] getTablerooculto() {
        return tablerooculto;
    }

    public void setTablerooculto(String[][] tablerooculto) {
        this.tablerooculto = tablerooculto;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
    
    public void ListarBarcos(Barco ref){
        if(cont<this.lista.length){
            lista[cont] = ref;
            cont++;
        }
        else{
            System.out.println("No se puede almacenar mas barcos, ha superado"
                    + "el numero de barcos posibles\n");
        }
    }
    public String mostrarBarcos(){ 
        String cad = " ";
        for(int i=0;i<cont;i++){
            cad = cad + lista[i].verInfo() + "\n";
        }
        return cad;
    }
    
    public void generarTablero(){
        for(int i=0;i<10;i++){
            for(int k=0;k<10;k++){
                tablero[i][k] = "*";
                this.tablerooculto[i][k] = "*";
            }
        }
    }
    
    public String mostrarTablero(){
        String cad = "    ";
        char FILA[] = {'A','B','C','D','E','F','G','H','I','J'};
        
        for(int k=0;k<10;k++){
            cad = cad + (k+1) + " ";
        }
       
        cad = cad + "\n" + "\n";
            
        for(int i=0;i<10;i++){
            cad = cad + FILA[i] + "   ";
            for(int k=0;k<10;k++){
                cad = cad + tablero[i][k] + " ";
            }
            cad = cad + '\n';
        }
        return cad;
    }
    
    public String TableroOculto(){
        String cad = "    ";
        String nombre;
        int vida;
        char FILA[] = {'A','B','C','D','E','F','G','H','I','J'};
        
        for(int k=0;k<10;k++){
            cad = cad + (k+1) + " ";
        }
        
        cad = cad + '\t' + "Vida de los barcos"+ "   " + "Puntos";
        cad = cad + "\n" + "\n";
            
        for(int i=0;i<10;i++){
            cad = cad + FILA[i] + "   ";
            for(int k=0;k<10;k++){
                cad = cad + tablerooculto[i][k] + " ";
            }
            if(i<cont){
                nombre = lista[i].getNombre();
                vida = lista[i].getVida();
                
                cad = cad + '\t' + "   " + nombre + "\t\t" + vida; 
            }
            cad = cad + '\n';
        }
        return cad;
    }
    
    public void colocarBarcosEnTablero(){
        for(int i=0;i<cont;i++){
            System.out.println("Barco " + lista[i].getNombre());
            System.out.println("==============================================");
            solicitarCoordenadas(lista[i]);
        }
    }
    
    public void solicitarCoordenadas(Barco ref){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las coordenadas para colocar el barco");
        System.out.println("Ingrese un numero para la fila: ");
        this.fila = sc.nextInt();
        System.out.println("Ingrese un numero para la columna: ");
        columna = sc.nextInt();
        
        if(validarCoordenadas(ref)==1){
            if(comparaYColocaTablero(ref)==1){
            }
            else{
                System.out.println("Los barcos NO pueden sobreponerse");
                solicitarCoordenadas(ref);
            }
        }
        else{
            System.out.println("Ha ingresado unas coordenadas NO validas "
                    + "y no se puede colocar en los limites del tablero");
            solicitarCoordenadas(ref);
        }
    }
    
    public int validarCoordenadas(Barco ref){
        int auxiliar=0;
        if((fila>0 && fila<11) && (columna>0 && columna<11)){
            //Definir el tamanho que ocupa en el arreglo bidimensional
            if(ref.getOrientacion().equalsIgnoreCase("horizontal")){
                auxiliar = (columna-1) + ref.getEspacio();
            }
            else if(ref.getOrientacion().equalsIgnoreCase("vertical")){
                auxiliar = (fila-1) + ref.getEspacio();
            }
            //comparar para validar
            if(auxiliar < 11){
                this.aux = auxiliar;
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
    
    public int comparaYColocaTablero(Barco ref){
        int check = 0;
        String car = buscarCaracter(ref);
        if(ref.getOrientacion().equalsIgnoreCase("horizontal")){
            for(int i=columna-1;i<aux;i++){
                if(tablero[fila-1][i].equalsIgnoreCase("*")){
                    //OBSERVACION
                    tablero[fila-1][i] = car;
                    check = 1;
                }
                else{
                    //Arreglar los caracteres introducidos sin validar
                    for(int k=i-1;k>columna-2;k--){
                        tablero[fila-1][k] = "*";
                    }
                    return 0;
                }
            }
        }
        else if(ref.getOrientacion().equalsIgnoreCase("vertical")){
            for(int i=fila-1;i<aux;i++){
                if(tablero[i][columna-1].equalsIgnoreCase("*")){
                    //OBSERVACION
                    tablero[i][columna-1]=car;
                    check = 1;
                }
                else{
                    //Arreglar los caracteres introducidos sin validar
                    for(int k=i-1;k>fila-2;k--){
                        tablero[k][fila-1] = "*";
                    }
                    return 0;
                }
            }
        }
        System.out.println(mostrarTablero());
        return check;
    }
     
    public void marcarYPuntuar(int fila,int columna){
        if(tablero[fila][columna].equalsIgnoreCase("*")){
            tablero[fila][columna] = "O";
            this.tablerooculto[fila][columna]="O";
            System.out.println("VACIO");
        }
        else if(tablero[fila][columna].equalsIgnoreCase("X") || 
                tablero[fila][columna].equalsIgnoreCase("O")){
            System.out.println("Movimiento REPETIDO");
        }
        else{
            System.out.println("Barco TOCADO");
            if(tablero[fila][columna].equalsIgnoreCase("P")){
                disminuirVida("portaviones");
                PuntosAdicional("portaviones");
                puntos += 500;
            }
            else if(tablero[fila][columna].equalsIgnoreCase("A")){
                disminuirVida("acorazado");
                PuntosAdicional("acorazado");
                puntos += 400;
                
            }
            else if(tablero[fila][columna].equalsIgnoreCase("S")){
                disminuirVida("submarino");
                PuntosAdicional("submarino");
                puntos += 300;
            }
            else if(tablero[fila][columna].equalsIgnoreCase("C")){
                disminuirVida("crucero");
                PuntosAdicional("crucero");
                puntos += 300;
            }
            else{
                disminuirVida("destructor");
                puntos += 100;
            }
            tablero[fila][columna] = "X";
            tablerooculto[fila][columna] = "X";
        }
    }
    
    public int finJuego(){
        for(int i=0;i<cont;i++){
            if(lista[i].getVida()!=0){
                return 0;
            }
        }
        return 1;
    }

    public void PuntosAdicional(String nombre) {
        int extra=0;
        if(nombre.equalsIgnoreCase("portaviones")){
            extra = 25;
            
        }
        else if(nombre.equalsIgnoreCase("acorazado")){
            extra = 15;
        }
        else if(nombre.equalsIgnoreCase("submarino")){
            extra = 10;
        }
        else if(nombre.equalsIgnoreCase("crucero")){
            extra = 5;
        }
        puntos += extra;
    }
    
    public void FirstMoveFirstHit() {
        puntos += 500;
    }
    
    public void mostrarTablaPuntosExtra(){
        System.out.println("Puntos extras por golpe: ");
        System.out.println("-------------------------------");
        System.out.println("Portaviones: " + "\t" + 20 + " puntos");
        System.out.println("Acorazado: " + "\t" + 15 + " puntos");
        System.out.println("Submarino: " + "\t" + 10 + " puntos");
        System.out.println("Crucero: " + "\t" + 5 + " puntos\n");
    }
    
    //Funciones
    public String buscarCaracter(Barco ref){
        String cad = "";
        if(ref instanceof Portaviones){
            cad = "P";
        }
        else if(ref instanceof Acorazado){
            cad = "A";
        }
        else if(ref instanceof Submarino){
            cad = "S";
        }
        else if(ref instanceof Crucero){
            cad = "C";
        }
        else if(ref instanceof Destructor){
            cad = "D";
        }
        return cad;
    }
    
    public void disminuirVida(String nombre){
        for(int i=0;i<cont;i++){
            if(lista[i].getNombre().equalsIgnoreCase(nombre)){
                lista[i].Damage();
                if(lista[i].getVida() == 0){
                    System.out.println(lista[i].Mensaje());
                }
            }
        }
    }
    
}
   
