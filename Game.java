import java.util.Scanner;
// class created to make the player, board, and UltimateBoard objects while also containing the methods that run the game
public class Game {
    Scanner input = new Scanner(System.in); // scanner used for user input
    int gameMode; // int that contains information on which gameMode is being played

    int gameMode2type; // int to determine which type of gameMode2 is ran (does human go first or computer?) determined by input of human
    String playerLetterChoice; // string that is used only in GameMode 2 when the human player says "yes" or "no" to being Player 1 (X)


    // 8 character arrays filled with 8 *'s are made and 8 small Boards are created using each char[] as a data field
    char[] box0 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board0 = new Board(0, box0);
    char[] box1 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board1 = new Board(1, box1);
    char[] box2 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board2 = new Board(2, box2);
    char[] box3 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board3 = new Board(3, box3);
    char[] box4 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board4 = new Board(4, box4);
    char[] box5 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board5 = new Board(5, box5);
    char[] box6 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board6 = new Board(6, box6);
    char[] box7 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board7 = new Board(7, box7);
    char[] box8 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'};
    Board board8 = new Board(8, box8);

    Board[] boards = {board0, board1, board2, board3, board4, board5, board6, board7, board8};
    // an array of boards is made so that we can create an Ultimate Board object which has a board array as a data field

    char[] box9 = {'*', '*', '*', '*', '*', '*', '*', '*', '*'}; // BOX 9 is the Ultimate winning char[] or Board that holds the winners of the other boards

    UltimateBoard UltBoard = new UltimateBoard(boards); // create instance of Ult Board that contains array of all board objects

    public Game() {  // create game instance to use in driver class
    }


    public void setGame() {
        // first start off game with welcome messages and explain game modes
        System.out.println("Welcome to Joel's game of Ultimate Tic Tac Toe!");
        System.out.println("You can choose from 3 available game modes!");
        System.out.println("1: Player vs Player ");
        System.out.println("2: Player vs AI");
        System.out.println("3: AI vs AI");

        while (true) {
            System.out.println("Please select a game mode! (Enter 1, 2, or 3): ");
            boolean isInt = input.hasNextInt();
            if (isInt) {
                gameMode = input.nextInt();  // confirm input is an int to prevent error
            } else {
                System.out.println("That is not an integer! Please enter correctly!");
                input.next();
                continue;
            }
            if (gameMode != 1 && gameMode != 2 && gameMode != 3) {  // confirm int is 1, 2 or 3
                System.out.println("Please enter a valid game mode!");
            } else {
                System.out.println("Thank you for your choice! Onto the game!");
                break;
            }

        }

        UltBoard.printUltimateBoard();
        // print main Board. First board is filled with * to represent empty boxes

    }


    public void playGame() {

        if (gameMode == 1) {

            //* creating two human Aplayers for gameMode 1 Human vs Human

            System.out.println("Player 1 will be X, Player 2 will be O");
            System.out.println("Please enter your name Player 1");
            Scanner firstname = new Scanner(System.in);
            String name = firstname.nextLine();

            HumanPlayer player1 = new HumanPlayer(name, 'X');

            System.out.println("Please enter your name Player 2");
            Scanner secondName = new Scanner(System.in);
            String name2 = secondName.nextLine();
            HumanPlayer player2 = new HumanPlayer(name2, 'O');



            int startingBoard;
            int rotatingBoard;
            int boxNum;
            while (true) {
                System.out.println("Which board would you like to start on Player 1 (X) " + player1.getName() + " ?") ;
                boolean isInt = input.hasNextInt();
                if (isInt) {
                    startingBoard = input.nextInt();  // confirm input is an int to prevent error
                } else {
                    System.out.println("That is not an integer! Please enter correctly!");
                    input.next();
                    continue;
                }
                if (!(startingBoard < 9 && startingBoard > -1)) {  // confirm int is 0-8
                    System.out.println("Please enter a valid Board Number!");
                } else {
                    break;
                }

            } // input validation to pick starting Board (can only pick from 0-8)
            System.out.println("Currently in Board " + startingBoard + " chosen by Player 1 (X) " + player1.getName());
            boards[startingBoard].printOpenBoxes(boards[startingBoard].getBox()); // method prints available boxes in curr board
            while (true) {
                System.out.println("Which box on board " + startingBoard + " would you like to mark Player 1(X) " + player1.getName() + " ?");
                boolean isInt = input.hasNextInt();
                if (isInt) {
                    boxNum = input.nextInt();  // confirm input is an int to prevent error
                } else {
                    System.out.println("That is not an integer! Please enter correctly!");
                    input.next();
                    continue;
                }
                if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                    System.out.println("Please enter a valid Box Number!");
                } else {
                    break;
                }

            } // input validation to pick which Box to mark (can only be from 0-8)
            boards[startingBoard].setBox(boards[startingBoard].getBox(), player1.getPlayerLetter(), boxNum); // sets chosen box to playerLetter (X or O)
            UltBoard.printUltimateBoard();
            rotatingBoard = boxNum; // next Board becomes the previous boxNum
            // Player 1's turn is over, now Player 2 is starting their move
            System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());
            boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // shows available boxes in curr board
            while (true) {
                System.out.println("Which box on board " + rotatingBoard + " would you like to mark Player 2 (O) " + player2.getName() + " ?");
                boolean isInt = input.hasNextInt();
                if (isInt) {
                    boxNum = input.nextInt();  // confirm input is an int to prevent error
                } else {
                    System.out.println("That is not an integer! Please enter correctly!");
                    input.next();
                    continue;
                }
                if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                    System.out.println("Please enter a valid Box Number!");
                } else if (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                    System.out.println("Box is already full! Please choose a different box!");
                } else {
                    break;
                }

            } // input validation to pick a new boxNum to mark the current Board (makes sure box isn't already full)
            boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum); // sets chosen box to playerLetter (X or O)
            UltBoard.printUltimateBoard();

            // FIRST TWO MOVES NOT IN LOOP

            while (!(UltBoard.foundWinner(box9)) && !(UltBoard.isTotallyFull(boards))) {
                // Player 1's turn
                rotatingBoard = boxNum;
                if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                    System.out.println("Current Player is 1(X) " + player1.getName());
                    while (true) {
                        System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                        boolean isInt = input.hasNextInt();
                        if (isInt) {
                            rotatingBoard = input.nextInt();  // confirm input is an int to prevent error
                        } else {
                            System.out.println("That is not an integer! Please enter correctly!");
                            input.next();
                            continue;
                        }
                        if (!(rotatingBoard < 9 && rotatingBoard > -1)) {  // confirm int is 0-8
                            System.out.println("Please enter a valid Board Number!");
                        } else if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                            System.out.println("Pick a board that isn't full!");
                        } else {
                            System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 2(O) " + player2.getName());
                            break;
                        }

                    }

                } // makes sure board isn't full, switches board to prev boxNum

                boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board
                while (true) {
                    System.out.println("Current Player is 1 (X) " + player1.getName());
                    System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player1.getName() + " ?");
                    boolean isInt = input.hasNextInt();
                    if (isInt) {
                        boxNum = input.nextInt();  // confirm input is an int to prevent error
                    } else {
                        System.out.println("That is not an integer! Please enter correctly!");
                        input.next();
                        continue;
                    }
                    if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                        System.out.println("Please enter a valid Box Number!");
                    } else if (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                        System.out.println("Box is already full! Please choose a different box!");
                    } else {
                        break;
                    }

                } // picks new box and confirms that chosen box isn't already full
                boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player1.getPlayerLetter(), boxNum);
                // sets player 1 mark onto the specific box they chose on the board being played
                UltBoard.printUltimateBoard();
                // prints the Ultimate Board with the new marks
                UltBoard.addSmallWins(boards, box9);
                // If any winners are found, adds winners to new char[] box9
                UltBoard.printSmallWins(box9);
                // If any winners are found, prints winners of each specific Board onto the screen

                // SWITCH PLAYERS Player 2 is now playing
                rotatingBoard = boxNum;
                if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                    System.out.println("Current Player is 2 (O) " + player2.getName());
                    while (true) {
                        System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                        boolean isInt = input.hasNextInt();
                        if (isInt) {
                            rotatingBoard = input.nextInt();  // confirm input is an int to prevent error
                        } else {
                            System.out.println("That is not an integer! Please enter correctly!");
                            input.next();
                            continue;
                        }
                        if (!(rotatingBoard < 9 && rotatingBoard > -1)) {  // confirm int is 0-8
                            System.out.println("Please enter a valid Board Number!");
                        } else if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                            System.out.println("Pick a board that isn't full!");
                        } else {
                            break;
                        }

                    }

                } // makes sure board isn't full, switches board to prev boxNum
                else {System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());}
                boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board
                while (true) {
                    System.out.println("Current Player is 2 (O) " + player2.getName());
                    System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player2.getName() + " ?");
                    boolean isInt = input.hasNextInt();
                    if (isInt) {
                        boxNum = input.nextInt();  // confirm input is an int to prevent error
                    } else {
                        System.out.println("That is not an integer! Please enter correctly!");
                        input.next();
                        continue;
                    }
                    if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                        System.out.println("Please enter a valid Box Number!");
                    } else if (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                        System.out.println("Box is already full! Please choose a different box!");
                    } else {
                        break;
                    }

                } // picks new box and confirms that chosen box isn't already full
                boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
                UltBoard.printUltimateBoard();
                UltBoard.addSmallWins(boards, box9);
                UltBoard.printSmallWins(box9);
            }
            if (UltBoard.foundWinner(box9)) {
                if (UltBoard.WinningLetter == player1.getPlayerLetter()){
                    System.out.println("The Ultimate Winner of this game is Player 1 (X) " + player1.getName() + " !!!");
                } else if (UltBoard.WinningLetter == player2.getPlayerLetter()){
                    System.out.println("The Ultimate Winner of this game is Player 2 (O) " + player2.getName() + " !!!");
                }

            } else if (UltBoard.isTotallyFull(boards)) {
                System.out.println("Sorry, this game was a Draw! Better luck next time guys!"); // Prints Draw result if game ends in draw
            }
        } // HUMAN vs HUMAN

        if (gameMode == 2) {
            // input validation to see if human player wants to go first or second
            System.out.println("Hello human, would you like to be Player 1? (P1 is X and P2 is O) Please say yes or no:)");
            boolean invalid = true;
            while (invalid) {  // input validation to make sure correct option is recorded
                playerLetterChoice = input.nextLine();
                if (playerLetterChoice.equals("yes")) {
                    gameMode2type = 1;
                    invalid = false;
                } else if (playerLetterChoice.equals("no")) {
                    gameMode2type = 2;
                    invalid = false;
                } else {
                    System.out.println("Please enter yes or no only!");
                }
            }


            if (gameMode2type == 1) {

                // human player starts first
                // create human player as P1 and ComputerPlayer as P2
                System.out.println("Please enter your name Player 1");
                String name = input.nextLine();
                HumanPlayer player1 = new HumanPlayer(name, 'X');    // if "yes" human goes first, then computer goes second
                ComputerPlayer player2 = new ComputerPlayer("ComputerPlayer", 'O');

                int startingBoard;
                int rotatingBoard;
                int boxNum;
                while (true) {
                    System.out.println("Which board would you like to start on Player 1(X) " + player1.getName() + " ?");
                    boolean isInt = input.hasNextInt();
                    if (isInt) {
                        startingBoard = input.nextInt();  // confirm input is an int to prevent error
                    } else {
                        System.out.println("That is not an integer! Please enter correctly!");
                        input.next();
                        continue;
                    }
                    if (!(startingBoard < 9 && startingBoard > -1)) {  // confirm int is 0-8
                        System.out.println("Please enter a valid Board Number!");
                    } else {
                        break;
                    }

                } // picks starting board
                System.out.println("Currently in Board " + startingBoard + " chosen by Player 1 (X) " + player1.getName());
                boards[startingBoard].printOpenBoxes(boards[startingBoard].getBox()); // shows available boxes in curr board
                while (true) {
                    System.out.println("Which box on board " + startingBoard + " would you like to mark Player 1(X) " + player1.getName() + " ?");
                    boolean isInt = input.hasNextInt();
                    if (isInt) {
                        boxNum = input.nextInt();  // confirm input is an int to prevent error
                    } else {
                        System.out.println("That is not an integer! Please enter correctly!");
                        input.next();
                        continue;
                    }
                    if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                        System.out.println("Please enter a valid Box Number!");
                    } else {
                        break;
                    }

                } // picks new box
                boards[startingBoard].setBox(boards[startingBoard].getBox(), player1.getPlayerLetter(), boxNum);
                UltBoard.printUltimateBoard();
                rotatingBoard = boxNum;
                System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());
                boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox());

                // NOW Computer's Turn
                System.out.println("Which box on board " + rotatingBoard + " would you like to mark Player 2(O) " + player2.getName() + " ?");
                boxNum = (int) (Math.random() * (9));
                while (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                    System.out.println("Box is already full! Please choose a different box!");
                    boxNum = (int) (Math.random() * (9));
                }
                // picks new boxNum and checks that it isn't full
                System.out.println("Player 2(O) " + player2.getName() + " chooses to mark box " + boxNum);
                boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
                UltBoard.printUltimateBoard();

                // FIRST TWO MOVES DONE, ONTO THE LOOP
                while (!(UltBoard.foundWinner(box9)) && !(UltBoard.isTotallyFull(boards))){
                    rotatingBoard = boxNum;
                    if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                        System.out.println("Current Player is 1 (X) " + player1.getName());
                        while (true) {
                            System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                            boolean isInt = input.hasNextInt();
                            if (isInt) {
                                rotatingBoard = input.nextInt();  // confirm input is an int to prevent error
                            } else {
                                System.out.println("That is not an integer! Please enter correctly!");
                                input.next();
                                continue;
                            }
                            if (!(rotatingBoard < 9 && rotatingBoard > -1)) {  // confirm int is 0-8
                                System.out.println("Please enter a valid Board Number!");
                            } else if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                                System.out.println("Pick a board that isn't full!");
                            } else {
                                System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 2 (O) " + player2.getName());
                                break;
                            }

                        }

                    } // makes sure board isn't full, switches board to prev boxNum

                    boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board
                    while (true) {
                        System.out.println("Current Player is 1 (X) " + player1.getName());
                        System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player1.getName() + " ?");
                        boolean isInt = input.hasNextInt();
                        if (isInt) {
                            boxNum = input.nextInt();  // confirm input is an int to prevent error
                        } else {
                            System.out.println("That is not an integer! Please enter correctly!");
                            input.next();
                            continue;
                        }
                        if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                            System.out.println("Please enter a valid Box Number!");
                        } else if (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                            System.out.println("Box is already full! Please choose a different box!");
                        } else {
                            break;
                        }

                    } // picks new box and confirms that chosen box isn't already full
                    boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player1.getPlayerLetter(), boxNum);
                    UltBoard.printUltimateBoard();
                    UltBoard.addSmallWins(boards, box9);
                    UltBoard.printSmallWins(box9);
                    // NOW THE COMPUTER'S TURN
                    rotatingBoard = boxNum;
                    if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                        System.out.println("Current Player is 2 (O) " + player2.getName());
                        System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                        do {
                            rotatingBoard = (int) (Math.random() * (9));
                        }
                        while (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox()) && !(UltBoard.isTotallyFull(boards)));
                        System.out.println("Player 2 (O) " + player2.getName() + " chooses board " + rotatingBoard);


                    } // makes sure board isn't full, switches board to prev boxNum
                    else {System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());}
                    boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board

                    System.out.println("Current Player is 2 (O) " + player2.getName());
                    System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player2.getName() + " ?");
                    do {
                        boxNum = (int) (Math.random() * (9));
                    }
                    while (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum) && !(UltBoard.isTotallyFull(boards)));
                    // picks new box and confirms that chosen box isn't already full

                    boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
                    System.out.println("Player 2 (O) chooses to mark box " + boxNum);
                    UltBoard.printUltimateBoard();
                    UltBoard.addSmallWins(boards, box9);
                    UltBoard.printSmallWins(box9);

                }
                if (UltBoard.foundWinner(box9)) {
                    if (UltBoard.WinningLetter == player1.getPlayerLetter()){
                        System.out.println("The Ultimate Winner of this game is Player 1 (X) " + player1.getName() + " !!!");
                    } else if (UltBoard.WinningLetter == player2.getPlayerLetter()){
                        System.out.println("The Ultimate Winner of this game is Player 2 (O) " + player2.getName() + " !!!");
                    }

                } else if (UltBoard.isTotallyFull(boards)) {
                    System.out.println("Sorry, this game was a Draw! Better luck next time guys!"); // Prints Draw result if game ends in draw
                }


            }
            else if (gameMode2type == 2) {
                //computer starts first
                // create computer aPlayer as player 1 and human aPlayer as player 2
                ComputerPlayer player1 = new ComputerPlayer("ComputerPlayer", 'X');    // if "no" computer goes first, then human goes second
                System.out.println("Please enter your name Player 2");
                String name = input.nextLine();
                HumanPlayer player2 = new HumanPlayer(name, 'O');

                int startingBoard;
                int rotatingBoard;
                int boxNum;

                // COMPUTER GOES FIRST
                System.out.println("Which board would you like to start on Player 1 (X) " + player1.getName() + " ?");
                startingBoard = (int) (Math.random() * (9)); // picks starting Board
                System.out.println("Currently in Board " + startingBoard + " chosen by Player 1 (X) " + player1.getName());
                boards[startingBoard].printOpenBoxes(boards[startingBoard].getBox()); // shows available boxes in curr board
                System.out.println("Which box on board " + startingBoard + " would you like to mark Player 1(X) " + player1.getName() + " ?");
                boxNum = (int) (Math.random() * (9)); // picks a new box
                boards[startingBoard].setBox(boards[startingBoard].getBox(), player1.getPlayerLetter(), boxNum);
                System.out.println("Player 1 (X) chooses to mark box " + boxNum);
                UltBoard.printUltimateBoard();
                rotatingBoard = boxNum;
                System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());
                boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // shows available boxes in curr board
                // HUMAN GOES NEXT
                while (true) {
                    System.out.println("Which box on board " + rotatingBoard + " would you like to mark Player 2 (O) " + player2.getName() + " ?");
                    boolean isInt = input.hasNextInt();
                    if (isInt) {
                        boxNum = input.nextInt();  // confirm input is an int to prevent error
                    } else {
                        System.out.println("That is not an integer! Please enter correctly!");
                        input.next();
                        continue;
                    }
                    if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                        System.out.println("Please enter a valid Box Number!");
                    } else if (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                        System.out.println("Box is already full! Please choose a different box!");
                    } else {
                        break;
                    }

                } // picks new boxNum
                boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
                UltBoard.printUltimateBoard();

                // FIRST TWO MOVES NOT IN LOOP
                while (!(UltBoard.foundWinner(box9)) && !(UltBoard.isTotallyFull(boards))) {
                    // COMPUTER PLAYER GOES FIRST
                    rotatingBoard = boxNum;
                    if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                        System.out.println("Current Player is 1 (X) " + player1.getName());
                        System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                        do {
                            rotatingBoard = (int) (Math.random() * (9));
                        }
                        while (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox()) && !(UltBoard.isTotallyFull(boards)));
                        System.out.println("Player 1 (X) " + player1.getName() + " chooses new board " + rotatingBoard);
                    } // makes sure board isn't full, switches board to prev boxNum
                    else {System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 2 (O) " + player2.getName());}
                    boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board

                    System.out.println("Current Player is 1 (X) " + player1.getName());
                    System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player1.getName() + " ?");
                    do {
                        boxNum = (int) (Math.random() * (9));
                    }
                    while (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum) && !(UltBoard.isTotallyFull(boards)));
                    // picks new box
                    System.out.println("Player 1 (X) " + player1.getName() + " chooses to mark box " + boxNum);
                    boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player1.getPlayerLetter(), boxNum);
                    UltBoard.printUltimateBoard();
                    UltBoard.addSmallWins(boards, box9);
                    UltBoard.printSmallWins(box9);

                    // SWITCH PLAYERS
                    //HUMAN PLAYER IS NEXT
                    rotatingBoard = boxNum;
                    if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                        System.out.println("Current Player is 2 (O) " + player2.getName());
                        while (true) {
                            System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                            boolean isInt = input.hasNextInt();
                            if (isInt) {
                                rotatingBoard = input.nextInt();  // confirm input is an int to prevent error
                            } else {
                                System.out.println("That is not an integer! Please enter correctly!");
                                input.next();
                                continue;
                            }
                            if (!(rotatingBoard < 9 && rotatingBoard > -1)) {  // confirm int is 0-8
                                System.out.println("Please enter a valid Board Number!");
                            } else if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                                System.out.println("Pick a board that isn't full!");
                            } else {
                                break;
                            }

                        }

                    } // makes sure board isn't full, switches board to prev boxNum
                    else {System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());}
                    boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board
                    while (true) {
                        System.out.println("Current Player is 2 (O) " + player2.getName());
                        System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player2.getName() + " ?");
                        boolean isInt = input.hasNextInt();
                        if (isInt) {
                            boxNum = input.nextInt();  // confirm input is an int to prevent error
                        } else {
                            System.out.println("That is not an integer! Please enter correctly!");
                            input.next();
                            continue;
                        }
                        if (!(boxNum < 9 && boxNum > -1)) {  // confirm int is 0-8
                            System.out.println("Please enter a valid Box Number!");
                        } else if (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                            System.out.println("Box is already full! Please choose a different box!");
                        } else {
                            break;
                        }

                    } // picks new box
                    boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
                    UltBoard.printUltimateBoard();
                    UltBoard.addSmallWins(boards, box9);
                    UltBoard.printSmallWins(box9);

                }
                if (UltBoard.foundWinner(box9)) {
                    if (UltBoard.WinningLetter == player1.getPlayerLetter()){
                        System.out.println("The Ultimate Winner of this game is Player 1 (X) " + player1.getName() + " !!!");
                    } else if (UltBoard.WinningLetter == player2.getPlayerLetter()){
                        System.out.println("The Ultimate Winner of this game is Player 2 (O) " + player2.getName() + " !!!");
                    }

                } else if (UltBoard.isTotallyFull(boards)) {
                    System.out.println("Sorry, this game was a Draw! Better luck next time guys!"); // Prints Draw result if game ends in draw
                }
            }

        } // HUMAN vs AI (either player can go first depending on human choice)

        if (gameMode == 3) { // AI vs AI
            // create two computer aPlayers for AI vs AI gamemode
            ComputerPlayer player1 = new ComputerPlayer("Temoc", 'X');
            ComputerPlayer player2 = new ComputerPlayer("Bevo", 'O');

            int startingBoard;
            int rotatingBoard;
            int boxNum;

            System.out.println("Which board would you like to start on Player 1 (X) " + player1.getName() + " ?");
            startingBoard = (int) (Math.random() * (9)); // picks starting Board
            System.out.println("Currently in Board " + startingBoard + " chosen by Player 1 (X) " + player1.getName());
            boards[startingBoard].printOpenBoxes(boards[startingBoard].getBox()); // shows available boxes in curr board
            System.out.println("Which box on board " + startingBoard + " would you like to mark Player 1(X) " + player1.getName() + " ?");
            boxNum = (int) (Math.random() * (9)); // picks a new box
            boards[startingBoard].setBox(boards[startingBoard].getBox(), player1.getPlayerLetter(), boxNum);
            System.out.println("Player 1 (X) " + player1.getName() + " chooses to mark box " + boxNum);
            UltBoard.printUltimateBoard();
            // now Player 2's turn
            rotatingBoard = boxNum;
            System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());
            boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // shows available boxes in curr board
            System.out.println("Which box on board " + rotatingBoard + " would you like to mark Player 2 (O) " + player2.getName() + " ?");
            boxNum = (int) (Math.random() * (9));
            while (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum)) {
                System.out.println("Box is already full! Please choose a different box!");
                boxNum = (int) (Math.random() * (9));
            }
            // picks new boxNum and checks that it isn't full
            boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
            System.out.println("Player 2 (O) " + player2.getName() + " chooses to mark box " + boxNum);
            UltBoard.printUltimateBoard();

            // FIRST TWO MOVES NOT IN LOOP

            while (!(UltBoard.foundWinner(box9)) && !(UltBoard.isTotallyFull(boards))) {
                rotatingBoard = boxNum;
                if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                    System.out.println("Current Player is 1 (X) " + player1.getName());
                    System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                    do {
                        rotatingBoard = (int) (Math.random() * (9));
                    }
                    while (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox()) && !(UltBoard.isTotallyFull(boards)));
                    System.out.println("Player 1 (X) " + player1.getName() + " chooses new board " + rotatingBoard);
                } // makes sure board isn't full, switches board to prev boxNum
                else {System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 2 (O) " + player2.getName());}
                boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board

                System.out.println("Current Player is 1 (X) " + player1.getName());
                System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player1.getName() + " ?");
                do {
                    boxNum = (int) (Math.random() * (9));
                }
                while (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum) && !(UltBoard.isTotallyFull(boards)));
                // picks new box and makes sure that box picked isn't already full
                System.out.println("Player 1 (X) " + player1.getName() + " chooses to mark box " + boxNum);
                // prints out the box that was chosen by the AI players
                boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player1.getPlayerLetter(), boxNum);
                // marks the box chosen by the player (in this case mark = X)
                UltBoard.printUltimateBoard();
                // prints Ultimate Board
                UltBoard.addSmallWins(boards, box9);
                // checks for winners on smallBoards and adds them to char[] box9 if found
                UltBoard.printSmallWins(box9);
                // prints winners of smallBoards if any are found

                // SWITCH PLAYERS Note: all logic for Player 2 is the same as Player 1
                rotatingBoard = boxNum;
                if (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox())) {
                    System.out.println("Current Player is 2 (O) " + player2.getName());
                    System.out.println("Since board " + rotatingBoard + " is full, please pick a new Board to play on");
                    do {
                        rotatingBoard = (int) (Math.random() * (9));
                    }
                    while (boards[rotatingBoard].isFull(boards[rotatingBoard].getBox()) && !(UltBoard.isTotallyFull(boards)));
                    System.out.println("Player 2 (O) " + player2.getName() + " chooses new board " + rotatingBoard);

                } // makes sure board isn't full, switches board to prev boxNum
                else {System.out.println("Currently in Board " + rotatingBoard + " chosen by Player 1 (X) " + player1.getName());}
                boards[rotatingBoard].printOpenBoxes(boards[rotatingBoard].getBox()); // prints available boxes in curr board

                System.out.println("Current Player is 2 (O) " + player2.getName());
                System.out.println("Which box on board " + rotatingBoard + " would you like to mark " + player2.getName() + " ?");
                do {
                    boxNum = (int) (Math.random() * (9));
                }
                while (boards[rotatingBoard].checkBox(boards[rotatingBoard].getBox(), boxNum) && !(UltBoard.isTotallyFull(boards)));
                boards[rotatingBoard].setBox(boards[rotatingBoard].getBox(), player2.getPlayerLetter(), boxNum);
                System.out.println("Player 2 (O) " + player2.getName() + " chooses to mark box " + boxNum);
                UltBoard.printUltimateBoard();
                UltBoard.addSmallWins(boards, box9);
                UltBoard.printSmallWins(box9);
            }
            if (UltBoard.foundWinner(box9)) {
                if (UltBoard.WinningLetter == player1.getPlayerLetter()){
                    System.out.println("The Ultimate Winner of this game is Player 1 (X) " + player1.getName() + " !!!");
                } else if (UltBoard.WinningLetter == player2.getPlayerLetter()){
                    System.out.println("The Ultimate Winner of this game is Player 2 (O) " + player2.getName() + " !!!");
                }

            } else if (UltBoard.isTotallyFull(boards)) {
                System.out.println("Sorry, this game was a Draw! Better luck next time " + player1.getName() + " and " + player2.getName()); // Prints Draw result if game ends in draw
            }


        } // AI VS AI


    }
}
