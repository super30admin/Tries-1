// Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

// Time Complexity

// Space Complexity


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

var TrieNode = function() {
    this.children = new Array(26);
    this.isEnd = false;
}

var Trie = function() {
    this.root = new TrieNode();
};

/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let curr = this.root;
    for(let i=0; i<word.length; i++){
        let ch = word[i];
        let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        if(!curr.children[index]){
            curr.children[index] = new TrieNode();      
        }
        curr = curr.children[index];
    }
    curr.isEnd = true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let curr = this.root;
    for(let i=0; i<word.length; i++){
        let ch = word[i];
        let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        if(!curr.children[index]){
            return false;
        }
        curr = curr.children[index];
    }
    return curr.isEnd;
};

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let curr = this.root;
    for(let i=0; i<prefix.length; i++){
        let ch = prefix[i];
        let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
        if(!curr.children[index]){
            return false;
        }
        curr = curr.children[index];
    }
    return true;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */