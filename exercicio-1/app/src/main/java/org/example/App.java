package org.example;

public class App {
   
    static void tri (int tamanho) {
        

        for (int i = 1; i <= tamanho; i++) {
            for (int j = tamanho - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

    

    
    public static void main (String[] args){
        int number = Integer.parseInt(args[1]);
        tri(number);
    }
}