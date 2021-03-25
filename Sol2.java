class Solution {
    public String longestWord(String[] words) {
        
        //Sort the words
        //Then compare the words lexograhically
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        String temp ="";
        String longest = "";
        for(String s : words) {
            if(s.startsWith(temp) && (s.length()-1 == temp.length())) {
                if(s.length() > longest.length()) {
                    longest = s;
                }
                
                temp = s;
                
            }

        }
        return longest;
        
    }
}
