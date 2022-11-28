public class UltimateBoard {
    Board[] boards;  // Ultimate board contains Board[] boards
    public char WinningLetter = '*';
    // Winning Letter set to meaningless * at first, but changes to X or O if winner is found

    public UltimateBoard(Board[] boards) {  // Ult Board Constructor
        this.boards = boards;
    }

    public void printSmallWins(char[] box){  // method to print the winners of the individual boards after each turn
        for (int i = 0; i < 9; i++){
            if (box[i] == 'X' || box[i] == 'O'){
                System.out.println("The winner of board " + i + " is " + box[i]);
            }
        }
    }

    public void addSmallWins(Board[] boards, char[] box){
        for (int i = 0; i < 9; i++){
            if (box[i] == '*') {
                if (boards[i].getWinner(boards[i].getBox()) == 'X' || boards[i].getWinner(boards[i].getBox()) == 'O') {
                    box[i] = boards[i].getWinner(boards[i].getBox());
                }
            }
        }
    } // method to add the winners of the small boards to a new char[] box so that I can build the skeleton for the Ultimate Board

    public boolean isTotallyFull(Board[] boards){
        int count = 0;
        for (int i = 0; i < 9; i++){
            if (boards[i].isFull(boards[i].getBox())){
                count ++;
            }
        }
        return count == 9;
    } // method used to check if the entire Ultimate Board is full (meaning all 81 boxes have an X or O)


    /* foundWinner method used to check the Ultimate Board skeleton and determine
     if an Ultimate winner is found. This method requires a char[] box which is the
     new char[] box built by addSmallwins. In our game class this is char[] box9)
     */
    public boolean foundWinner(char[] box){
        if (box[0] == 'X' && box[1] == 'X' && box[2] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[3] == 'X' && box[4] == 'X' && box[5] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[6] == 'X' && box[7] == 'X' && box[8] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[0] == 'X' && box[3] == 'X' && box[6] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[1] == 'X' && box[4] == 'X' && box[7] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[2] == 'X' && box[5] == 'X' && box[8] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[0] == 'X' && box[4] == 'X' && box[8] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        else if (box[2] == 'X' && box[4] == 'X' && box[6] == 'X'){
            WinningLetter = 'X';
            return true;
        }
        // BREAK POINT BETWEEN X AND O
        else if (box[0] == 'O' && box[1] == 'O' && box[2] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[3] == 'O' && box[4] == 'O' && box[5] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[6] == 'O' && box[7] == 'O' && box[8] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[0] == 'O' && box[3] == 'O' && box[6] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[1] == 'O' && box[4] == 'O' && box[7] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[2] == 'O' && box[5] == 'O' && box[8] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[0] == 'O' && box[4] == 'O' && box[8] == 'O'){
            WinningLetter = 'O';
            return true;
        }
        else if (box[2] == 'O' && box[4] == 'O' && box[6] == 'O'){
            WinningLetter = 'O';
            return true;
        } else {
            return false;
        }
    }

    // this method is used to print the entirety of the Ult TTT Board after each turn, using the printrow methods found in the Board class
    public void printUltimateBoard() {
        System.out.print("    BOARD 0        BOARD 1        BOARD 2");
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            boards[i].printrow1();
        }
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            boards[i].printrow2();
        }
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            boards[i].printrow3();
        }
        System.out.println("");
        System.out.print("    BOARD 3        BOARD 4        BOARD 5");
        System.out.println("");
        for (int i = 3; i < 6; i++) {
            boards[i].printrow1();
        }
        System.out.println("");
        for (int i = 3; i < 6; i++) {
            boards[i].printrow2();
        }
        System.out.println("");
        for (int i = 3; i < 6; i++) {
            boards[i].printrow3();
        }
        System.out.println("");
        System.out.print("    BOARD 6        BOARD 7        BOARD 8");
        System.out.println("");
        for (int i = 6; i < 9; i++) {
            boards[i].printrow1();
        }
        System.out.println("");
        for (int i = 6; i < 9; i++) {
            boards[i].printrow2();
        }
        System.out.println("");
        for (int i = 6; i < 9; i++) {
            boards[i].printrow3();
        }
        System.out.println("");

    }

}
