package lexis;

import java.util.*;

/**
 * RL class contains the core functionality Right-Left Analysis
 *
 * @author Alex Hughes
 */
public class RL {

    private TreeSet<Rating> ratingT;
    private ArrayList<Rating> ratingL;
    private int left;
    private int right;

    /**
     * Constructor initializing functionality
     *
     * @param aLeft - Lexicon
     * @param aRight - Lexicon
     */
    public RL(String aLeft, String aRight) {
        char[] leftC = aLeft.toCharArray();
        char[] rightC = aRight.toCharArray();

        ratingT = new TreeSet();

        Rating tmp;
        //creating the lexicon with the ratingL as well as ratingR...
        for (int i = 0; i < leftC.length; i++) {
            tmp = new Rating(leftC[i], "left");
            ratingT.add(tmp);
        }

        for (int i = 0; i < rightC.length; i++) {
            tmp = new Rating(rightC[i], "right");
            ratingT.add(tmp);
        }
    }

    public String cleanChars(String anInput) {
        char[] input = anInput.toCharArray();
        String output;
        StringBuilder sb = new StringBuilder();

        //sanitizing input...
        Rating tmp;
        for (int i = 0; i < input.length; i++) {
            tmp = new Rating(input[i], null);
            if (ratingT.contains(tmp)) {
                sb.append(input[i]);
            }
        }

        output = sb.toString();
        return output;
    }

    public void rateInput(String anInput) {
        ratingL = new ArrayList();
        char[] inputC = anInput.toCharArray();

        //dumping the tree in ArrayList for ease of use (updates)
        Iterator it = ratingT.iterator();
        while (it.hasNext()) {
            ratingL.add((Rating) it.next());
        }

        //iterating through array and updating counters in array list
        //also updating counters
        left = 0;
        right = 0;
        for (int i = 0; i < inputC.length; i++) {
            for (int j = 0; j < ratingL.size(); j++) {
                if (inputC[i] == ratingL.get(j).getCharacter()) {
                    ratingL.get(j).updateCtr();
                    //also updating stat counters
                    if (ratingL.get(j).getType().equals("left")) {
                        left++;
                    } else {
                        right++;
                    }
                }
            }
        }

        //dumping the arraylist to the tree again
        //at the end of the day the class contains both
        for (int i = 0; i < ratingL.size(); i++) {
            ratingT.add(ratingL.get(i));
        }
    }

    public void printResults() {
        Iterator it = ratingT.iterator();

        while (it.hasNext()) {
            Rating tmp = (Rating) it.next();
            if (tmp.getCounter() != 0) {
                System.out.println(tmp.getCharacter() + ": " + tmp.getCounter());
            }
        }
        System.out.println("Right Hand: " + right);
        System.out.println("Left Hand: " + left);
        System.out.println("Size: " + ratingL.size());
    }
}
