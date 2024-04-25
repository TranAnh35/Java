package Project.TicTacToe.src.main.java;

public class App {
    public static void main(String[] args){
        TicTacToe game = new TicTacToe(1, 2);
        AI ai = new AI();
        UI panel = new UI(game, ai);
        panel.buildUI();
    }
}
