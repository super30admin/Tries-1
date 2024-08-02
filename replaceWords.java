/*
TC --> O(n*l)
SC --> O(n*l)
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

    Node head = new Node();

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

        }
        curr.flag = true;

    }

    public String Search(String word) {
        Node curr = head;
        int val = 0;
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            val = c - 'a';
            if (curr.links[val] == null) {
                return word;
            } else if (curr.links[val].flag) {
                st.append(c);
                return st.toString();
            } else {
                st.append(c);
                curr = curr.links[val];
            }

        }
        return st.toString();

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (int i = 0; i < dictionary.size(); i++) {
            insert(dictionary.get(i));
        }//for
        String[] words = sentence.split(" ");
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            st.append(Search(words[i]));
            st.append(" ");

        }//
        st.setLength(st.length() - 1);

        //System.out.print(st);
        return st.toString();

    }

}
