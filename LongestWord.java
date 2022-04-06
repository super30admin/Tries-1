//Time Complexity O(N)
//space complexity O(26*M*N)
//leetcode tested

public class LongestWord {
    public class Tr{
        Tr children[] = new Tr[26];
        String str;
    }
    public void insert(Tr current, String s){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new Tr();
            }
            current = current.children[c-'a'];
        }
        current.str = s;
    }
    String answer="";
    public String longestWord(String[] words) {
        Tr trie = new Tr();
        for (String word:words) {
            insert(trie,word);
        }
        dfs(trie);
        return answer;
    }

    public void dfs(Tr root){
        for (Tr child: root.children) {
            if(child!=null && child.str!=null){
                if(child.str.length() > answer.length()){
                    answer = child.str;
                }
                dfs(child);
            }
        }
    }
}
