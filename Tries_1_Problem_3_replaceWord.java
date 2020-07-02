import java.util.List;
//Time Complexity : O(n) (Where n = number of words in sentence + number of words we need to enter into trie)
//Space Complexity : O(n) (Where n = number of words we need to enter into the trie)
//Runs successfully on leetcode
//No problem

//Here we will be entering all the given words of dict into our trie
//After that we'll be checking for all the words in the given sentence if prefix of that word exists in the dict or not
//If there exists a prefix, we'll be replacing it by our word


public class Tries_1_Problem_3_replaceWord {
    TrieNode root;
    String out = "";
    public String replaceWords(List<String> dict, String sentence) {

        root = new TrieNode();
        for(String str : dict)
        {
            insertIntoTrie(str);
        }

        String[] words = sentence.split("\\s+");
        for(int i = 0 ; i < words.length ; i ++)
        {
            String word = words[i];
            TrieNode temp = root;
            String replace = "";
            for(int j = 0; j < word.length() ; j ++)
            {
                char c = word.charAt(j);
                if(temp.children[c - 'a'] == null || temp.word != null) break;
                temp = temp.children[c - 'a'];
            }
            if(temp.word == null)
            {
                replace = word;
            }
            else
            {
                replace = temp.word;
            }
            out = out + replace + " ";

        }



        return out.substring(0,out.length()-1);

    }


    public void insertIntoTrie(String word)
    {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ;i++)
        {
            if(temp.children[word.charAt(i) - 'a'] == null)
            {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        temp.word = word;
    }

    class TrieNode
    {
        String word;
        TrieNode[] children;
        TrieNode()
        {
            word = null;
            children = new TrieNode[26];
        }
    }
}
