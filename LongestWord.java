
// Time Complexity: O(N*M) Where N is the number of words and M is the average length of words.
// Space Complexity: O(N*M) Where N is the number of words and M is the average length of words.

class Solution {
    class TrieNode{
        String word;
        TrieNode children[];
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    private void insert(String word){
        if(word==null || word.length()==0) return;
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.word=word;
    }

    public String longestWord(String[] words) {
        if(words==null || words.length==0) return null;

        root=new TrieNode();
        for(String word: words){
            insert(word);
        }

        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        TrieNode curr=null;
        while(!queue.isEmpty()){
            curr = queue.poll();
            for(int i=curr.children.length-1;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].word!=null){
                    queue.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}