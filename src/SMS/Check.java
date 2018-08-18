package SMS;

import java.util.ArrayList;
import java.util.Arrays;

public class Check {

    public static boolean isWordExist(String sentence, String word) {
        boolean ans = Boolean.FALSE;
        ArrayList<String> wordList = null;

        try {

            if (sentence != null && word != null) {
                wordList = new ArrayList<String>(Arrays.asList(sentence.split("[^a-zA-z]+")));
                if (wordList.contains(word)) {
                    ans = Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return ans;
    }

}
