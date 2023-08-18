// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes



class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < words.length; i++){
            set.add(words[i]);
        }

        Queue<String> q = new LinkedList<>();

        q.add("");
        String prev = "";

        while(!q.isEmpty()){
            String s = q.poll();
            prev = s;
            for(int i = 25; i >=0 ; i--){
                String key = s + String.valueOf((char) ('a' + i));
                if(set.contains(key)){
                    q.add(key);;
                }
            }
        }
        return prev;
    }
}