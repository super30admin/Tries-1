// Replace Words (https://leetcode.com/problems/replace-words/)

// TC: O(nk) n is the number of words in sentence; k is the length of longest word in dictionary
// SC: O(n) Size of trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class TrieNode {
    constructor() {
        this.children = new Array(26);
        this.isEnd = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }
    insert = function (word) {
        let curr = this.root;
        // Insert word in trie
        for (let i = 0; i < word.length; i++) {
            let ch = word[i];
            let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
            if (!curr.children[index]) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index]
        }
        curr.isEnd = true;
    }

    getSuccessor = function (word) {
        let curr = this.root;
        for (let i = 0; i < word.length; i++) {
            let ch = word[i];
            let index = ch.charCodeAt(0) - 'a'.charCodeAt(0);
            if (!curr.children[index]) {
                return word;
            }
            if (curr.children[index].isEnd) {
                return word.slice(0, i + 1);
            }
            curr = curr.children[index];
        }
        return word;
    }

}

/**
 * @param {string[]} dictionary
 * @param {string} sentence
 * @return {string}
 */
var replaceWords = function (dictionary, sentence) {
    if (dictionary === null || dictionary.length == 0)
        return sentence;
    if (sentence === null)
        return "";
    let trie = new Trie();
    for (let i = 0; i < dictionary.length; i++)
        trie.insert(dictionary[i]);

    let result = [];
    let words = sentence.split(/\s+/);
    for (let i = 0; i < words.length; i++) {
        let word = words[i];
        // Get successor if exists or return the word
        result.push(trie.getSuccessor(word));
    }

    return result.join(" ");
};