
package lexis;
import java.util.TreeSet;

/**
 * Lexis class contains the core functionality of the application
 * @author Alex Hughes
 */

public class Lexis {
    
    private TreeSet charset;
    
    public Lexis(String aCharset) {
        char [] tmp = aCharset.toCharArray();
        charset = new TreeSet();
       
        for(int i=0; i<tmp.length; i++){
            charset.add(tmp[i]);
        }
    }
    
    public String cleanChars(String anInput) {
        char [] input = anInput.toCharArray();
        String output;
        StringBuilder sb = new StringBuilder();
        
        //sanitizing input...
        for(int i=0; i<input.length; i++) {
            if(charset.contains(input[i])){
                sb.append(input[i]);
            }
        }
        
        output = sb.toString();
        return output;
    }
}
