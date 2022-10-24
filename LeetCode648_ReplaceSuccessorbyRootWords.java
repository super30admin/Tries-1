//approach - BF
/*1. take Hashset, add all the words from List to set. 
2. make a string array from sentence by splitting with space 
3. have a new stringbuilder 'answer' created
4. start a for loop over string array, fetch that i into word 
5. create a stringbuilder to store root for the every word
6.nested loop - to traverse over word stored
    a. if we find the substring(0,j+1) into the set, we append it to the root only if it's null, otherwise we will not 
        update if we find the second/larger root than earlier as we just want the smaller root. 
     b. after exhausting the word loop, 
        p.check if i!=0, if it's not first word then append space after every word, 
        q. check if the root is null? then we never found it in set, so just append the exisiting word
        r. else append the root to 'answer'. 
 * TC - O(M*k)+O(N)+O(N*l) ;M= dictionary length, k= avg length of dictionary's words, N= sentence length, l= avg length of sentence words
SC- [O(M*k)for set +O(N*l)for string array + O(N*l) string builder ]
*/

class Solution {
    Set<String> set;
    public String replaceWords(List<String> dictionary, String sentence) {
        set  = new HashSet<>();
        
        if(sentence == null) return "";
        if(dictionary == null ||dictionary.size() == 0) return sentence;
        
        
        //add words from dictionary to set.TC- O(M), sc - O(M*k) ; m= length of the list; k= avg length of the word
        for(int i=0; i < dictionary.size() ; i++)
        {
                set.add(dictionary.get(i));
        }
        
        //string array from sentence -TC- O(N = length of the sentence)
        String[] strArray = sentence.split(" ");
        
        //to append the final result in stringbuilder
        StringBuilder answer = new StringBuilder();
        
        //traversing through string array and each word of it = O(N*l); N = total words, l = avg length of the word
        for(int i =0; i<strArray.length; i++)
        {
            String word = strArray[i];
            StringBuilder root = new StringBuilder();
            
            for(int j=0; j < word.length(); j++)
            {
                if(set.contains(word.substring(0,j+1)))
                   if(root.length() ==0) // weappend the shortest path only
                       root.append(word.substring(0,j+1));
            }
            //after word is exhausted either we found sth or not. will be based on root 
            if(i != 0)
                answer.append(" ");
            
            if(root.length() ==0|| root == null)
                answer.append(word);
            else
                answer.append(root);
        }
        return answer.toString();
    }
}


//approach-2 optimized using Trie
/*
 * 1. insert all the dicitionary word in trie, and mark the end as true for all the words. 
 * 2. get a string array fpr sentence split by space
 * 3. get a string builderfor answer
 * 4. traverse through the array, get one word and process
 *      process -
 *          a. take a stringbuilder rootword
 *          b. extract character at index k and look for it in trie, if not found then break out of word's loop and append the og word. 
 *          c. if found, then update curr to its child, check if flag is true, 
 *                  if flag is true, then append the character to rootword, we found the end so append the rootword to answer and break. 
 *          d. if not, flag = false , then just append ch to rootword. 
 * 5. out of nested fpr loop, check if we got out due t break || due to for loop exhausted?
 * 6. if(rootword length is zero, means we got out due to no char found. ), if we found ength not zero, but leet say we never
 * found the flag to be true then we just ppend tthe og word in this case. 
 *  TC- O(M*k) dictionry adding to trie + O(N*l) looping string and making array + O(N*l) search through trie
 * sc- O(M*k) trie + O(N*l)str array + O(N*l) stringbuilder answer 
 */

class Solution {

    class TrieNode{
        TrieNode children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            //by default, java assigns isEnd = false. 
        }
    }
    TrieNode root = new TrieNode();

    //insert all the children of dictionary to trienode
    private void insert(String word){
        TrieNode curr = root;

        for(int i =0; i< word.length(); i++){
            char ch = word.charAt(i);
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr= curr.children[ch-'a'];
            //check if the character is already there
        }
        //after iterating through the entire word - mark flag true.
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set   = new HashSet<>();

        if(sentence == null) return "";
        if(dictionary == null ||dictionary.size() == 0) return sentence;
        
        //trverse through thr dictionary and add word in tree
        for(int i=0; i< dicitionary.size(); i++){
            insert(dicitionary.get(i));
        }
        
        //split string
        String [] str = sentence.split(" ");

        StringBuilder answer = new StringBuilder();
        //traverse through the str array and check if word exist
        for(int j=0; j < str.length; j++){
            if(j!=0) answer.append(" ");
            
            String word = str[j];
            TrieNode curr = root;
            StringBuilder rootWord = new StringBuilder();

            for(int k=0; k<word.length(); k++){
                char ch = word.charAt(k);
                if(curr.children[ch-'a'] != null)
                {
                    
                    if(curr.childre[ch-'a'] != null){
                        curr = curr.children[ch-'a'];
                        if(curr.isEnd)
                        {
                            rootWord.append(ch);
                            answer.append(rootWord);
                            break; //we stop it right here if root is found.
                        }
                        rootWord.append(ch);//regadless of flag status we are going to append
                    }
                    else
                        break;
                }
                //we never find the flag == true and exhausted the loop || we got out  from else part
                if(rootWord.length() ==0 || curr.isEnd == false)
                    answer.append(word);
            }
            //we never find true flag into the tree and so we come here not finding root, 
            answer.append(word);
        }
        return answer.toString();
    }
}