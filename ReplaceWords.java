/**
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie tr = new Trie();
        tr.add(dict);
        return tr.newSentence(sentence);
    }
}

class Trie{
    class Node{
        char ch;
        TreeMap<Character, Node> child;
        boolean isLast;
        Node(char ch, boolean last){
            this.ch = ch;
            this.isLast = last;
            child = new TreeMap<>();
        }
    }

    Node head;
    Trie(){
        head = new Node(' ', false);
    }

    public void add(List<String> dict){
        for(String word : dict){
            Node node = head;
            int indx = 0;

            while(indx < word.length()){
                char ch = word.charAt(indx++);
                Node cnode = node.child.getOrDefault(ch, null);
                if(cnode == null){
                    cnode = new Node(ch, false);
                    node.child.put(ch, cnode);
                }
                node = cnode;
            }
            node.isLast = true;
        }
    }

    public String newSentence(String sen){
        String wordList[] = sen.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word: wordList){

            if(sb.length() > 0 )
                sb.append(" ");

            StringBuilder temp = new StringBuilder();
            Node node = head;
            int indx = 0;
            while(indx < word.length()){
                char ch = word.charAt(indx++);
                Node cnode = node.child.getOrDefault(ch, null);

                if(cnode == null)
                    break;

                temp.append(ch);
                node = cnode;

                if(cnode.isLast)
                    break;
            }
            if(temp.length() == 0 || !node.isLast){
                sb.append(word);
            }
            else{
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
