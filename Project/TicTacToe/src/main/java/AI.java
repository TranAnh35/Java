package Project.TicTacToe.src.main.java;

class AI {
    public int pickSpot(TicTacToe game) {
        
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;
        for (int i = 0; i < 9; i++) {
            if (game.board[i] == 0) {
                game.board[i] = game.aiMarker;
                int score = minimax(game, 0, false);
                game.board[i] = 0;
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
        if (result.equals("X win")) {
            return -1;
        } else if (result.equals("O win")) {
            return 1;
        } else if (result.equals("Draw")) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (game.board[i] == 0) {
                    game.board[i] = game.aiMarker;
                    int score = minimax(game, depth + 1, false);
                    game.board[i] = 0;
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (game.board[i] == 0) {
                    game.board[i] = game.userMarker;
                    int score = minimax(game, depth + 1, true);
                    game.board[i] = 0;
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }
}
