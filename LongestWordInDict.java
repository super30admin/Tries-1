//T.C O(n*L) collective length of all the words in the input array
//S.C O(n)
//Successful executed in leetcode : yes
//Solution: Sorting the array lexicographically also brings small words to front and long words at back.
// Maintain a Hashset for all the words and check for each word, the corresponding substring words are already in the hashset.
import java.util.Arrays;
import java.util.HashSet;

class LongestWordInDict {
    public String longestWord(String[] words) {
        HashSet<String> h = new HashSet<String>();
        String result = new String();
        Arrays.sort(words);//O(nlogn)
        for(String w : words){ //O(n)
            h.add(w);
        }
        for(String w: words){//O(n)
            int len = w.length();
            while(len>1){
                if(!h.contains(w.substring(0,len-1)))
                    break;
                len--;
            }
            if(len==1 && w.length()>result.length())
                result = w;
        }
        return result;
    }
}