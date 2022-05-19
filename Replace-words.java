//time - O(n + mk) n - length of sentence, m - number of words in dictionary, k - avg //length of words in dictionary
//space - O(mk)
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence==null || sentence.length()==0) return "";
        StringBuilder result = new StringBuilder();
        root = new TrieNode();

        for(String word : dictionary){
            fillTrie(word);
        }

        String[] sentenceArray = sentence.split(" ");

        for(String s : sentenceArray){
            String prefix = getPrefix(s);
            if(prefix=="") result.append(s+" ");
            else result.append(prefix+" ");
        }

        return result.toString().trim();
    }

    private void fillTrie(String s){
        TrieNode curr = root;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(curr.children[ch - 'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
            if(i==s.length()-1) curr.isEnd = true;
        }
    }

    private String getPrefix(String s){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(curr.children[ch - 'a']==null){
                break;
            }
            sb.append(ch);
            curr = curr.children[ch-'a'];
            if(curr.isEnd) return sb.toString();
        }
        return "";
    }
}
