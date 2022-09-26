/* 
Time Complexity: O(N)
Space Complexity: O(N)
*/
class Trie {
    boolean end = false;
    Trie a[] = new Trie[26];
}

class Solution {
    public String replaceWords(List<String> d, String sentence) {
	
        Trie trie = new Trie();
		
        String str[] = sentence.split(" ");
		
        for (int i = 0; i < d.size(); i++) {
            insert(d.get(i), trie);
        }
		
        for (int i = 0; i < str.length; i++) {
            str[i] = replace(trie, str[i]);
        }
		
        StringBuilder sb = new StringBuilder();
		
        sb.append(str[0]);
		
        for (int i = 1; i < str.length; i++) {
            sb.append(" ");
            sb.append(str[i]);
        }
		
        return sb.toString();
    }

    public void insert(String str, Trie trie) {
	
        Trie temp = trie;
		
        for (int i = 0; i < str.length(); i++) {
            if (temp.a[str.charAt(i) - 'a'] == null) {
                temp.a[str.charAt(i) - 'a'] = new Trie();
                temp = temp.a[str.charAt(i) - 'a'];
            } else {
                temp = temp.a[str.charAt(i) - 'a'];
            }
        }
        temp.end = true;
    }

    public String replace(Trie trie, String s) {
	
        Trie temp = trie;

        StringBuilder sb = new StringBuilder();
		
        if (temp.a[s.charAt(0) - 'a'] == null) {
			return s;
		}

        for (int i = 0; i < s.length(); i++) {
            if (temp.a[s.charAt(i) - 'a'] != null) {
                temp = temp.a[s.charAt(i) - 'a'];
                sb.append(s.charAt(i));
            } else {
                return s;
            }
            if (temp.end == true) return sb.toString();
        }
        return s;
    }
}