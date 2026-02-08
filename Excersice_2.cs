
public class Node{
    public Node[] children;
    public bool isEnd;
    public Node(){
        children = new Node[26];
        isEnd  = false;
    }
}

public class Solution {
    public Node root = new Node();

    public string LongestWord(string[] words) {
       

        for(int i = 0 ;i<words.Length;i++){
         insert(words[i]);
        }

    Queue<Node> q = new Queue<Node>();
    Queue<string> sq = new Queue<string>();

    q.Enqueue(root);
   
    string currstr = "";
 sq.Enqueue(currstr);
    while(q.Any()){
        Node curr = q.Dequeue();
         currstr = sq.Dequeue();

        for(int i = 25 ; i>=0 ; i-- ){
            Node child = curr.children[i];
            if(child != null && child.isEnd){
                q.Enqueue(curr.children[i]);
                string recent = currstr+ (char)('a' + i); 
                sq.Enqueue(recent);
            }
        }
    }
    return currstr;
    }


    public void insert(string s){
        Node curr = root;
     
        for(int i=0;i<s.Length;i++){
            int idx = s[i] - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
}