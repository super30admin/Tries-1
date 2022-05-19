//time - O(nk + nk) - O(nk)
//space - O(nk)
//DFS solution
class Solution {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    int max;
    String result;

    public String longestWord(String[] words) {

        if(words==null || words.length==0) return "";

        root = new TrieNode();
        max = 0;
        result = "";

        fillTrie(words);

        for(String s : words) //time - O(n)
            dfs(root, s, 0, 0);

        return result;
    }

    private void fillTrie(String[] words){ //time - O(nk)
        for(String s : words){
            TrieNode curr = root;
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(curr.children[ch-'a']==null)
                    curr.children[ch-'a'] = new TrieNode();
                curr = curr.children[ch-'a'];
                if(i==s.length()-1) curr.isEnd = true;
            }
        }
    }

    private void dfs(TrieNode curr, String s, int index, int count){//time - O(length of result), space - O(length of result)
        if(count==max){
            if(result.compareTo(s) > 0)
                result = s;
        }
        else if(count > max){
            max = count;
            result = s;
        }

        if(index==s.length()) return;

        char ch = s.charAt(index);
        curr = curr.children[ch-'a'];

        if(curr.isEnd){
            dfs(curr, s, index+1, count+1);
        }

        else return;
    }
}
