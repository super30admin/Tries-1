// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Initialize your data structure here.
 */
var TrieNode = function () {
    this.isEnd = false;
    this.children = new Array(26);
}
var Trie = function() {
    this.root = new TrieNode();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let curr = this.root;
    for (let i = 0; i < word.length; i++) {
        let c = word.charCodeAt(i) - 97;
        if (curr.children[c] == null) {
            curr.children[c] = new TrieNode();
        }
        curr = curr.children[c];
    }
    curr.isEnd = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let curr = this.root;
    for (let i = 0; i < word.length; i++) {
        let c = word.charCodeAt(i) - 97;
        if (curr.children[c] == null) return false;
        curr = curr.children[c];
    }
    return curr.isEnd;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let curr = this.root;
    for (let i = 0; i < prefix.length; i++) {
        let c = prefix.charCodeAt(i) - 97;
        if (curr.children[c] == null) return false;
        curr = curr.children[c];
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
