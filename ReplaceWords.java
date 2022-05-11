import java.util.List;

public class ReplaceWords {


    class TrieNode {
       TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;

        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    // TC: O(n * k) + O(m * l)
        // we are building a trie first then we are doing the replace operation
        // n - number of words in dictionary
        // k - average length of the word in dictionary
        // m - number of words in a sentence
        // l - average length of a word in a sentence
    // SC: O(n * k) + O(m * l)
        // extra m * l because we are creating an array of words
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) return sentence;

        root = new TrieNode();

        for(String word : dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");


        for(int i=0; i < words.length; i++) {
            StringBuilder newString = new StringBuilder();
            String word = words[i];

            TrieNode current = root;

            // Just add space after each word
            if(i != 0) result.append(" ");

            for(int j=0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(current.children[c - 'a'] == null || current.isEnd){
                    break;
                }
                newString.append(c);
                current = current.children[c - 'a'];
            }

            if(current.isEnd) result.append(newString);
            else result.append(word);

        }

        return result.toString();
    }
}
