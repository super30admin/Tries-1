import java.util.*;
class ReplaceWords {

    ReplaceWords() {
        root = new TrieNode();
    }

    TrieNode root;

    //TC:
    //Insert words in the tries - O(L), So number of words in the dictionary would be O(NL) where N is number of words and L is length of each word.
    //Searching a word in a tried - O(N)

    //SC:
    //Saving words in tries - O(N)
    //Searching a word in a tries - O(1)

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) return "";
        StringBuilder result = new StringBuilder();
        root = new TrieNode();
        
        //Insert all dictionary values
        for(String word: dictionary) {
            insert(word);
        }
        
        //Traverse each word in the sentence
        String[] sentenceArray = sentence.split("\\s+");
        for(int i=0; i<sentenceArray.length;i++) {
            String currentWord = sentenceArray[i];
            //Check if the word exist or not
            //if exists get the matched value
            //Append the matched value to the result string.
            //Else append the original value
            if(i > 0) {
                result.append(" ");
            }
            result.append(getMatchedWord(currentWord));
        }
        return result.toString();
    }

    private void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            int indexOfChar = word.charAt(i) - 'a';
            if(current.children[indexOfChar] == null){
                current.children[indexOfChar] = new TrieNode();
            }
            current = current.children[indexOfChar];
        }
        current.isEnd = true;
    }
    
    private StringBuilder getMatchedWord(String word) {
        StringBuilder matchedWord = new StringBuilder();
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            char currentChar = word.charAt(i);
            int indexOfChar = currentChar - 'a';
            if(current.isEnd) return matchedWord;
            if(current.children[indexOfChar] == null) {
                break;
            }
            matchedWord.append(currentChar);
            current = current.children[indexOfChar];
        }
        return new StringBuilder(word);
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        String result = replaceWords.replaceWords(
            Arrays.asList("cat", "rat", "bat"),
            "the cattle was rattled by the battary"
        );
        System.out.println("The result: "+result);
    }
}