import java.util.*;
public class ReplaceWords {
    

    class TrieNode{

        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word)
    {
        TrieNode curr = root;

        for(int i =0;i<word.length();i++)
        {
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }

        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence)
    {
        root = new TrieNode();

        if(dictionary == null || dictionary.size() == 0)
        {
            return sentence;
        }

        for(String word: dictionary)
        {
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        String[] splitArray = sentence.split(" ");

        for(int i =0;i<splitArray.length;i++)
        {
            String word = splitArray[i];

            StringBuilder newString = new StringBuilder();
            TrieNode curr = root;

            for(int j = 0;j<word.length();j++)
            {
                char c =  word.charAt(j);

                if(curr.children[c-'a'] == null || curr.isEnd)
                {
                    break;
                }

                newString.append(c);
                curr = curr.children[c-'a'];
            }

            if(curr.isEnd)
            {
                result.append(newString);
            }
            else{
                result.append(word);
            }

            result.append(" ");
        }

        return result.toString().trim();


    }


}
