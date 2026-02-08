public class Solution {
    public Node root = new Node();
    public string ReplaceWords(IList<string> dictionary, string sentence) {
     string [] parts = sentence.Split(' ');
        for(int i = 0 ; i<dictionary.Count ; i++){
            insert(dictionary[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<parts.Length ; i++){

                sb.Append(searchandreplace(parts[i]));
                if(i<(parts.Length-1)){
                 sb.Append(" ");
                }
        }
        return sb.ToString();
    }

    public string searchandreplace(string s){
        StringBuilder sb= new StringBuilder();
        Node curr = root;
        for(int i = 0 ;i<s.Length; i++){
            int idx = s[i] - 'a';
            if(curr.children[idx] == null){
                break;
            }
             sb.Append(s[i]);
            curr = curr.children[idx];
            if(curr.IsEnd){
               return sb.ToString();
            }
        }
        return s;
    }
    public void insert(string s) {
        Node curr = root;
        for(int i = 0;i<s.Length; i++) {
            int idx = s[i] - 'a';
            if(curr.children[idx] == null ) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
         curr.IsEnd = true;
    }
    
}

public  class Node{
    public Node[] children = new Node[26];
    public bool IsEnd;

    public Node (){
        for(int i = 0 ;i<26 ; i++){
            children[i] = null;
        }
        IsEnd = false;
    }
}