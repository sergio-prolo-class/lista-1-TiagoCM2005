package org.example;

public class App {
   
    static void tri (int tamanho) {
        // função que imprime o triangulo
        for (int i = 1; i <= tamanho; i++) { // for que intera toda a altura do triangulo, sua altura.
            for (int j = tamanho - i; j >= 1; j--) { // for responsável por imprimir os espaços. Ele recebe o tamanho - i, considerando que tamanho seja 5, j recebe 4
                System.out.print(" ");             // então ele vai imprimir 4 espaços 
            }
            for(int k = 0; k < i; k++){ // for responsável de imprimir os asteriscos, ele imprime a quantidade de * equivalentes ao valor de i;
                System.out.print("*");
            }
            System.out.println();

        }
    }

    static void retangulo (int lar_tamanho, int alt_tamanho) {
        
        for (int i = 0; i < alt_tamanho; i++) {
            for (int j = 0; j < lar_tamanho; j++) {
                if (i == 0 || i == alt_tamanho - 1 || j == 0 || j == lar_tamanho - 1) {
                    System.out.print("*"); // feito um if, para verificar se está nas bordas, limitando a impressão de * somente nas bordas
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
}

    static void losango (int tamanho){
        // Para o losango, foi pensando em fazer dois triangulos, um crescente na parte superior e um descrescente na parte inferior
        
        //Para a parte superior
        int meio = tamanho / 2; // calcula o meio do losango
        for (int i = 0; i <= meio; i++ ){
            for (int j = 0; j < meio - i; j++) { // A parte superior vai imprimir apenas até o meio do losango, então meio - i, vai adicionar os espaços necessários
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) { // 2**i + 1 vai sempre formar um número impar, imprindo sempre uma quantidade número ímpar de asteriscos;
                System.out.print("*");
            }
            System.out.println();
        }    

        // Foi pensando anteriormente em usar "for(int i = 1; i >= 0; i--)", porém assim, ele não ficará faltando um espaço.(Foi debugado pensando no valor de meio em 2)
        // Corrigido para: " for(int i = meio - 1; i >= 0; i--)", assim é percorrido todos valores de meio - 1, ou seja, considerando que o valor seja 7, o meio valerá 3, a variável 
        // vai receber 2, logo será impresso 3 valores embaixo do centro. Antes, seria apenas impresso duas linhas de *.
        for(int i = meio - 1; i >= 0; i--){ 
            for (int j = 0; j < meio - i; j++) { // na parte superior, é feito uma parte crescente para os espaços, aqui é de forma decrescente
                System.out.print(" ");
            }
            for(int k = 0; k < i * 2 + 1; k++ ){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println(); 
    }

    

    
    // Arquivo MAIN
    public static void main (String[] args){
        // Na função main, foi feito apenas um switch tratando cada caso, feito a conversão de string dos argumentos de entrada para inteiros.

        String formato = args[0].toLowerCase(); // Recebe os valores do argumento 1 de forma minuscula
        switch(formato) {

            case "triangulo":
                int num_tri = Integer.parseInt(args[1]);
                tri(num_tri);
                break;

            case "retangulo": // verificar se no argumento, foi passado mais de 2 valores
                if(args.length < 3) {
                    System.out.println("É preciso entrar com dois valores! 'gradle run --args \"retangulo 8 5\"");
                } else {
                    int lar_tamanho = Integer.parseInt(args[1]); // recebe o segundo valor do argumento; Largura
                    int alt_tamanho = Integer.parseInt(args[2]); // recebe o terceiro valor do argumento; Altura
                    retangulo(lar_tamanho, alt_tamanho);
                }
                break;

            case "losango":
                int num_los = Integer.parseInt(args[1]);
                if (num_los % 2 == 0) {
                    System.out.println("O número deve ser impar!");
                    return;
                } else {
                    losango(num_los);
                }
                break;
                
            default:
                    System.out.println("Formato inválido! Escolha entre triangulo, retangulo ou losango.");
                    return;

        }
    
    }
}