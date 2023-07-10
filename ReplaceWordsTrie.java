import java.util.List;

public class ReplaceWordsTrie {
        public static class TrieNode {

            TrieNode[] children;
            boolean isEnd;

            // Constructor of TrieNode class
            public TrieNode() {

                this.children = new TrieNode[26];
            }

        }

        // method to insert roots of dictionary in trie
        public void insertInTrie(TrieNode root, String word) {

            TrieNode curr = root;

            for(int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                if(curr.children[c - 'a'] == null) {

                    curr.children[c - 'a'] = new TrieNode();
                }

                curr = curr.children[c - 'a'];

                //only insert shortest roots, if bat is there already, don't insert battle
                if(curr.isEnd) return;
            }

            curr.isEnd = true;
        }

        public String replaceWords(List<String> dictionary, String sentence) {

            // initiate a Trie Node
            TrieNode rootDictTrie = new TrieNode();

            // make trie of root words in dictionary
            for(String word: dictionary) { // O(n*L)

                insertInTrie(rootDictTrie, word);
            }

            //split the given sentence to process words in it
            String[] splitSentence = sentence.split(" ");

            // make a result String Builder
            StringBuilder result = new StringBuilder(); // O(m*k) - size

            // iterate over every word in split Sentence
            for(int i = 0; i < splitSentence.length; i++) { // Sentence loop // O(m*k)

                String currWord = splitSentence[i];

                // make a String Builder for each word in split Sentence
                StringBuilder currReplace = new StringBuilder();

                // initiate a current Trie Node at main root on which trie is made
                TrieNode curr = rootDictTrie;

                // space between words
                if(i > 0) result.append(" ");

                // iterate over each character in current word
                for(int j = 0; j < currWord.length(); j++) { // Word loop

                    char c = currWord.charAt(j);

                    // if a null is found at current character position in Trie Node array of current Trie Node or boolean of current Trie Node is true
                    if(curr.children[c - 'a'] == null || curr.isEnd) {

                        // decision on current word is done, stop
                        break;

                    } else { //otherwise

                        // update current Trie Node
                        curr = curr.children[c - 'a'];

                        // place current character in current replacement word
                        currReplace.append(c);
                    }

                }

                if(curr.isEnd) {

                    // add current replacement word to result, if word loop is exited by boolean true condition
                    result.append(currReplace);

                } else { // add current original word to result, if word loop is exited by null condition
                    result.append(currWord);
                }

                //result.append(" ");
            }
            // convert result to string to return to main method
            return  result.toString();

            // trim the last space if space is added at the end of sentence loop
            // return  result.toString().trim();

        }



}

/*
TIME COMPLEXITY = O(n*L + m*k)

O(n*L) = Time to make trie
n - roots in dictionary
L - average length of root in dictionary

 O(m*k) = Time to find replacement words in sentence = length of sentence (excluding space)
 m - words in sentence
 k - average length of word in sentence

 TIME COMPLEXITY = O(n*L + m*k)

 n*L - trie size
 m*k - result string builder size
*/