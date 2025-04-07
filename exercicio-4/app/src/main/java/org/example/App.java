/*
 * Primeira parte vai ser em válidar se o tabuleiro está de forma na dimensão correta;
 * Ele será limitado para um tabuleiro 10X10, levado em cosideração ao exercício anterior;
 * A primeira parte será feita e testada, será tudo feito como parte da função main, depois será ajustada para um função, assim como as outras partes a serem implementadas;
 * 
 * No arquivo, terá um tabuleiro 10X10, quando lido, será sempre lido a primeira linha do tabuleiro.
 * Então uma matriz: tabuleiro[10][10] poderá armazenar os valores do tabuleiro.
 * Visto no último exercício que o tabuleiro será separado pelos elementos e ' '(espaço), entã será preciso se livrar dos espaços entre os números e possíveis no início e fim da linha;
 * Procurado sobre, encontrado a função trim e split. 
 * trim() retira os espaços no início e fim da linha, é considerado que a entrada não vá ter espaço no começo ou fim, mas por segurança, foi incluído
 * split(\\s+), uma indicação encontrada na internet, consegue retirar os espaços entre os números; Split retorna uma string!
 * Atribuíndo tudo para uma variável, ela terá em cada interação do while, toda a primeira linha contida nela
 * Uma verificação apartir desse ponto é possível, sabendo que toda a primeira linha está em um variável, podemos verificar a dimensão dela.
 * 
 * Tendo uma variável responsável por contar quantas linhas foram lidas, inciada com 0 e incrementada em cada loop, pode adicionar para a matriz tabuleiro todos os valores do tabuleiro lido
 * Exemplo: tabuleiro[linha_atual][i] = elementos[i].charAt(0); // Vai percorrer a primeira linha fixa e variar a coluna da matriz, adicionando o caracter
 * charAt vai obtér o primeiro valor da string, como são sempre um caracter, vai sempre atribuir aquela carecter;
 * 
 * 
 */

 
package org.example;
import java.util.Scanner;

public class App {
    static final int tamanho = 10; // Define uma variável global
    public static void main(String[] args) {
        Scanner teclado_in = new Scanner(System.in); // Scanner iniciado

        char[][] tabuleiro = new char[tamanho][tamanho]; // Matriz tabuleiro de 10X10, que vai guardar os caracteres do tabuleiro
        int linhas_lidas = 0; // vai existir uma variável que será responsável em verificar se a quatidade de linhas lidas no tabuleiro estão na dimensão correta

        while(teclado_in.hasNextLine()) { // Um while que vai ficar no loop até ler todas as linhas do arquivo
            if(linhas_lidas >= tamanho) { // linhdas_lidas é inciada com 0, então quando chegar em 10 valores, vai possuir um valor inteiro igual a 9;
                System.out.println("Tabuleiro inválido"); // If verifica se não há execessos de linhas
            }
            
            String linha = teclado_in.nextLine().trim(); // A string linha, recebe a linha de entrada do arquvio junto da função trim, que tira qualquer espaço no começo e fora do arquivo
            
            String[] elementos = linha.split("\\s+"); // Como no atividade 3, os pontos e os navios são separados por espaços, foi pesquisado uma função para retirar os espaços
            
            // "\\s+" Vai separar a string onde houver espaço branco, então a string elementos, vai compor todos os elementos da linha:
            /* Exemplo: [* * * * * * N N * *]
                Usando o comando do split, a string elementos vai receber: elemento = ['*','*','*','*','*','*','N','N','*','*']
                    Todos os elementos, sem conter o espaço
            */
            if(elementos.length != tamanho){ // Se a quantidade de linhas for diferente de 10(tamanho) já sabemos que está fora da dimensão;
                System.out.println("Tamnaho inválido, tabuleiro fora da dimensão correta!");
                return;
            }

            for(int i = 0; i < tamanho; i++){
                tabuleiro[linhas_lidas][i] = elementos[i].charAt(0); 
            /* Considerando a tabela:
             *    1 2 3 4 5 6 7 8 9 10  - No primeiro loop do while, linhas_lidas é 0, então vai levar a primeira linha;
             *  1 . N N . . . . . . .   - i é inicia igual a 0, então vai ler a primeira coluna
             *  2 . . . . . . N N . .   - Tabuleiro que é uma matriz 10X10, vai receber na primeira linha coluna 1, o primeiro elemento da string "elementos", pois foi usado a função
             *  3 . . . . . . . . . .       charAt(0) que retorna o primeiro valor;
             *  4 . . . . . . . . . .   - Quando ler a linha toda da matriz, vai sair do for e icrementar a variável linhas_lidas, começando na proxima iteração na segunda linha; 
             *  5 P P P P P . . . . .
             *  6 . . . . E E E E . .
             *  7 . . . . . . . . . .
             *  8 . . . . . . . . . .
             *  9 . . . . . . . . . .
             * 10 . . . . . . . . . .
             */
            }
            linhas_lidas++;
        }

        if(linhas_lidas == tamanho){
            System.out.println("Tabuleiro está correta");
        }
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                System.out.print(tabuleiro[i][j] + " "); // Vai imprimir o tabuleiro separando os elementos com " "(espaço)
            }
            System.out.println();
        }
    }

}
