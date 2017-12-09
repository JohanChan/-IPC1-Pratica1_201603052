package juegosnake;

import java.util.Random;
import java.util.Scanner;


public class JuegoSnake {
       public static Scanner sc = new Scanner(System.in);
       public static String [][] tablero;
       public static String[] nombre_jugador;
       public static String[] snake;
       public static int Posx=1;
       public static int Posy=1;
       public static int contador=0;
       public static int punteo=10;
       public static String nombre="",fecha_nacimiento="";
       public static void main(String[] args) {
       menu();
       

    }
    
    /*
                CREACION DE MENU 
    */
    public static void menu(){
        int seleccion=0;
        while(seleccion!=4){
                    System.out.println(" ");
                    System.out.println("\033[34m***********************");
                    System.out.println("\033[34m****** Bienvenido *****");
                    System.out.println("\033[34m***********************");
                    System.out.println("");
                    System.out.println("\033[32m1. Iniciar Juego");
                    System.out.println("\033[32m2. Regresar al juego");
                    System.out.println("\033[32m3. Historial");
                    System.out.println("\033[32m4. Sailr");
            try{
                System.out.println(" ");
                System.out.println("\033[34mIngrese una opcion: ");
                seleccion = sc.nextInt();
            switch(seleccion){
                case 1: 
                    System.out.println("Has iniciado el juego");
                    datoJugador();
                    teclasJuego();
                    
                    
                    break;
                case 2: 
                    saltoLinea();
                    System.out.println("Sigamos jugando");
                    break;
                case 3: 
                    saltoLinea();
                    System.out.println("Historial");
                    break;
                case 4: 
                        System.out.println("\033[31m***************************");
                        System.out.println("\033[31m******** Adios :'( ********");
                        System.out.println("\033[31m***************************");
                        System.exit(0);
                    break;
                default:System.out.println("Numeros entre 1 y 4.");
                    break;
            }
            }catch(Exception e){
                System.out.println("Solo se aceptan numeros");
                sc.next();
                
            }
            
        
        
        }

    }
/*------------------------------------------------------------------------  
                       METODO CREA EL TABLERO DE 37x70                                                                    
    */
      
    public static void crea_tablero(){
        //SE VACIA LA MATRIZ
        tablero = new String[35][70];
        for(int fila=0;fila<35;fila++){
            for(int columna=0;columna<70;columna++){
                tablero[fila][columna] = " ";
                
            }
              
        }
        
        /* ------------------------------------------------------------------------
                SE COLOCAN LOS BORDES
                */
    for(int fila=0; fila<35;fila++){
            for(int columna=0;columna<70;columna++){
                tablero[0][columna]="\033[31m#";
                tablero[34][columna]="\033[31m#";
        }

    }
    
    for(int fila=0;fila<35;fila++){
        for(int columna=0;columna<70;columna++){
                tablero[fila][0]="\033[31m#";
                tablero[fila][69]="\033[31m#";
        }
    }
    wall();
    jugar();
    comida();
      /*
    ---------------------------------------------------------------------        
            SE IMPRIME LA MATRIZ EN PANTALLA
    */
     

    
 }
    
    public static void wall(){
    /*
                    PAREDES ALEATORIAS
    
    */
    for(int pared=0;pared<1000;pared++){
        Random wall = new Random();
        int posx = wall.nextInt(35);
        int posy = wall.nextInt(68);
        tablero[posx][posy] = "#";
    
    }
    
    }
    
    
    public static void imprime_Tablero(){
        tablero[Posy][Posx]="@";
        for(int fila=0;fila<35;fila++){
        System.out.println();
        for(int columna=0;columna<70;columna++){
            System.out.print(tablero[fila][columna]);
            if(fila ==5 && columna==69){
                System.out.print("      ##############");
            
            }
            if(fila==6 && columna == 69){
                System.out.print("      Punteo: "+ punteo);
            
            }
            if(fila ==7 && columna ==69){
                System.out.print("      Nombre: " + nombre);
            
            }
            if(fila == 8 && columna ==69){
                System.out.print("      ##############");
            }
        
        }
        System.out.print("");
    }
    
    }
    
    //Comida $, 
    public static void comida(){
        for(int porciento=0;porciento<40;porciento++){
            Random com_porc = new Random();
            int porc_x = com_porc.nextInt(33)+1;
            int porc_y = com_porc.nextInt(68)+1;
            tablero[porc_x][porc_y]="%";
        
        }
        
        for(int dolar=0;dolar<30;dolar++){
            Random com_dolar = new Random();
            int dolar_x = com_dolar.nextInt(33)+1;
            int dolar_y = com_dolar.nextInt(68)+1;
            tablero[dolar_x][dolar_y]="$";
        }
        
          
    }
    public static void jugar(){
        for(int i=1;i<68;i++){
            tablero[1][i]=" ";
        
        }

        
    
    }
    
    public static void saltoLinea(){
    for(int i=0;i<80;i++){
        System.out.println("");
    
    }
    
    }
    public static void datoJugador(){
        Scanner datos = new Scanner(System.in);
        
        nombre_jugador = new String[10];
        contador = contador +1;
        
        
        
        
        System.out.println("Ingrese su nombre: ");
        nombre = datos.next();
        //System.out.println("Ingrese su fecha de nacimiento: ");
        //nombre_jugador[contador] = datos.next();
        
        System.out.println(nombre_jugador[contador-1]);
        System.out.println(nombre_jugador[contador]);
        if(nombre_jugador!=null){
            System.out.println("se logro guardar.");
            
            
        }else{
            System.out.println("alv");}
        
        }

    public static void puntos(){
        if(tablero[Posy][Posx] == "%"){
            punteo+=10;
            
        
        }
        else if (tablero[Posy][Posx] == "$"){
            punteo-=10;
            
        }
        if(punteo>=100){
            System.out.println("");
            System.out.println("HAS GANDO EL JUEGO, FELICIDADES!!");
            System.out.println("Tu puntaje fue: "+punteo);
        }
        if(punteo<=10){
            System.out.println("");
            System.out.println("HAS PERDIDO EL JUEGO, INTENTALO DE NUEVO");
            System.out.println("Tu puntaje fue: "+punteo);
            punteo=10;
        }
        
    }
    
    public static void teclasJuego(){
            crea_tablero();
            imprime_Tablero();
            System.out.println(" ");
            System.out.println("\033[34m•••••••••••••••••••••••••••••••");
            System.out.println("\033[34m•••••••• Instrucciones ••••••••");
            System.out.println("\033[34m••••••••    W  arriba  ••••••••");
            System.out.println("\033[34m••••••••    S  abajo   ••••••••");
            System.out.println("\033[34m••••••••    D derecha  ••••••••");
            System.out.println("\033[34m•••••••    A izquierda  •••••••");
            System.out.println("\033[34m•••••••    M   pausar   •••••••");
            System.out.println("\033[34m•••••••••••••••••••••••••••••••");
            
            Scanner tecla = new Scanner(System.in);
            boolean exit = false;
            while(!exit){
                System.out.println(" ");
                System.out.println("\033[33mElija una letra...");
                String entrada = tecla.nextLine();
                if(entrada !=null){
                    System.out.println("Tecla: "+ " " + entrada + "No es Valida");
                    if("W".equals(entrada) || "w".equals(entrada)){
                        Posy -=1;
                        if(tablero[Posy][Posx]=="#"){
                            Posy +=1;
                        
                        }
                        puntos();
                        tablero[Posy+1][Posx] =" ";
                        saltoLinea();
                        imprime_Tablero();
                    }
                
                }
                if("S".equals(entrada) || "s".equals(entrada)){
                    Posy +=1;
                        if(tablero[Posy][Posx]=="#"){
                            Posy-=1;
                        
                        }
                        tablero[Posx-1][Posy] = " ";
                        saltoLinea();
                        imprime_Tablero();
                }
                if("A".equals(entrada) || "a".equals(entrada)){
                    Posx -=1;
                    if(tablero[Posy][Posx]=="#"){
                        Posx +=1;
                    
                    }
                    puntos();
                    tablero[Posy][Posx+1]=" ";
                    saltoLinea();
                    imprime_Tablero();
                }
                if("D".equals(entrada) || "d".equals(entrada)){
                    Posx+=1;
                    if(tablero[Posy][Posx]=="#"){
                        Posx-=1;
                    
                    }
                    puntos();
                    tablero[Posy][Posx-1]=" ";
                    saltoLinea();
                    imprime_Tablero();
                }
                if("M".equals(entrada) || "m".equals(entrada)){
                    saltoLinea();
                    System.out.println("JUEGO PAUSADO");
                    menu();
                    break;
                
                }
                if(punteo>=100){
                    puntos();
                    menu();
                    break;
                }
                if(punteo<=0){
                    puntos();
                    menu();
                    break;
                }
                
            
               
            }
    tecla.close();
    }
        
    

    
}
