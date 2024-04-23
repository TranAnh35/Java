package Project.TicTacToe;

//import java.util.ArrayList;
//import java.util.Random;

class AI {
    public int pickSpot(TicTacToe game) {
        // ArrayList<Integer> choices = new ArrayList<>();
        // for (int i = 0; i < 9; i++) {
        //     if (game.board[i] == '-') {
        //         choices.add(i + 1);
        //     }
        // }
        // Random rand = new Random();
        // int choice = choices.get(Math.abs(rand.nextInt() % choices.size()));
        // return choice;

        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;
        for (int i = 0; i < 9; i++) {
            if (game.board[i] == '-') {
                game.board[i] = game.aiMarker;
                int score = minimax(game, 0, false);
                game.board[i] = '-';
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove + 1;
    }    

    private int minimax(TicTacToe game, int depth, boolean isMaximizing) {
        String result = game.gameOver();
        if (result.equals(game.userMarker + "win")) {
            return -1;
        } else if (result.equals(game.aiMarker + "win")) {
            return 1;
        } else if (result.equals("Draw")) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (game.board[i] == '-') {
                    game.board[i] = game.aiMarker;
                    int score = minimax(game, depth + 1, false);
                    game.board[i] = '-';
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (game.board[i] == '-') {
                    game.board[i] = game.userMarker;
                    int score = minimax(game, depth + 1, true);
                    game.board[i] = '-';
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }
}
