//Time Complexity: O(length of string)
//Space Complexity: O(dictionary)
class Solution {
    class Trie{
        boolean isTerminated;
        Trie[] sub;

        Trie(){
            sub = new Trie[26];
        }

        private void insert(String s){
            int index = s.charAt(0) - 'a';
            if(sub[index] == null)
                sub[index] = new Trie();
            if(s.length()==1)
                sub[index].isTerminated = true;
            else
                sub[index].insert(s.substring(1));
        }

        private StringBuilder helper(String s){
            int index = s.charAt(0) - 'a';
            if(sub[index] == null)
                return new StringBuilder(s);
            StringBuilder sb = new StringBuilder(s.substring(0,1));
            if(sub[index].isTerminated || s.length()==1)
                return sb;
            else
                return sb.append(sub[index].helper(s.substring(1)));
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for(String s:dictionary)
            root.insert(s);
        StringBuilder sb = new StringBuilder();
        for(String s:sentence.split(" ")){
            sb = sb.append(" ");
            sb = sb.append(root.helper(s));
        }
        return sb.substring(1);
    }
}