// Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

// Time complexity: O(nl); n is the words, l is the average length
// Space complexity: O(nl); n is the words, l is the average length

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class TrieNode {
    constructor() {
        this.children = new Array(26);
        this.word = null;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert = function (word) {
        let curr = this.root;
        for (let i = 0; i < word.length; i++) {
            let ch = word[i];
            let index = ch.charCodeAt(0) - "a".charCodeAt(0);
            if (!curr.children[index]) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index]
        }
        curr.word = word;
    }

}
/**
 * @param {string[]} words
 * @return {string}
 */
var longestWord = function (words) {
    if (words === null || words.length === 0)
        return "";

    let trie = new Trie();

    for (let i = 0; i < words.length; i++) {
        trie.insert(words[i]);
    }

    // BFS
    let queue = [];
    queue.push(trie.root);
    let node = new TrieNode();
    while (queue.length > 0) {
        node = queue.shift();
        for (let i = 25; i >= 0; i--) {
            if (node.children[i] && node.children[i].word !== null) {
                queue.push(node.children[i])
            }
        }
    }
    if (node.word === null)
        return "";
    return node.word;
};