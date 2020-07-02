//Time and Space Complexity :O(m)

class Node{
        char c;
        Node[] arr;
        boolean b;
        
        Node(char c){
            this.c = c;
            this.arr = new Node[26];
        }
    }
    
    Node root;
    public Trie() {
        this.root = new Node('\0');
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                temp = new Node(c);
                node.arr[c - 'a'] = temp;
            }
            node = temp;
        }
        node.b = true;
    }
    

    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                return false;
            }
            node = temp;
        }
        return node.b;
    }
    

    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            Node temp = node.arr[c - 'a'];
            if(temp == null){
                return false;
            }
            node = temp;
        }
        return true;
    }-------------------------------------------------------------------------------------
//Time and Space complexity : O(n)
class TrieNode
{
    TrieNode[] children;
    String word;
    TrieNode()
    {
        children= new TrieNode[26];
    }
    
}

class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root: roots) {
            TrieNode cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}
------------------------------------------------------------------------
class Solution {
     public String longestWord(String[] words) {

         Arrays.sort(words); String retWord = "";

         TrieNode root = new TrieNode('-'); root.isValid = true;

         for(String word:words){

             if(insert(root,word)){

                 if(word.length()>retWord.length()){

                     retWord = word;

                 }

             }

         }

         return retWord;

     }

     public boolean insert(TrieNode root,String word) {

         TrieNode temp = root; TrieNode prev = root; int newCount = 0;

         for(int i=0;i<word.length();i++){

             if(temp.arr[word.charAt(i)-'a']!=null){

                 prev = temp;

                 temp = temp.arr[word.charAt(i)-'a'];

             }

             else{

                 newCount++;

                 prev = temp;

                 temp.arr[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));

                 temp = temp.arr[word.charAt(i)-'a'];

             }

         }

         temp.isWord = true;

         if(newCount==1){

             if(prev.isValid){

                 temp.isValid = true;

                 return true;

             }

             return false;

         }

         return false;

     }

 }


 class TrieNode {

     char c;

     TrieNode[] arr;

     boolean isWord;

     boolean isValid;

     TrieNode(char c){

         this.c = c;

         arr = new TrieNode[26];

         isWord = false;

         isValid = false;

     }

 }


