package S30_Codes.Tries_1;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestWordInDictionary {
}
// TC : O(n*l)
// SC : O(n*l)

class TrieNode2 {
    private boolean isWord;
    private Map<Character, TrieNode2> children;
    TrieNode2(){
        isWord = false;
        children = new HashMap<>();
    }

    public TrieNode2 createOrGetChild(char c){
        if(!this.children.containsKey(c))
            this.children.put(c, new TrieNode2());
        return this.children.get(c);
    }

    public Map<Character, TrieNode2> getChildren(){
        return this.children;
    }

    public void setIsWord(boolean flag){
        this.isWord = flag;
    }

    public boolean getIsWord(){
        return this.isWord;
    }
}

class Trie2 {
    TrieNode2 root;

    Trie2(){
        root = new TrieNode2();
    }

    public void insert(String word){
        TrieNode2 node = root;
        for(int i=0; i<word.length(); i++){
            node = node.createOrGetChild(word.charAt(i));
        }
        node.setIsWord(true);
    }
}


class Solution{
    Trie2 t = new Trie2();
    StringBuilder curWord;
    String ans;

    public String longestWord(String[] words) {
        ans = new String();
        for(String word : words){
            t.insert(word);
        }

        Queue<Pair<TrieNode2,StringBuilder>> queue = new LinkedList<>();
        for (Map.Entry<Character, TrieNode2> entry : t.root.getChildren().entrySet()) {
            Character ch = entry.getKey();
            TrieNode2 node = entry.getValue();

            if(node.getIsWord()){
                queue.add(new Pair(node, new StringBuilder().append(ch)));
            }
        }

        while(!queue.isEmpty()){
            Pair<TrieNode2,StringBuilder> p = queue.remove();
            TrieNode2 node = p.getKey();
            StringBuilder curWord = p.getValue();

            if(node.getIsWord()){
                if( ans.length() < curWord.length() ||
                        (ans.length() == curWord.length() && ans.compareTo(curWord.toString()) > 0) ){
                    ans = curWord.toString();
                }

                for (Map.Entry<Character, TrieNode2> entry : node.getChildren().entrySet()) {
                    Character ch = entry.getKey();
                    node = entry.getValue();

                    queue.add(new Pair(node, new StringBuilder(curWord).append(ch)));
                }
            }

        }

        return ans;
    }


}