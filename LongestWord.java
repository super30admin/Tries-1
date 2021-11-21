//Time Complexity: O(n where n is the legnth of all the words combined)
//Space Complexity: O(n where n is the legnth of all the words combined)

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
            if(s.length()>1)
                sub[index].insert(s.substring(1));
            else if(s.length()==1)
                sub[index].isTerminated = true;
        }

        private String longestWord(){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(sub[i] !=null && sub[i].isTerminated){
                    String s = sub[i].longestWord();
                    if(sb.length()<1+s.length())
                        sb = new StringBuilder((char)(i+'a')+s);
                }
            }
            return sb.toString();
        }
    }
    public String longestWord(String[] words) {
        Trie root = new Trie();
        for(String word:words)
            root.insert(word);

        return root.longestWord();
    }
}