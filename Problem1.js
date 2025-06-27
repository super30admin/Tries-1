// # Tries-1

// ## Problem1 
// Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

class TrieNode{
    //Each Node has an array and a boolean flag to tell if its the end of the word
    constructor(){
        this.childrens = new Array(26) // of type TrieNode
        this.isEnd = false
    }
}

class Trie{
    constructor(){
        //Our trie dictionary has one node because its a tree like ds
        this.root = new TrieNode()
    }

    insert(word){
        //Time Complexity : O(L) l is the length of the word
        //Space O(1) : amortized
//         O(L) in the worst case

// In the worst case (no characters of the word are shared with existing words), you create a new node for each character → L new nodes → O(L) space.

// If all characters are shared with previously inserted words, then it's O(1) — but we typically express the worst-case.

        //Go to the root first node
        let current = this.root
        for(let i =0;i<word.length;i++){
            //find map index value in our 26 sized array
            //map each word to a unique position
            //a->0 and so on
            let position  = word.charCodeAt(i)-"a".charCodeAt(0)
            //if that postion exist
            if(current.childrens[position]){
                //set our current to that postion we already have the first character of the word present
                //we do not create new but we share 
                current = current.childrens[position]
            }   
            else{
                //if not present add and move th current 
                current.childrens[position] = new TrieNode()
                current = current.childrens[position]

            }
        }
        //This means the last node is inserted now turn its boolean flag to true
          current.isEnd = true;
    }
    search(word){
                //Time Complexity : O(L) l is the length of the word
        //Space Complexity : O(1)
        let current = this.root
        for(let i =0;i<word.length;i++){
            let position  = word.charCodeAt(i)-"a".charCodeAt(0)
            //if the node not present in the postion direct return false
                if(!current.childrens[position]){
                    return false
            }
            //else if present keep on going inside 
             current = current.childrens[position]
        }
        //we reached at the last node return if isEnd of that node 
        //if its the last node we must have set ites bool flag as true
        return current.isEnd

    }
    startsWith(prefix){
                //Time Complexity : O(L) l is the length of the prefix
        //Space Complexity : O(1)
        let current = this.root
        for(let i =0;i<prefix.length;i++){
        let position  = prefix.charCodeAt(i)-"a".charCodeAt(0)
            if(!current.childrens[position]){
                return false
            }
             current = current.childrens[position] 
        }
        //here we do not want to find if its the last node or not we just want to tell if it exist
        return true
    }
}
