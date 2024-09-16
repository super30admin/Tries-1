class Solution {

    //Time Complexity : 0(nk) where n:length of the words array and k is the length of each word in the array
    //Space Complexity: 0(nk) where n:length of the words array and k is the length of each word in the array
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief explain your approach

    class TrieNode{ //we use a trie appoach hence we create a tirenode class
        TrieNode[] children;    //children of each 26 character
        String word;    //we will store the word at the end
        public TrieNode(){
            children = new TrieNode[26];    //initialization
        }
    }
    TrieNode root;  //to navigate the trienode

    public void insert(String s){   //passing each word in the array to create a trienode
        TrieNode current = root;    //initializing current to the root
        for(int i = 0; i < s.length(); i++){    //traversing through the word
            char c = s.charAt(i);   //extracting each character at a time
            if(current.children[c - 'a'] == null){  //if there is no trienode declared at the character we initialize a child
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];    //once initialized, we move the current pointer to that child character
        }
        current.word = s;   //we store the word passed at the last child to mark true or to denote that this word is present in the array of words
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words){   //we go through every word and create a trienode
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>(); //we create a queue for BFS traversal
        TrieNode a = new TrieNode();    //to store the trienode popped out of the queue
        q.add(root);    //add root to the queue initially
        while(!q.isEmpty()){    //checking if the queue is empty or not
            a = q.poll();
            for(int i = 25; i >= 0 ; i--){  //traversing from the last character and checking at each instance if word is there or not indicating that the parts of the word are present in the array
                if(a.children[i] != null && a.children[i].word != null){
                    q.add(a.children[i]);   //if yes, then adding that word or tienode to the queue
                }
            }
        }
        if(a.word == null){ //if bottom up navigation does not encounter a word at every intercal means that all the character that form the longest word are not present in the array
            return "";  //so we return null string
        }
        return a.word;  //if all the characters are present then our current will be pointing to that trienode which will inturn hold the word
    }
}

