import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String word;
            while ((word = br.readLine()) != null) {
                String sortedWord = sortCharacters(word);

                anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
                anagramMap.get(sortedWord).add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anagramMap;
    }
    private static String sortCharacters(String word) {
        char[] charArray = word.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> mostFrequentList = new ArrayList<>();

        for (ArrayList<String> anagramList : anagrams.values()) {
            if (anagramList.size() > mostFrequentList.size()) {
                mostFrequentList = anagramList;
            }
        }

        return mostFrequentList;
    }


    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (Map.Entry<String, ArrayList<String>> entry : anagrams.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();


            System.out.println(key + ": " + value);
        }
    }






public void main() {
}
