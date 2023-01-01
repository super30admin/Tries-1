// Time Complexity : O(w*l)
// Space Complexity :O(l)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

/* We will use trie to store the words. We will calculate the longest word by doing DFS lexicographically and at each level we would check which was the *longest string
*
*/

class Solution {
    public String longestWord(String[] words) {
        
        Trie root = new Trie();
        // we will add each word from the array into trie
        for(String str:words){ // O(w) --> O(w*l)
            root.insert(str);//O(l)
        }
        // we will then search for the startings in trie and keep adding them into the list , and will store the lexicographically string at each level
        
        return root.calculateLongest();//O(w*l)
        
    }
}


class Trie {
    class TrieNode{
        private TrieNode[] children;
        private Character val;
        private boolean isWord;

        TrieNode(Character newVal){
            val = newVal;
            isWord=false;
            children = new TrieNode[26];
        }
        TrieNode(){
            isWord=false;
            children = new TrieNode[26];
        }
    }
    TrieNode root; // root itself will not have any character associated with it
    Set<Integer> levels;
    String longStr="";

    public Trie() {
        root = new TrieNode();
        levels = new HashSet<Integer>();
    }


    
    public void insert(String word) {
        TrieNode head = root;
        //iterate over array
        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);
            //check if the head children have it

            if(head.children[current - 'a'] == null){
                // start putting chars from here
                head.children[current - 'a'] = new TrieNode(current); //create node with the char in it
            }
             head = head.children[current - 'a']; // move head to the next node
        }
        head.isWord = true;
    }
    
    public String calculateLongest() {
        TrieNode head = root;
        // we will keep adding chars to it, once we find a word, we will add them to the list
        // we will traverse the Trie by DFS but in lexicographical manner
        for(int i=0;i<26;i++){
        DFS(new LinkedList<Character>(),0,head.children[i]);
 
        }
        return longStr;
    }

    private void DFS(LinkedList<Character> list , int level,TrieNode node){
        
        // we will keep on traversing until we find the bottom on the string

        //base case
        if(node == null){
            return;
        }
        //logic
        if(node.isWord){
            // then only append to the string
            list.add(node.val);

        // Add it to the levels as well
        if(!levels.contains(level)){
        // create the string and add it to the array
                StringBuilder str = new StringBuilder();
                for(char c:list){
                    str.append(c);
                }
                String currentString =  str.toString();

                // check for longest string till now

                if(longStr.isEmpty()){
                    longStr = currentString;
                }
                else{
                    //check if this is bigger
                    if(currentString.length()>longStr.length()){
                        longStr = currentString; //make it longest
                    }

                }
                levels.add(level); // adding the indicator that lexicographically the string had been calculated in the level
        }

        //recurse
        int curSize = list.size();
        for(int i=0;i<26;i++){
        DFS(list ,level+1,node.children[i]);// doing DFS in lexicographical
        //backtrack
        if(list.size() > curSize)
        list.removeLast(); //O(1)

        }



        }



    }
    
}