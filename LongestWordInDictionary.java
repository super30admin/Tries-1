//Time Complexity: O(sum of length of each string in array)
//Space Complexity: O(sum of length of each string in array)

public class LongestWordInDictionary {
    

    public static class TrieNode{
        String word;
        TrieNode[] children;

        TrieNode()
        {
            children = new TrieNode[26];
        }
    }

    public static TrieNode root;
    public static String result = "";

    public static String longestWord(String[] words)
    {
        root = new TrieNode();
        
        if(words == null)
        {
            return result;
        }

        for(String word: words)
        {
            insert(word);
        }

        dfs(root);

        return result;

    }


    public static void insert(String word)
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

        curr.word = word;
    }

    public static void dfs(TrieNode root)
    {
        if(root == null)
        {
            return;
        }

        if(root.word!=null)
        {
            if(root.word.length()>result.length())
            {
                result = root.word;
            }
            else if(root.word.length() == result.length() && root.word.compareTo(result)< 0 )
            {
                result = root.word;
            }
        }

        for(TrieNode child : root.children)
        {
            if(child!=null && child.word!=null)
            {
                dfs(child);
            }
        }
    }


        public static void main(String args[])
        {
            String[] words = {"w","wo","wor","worl","world"};
            System.out.println(longestWord(words));
        }
    }

