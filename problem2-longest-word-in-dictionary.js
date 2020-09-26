//https://leetcode.com/problems/longest-word-in-dictionary
//// Time Complexity : O(N^N)
//// Space Complexity : O(N^N)
//// Did this code successfully run on Leetcode : yes and no :( there's a bug for some cases
//// Any problem you faced while coding this :

// hard to debug

//// Your code here along with comments explaining your approach

// insert each word in the trie
// traverse each trie child, stop when .word is ''
// return the last word
var Trie, charToIndex, dfs, longestWord;

charToIndex = function(char) {
  return char.charCodeAt() - 'a'.charCodeAt();
};

Trie = function() {
  return Object.assign(Object.create(Trie.prototype), {
    children: Array(26),
    word: ''
  });
};

Trie.prototype.insert = function(word) {
  var ch, curr, j, ref, x;
  curr = this;
  for (x = j = 0, ref = word.length; (0 <= ref ? j < ref : j > ref); x = 0 <= ref ? ++j : --j) {
    ch = word[x];
    if (curr.children[charToIndex(ch)] == null) {
      curr.children[charToIndex(ch)] = Trie();
    }
    curr = curr.children[charToIndex(ch)];
  }
  return curr.word = word;
};

dfs = function(root, result) {
  var i, j, results;
  if (root.word.length > result.length) {
    result.push(root.word);
  }
  results = [];
  for (i = j = 0; j < 26; i = ++j) {
    if (root.children[i] && root.children.word !== '') {
      results.push(dfs(root.children[i], result));
    } else {
      results.push(void 0);
    }
  }
  return results;
};

longestWord = function(words) {
  var result, root;
  if ((words == null) || words.length === 0) {
    return '';
  }
  root = Trie();
  words.forEach(function(word) {
    return root.insert(word);
  });
  result = [];
  dfs(root, result);
  return result[result.length - 1];
};

longestWord(["w"]);

//longestWord(["w","wo","wor","worl", "world"])

//# sourceMappingURL=problem2-longest-word-in-dictionary.js.map
