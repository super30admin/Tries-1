public class ImplementTrie {
}

//Time Complexity: O(n) n = length of word
//Space Complexity: O(n)

class TrieNode {

    TrieNode[] children;
    boolean end;

    public TrieNode(){                                              //create a TrieNode
        children = new TrieNode[26];                                //children Node
        end = false;                                                //useful to detect if word is ending here or not

    }

}


class Trie {

    private TrieNode root;

    public Trie() {

        root = new TrieNode();                                  //initialize the root
    }

    public void insert(String word) {

        TrieNode node = root;                                   //create node and points it to root

        for(int i=0; i<word.length(); i++){                     //iterate through word

            int index = word.charAt(i) - 'a';                   //get the each character of the word, find get the integer value between 0 to 25
            if(node.children[index] == null){                   //check if at that position, any children is present or not
                node.children[index] = new TrieNode();          //if not, then create a node at that position

            }
            node = node.children[index];                        //move node pointer to that children position
        }
        node.end = true;                                        //means we added a word in trie, so node.end = true

    }

    public boolean search(String word) {

        TrieNode node = root;                               //create node and points it to root

        for(int i=0; i<word.length(); i++){                 //iterate through word

            int index = word.charAt(i) - 'a';                //get the each character of the word, find get the integer value between 0 to 25

            if(node.children[index] == null){               //check if at that position, any children is present or not
                return false;                               //if not present, then return false
            }
            node = node.children[index];                     //move node pointer to that children position
        }

        return node.end;                                    //means, trie have each character as word, now we have to simply see if trie has the word, or becuase of other longer words we got here, so we just simply return node.end, means if trie has the word, then it return true, and if it doen't then it will return false

    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;                               //create node and points it to root

        for(int i=0; i<prefix.length(); i++){                //iterate through word

            int index = prefix.charAt(i) - 'a';                //get the each character of the word, find get the integer value between 0 to 25

            if(node.children[index] == null){                   //check if at that position, any children is present or not
                return false;                                      //if not present, then return false
            }
            node = node.children[index];                    //move node pointer to that children position
        }
        return true;                                        //we reach here, means trie has one of the word starting from the prefix, so return true

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */