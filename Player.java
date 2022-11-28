// class made to build player objects and gain information about player type and letter

public class Player {

    char playerType; // can be H or C

    char playerLetter; // can be either X, O to represent players in Ult TTT game


    public Player (char playerType, char playerLetter){  // player constructor used in game class to build players
        this.playerType = playerType;
        this.playerLetter = playerLetter;
    }

    public char getPlayerType() {
        return playerType;
    } // checks player type to ensure proper gameMode is being played

    public char getPlayerLetter() {
        return playerLetter;
    } // gets curr Player Letter and uses that to mark TTT board




}
