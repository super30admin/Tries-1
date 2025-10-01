// Problem - Longest word in dictionary
//  Time Complexity : O(nl)
//  Space Complexity : O(nl) where l is avg length of word
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first build a trie wit the given words
// 2. Now we use recursive approach and keep track of the path and only visit
// nodes which are not null
// and have isEnd equal to true
// 3. We keep updating the result and in the end return it

#include <bits/stdc++.h>
using namespace std;

class TrieNode {
public:
  bool isEnd;
  TrieNode *children[26];
  TrieNode() {
    this->isEnd = false;
    for (int i = 0; i < 26; i++) {
      children[i] = nullptr;
    }
  }
};

class Solution {
public:
  string result = "";
  void insert(string word, TrieNode *root) {
    TrieNode *curr = root;
    for (auto ch : word) {
      int idx = ch - 'a';
      if (curr->children[idx] == nullptr) {
        curr->children[idx] = new TrieNode();
      }
      curr = curr->children[idx];
    }
    curr->isEnd = true;
  }

  string longestWord(vector<string> &words) {
    TrieNode *root = new TrieNode();
    for (auto word : words) {
      insert(word, root);
    }
    dfs(root, "");
    return result;
  }

  void dfs(TrieNode *root, string path) {
    // base
    if (path.size() > result.size()) {
      result = path;
    }
    // logic
    for (int i = 0; i < 26; i++) {
      if (root->children[i] != nullptr && root->children[i]->isEnd) {
        path.push_back('a' + i);
        dfs(root->children[i], path);
        path.pop_back();
      }
    }
  }
};
