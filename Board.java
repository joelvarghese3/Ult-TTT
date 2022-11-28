// class that contains information about the 9 mini boards used during the game
public class Board {

    public char[] box; // each Board contains a char[] box

    int boardNum; // stores num 0-8 of which board we are using

    public Board (int boardNum, char [] box){ //Board constructor used to build Board objects in game class
        this.box = box;
        this.boardNum = boardNum;
    }

    public char[] getBox() {
        return box;
    }

    public void printOpenBoxes(char[] box){   // method used to print the empty boxes remaining in each current board during the game
        System.out.print("Open boxes in this board: ");
        for (int i = 0; i < 9; i++){
            if (box[i] == '*'){
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }


    public char getWinner(char[] box){   // method used to determine winner of each individual Board
        if (box[0] == 'X' && box[1] == 'X' && box[2] == 'X'){
            return 'X';
        }
        else if (box[3] == 'X' && box[4] == 'X' && box[5] == 'X'){
            return 'X';
        }
        else if (box[6] == 'X' && box[7] == 'X' && box[8] == 'X'){
            return 'X';
        }
        else if (box[0] == 'X' && box[3] == 'X' && box[6] == 'X'){
            return 'X';
        }
        else if (box[1] == 'X' && box[4] == 'X' && box[7] == 'X'){
            return 'X';
        }
        else if (box[2] == 'X' && box[5] == 'X' && box[8] == 'X'){
            return 'X';
        }
        else if (box[0] == 'X' && box[4] == 'X' && box[8] == 'X'){
            return 'X';
        }
        else if (box[2] == 'X' && box[4] == 'X' && box[6] == 'X'){
            return 'X';
        }
        // BREAK POINT BETWEEN X AND O
        else if (box[0] == 'O' && box[1] == 'O' && box[2] == 'O'){
            return 'O';
        }
        else if (box[3] == 'O' && box[4] == 'O' && box[5] == 'O'){
            return 'O';
        }
        else if (box[6] == 'O' && box[7] == 'O' && box[8] == 'O'){
            return 'O';
        }
        else if (box[0] == 'O' && box[3] == 'O' && box[6] == 'O'){
            return 'O';
        }
        else if (box[1] == 'O' && box[4] == 'O' && box[7] == 'O'){
            return 'O';
        }
        else if (box[2] == 'O' && box[5] == 'O' && box[8] == 'O'){
            return 'O';
        }
        else if (box[0] == 'O' && box[4] == 'O' && box[8] == 'O'){
            return 'O';
        }
        else if (box[2] == 'O' && box[4] == 'O' && box[6] == 'O'){
            return 'O';
        }
        else {
            return '*';
        }
    }

    public boolean isFull(char[] box){ // method used to determine if each individual Board is full or not
        int count = 0;
        for (int i = 0; i < 9; i++){
            if (box[i] == 'X' || box[i] == 'O'){
                count ++;
            }
        }
        return count == 9;

    }

    public boolean checkBox(char[] box, int boxNum){
        return box[boxNum] == 'X' || box[boxNum] == 'O';
    } // method used to determine if a specific box in a Board is full or not
    public void setBox(char[] box, char c, int boxNum) {
            box[boxNum] = c;
    } // method used to change box contents to X or O depending on which player is marking the box


    /* in order to print properly in command line, we print row by row for each board
    I used 3 different print methods because I had to print 3 rows for each board. I split it up
    into 3 methods so that boards 0 - 2 could be on top, 3 - 5 could be in the middle, and 6 - 8 could
    be on the bottom. This way when I print the UltBoard I can use these methods to print it. If I only used
    one method to print all 9 they would appear in a horizontal line and that's not what I need to properly
    showcase the Ultimate TTT board.
     */
    public void printrow1(){
        for (int i = 0; i < 3; i++){
                System.out.print(" | " + box[i]);
        }
        System.out.print(" | ");
    }
    public void printrow2(){
        for (int i = 3; i < 6; i++){
            System.out.print(" | " + box[i]);
        }
        System.out.print(" | ");
    }
    public void printrow3(){
        for (int i = 6; i < 9; i++){
            System.out.print(" | " + box[i]);
        }
        System.out.print(" | ");
    }


}
