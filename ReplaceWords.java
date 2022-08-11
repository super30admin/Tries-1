//Time Complexity: O(nl + mk), where n is the number of words in the dict and l is the average length of each word, m is the numbers of words in the sentence and k is the average length of each word.
//Space Complexity: O(nl), where n is the number of words in the dict and l is the average length of each word (for constructing the dict(Trie))
//Did it run successfully on leetcode: Yes
//Did you face any issues coding the solution: No


class ReplaceWords {
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private void insert(String word) {
        //root is the empty trienode
        TrieNode curr = root;

        //For every character in a word, check if a trie node already exists for that character
        //If it already exists, go to the next character or else create a new trie node for that character
        //When the end of the word is reached, mark that character as end of the word.
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        //base case
        if(dictionary.size() == 0) return sentence;

        for(String word: dictionary) {
            insert(word);
        }

        //check if there is any prefix word for the given word (sentence) in the dictionary.
        //If yes, replace the original word with the word in the dict and return the sentence.
        String[] splitStrings = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < splitStrings.length; i++) {
            if(i != 0) result.append(" ");
            String word = splitStrings[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(curr.children[c-'a'] == null || curr.isEnd) {
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            //replace the word with dict word
            if(curr.isEnd) result.append(sb.toString());
            //append the original word
            else result.append(word);
        }

        return result.toString();
    }
}