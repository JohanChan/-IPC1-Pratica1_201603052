package juegosnake;

import java.util.Random;
import java.util.Scanner;


public class JuegoSnake {
       public static Scanner sc = new Scanner(System.in);
       public static String [][] tablero;
       public static String[][] auxiliar= new String[35][70];
       public static String[] nombre_jugador=new String[5];
       public static String[] fecha= new String[5];
       public static String[] snake;
       public static int Posx=1;
       public static int Posy=1;
       public static int contador=0;
       public static int punteo=0;
       public static int movimientos;
       public static String nombre,fecha_nac;
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
                    punteo=10;
                    movimientos=0;
                    System.out.println("Has iniciado el juego");
                    datoJugador();
                    crea_tablero();
                    imprime_Tablero();
                    teclasJuego();
                    break;
                case 2: 
                    movimientos = movimientos;
                    saltoLinea();
                    System.out.println("Sigamos jugando");
                    regreso();
                    imprime_Tablero();
                    teclasJuego();
                    break;
                case 3: 
                    saltoLinea();
                    System.out.println("Historial");
                    historial();
                    
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
                System.out.print("      ##################");
            
            }
            if(fila==6 && columna == 69){
                System.out.print("       Punteo: "+ punteo);
            
            }
            if(fila ==7 && columna ==69){
                System.out.print("       Nombre: "+nombre);
            
            }
            if(fila ==8&& columna ==69){
                System.out.print("       Movimientos: "+ movimientos);
            
            }
            if(fila == 9 && columna ==69){
                System.out.print("      ##################");
            }
        
        }
        System.out.print("");
    }
        guardar(tablero);
    
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
        System.out.println("Ingrese nombre: ");
        nombre = datos.next();
        nombre_jugador[contador]=nombre;
        System.out.println("Ingrese fecha de nacimiento formato dd/mm/aa: ");
        fecha_nac = datos.next();
        fecha[contador] = fecha_nac;
        contador++;
        
    }
    public static void historial(){
       contador=1;
       for(int i=0;i<5;i++){
            System.out.println(contador++ + " Nombre: "+nombre_jugador[i]+"\t"+"Fecha Nacimiento: "+fecha[i]+"\t"+"Punteo: "+ punteo);
       }
      
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
        if(punteo<=0){
            System.out.println("");
            System.out.println("HAS PERDIDO EL JUEGO, INTENTALO DE NUEVO");
            System.out.println("Tu puntaje fue: "+punteo);
            
        }
        
    }
    
    public static void teclasJuego(){
            movimientos=0;
            tablero[Posy][Posx]="@";
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
                System.out.println("\033[32mElija una letra...");
                String entrada = tecla.nextLine();
                if(entrada !=null){
                    System.out.println("Tecla: "+ " " + entrada + "No es Valida");
                    if("W".equalsIgnoreCase(entrada)){
                        Posy -=1;
                        if(tablero[Posy][Posx]=="#"){
                            Posy +=1;
                        
                        }
                        movimientos++;
                        puntos();
                        tablero[Posy+1][Posx] =" ";
                        saltoLinea();
                        imprime_Tablero();
                    }
                
                }
                if("S".equalsIgnoreCase(entrada)){
                    Posy +=1; 
                        if(tablero[Posy][Posx]=="#"){
                            Posy-=1;
                        
                        }
                        movimientos++;
                        puntos();
                        tablero[Posy-1][Posx] = " ";
                        saltoLinea();
                        imprime_Tablero();
                }
                if("A".equalsIgnoreCase(entrada)){
                    Posx -=1;
                    if(tablero[Posy][Posx]=="#"){
                        Posx +=1;
                    
                    }
                    movimientos++;
                    puntos();
                    tablero[Posy][Posx+1]=" ";
                    saltoLinea();
                    imprime_Tablero();
                }
                if("D".equalsIgnoreCase(entrada)){
                    if(tablero[Posy][Posx]=="#"){
                    }else{
                        Posx+=1;
                    
                    }
                    movimientos++;
                    puntos();
                    tablero[Posy][Posx-1]=" ";
                    saltoLinea();
                    imprime_Tablero();
                }
                if("M".equalsIgnoreCase(entrada)){
                    saltoLinea();
                    System.out.println("JUEGO PAUSADO");
                    //guardar();
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
    public static void guardar(String tabla[][]){
        
        auxiliar = tabla;
        
    
    }
    public static String[][] regreso(){
        return auxiliar;
    
    }

        
    

    
}
