class ReplaceWords {
    // Time Complexity : O(MxN) + O(K) | M : AVG length of a dict string | N : total number of strings | K : words in a sentance
    // Space Complexity : O(MxN) | Trie space created
    // Leetcode : Yes


    // Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    // Output: "the cat was rat by the bat"

    class TrieNode {
      boolean isEnd;
      TrieNode[] childrens;

      public TrieNode(){
        isEnd = false;
        childrens = new TrieNode[26];
      }
    }

    TrieNode root;

    public ReplaceWords(){
      root = new TrieNode();
    }

    public void insert(String word){
      TrieNode curr = root;

      for(int i = 0; i < word.length(); i++){
          char c = word.charAt(i);

          if(curr.childrens[c - 'a'] == null){
             curr.childrens[c - 'a'] = new TrieNode();
          }

          curr = curr.childrens[c - 'a'];
      }
      curr.isEnd = true;

    }


    public String replaceWords(List<String> dictionary, String sentence) {
      if(dictionary == null || sentence == null || dictionary.size() == 0) return sentence;

      for(String word : dictionary){
        insert(word);
      }

      StringBuilder currReplacementBuilder;
      StringBuilder result = new StringBuilder();
      TrieNode curr;
      String[] splitArr = sentence.split("\\s+");

      for(int k = 0; k < splitArr.length; k++){
        curr = root;
        currReplacementBuilder = new StringBuilder();
        String currStr = splitArr[k];
        if(k > 0){
          result.append(' ');
        }

        for(int i = 0; i < currStr.length(); i++){

          char c = currStr.charAt(i);

          if(curr.childrens[c - 'a'] == null || curr.isEnd){
            break;
          }
          currReplacementBuilder.append(c);
          curr = curr.childrens[c - 'a'];
        }

         System.out.println();

        if(curr.isEnd){
          result.append(currReplacementBuilder);
        }else{
          result.append(currStr);
        }

      }

      return result.toString();

    }
}
