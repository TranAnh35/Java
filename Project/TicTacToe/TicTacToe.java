package Project.TicTacToe;

public class TicTacToe {
    // Hình ảnh của bảng cờ có chỉ mục
    /*
     * 0 | 1 | 2
     * ---------
     * 3 | 4 | 5
     * ---------
     * 6 | 7 | 8
     */

    // Hình ảnh UI của bảng cờ
    // Khởi tạo bảng cờ
    // | - | - | - |
    // -------------
    // | - | - | - |
    // -------------
    // | - | - | - |

    // Bảng cờ
    // | 0 | - | 0
    // ------------
    // | - | X | -
    // ------------
    // | - | - | X

    // Thiết lập
    // Tạo bảng
    protected char[] board;

    // Cho phép người chơi thể hiện di chuyển của họ
    protected char userMarker;

    // Cho phép máy thể hiện di chuyển của họ
    protected char aiMarker;

    // Tuyên bố người chiến thắng
    protected char winner;

    // Khai báo điểm đánh dấu hiện tại
    protected char currentMarker;

    // Tạo 1 constructor
    public TicTacToe(char playerToken, char aiToken) {
        this.userMarker = playerToken;
        this.aiMarker = aiToken;
        this.winner = '-';
        this.board = setBoard();
        this.currentMarker = userMarker;
    }

    // Tạo bảng cờ
    public static char[] setBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
        return board;
    }

    // Lượt chơi
    public boolean playTurn(int spot) {
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if (isValid) {
            board[spot - 1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }

    // Kiểm tra xem vị trí có hợp lệ không
    public boolean withinRange(int number) {
        return number > 0 && number < board.length + 1;
    }

    // Kiểm tra xem vị trí đã được chọn chưa
    public boolean isSpotTaken(int number) {
        return board[number-1] != '-';
    }

    // In bảng cờ
    public void printBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print(" | " + board[i]);
        }
        System.out.println();
    }

    // In bảng cờ với chỉ mục
    public void printIndexBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("-------------");
            }
            System.out.print(" | " + (i + 1));
        }
        System.out.println();
    }

    public TicTacToe() {
    }

    // Kiểm tra xem có người chiến thắng không
    public boolean isThereAWinner() {
        boolean diagonalsAndMiddles = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
        boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
        boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';

        // Kiểm tra các trường hợp chiến thắng
        if (diagonalsAndMiddles) {
            this.winner = board[4];
        } else if (topAndFirst) {
            this.winner = board[0];
        } else if (bottomAndThird) {
            this.winner = board[8];
        }
        return diagonalsAndMiddles || topAndFirst || bottomAndThird;
    }

    // Kiểm tra hàng trên cùng
    public boolean topRow() {
        return board[0] == board[1] && board[1] == board[2];
    }

    // Kiểm tra hàng giữa
    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }

    // Kiểm tra hàng dưới cùng
    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }

    // Kiểm tra cột đầu tiên
    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }

    // Kiểm tra cột thứ hai
    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }

    // Kiểm tra cột thứ ba
    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }

    // Kiểm tra đường chéo phải
    public boolean rightDi() {
        return board[0] == board[4] && board[4] == board[8];
    }

    // Kiểm tra đường chéo trái
    public boolean leftDi() {
        return board[2] == board[4] && board[4] == board[6];
    }

    // Kiểm tra xem có hòa không
    public boolean isTheBoardFilled() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                return false;
            }
        }
        return true;
    }

    // Lấy người chiến thắng
    public String gameOver() {
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin) {
            return this.winner + " win";
        } else if (isTheBoardFilled()) {
            return "Draw";
        } else {
            return "notOver";
        }
    }
}
