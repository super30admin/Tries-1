
class Solution {
    Node root;
    class Node{
        boolean flag;
        Node[] children = new Node[26];
        public Node(){
            flag = false;
        }
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null){
                temp.children[c-'a'] = new Node();
            }
            temp = temp.children[c-'a'];
        }
        temp.flag = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        for(String str : dictionary) //m *l
            insert(str);
        
        String[] splitSen = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<splitSen.length;i++){
            String word = splitSen[i];
            StringBuilder replacement = new StringBuilder();
            Node curr = root;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a'] == null || curr.flag)
                    break;
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.flag){
                result.append(replacement);
            }else{
                result.append(word);
            }
            result.append(" ");
        }
        result.setLength(result.length()-1);
        return result.toString();
    }
}
