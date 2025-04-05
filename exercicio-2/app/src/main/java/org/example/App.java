/* Vou descrever a forma que pensei para realizar esse código.

Visto que será necessário fazer diversas verificações de cores, decidi usar switch's, para fazer a leitura dos argumentos de entrada.
    O primeriro switch é para verificar o valor da faixa, que é a primeira e segunda cor.
    O segundo switch é para verificar o valor multiplicador, que é a terceira cor.
    O terceiro switch é para verificar o valor da tolerância, que é a quarta cor.
    O quarto switch é para verificar o valor da tolerância, que é a quarta cor.

Para inicio do código, foi preciso verificar se as entradas seram válidas, um IF para a verificação, contando se os argumentos de entrada, coicidem com o esperado.
Para calcular a resistência, é preciso antes, juntar os primeiros dois números, para isso a conversão de string para inteiro. O fator multiplicativo já é lido como double
sem a necessidade de conversão.
Com ambos números convertidos, basta multiplicalos para obter o valor da resistência.
 * 
 * 
 * 
 * 
  */
  package org.example;

  public class App {
  
      static String faixa(String faixa){ // Switch para calcular o valor da faixa, vale para a primeira e segunda cor
          switch(faixa){
              case "preto": return "0"; 
              case "marrom": return "1";
              case "vermelho": return "2";
              case "laranja": return "3";
              case "amarelo" : return "4";
              case "verde" : return "5";
              case "azul" : return "6";
              case "violeta" : return "7";
              case "cinza": return "8";
              case "branco" : return "9";
              default: return "-1"; // Usado o -1 para identificar caso aconteça algum erro
          }
      }
  
      static double multiplicador(String multiplicado){ // Verificar o valor multiplicativo
          switch(multiplicado) {
              case "preto": return 1.0; 
              case "marrom": return 10.0;
              case "vermelho": return 100.0;
              case "laranja": return 1000.0;
              case "amarelo" : return 10000.0;
              case "verde" : return 100000.0;
              case "azul" : return 1000000.0;
              case "violeta" : return 10000000.0;
              case "cinza": return 1000000000.0;
              case "branco" : return 1000000000.0;
              case "ouro" : return 0.1;
              case "prata" : return 0.01;
              default: return -1;  
          }
      }
  
      static String tolerancia(String cor){ // Verificar o valor da tolerancia
          switch (cor) {
              case "marrom": return "1%";
              case "vermelho": return "2%";
              case "verde" : return "0.5%";
              case "azul" : return "0.25%";
              case "violeta" : return "0.1%";
              case "cinza": return "0.05%";
              case "ouro" : return "5%";
              case "prata" : return "10%";
              case "vazio" : return "20%";
              default : return "-1";
          }
      }
  public static void main(String[] args) {
          // teste para verificar se a entrada está correta
          if (args.length < 3 || args.length > 4) {
              System.out.println("Digite 4 cores para calcular a resistencia!");
              return;
          }
          
          
          String first_faixa = faixa(args[0]);
          String second_faixa = faixa(args[1]);
          double faixa_multiplicador = multiplicador(args[2]);
          String four_faixa;
          if (args.length == 4) {
               four_faixa = tolerancia(args[3]);
          } else {
               four_faixa = tolerancia("vazio");
          }
          
          if(first_faixa.equals("-1") || second_faixa.equals("-1") || faixa_multiplicador == -1 || four_faixa.equals("-1")) {
                  System.out.println("Corres erradas, digite cores válidas para prosseguir!");
                  return;
          }
  
          // Para obter os primeiro valor, é preciso fazer uma identização dos dois primeiros números
          String soma = first_faixa + second_faixa; // Soma as Strings
          int faixa_int = Integer.parseInt(soma); // Converte os valores para interos
          faixa_int *= faixa_multiplicador; // Para calcular o valor da resistencia, é preciso juntar os dois primeiros termos e multiplicar pela faixa multiplicadora
  
          // Com o resultado da resistencia, é preciso juntar com a tolerancia;
  
          System.out.printf("Resistência: %d (+- %s)%n", faixa_int, four_faixa);
          // Desta forma, o código funciona de forma perfeita, porém na impressão não foi adicionado a simbologia de ohm e as medidas como K, M e G.
          // É preciso estudar melhor de como implementar isso, porém o tempo é curto e será visto em outro momento.
      
  
  
      }
  }
  