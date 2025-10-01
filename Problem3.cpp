// Problem - Replace words
//  Time Complexity : O(ml + nl)
//  Space Complexity : O(ml + nl) where l is avg length of word
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first build a trie of the dictionary words
// 2. Now we split the sentence and capture the shortest prefix for the given
// word using our trie
// 3. In the end, we keep joining our words and return the result

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

  void insert(string word, TrieNode *root) {
    TrieNode *curr = root;
    for (char ch : word) {
      int idx = ch - 'a';
      if (curr->children[idx] == nullptr) {
        curr->children[idx] = new TrieNode();
      }
      curr = curr->children[idx];
    }
    curr->isEnd = true;
  }

  string shortVersion(string word, TrieNode *root) {
    TrieNode *curr = root;
    string res = "";
    for (char ch : word) {
      int idx = ch - 'a';
      if (!curr->children[idx] || curr->isEnd)
        break;
      res += (char)('a' + idx);
      curr = curr->children[idx];
    }
    return curr->isEnd ? res : word;
  }

public:
  string replaceWords(vector<string> &dictionary, string sentence) {
    TrieNode *root = new TrieNode();
    for (string word : dictionary) {
      insert(word, root);
    }
    istringstream iss(sentence);
    string word;
    string result;
    bool first = true;
    while (iss >> word) {
      if (!first)
        result += " ";
      result += shortVersion(word, root);
      first = false;
    }

    return result;
  }
};
