
package org.example;
import java.util.Random;

public class App { 
    static final int tamanho_tab = 10;
    static char[][] tab = new char[tamanho_tab][tamanho_tab];  // cria um bi vetor, assim é possível acessar tanto a linha quanto a coluna do tabuleiro  
    
    static void tabuleiro(){
        
        for(int i = 0; i < tamanho_tab; i++){
            for(int j = 0; j < tamanho_tab; j++){
                tab[i][j] = '.'; // Tanto i quanto j vão iterar até o tamanho (10) fixado no código, adicionando ponto em cada valor do vetor
            }
            
        }
    }

    static void posiciona(char simbolo, int tamanho) {
        Random rand = new Random();
        boolean loop = true;
        while(loop) { // Corrigido a expressão do loop, de (!loop) para (loop)
            int linha = rand.nextInt(tamanho_tab);
            int coluna = rand.nextInt(tamanho_tab);
            int sentido = rand.nextInt(2);
            
            if (valida(linha,coluna,tamanho,sentido) == true) {
                for(int i = 0; i < tamanho; i++){
                    if(sentido == 0) {
                        tab[linha + i][coluna] = simbolo;
                    } else {
                        tab[linha][coluna + i] = simbolo;
                    }
                }
                loop = false;
            }
        }
    }

    static boolean valida(int linha, int coluna, int tamanho, int posicao){ // Visto que sempre vai retornar sucesso ou falha, foi alterado para boolean para ficar mais legível
        
         //Random rand = new Random();
        // posicao = rand.nextInt(2); // vertical = 0 || horizontal = 1

        // Visto que a posição já foi sorteada, não é necessário realizar o sorteio novamente
        
        if (posicao == 0) { // vertical
            if(linha + tamanho > tamanho_tab) // a variavel tamanho se refere ao tamanho do navio
                return false; // Se passerem do limite da tabela, retorna a false

            for(int i = 0; i < tamanho; i++){
                if(tab[linha + i][coluna] != '.') // Quando a posição é igual a 0, é preciso fazer duas verificações
                return false;                              // Verificar se não ultrapassa da borda e se não à nada além do ponto
            }
        } else {
            if(coluna + tamanho > tamanho_tab) // Alterado a variável coluna e linha, pois eu havia compreendido de forma incorreta a lógica de linhas e colunas.
            return false;
            for (int j = 0; j < tamanho; j++){ // aqui se verifica a linha, mesma logica // Alterado de tamanho_tab para apenas o tamanho do navio
                if(tab[linha][coluna + j ] != '.') 
                return false;
            }
        }

        return true; // Se ele não entrar em nenhum IF, vai retornar a ture, assim é possível saber que aquele ponto está livre e pode-se colocar qualquer navio
    }

    static void imprimir() { // função que vai imprimir o tabuleiro
        for (int i = 0; i < tamanho_tab; i++) { // for que percorre o tabuleiro todo
            for (int j = 0; j < tamanho_tab; j++) {
                System.out.print(tab[i][j] + " "); // tanto na vetical como j são impressos com um ' ' entre eles
            }
            System.out.println();
        }
    }
   public static void main(String[] args) {
        tabuleiro();
        posiciona('P', 5); // Porta-aviões
        posiciona('E', 4); // Encouraçado
        posiciona('C', 3); // Cruzador
        posiciona('S', 3); // Submarino
        posiciona('N', 2); // Contratorpedeiro
        imprimir();
}





}
