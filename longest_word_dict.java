/**
 * Time: O(m*n) m-length of the input array n-length of the longest string in the given input array
 * Space: O(m*n)
 */
class TNode{
    TNode[] child;
    boolean isEnd;

    TNode(){
        child = new TNode[26];
        isEnd = false;
    }
}
class Solution {
    TNode root = new TNode();

    public String longestWord(String[] words) {
        TNode obj = root;
        int flag = 0;
        Arrays.sort(words);
        String res = " ";
        int maxlen = 0;

        for(String str: words){
            int size = 0 ;
            obj = root;
            flag = 0;
            while(size < str.length()-1){
                if(obj.child[str.charAt(size)-'a'] == null ){
                    flag = 1;
                    obj.child[str.charAt(size)-'a'] = new TNode();
                }
                obj = obj.child[str.charAt(size)-'a'];
                if(obj.isEnd == false) flag = 1;
                size++;
            }
            obj.child[str.charAt(str.length()-1)-'a'] = new TNode();
            obj = obj.child[str.charAt(str.length()-1)-'a'];
            obj.isEnd = true;

            if(flag == 0 && maxlen < str.length()){
                maxlen = str.length();
                res = str;
            }
        }
        return res;
    }
}