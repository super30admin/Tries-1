class Solution {
    Node root;
    int count = 0;
    String result = "";
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
    
    public String longestWord(String[] words) {
        root = new Node();
        for(String str : words) //m *l
            insert(str);
        dfs(root,new StringBuilder(),0);
        return result;
    }
    
    public void dfs(Node root,StringBuilder path,int cnt){
        //base
            if(cnt>count){
                count = cnt;
                result = path.toString();
            }else if(cnt == count){
                if(path.toString().compareTo(result)<0){
                    result = path.toString();
                }
            }
        //logic
        for(int i = 0;i<root.children.length;i++){
            char c = (char)(i + 'a');
            
            if(root.children[i] != null && root.children[i].flag){  
                cnt++;
                path.append(c);
                dfs(root.children[i],path,cnt);
                cnt--;
                path.setLength(path.length()-1);
            }
        }
    }
}
