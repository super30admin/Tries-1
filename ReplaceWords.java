//Time Complexity: O(n*l for creating Trie + N*l for looping through each word in input string and checking for prefix) where n=number of words in dictionary, N=number of word in input string, l= average length of each word
//Space Complexity: O(n*l+N*l)
//Did it run on leetcode successfully: yes
// Did you face any problem: No
class ReplaceWords {
    //TrieNode class to store characters
    class TrieNode{
        //marks if it is a word
        boolean isEnd;
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
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        //creating a Trie
        //for each word in dictionary
        for(String word: dictionary){//O(n.l)
            //insert into Trie
            insert(word);
        }
        //split input string into words
        String[] splitArray = sentence.split("\\s+");
        //variable to store results
        StringBuilder result = new StringBuilder();

        //check if word present in Trie
        //for each word in string
        for(int i=0; i<splitArray.length; i++){//O(N*l)
            //if it is not the first word
            if(i!=0){
                //add space before the word
                result.append(" ");
            }
            //variable to store current traversed word in Trie
            StringBuilder sb = new StringBuilder();
            //getting root of TrieNode
            TrieNode curr = root;
            //getting current input word
            String word = splitArray[i];
            //for each character in string
            for(int j=0;j<word.length(); j++){
                //get current character
                char c = word.charAt(j);
                //no child of current char or curr is a word
                if(curr.children[c-'a']==null||curr.isEnd){
                    break;
                }
                //add curr char to current traverse
                sb.append(c);
                //move curr to next node or children node
                curr = curr.children[c-'a'];
            }
            //if it is a word
            if(curr.isEnd){
                //add current traversed to result
                result.append(sb.toString());
            }//if it is not a word or not found
            else{
                //add current word in string to result
                result.append(word);
            }
        }

        //return result
        return result.toString();
    }
}