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
 * Para a segunda parte do atividade, onde é preciso verificar se há um navio desconhecido, como vamos ler a linha por linha do tabuleiro, podemos verificar se há um navio desconhecido.
 * Feito um switch, onde cada caso é um navio conhecido, e o default é o navio desconhecido;
 * uma variável recebe os valores de elementos[i].charAt(0), e em um switch, verifica se o valor é um navio conhecido ou não;
 * 
 * Para a terceira parte, onde é verificado se cada navio foi incluido pelo menos uma vez no tabuleiro. é percorrido um o tabuleiro dentro de um FOR, dentro do FOR é usado um switch
 * que em cada caso é um navio diferente, e caso encontre, podemos alterar o valor da variável, exemplo:
 *  Na primeira linha do tabuleiro ele encontre N, dentro do switch tem o caso N e ele atribui ao uma variável um sinal positivo, por exemplo, número 0 ou true;
 * Para saber se todos foram adicionados, um IF com o operadora &&, então vai ser preciso ser um booleano, se o resultado for true, quer dizer que está correto, caso contrário, falta
 * algum outro navio.
 * 
 * 
 * 
 * 
 * 
 * 
 * Para fazer a leitura do arquivo, foi criado um arquivo.txt, onde para testar o código, é necessário alterar o conteudo do arquivo. 
 * Não encontrei uma forma de fazer a entrada do arquivo, da forma que o docente pediu, então segui o mesmo metôdo utilizado em programação 2.
 */


 package org.example;
 import java.util.Scanner;
 
 public class App {
        static final int tamanho = 10; // Define uma variável global

 
        static boolean lerTabuleiro(Scanner teclado_in, char[][] tabuleiro) {
         int linhas_lidas = 0; // vai existir uma variável que será responsável em verificar se a quatidade de linhas lidas no tabuleiro estão na dimensão correta
 
         while(teclado_in.hasNextLine()) { // Um while que vai ficar no loop até ler todas as linhas do arquivo
             if(linhas_lidas >= tamanho) { // linhdas_lidas é inciada com 0, então quando chegar em 10 valores, vai possuir um valor inteiro igual a 9;
                 System.out.println("Tabuleiro inválido"); // If verifica se não há execessos de linhas
                 return false;
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
                 return false;
             }
 
             for(int i = 0; i < tamanho; i++){ // Adicionado no for, uma verificaçã do digito, então caso não seja um ponto ou navio, imprime que o tabuleiro é inválido
                 char c = elementos[i].charAt(0); // A variável c vai receber o primeiro elemento da string, que é o caracter, ou seja, o ponto ou navio
                 switch(c){ // Todos os casos do switch vão ser adicionados no tabuleiro;
                     case '.':
                     case 'P':
                     case 'E':
                     case 'C':
                     case 'S':
                     case 'N':
                         tabuleiro[linhas_lidas][i] = c;
                         break; // Se for um ponto ou navio, não faz nada, só continua o loop 
                     default:
                         System.out.println("Tabuleiro inválido, contém caracteres inválidos!"); // Se não for nenhum dos valores válidos, imprime que o tabuleiro é inválido
                         return false;
                 }
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
 
         return linhas_lidas == tamanho;
     }

    
 
        static void imprimirTabuleiro(char[][] tabuleiro) {
         for(int i = 0; i < tamanho; i++){
             for(int j = 0; j < tamanho; j++){
                 System.out.print(tabuleiro[i][j] + " "); // Vai imprimir o tabuleiro separando os elementos com " "(espaço)
             }
             System.out.println();
         }
     }
        static boolean verifica_navio(char[][] tabuleiro){
            boolean P = false, E = false, C = false, S = false, N = false; // Variáveis que vão representar cada navio

            for(int i = 0; i < tamanho; i++){
                for(int j = 0; j < tamanho; j++){
                    switch(tabuleiro[i][j]){ // Vai ler todo o tabuleiro, caso encontre o valor na linha, atribui ao respectivo nome, o valor de true.
                        case 'P': P = true;
                        break;
                        case 'E': E = true;
                        break;
                        case 'C': C = true;
                        break;
                        case 'S': S = true;
                        break;
                        case 'N': N = true;
                        break;
                    }
                }
            }

            boolean verifica_navio = (P && E && C && S && N);
            return verifica_navio;
        }
      
        public static void main(String[] args) {
            Scanner teclado_in;
            try {
                teclado_in = new Scanner(new java.io.File("tabuleiro.txt")); // Lê o arquivo diretamente
            } catch (java.io.FileNotFoundException e) {
                System.out.println("Arquivo tabuleiro.txt não encontrado.");
                return;
            }
        
            char[][] tabuleiro = new char[tamanho][tamanho]; // Matriz tabuleiro de 10X10
        
            if (lerTabuleiro(teclado_in, tabuleiro)) {
                System.out.println("Tabuleiro está correto");
                imprimirTabuleiro(tabuleiro);
        
                if (verifica_navio(tabuleiro)) {
                    System.out.println("Todos os navios estão presentes!");
                } else {
                    System.out.println("Nem todos os navios foram acrescentados");
                }
        
            } else {
                System.out.println("Falha na leitura ou validação do tabuleiro.");
            }
        }
        

 }
 