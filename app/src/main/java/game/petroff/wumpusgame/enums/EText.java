package game.petroff.wumpusgame.enums;

/**
 * Created by petroff on 12/8/17.
 */

public enum EText {

    CANT_GO_THERE("You can not go there!"),
    WUMPUS_EAT_YOU("Wumpus just eat you!"),
    YOU_FALL("You fall in a pit!"),
    HAS_WALL("It's a wall!"),
    SMELL_BAD("Something smells bad!"),
    IS_IT_LIGHTING("There is a light!"),
    TRY_AGAIN ("Do you want to try again?"),
    YOU_WIN("Congratulations! YOU WIN"),
    OK("OK"),
    SHOUT("SIUUUGH"),
    NO_MORE_ARROW("No more arrow!");

    private String text;

    private EText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
