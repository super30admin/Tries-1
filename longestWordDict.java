/*
TC --> O(n*k)
SC --> O(L)
 */
class Node {

    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[26];
        flag = false;
    }
}

class Solution {

    //HashSet<String> data;
    Node head;
    String res;

    public void insert(String word) {
        Node curr = head;
        int val = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            val = c - 'a';
            if (curr.links[val] == null) {
                curr.links[val] = new Node();

            }
            curr = curr.links[val];
        }//for

        curr.flag = true;

    }//method

    public String longestWord(String[] words) {
        // data = new HashSet<>();
        head = new Node();
        res = new String();
        for (int i = 0; i < words.length; i++) {
            //data.add(words[i]);
            insert(words[i]);

        }//for

        Helper(words, head, new StringBuilder());
        return res;

    }//method

    public void Helper(String[] words, Node node, StringBuilder path) {
        if (node.flag == true && res.length() < path.length()) {
            //System.out.println(path);
            res = new String(path.toString());

        }
        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null && node.links[i].flag) {
                char c = (char) (97 + i);
                path.append(c);
                Helper(words, node.links[i], path);
                path.setLength(path.length() - 1);

            }

        }
    }
}//class
