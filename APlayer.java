abstract class APlayer {
    private String name;

    private final char playerLetter;

    public APlayer(String name, char playerLetter){
        this.name = name;
        this.playerLetter = playerLetter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char getPlayerLetter() {
        return playerLetter;
    }


}
