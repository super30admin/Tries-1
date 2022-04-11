//Time Complexity : O(no.of words in dict * avg word length in dict + no.of words in input * avg word length in input)
//Space Complexity : O(no.of words in dict * avg word length in dict + no.of words in input * avg word length in input)

class Solution {

    class TrieNode {

        boolean isEnd;
        TrieNode[] children;

        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word) {

        TrieNode current = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        root = new TrieNode();

        for(String s : dictionary)
        {
            insert(s);
        }

        String[] words = sentence.split(" ");

        //resultant sentence
        StringBuilder result = new StringBuilder();

        for(int i=0; i<words.length; i++)
        {
            TrieNode current = root;
            StringBuilder prefix = new StringBuilder();

            String word = words[i];

            for(int j=0; j<word.length(); j++)
            {
                char c = word.charAt(j);
                //no more chars in the path or path has ended
                if(current.isEnd || current.children[c - 'a'] == null)
                    break;

                current = current.children[c-'a'];
                prefix.append(c);
            }


            if(current.isEnd) //short form found
                result.append(prefix);
            else //short for not found
                result.append(word);

            result.append(" "); //space after every word
        }

        return result.toString().trim(); //remove space after last word
    }
}
