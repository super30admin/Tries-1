// ## Problem3
// Replace Words (https://leetcode.com/problems/replace-words/)
class TrieNode{
    constructor(){
        this.childrens = new Array(26) // of type TrieNode
        this.isEnd = false
    }
}
class Trie{
    constructor(){
        this.root = new TrieNode()
    }

    insert(word){
        let current = this.root
        for(let i =0;i<word.length;i++){
            let position  = word.charCodeAt(i)-"a".charCodeAt(0)
            if(current.childrens[position]){
                current = current.childrens[position]
            }   
            else{
                current.childrens[position] = new TrieNode()
                current = current.childrens[position]

            }
        }
          current.isEnd = true;
    }
    search(word){
        let current = this.root
        for(let i =0;i<word.length;i++){
            let position  = word.charCodeAt(i)-"a".charCodeAt(0)
                if(!current.childrens[position]){
                    return false
            }
             current = current.childrens[position]
        }
        return current.isEnd

    }
    startsWith(prefix){
        let current = this.root
        for(let i =0;i<prefix.length;i++){
        let position  = prefix.charCodeAt(i)-"a".charCodeAt(0)
            if(!current.childrens[position]){
                return false
            }
             current = current.childrens[position] 
        }
        return true
    }
}

var replaceWords = function(dictionary, sentence) {
    //Time Complexity : nl + ml
    //Space Comexplity : nl 
    let obj = new Trie()
    for(let i=0;i<dictionary.length;i++){
        //O(nL + ml)	Space = O(nL )
        // n = number of words in dictionary
        // m = number of words in sentence
        //l is length of word
        obj.insert(dictionary[i])
    }
    //our dictionary is ready
    let str = sentence.split(" ")
    for(let i =0;i<str.length;i++){
        let current = obj.root
        let replacement ="" // this will store the word from
        for(j = 0;j<str[i].length;j++){
            let position  = str[i].charCodeAt(j) - "a".charCodeAt(0)
            if(current.childrens[position]){
                replacement+=str[i][j]
                current = current.childrens[position]
                //We have the first word
                if(current.isEnd){
                    // we replace
                    str[i] = replacement
                     break// shortest
                }   
            }
            else{
                //We dont have the first word   
                // dont do anything
                break
            }
        }
    }
    return str.join(" ")
};