import java.util.Scanner;

public class Tela {

    static boolean checarVitoria(char[][] tabuleiro){
        boolean vitoria = false;
        for(int i = 0; i < 3; i++){
            if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] && tabuleiro[i][2] != ' '){
                vitoria = true;
            }else if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i] && tabuleiro[2][i] != ' '){
                vitoria = true;
            }else if(tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2] && tabuleiro[2][2] != ' '){
                vitoria = true;
            }else if(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0] && tabuleiro[0][2] != ' '){
                vitoria = true;
            }
        }
        return vitoria;
    }

    static void mostrarTabuleiro(char[][] tabuleiro){
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

    static void montarTabuleiro(char[][] tabuleiro){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean vitoria = false;
        char[][] tabuleiro = new char[3][3];
        int rodadas = 0;

        montarTabuleiro(tabuleiro);

        do{
            int quemJoga = (rodadas % 2) + 1;
            int jogadaLinha, jogadaColuna;
            System.out.println("Turn of player " + quemJoga + ":");
            mostrarTabuleiro(tabuleiro);

            System.out.print("Enter the line you want to play (0 - 2):");
            jogadaLinha = entrada.nextInt();
            System.out.print("Enter the column you want to play (0 - 2):");
            jogadaColuna = entrada.nextInt();

            if(quemJoga == 1){
                if(tabuleiro[jogadaLinha][jogadaColuna] == ' '){
                    tabuleiro[jogadaLinha][jogadaColuna] = 'X';
                }else{
                    System.out.println("You think you are smart but you lost your turn kkkkkkkkkkk");
                }
            }else{
                if(tabuleiro[jogadaLinha][jogadaColuna] == ' '){
                    tabuleiro[jogadaLinha][jogadaColuna] = 'O';
                }else{
                    System.out.println("You think you are smart but you lost your turn kkkkkkkkkkk");
                }
            }
            rodadas++;
            vitoria = checarVitoria(tabuleiro);

            if(rodadas == 9){
                vitoria = true;
            }

        }while(!vitoria);
        mostrarTabuleiro(tabuleiro);
    }
}
