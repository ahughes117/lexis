/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lexis;

/**
 *
 * @author Alex Hughes
 */
public class Rating implements Comparable {

    private char character;
    private int counter = 0;
    private String type;

    public Rating(char character, String type) {
        this.character = character;
        this.type = type;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCounter() {
        return counter;
    }

    public void updateCtr() {
        counter++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Rating) {
            return this.character - ((Rating) o).character;
        } else {
            return -1;
        }
    }
}
