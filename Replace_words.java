// Time Complexity : O(m * l1  + n * l2) where m, l1 are number of words in dictionary and its average length of each string
											//where n, l2 are number of words in sentence and its average length of each string
// Space Complexity : O(m * l1)
// Method used : Tries

class Solution {

    class TrieNode
    {
        TrieNode[] node;
        String result;

        public TrieNode()
        {
            node = new TrieNode[26];
        }
    }

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        StringBuilder result = new StringBuilder();

        for(String word : dictionary) insert(word);

        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++)
        {
            String temp = search(words[i]);

            if(temp == null) result.append(words[i]);

            else result.append(temp);

            if(i != words.length - 1) result.append(" ");
        }

        return result.toString();
        
    }

    public void insert(String word) {

            TrieNode temp = root;
            
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);

                if(temp.node[c - 'a'] == null) temp.node[c - 'a'] = new TrieNode();

                temp = temp.node[c - 'a']; 
            }

            temp.result = word;
        }
        
        public String search(String word) {
            
            TrieNode temp = root;
            
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);

                if(temp.node[c - 'a'] == null)
                {
                    return temp.result;
                }

                else if(temp.result != null) return temp.result;

                temp = temp.node[c - 'a']; 
            }

            return word;
        }
}