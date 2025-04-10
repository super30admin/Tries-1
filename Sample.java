class Sample{
    /***************PROBLEM-2*******************/
    //TC:0(n*k)
    //SC:0(n)
    class Solution {
        TrieNode root;
        public String replaceWords(List<String> dictionary, String sentence) {
            if(sentence==null || sentence.length()==0 || dictionary.size()==0 || dictionary==null){
                return sentence;
            }

            root=new TrieNode();
            for(String word:dictionary){
                insert(word);
            }

            String[] split=sentence.split(" ");
            StringBuilder answer=new StringBuilder();
            for(int i=0;i<split.length;i++){
                if(i!=0){
                    answer.append(" ");
                }
                String word=split[i];
                TrieNode curr=root;
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<word.length();j++){
                    char each=word.charAt(j);
                    if(curr.children[each-'a']==null || curr.isEnd==true){
                        break;
                    }
                    sb.append(each);
                    curr=curr.children[each-'a'];
                }

                if(curr.isEnd==true){
                    answer.append(sb.toString());
                }else{
                    answer.append(word);
                }
            }
            return answer.toString();
        }

        private class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children=new TrieNode[26];
                isEnd=false;
            }
        }

        private void insert(String word){
            TrieNode curr=root;
            for(char each:word.toCharArray()){
                if(curr.children[each-'a']==null){
                    curr.children[each-'a']=new TrieNode();
                }
                curr=curr.children[each-'a'];
            }
            curr.isEnd=true;
        }
    }

    /***********************PROBLEM-1*******************/

    class Trie {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children=new TrieNode[26];
                isEnd=false;
            }
        }
        TrieNode root;
        public Trie() {
            root=new TrieNode();
        }
        //TC:0(N)
        //SC:0(1)
        public void insert(String word) {
            TrieNode curr=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null){
                    curr.children[c-'a']=new TrieNode();
                }
                curr=curr.children[c-'a'];
            }
            curr.isEnd=true;
        }
        //TC:0(N)
        //SC:0(1)
        public boolean search(String word) {
            TrieNode curr=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null){
                    return false;
                }
                curr=curr.children[c-'a'];
            }
            return curr.isEnd;
        }
        //TC:0(N)
        //SC:0(1)
        public boolean startsWith(String prefix) {
            TrieNode curr=root;
            for(int i=0;i<prefix.length();i++){
                char c=prefix.charAt(i);
                if(curr.children[c-'a']==null){
                    return false;
                }
                curr=curr.children[c-'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**********************PROBLEM-3**********************/

}