class ReplaceWords {

    //Time Commplexity: n x k (number of words in trie x length of words) + L (l being the length of the word)
    //Space Complexity: O (nk)

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }

        String[] arr = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int j=0; j<arr.length; j++) {
            if (j > 0) {
                result.append(" ");
            }
            StringBuilder replacment = new StringBuilder();
            TrieNode curr = root;

            for (int i=0; i<arr[j].length(); i++) {
                char c = arr[j].charAt(i);
                if (curr.children[c-'a'] == null || curr.isEnd) break;

                curr = curr.children[c-'a'];
                replacment.append(c);

            }
            if (curr.isEnd) {
                result.append(replacment);
            } else {
                result.append(arr[j]);
            }
        }

        return result.toString();

    }
}