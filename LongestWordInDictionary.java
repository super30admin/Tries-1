/*Time Complexity: O(n)
Space Complexity: O(n)*/


class Solution {
    public String longestWord(String[] words) {

        Arrays.sort(words);
        HashSet<String> buildWords = new HashSet<>();
        String result = "";

        for(String word:words)
        {
            if(word.length() == 1 || buildWords.contains(word.substring(0,word.length()-1)))
            {
                if(word.length() > result.length())
                {
                    result = word;
                }
                buildWords.add(word);
            }
        }
        return result;
    }
}
