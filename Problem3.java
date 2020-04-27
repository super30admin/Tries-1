// Time Complexity - O(L) l = maxlength of word
// Space Complexity - O(L)

class Solution {

    class TrieNode{
        TrieNode[] children;
        String str;
        TrieNode(){
            children = new TrieNode[26];
            str = "";
        }
    }

    TrieNode root;

    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        insert(dict);

        String[] splits = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String split : splits){
            sb.append(find(split));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    private String find(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            if(curr.str != ""){
                return curr.str;
            }
            if(curr.children[ch-'a'] == null){
                break;
            }
            curr = curr.children[ch-'a'];
        }
        return word;
    }

    /** Inserts a words into the trie. */
    private void insert(List<String> dicts) {
        for(String word: dicts){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a'] == null)
                    curr.children[ch-'a'] = new TrieNode();

                curr = curr.children[ch-'a'];
            }
            curr.str = word;
        }
    }
}