import java.util.Arrays;
//Time Complexity: length of word array * maxnumber of letterin eachword *log N(as we are sorting the array)
//Space complexity: length of word array * max number of letter in word
class LongestWordInDictionary {
    class Trie{
        Trie[] children;
        boolean isEnd;
        Trie(){
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }
    Trie root;
    StringBuilder str;
    public String longestWord(String[] words) {
        Arrays.sort(words);
        root = new Trie();
        str = new StringBuilder();
        for(String word: words){
            Trie node = root;
            int index = 0;

            while(index < word.length() && node.children[word.charAt(index) - 'a'] != null){
                node = node.children[word.charAt(index) - 'a'];
                index++;
            }

            if(index == (word.length()-1)){
                node.children[word.charAt(index) - 'a'] = new Trie();
                if(word.length()> str.length()) str = new StringBuilder(word);

            }
        }

        return str.toString();

    }
}
