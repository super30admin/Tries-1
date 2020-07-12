/**
 * Time: O(m*n) m -max(length of dict and words in the sentence) n - length of the word which is bigggest
 * Space: O(m*n)
 */
class TNode{
    TNode[] child;
    boolean isEnd;
    String wrd;
    TNode(){
        child = new TNode[26];
        isEnd = false;
        wrd = null;
    }
}
class Solution {
    TNode root = new TNode();
    public String replaceWords(List<String> dict, String sentence) {
        //insert all the dict words
        for(int i=0;i<dict.size();i++){
            String str = dict.get(i);
            int size = 0;
            TNode obj = root;
            while(size<str.length()){
                if(obj.child[str.charAt(size)-'a'] == null)
                    obj.child[str.charAt(size)-'a'] = new TNode();
                obj = obj.child[str.charAt(size)-'a'];
                size++;
            }
            obj.isEnd = true;
            obj.wrd = str;
        }
        //traverse thr the words of sentence and for each word is there is root word in dict then replace

        StringBuilder sb = new StringBuilder();
        String[] sarr = sentence.split(" ");
        for(String str : sarr){
            int size = 0;
            StringBuilder wb = new StringBuilder();
            TNode obj = root;
            while(size < str.length()){
                if(obj.isEnd){
                    // System.out.println(str+" "+obj.wrd);
                    wb.append(obj.wrd);
                    break;
                }
                else if(obj.child[str.charAt(size)-'a'] == null){
                    wb.append(str);
                    break;
                }

                obj = obj.child[str.charAt(size)-'a'];
                size++;
            }
            if(size == str.length() && obj.isEnd){      //if the length is same of root and the gvn word
                // System.out.println(str+" "+obj.wrd);
                wb.append(obj.wrd);
            }
            if(wb.length() == 0) // if word is smaller there is already a dict word which starts from the                             same letters for ex: actual word in the sentence is s and the dict word is sb
                wb.append(str);
            sb.append(wb);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}