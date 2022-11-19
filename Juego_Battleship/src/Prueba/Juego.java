package Prueba;

import Package.Clases.*;
import Package.Gestion.Tablero;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        //Crear objetos
        Portaviones ob1 = new Portaviones("horizontal");
        ob1.AsignarNombre();
        ob1.AsignarEspacio();
        ob1.AsignarVida();
        ob1.GenerarCodigo();
        
        Acorazado ob2 = new Acorazado("vertical");
        ob2.AsignarNombre();
        ob2.AsignarEspacio();
        ob2.AsignarVida();
        ob2.GenerarCodigo();
        
        Submarino ob3 = new Submarino("horizontal");
        ob3.AsignarNombre();
        ob3.AsignarEspacio();
        ob3.AsignarVida();
        ob3.GenerarCodigo();
        
        Crucero ob4 = new Crucero("vertical");
        ob4.AsignarNombre();
        ob4.AsignarEspacio();
        ob4.AsignarVida();
        ob4.GenerarCodigo();
        
        Destructor ob5 = new Destructor("horizontal");
        ob5.AsignarNombre();
        ob5.AsignarEspacio();
        ob5.AsignarVida();
        ob5.GenerarCodigo();
        
        Tablero obT = new Tablero();
        obT.generarTablero();
        obT.ListarBarcos(ob1);
        obT.ListarBarcos(ob2);
        obT.ListarBarcos(ob3);
        obT.ListarBarcos(ob4);
        obT.ListarBarcos(ob5);
        
        //Mostrar sin marcadores de barcos y puntos de vida
        System.out.println(obT.mostrarTablero()); 
        obT.colocarBarcosEnTablero();
        //Mostrar con marcadores de barcos y puntos de vida
        System.out.println(obT.mostrarTablero());
        System.out.println("Los barcos han sido colocados, ¡comienza el juego!\n");
        obT.mostrarTablaPuntosExtra();
        System.out.println(obT.TableroOculto());
        
        
        //El juego comienza a interactuar
        int fila=0;
        int columna=0;
        int flag = 0;
        boolean salida = false;
        
        for(i=0;i<100;i++){ //En el tablero se permite 100 movimineto
            while(flag!=1){
                System.out.println("Ingrese un numero para la fila: ");
                fila = sc.nextInt();
                System.out.println("Ingrese un numero para la columna: ");
                columna = sc.nextInt();
                if((fila>0 && fila<11) && (columna>0 && columna<11)){
                    flag = 1;
                }
                else if(fila ==0 && columna ==0){
                    salida = true;
                    break;
                }
                else{
                    System.out.println("Ingreso coordenadas fuera de rango o "
                            + "NO validas\n");
                }
            }
            if(salida){ //El jugador abandona la partida
                System.out.println("          Juego ABANDONADO");
                System.out.println("");
                System.out.println("Tablero con la posicion de los barcos");
                System.out.println("==========================================");
                System.out.println(obT.mostrarTablero());
                System.out.println("PUNTAJE ACUMULADO: " + obT.getPuntos());
                break;
            }
            flag = 0;
            if(i==0){ //Si el primer movimiento da con la casilla de un barco, se le otorga una bonificacion
                obT.FirstMoveFirstHit();
            }
            obT.marcarYPuntuar(fila-1,columna-1);
            System.out.println(obT.TableroOculto());
            if(obT.finJuego() == 1){ //Todos los barcos estan hundidos
                System.out.println("FIN DEL JUEGO");
                System.out.println("PUNTAJE ACUMULADO: " + obT.getPuntos());
                break;
            }
        }
    }
}
