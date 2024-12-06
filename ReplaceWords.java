// Approach : Using HashSet
// Time : O(mXl^2)
// space : O(N*L) 
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary); // O(N*L)
        StringBuilder result = new StringBuilder(); // for building result

        // split the sentence into words
        String[] splitArr = sentence.split(" "); // split on spaces
        // search each word in Trie and see if there is shortest version
        for(int i =0;i<splitArr.length;i++){
            if(i>0) result.append(" ");
            boolean flag = false;
            String word = splitArr[i];
            for(int j=0;j<word.length();j++){ // O(l)
                String subStr = word.substring(0,j+1);// O(l)
                if(set.contains(subStr)){
                    result.append(subStr);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.append(word);
            }
        }
        return result.toString();

    }
}

// Approach : Using Trie
// Time : O(nl) + O(ml) + O(ml) // n- Total no of words in dict insert into Trie & split m words in sentence of len l & search
// space : O(nl) + O(ml) // store the words of dict in Trie & store the words of sentence in a temp array
class Solution {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = this.root; // take curr pointer on root of the Trie
        for(char ch:word.toCharArray()){
            if(curr.children[ch-'a']== null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
        return;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder(); // for building result
        this.root = new TrieNode(); // create object for Trie Node
        // insert all words of Dict into Trie
        for(String word: dictionary){
            insert(word);
        }

        // split the sentence into words
        String[] splitArr = sentence.split(" "); // split on spaces
        // search each word in Trie and see if there is shortest version
        for(int i =0;i<splitArr.length;i++){
            if(i>0) result.append(" ");
            result.append(getShortestVersion(splitArr[i]));
        }

        return result.toString();
    }

    private String getShortestVersion(String word){
        StringBuilder result = new StringBuilder();
        TrieNode curr = this.root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null || curr.isEnd){
                break;
            } else{
                curr= curr.children[ch-'a'];
                result.append(ch);
            }
        }
        if(curr.isEnd){
            return result.toString();
        } 
        return word;
    }
}