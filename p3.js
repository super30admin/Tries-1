// ## Problem3
// Replace Words (https://leetcode.com/problems/replace-words/)

// Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
// Output: "the cat was rat by the bat"

// time: O(nk + lk)
// space: O(n)


/**
 * @param {string[]} dict
 * @param {string} sentence
 * @return {string}
 */
var alphabet = { 
    'a': 0, 
    'b': 1,
    'c': 2,
    'd': 3,
    'e': 4,
    'f': 5,
    'g': 6,
    'h': 7,
    'i': 8,
    'j': 9,
    'k': 10,
    'l': 11,
    'm': 12,
    'n': 13,
    'o': 14,
    'p': 15,
    'q': 16,
    'r': 17,
    's': 18,
    't': 19,
    'u': 20,
    'v': 21,
    'w': 22,
    'x': 23,
    'y': 24,
    'z': 25
}
class TrieNode {
    word;
    children = [];   
}
let root = new TrieNode();
function insert(word) {
    let cur = root;
    let char;
    for(let i = 0; i < word.length; i++) {
        char = word[i];
        if(!cur.children[alphabet[char]]) cur.children[alphabet[char]] = new TrieNode();
        cur = cur.children[alphabet[char]];
    }
    cur.word = word;
}

const replaceWords = function(dict, sentence) {
    for(let str of dict) { //nk + lk
        insert(str);
    }
    let sentenceArr = sentence.split(' '); 
    let originalArr = sentence.split(' '); 
    for(let k = 0; k < sentenceArr.length; k++) {
        let cur = root;
        for(let j = 0; j < sentenceArr[k].length; j++) {
            let char = sentenceArr[k][j];
            if(!cur.children[alphabet[char]] || cur.word) break;
            cur = cur.children[alphabet[char]];
        }
        if(cur.word) {
            sentenceArr[k] = cur.word;
        }
    }
    return sentenceArr.join(' ');
}