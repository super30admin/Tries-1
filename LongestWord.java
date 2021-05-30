//Time Complexity: O(n*l) n= num of words, l=avg length of words
//Space Complexity: O(n*l)
//Did it run on leetcode successfully: yes
// Did you face any problem: No
class LongestWord {

    //TrieNode class to store characters
    class TrieNode{
        //marks if it is a word
        boolean isEnd;
        //current word
        String currWord;
        //charcters following current characters
        TrieNode[] children;
        //constructor to create TrieNode
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    //variable to store root of TrieNode
    TrieNode root;
    public Solution(){
        //initializing root
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    //O(l)
    public void insert(String word) {
        //getting root node
        TrieNode curr = root;
        //looping through all characters in word
        for(int i=0; i<word.length(); i++){
            //get current character
            char c = word.charAt(i);
            //if current character not present
            if(curr.children[c-'a']==null){
                //create new TrieNode
                curr.children[c-'a'] = new TrieNode();
            }
            //move current to next or child TrieNode
            curr = curr.children[c-'a'];
        }
        //mark that it is a word
        curr.isEnd = true;
        //set current word
        curr.currWord = word;
    }

    public String longestWord(String[] words) {
        //creating a Trie
        for(String word: words){//n*l
            insert(word);
        }

        //queue for BFS traversal
        Queue<TrieNode> que = new LinkedList<>();
        //adding root to queue
        que.add(root);
        //initializing curr
        TrieNode curr=root;
        //until queue is not empty
        while(!que.isEmpty()){//
            //get size
            int size = que.size();
            //for current level
            for(int j=0; j<size; j++){
                //get first element in queue
                curr = que.poll();
                //traversing through all children in reverse direction
                for(int i=curr.children.length-1; i>=0; i--){

                    //if children is a word in input array
                    if(curr.children[i]!=null && curr.children[i].isEnd){

                        // add to quueue
                        que.add(curr.children[i]);
                    }
                }

            }

        }
        //curr node is not a word
        if(curr.currWord==null) return "";
        //return the last child
        return curr.currWord;
    }
}