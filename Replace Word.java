// Time Complexity: O(m^2 * L ^2) m is the number of words and L is the length of the word
class Solution {
    TrieNode root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        // O(n*L)
        for(String s: dictionary){
            insert(s);
        }

        String words[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        

        for(int i=0; i<words.length; i++){
            String word = words[i];
            StringBuilder sc = new StringBuilder();
            for(char c: word.toCharArray()){
                sc.append(c);
                if(search(sc.toString())){
                    sb.append(sc);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                sb.append(word);
            }
            flag = false;
            if(i<words.length -1)
                sb.append(" ");

        }
        return sb.toString();

    }


    class TrieNode{
        boolean isEnd;
        TrieNode children[];

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private void insert(String s){
        TrieNode curr = root;
        for(char c: s.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a']  = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }


    private boolean search(String s){
        TrieNode curr = root;
        for(char c: s.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
}