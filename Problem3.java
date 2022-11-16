import java.util.*;

class Problem3 {

    public static class TrieNode {
        public HashMap<Integer, TrieNode> children;
        public String word;
        public boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public static TrieNode root;

    public static void buildDict(List<String> dictionary) {
        root = new TrieNode();
        for (String str : dictionary) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                int childIndex = str.charAt(i) - 'a';
                if (!curr.children.containsKey(childIndex)) {
                    curr.children.put(childIndex, new TrieNode());
                }
                curr = curr.children.get(childIndex);
            }
            curr.isWord = true;
            curr.word = str;
            // System.out.println(curr.word);
        }
    }

    public static String search(String[] sentences) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String str : sentences) {
            TrieNode curr = root;
            String temp = rootStr(str, curr);
            if (temp == null) {
                sb.append(str);
            } else {
                sb.append(temp);
            }
            sb.append(" ");
        }
        String answer = sb.toString();
        return answer.substring(0, answer.length() - 1);
    }

    public static String rootStr(String str, TrieNode curr) {
        for (int i = 0; i < str.length(); i++) {
            int childIndex = str.charAt(i) - 'a';
            if (curr == null) {
                break;
            }
            if (curr.isWord) {
                return curr.word;
            }
            curr = curr.children.get(childIndex);
        }
        return null;
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        buildDict(dictionary);
        String[] sentences = sentence.split(" ");
        String s = search(sentences);
        return s;
    }

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList(new String[] { "cat", "rat", "bat" });
        String sentence = "the cattle was rattled by the battery";
        String result = replaceWords(dictionary, sentence);
        System.out.print(result);
    }
}
