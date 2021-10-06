class replace_Words {

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
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String str : dictionary)
            insert(str);
        String[] splitArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < splitArr.length; i++) {
            if (i != 0)
                result.append(" ");
            String word = splitArr[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) {
                result.append(replacement);
            } else {
                result.append(word);
            }

        }
        return result.toString();
    }
}