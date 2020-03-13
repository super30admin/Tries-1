// Time Complexity : O(N * L)
// Space Complexity : O(N * L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string[]} words
 * @return {string}
*/

var TrieNode = function() {
    this.word = null;
    this.children = new Array(26);
}

var Trie = function() {
    this.root = new TrieNode();
}
Trie.prototype.insert = function (word) {
    let curr = this.root;
    for (let i = 0; i < word.length; i++) {
        let c = word.charCodeAt(i) - 97;
        if (curr.children[c] == null) {
            curr.children[c] = new TrieNode();
        }
        curr = curr.children[c];
    }
    curr.word = word;
}
var longestWord = function(words) {
    if (!words || !words.length) return '';
    
    let trie = new Trie(),
        q = [trie.root];
    
    // Build the trie
    for (const word of words) {
        trie.insert(word);
    }
    
    // BFS to find longest word
    let curr = null;
    while (q.length > 0) {
        curr = q.shift();
        for (let i = 25; i >= 0; i--) {
            if (curr.children[i] && curr.children[i].word) {
                q.push(curr.children[i]);
            }
        }
    }

    return curr.word;
};
