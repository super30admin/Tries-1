class Solution {
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }


    private void insert(String word){
        TrieNode curr =root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for(int i=0;i<splitArr.length;i++){
            if(i>0) sb.append(" ");
            sb.append(getsversion(splitArr[i]));
        }

        return sb.toString();
    }

    private String getsversion(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null || curr.isEnd){
                break;
            }
            curr=curr.children[c-'a'];
            sb.append(c);

            if(curr.isEnd){
                return sb.toString();
            }
        }

        return word;
    }
}