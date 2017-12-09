package ef1;


public class EF1 {

   
    public static void main(String[] args) {
        System.out.println("Escriba un numero");
        int n = Integer.parseInt(args[0]);
        System.out.println(Factorial(n));
        Factorial(n);
    }
    public static int Factorial(int n){
         int resp;
         if(n == 1){
             return 1;
         }else{
           resp = n*Factorial(n-1);
         }
        return resp;
         
    
    
    }
}
