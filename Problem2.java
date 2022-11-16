import java.util.*;

class Problem2 {
    public static List<String> list;
    public static TrieNode root;
    public static HashMap<Integer, List<String>> map;
    public static int maxCount = Integer.MIN_VALUE;

    public static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public static void search(String[] words) {
        for (String str : words) {
            TrieNode curr = root;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                int childIndex = str.charAt(i) - 'a';
                if (curr.isWord) {
                    count++;
                }
                curr = curr.children[childIndex];
            }
            if (count == str.length() - 1) {
                maxCount = Math.max(count, maxCount);
                // System.out.println(str);
                List<String> temp;
                if (map.containsKey(count)) {
                    temp = map.get(count);
                } else {
                    temp = new ArrayList<>();
                }
                temp.add(str);
                map.put(count, temp);
            }
        }
    }

    public static void createDict(String[] words) {
        for (String str : words) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                int childIndex = str.charAt(i) - 'a';
                if (curr.children[childIndex] == null) {
                    curr.children[childIndex] = new TrieNode();
                }

                curr = curr.children[childIndex];
            }
            curr.isWord = true;
        }
    }

    public static String longestWord(String[] words) {
        root = new TrieNode();
        map = new HashMap<>();
        createDict(words);
        search(words);
        // System.out.print(map);
        // System.out.print(maxCount);
        list = map.get(maxCount);
        if (list != null) {
            Collections.sort(list);
            return list.get(0);
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        String answer = longestWord(words);
        System.out.println(answer);
    }
}