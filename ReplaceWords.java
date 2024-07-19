import java.util.List;

/***
 Using Trie
 TC - O(k*l) + O(m*n) {k - no of words in dict, l = average length of each word in dict, m = no of words in sentence,
 n = average length of each word in sentence}
 SC - O(k*l) + O(n)
 */

class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;

        public TrieNode() {
            isEnd = false;
            child = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = root;

        for(int i =0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new TrieNode();
            }
            curr = curr.child[ch - 'a'];
        }

        curr.isEnd = true;

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for(String str : dictionary) {
            insert(str);
        }

        String[] strArray = sentence.split(" ");
        StringBuilder answer = new StringBuilder();
        for(int index=0; index < strArray.length; index++) {
            if(index != 0)
                answer.append(" ");

            String str = strArray[index];
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();

            for(int i =0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if(curr.child[ch - 'a'] == null || curr.isEnd == true) {
                    break;
                }

                else{
                    sb.append(ch);
                    curr = curr.child[ch - 'a'];
                }
            }

            if(curr.isEnd) {
                answer.append(sb);

            }
            else
                answer.append(str);
        }

        return answer.toString();

    }
}