// Time Complexity : O(N) //number of characters
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.children = new Map();
    this.isEnd = false;
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let curr = this
    for(let i = 0; i < word.length; i++){
        let node = curr.children.get(word[i])
        if(!node){
            node = new Trie();
            curr.children.set(word[i], node);
        }
        curr = node
    }
    curr.isEnd = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let curr = this;
    for(let i = 0; i < word.length; i++){
        if(!curr.children.has(word[i])) return false
        let node = curr.children.get(word[i])
        if(!node) return false
        curr = node
    }
    return curr.isEnd;
    
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let curr = this;
    for(let i = 0; i < prefix.length; i++){
        if(!curr.children.has(prefix[i])) return false
        let node = curr.children.get(prefix[i])
        if(!node) return false
        curr = node
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