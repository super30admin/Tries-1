//Time COmplexity: O(l*n) l is the averge length of the words and n is number of words
//Space complexity: O(l*n)
//accepted on leetcode
class Solution {
    public String longestWord(String[] words) {
            //Initialise trie and index
            Trie trie = new Trie();
            int index = 0;
            //iterate over the word ans insert the words in trie data structure
            for (String word: words) {
                trie.insert(word, ++index); //indexed by 1
            }
            //initialise trie.words
            trie.words = words;
           //dfs function to recursively check for largest word
            return trie.dfs();
        }
    }
//Node class definition
    class Node 
    {
        char c;
        //Hashmap to store characters
        HashMap<Character,Node> children = new HashMap();
        int end;
        public Node(char c)
        {
            this.c = c;
        }
    }
    //Trie class definition
    class Trie
    {
        
        Node root;
        String[] words;
        //initialise root to 0th node
        public Trie()
        {
            root = new Node('0');
        }
        //Insert function to insert word in trie
        public void insert(String word, int index)
        {
            Node cur = root;
            //check for char in the trie and put if absent
            for(char c: word.toCharArray())
            {
                cur.children.putIfAbsent(c,new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }
        
        //dfs function
        public String dfs()
        {
            //initiate ans string
            String ans = "";
            //stack to push the char
            Stack<Node> stack = new Stack();
            stack.push(root);
            //while stack not empty
            while (!stack.empty())
            {
                //pop stack
                Node node = stack.pop();
                if(node.end >0||node==root)
                {
                    if(node!=root)
                    {
                        String word = words[node.end - 1];
                        //if word length >= ans length 
                        if(word.length() > ans.length() || word.length()==ans.length() && word.compareTo(ans)<0)
                        {
                            //assign ans as word
                            ans=word;
                        }
                    }
                    //push to stack
                    for(Node n: node.children.values())
                    {
                        stack.push(n);
                    }
                }
            }
            //return ans
            return ans;
        }
    }
