package Project.TicTacToe;

import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String[] args){
        try (// Nhận đầu vào
        Scanner sc = new Scanner(System.in)) {
            // Cho phép người chơi chơi lại
            boolean doYouWantToPlay = true;

            // Bắt đầu trò chơi
            while(doYouWantToPlay){
                System.out.println("Chao mung den voi Tic Tac Toe! Ban da san sang de doi dau voi bac thay Tic Tac Toe chua? \n"
                + "Nhung truoc do ban hay chon cho minh mot ki hieu de choi.");
                System.out.println();
                System.out.println("Nhap ki hieu dai dien cua ban: ");
                char playerToken = sc.next().charAt(0);
                System.out.println("Nhap ki hieu dai dien cua AI: ");
                char aiToken = sc.next().charAt(0);
                TicTacToe game = new TicTacToe(playerToken, aiToken);
                AI ai = new AI();

                // Thiết lập trò chơi
                System.out.println();
                System.out.println("Bay gio chung ta co the bat dau tro choi. De chon mot o tren ban co, hay nhap so tu 1 den 9.");
                //TicTacToe.printIndexBoard();
                System.out.println();

                // Bắt đầu chơi
                while(game.gameOver().equals("notOver")){
                    if(game.currentMarker == game.userMarker){
                        // Lượt của người chơi
                        System.out.println("Luot cua ban! Chon mot o (1-9): ");
                        int spot = sc.nextInt();
                        while(!game.playTurn(spot)){
                            System.out.println("O nay da duoc chon hoac khong hop le. Hay chon o khac: ");
                            spot = sc.nextInt();
                        }
                        System.out.println("Ban da chon o " + spot);
                    } else {
                        // Lượt của AI
                        System.out.println("Luot cua AI!");
                        int aiSpot = ai.pickSpot(game);
                        game.playTurn(aiSpot);
                        System.out.println("AI da chon o " + aiSpot);
                    }
                    // In bảng
                    System.out.println();
                    game.printBoard();
                }
                System.out.println(game.gameOver());
                System.out.println();

                // Chơi lại
                System.out.println("Ban co muon choi lai khong? Nhap 'Y' de choi lai, 'N' de thoat.");
                char response = sc.next().charAt(0);
                doYouWantToPlay = (response == 'Y');
                System.out.println();
                System.out.println();
            }
        }
    }
}
