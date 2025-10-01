// Problem - Implement Trie prefix tree
//  Time Complexity : O(nl)
//  Space Complexity : O(nl) where l is avg length of word
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We make a trienode with 26 children to represent lowercase chars and have
// a bool flag isEnd to mark end of the word
// 2. For insert, we go through chars of the word, if the node is new we create
// a new TrieNode at that idx and move our curr
// 3.For search, if anywhere we find curr->children[idx] is null, we break, but
// if we don't then we return curr->isEnd
// 4. for startswith, we follow the same approach we did in search but in the
// end we return true because we surely know the prefix does exist

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

class Trie {
public:
  TrieNode *root;
  Trie() { root = new TrieNode(); }

  void insert(string word) {
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

  bool search(string word) {
    TrieNode *curr = root;
    for (char ch : word) {
      int idx = ch - 'a';
      if (!curr->children[idx])
        return false;
      curr = curr->children[idx];
    }
    return curr->isEnd;
  }

  bool startsWith(string prefix) {
    TrieNode *curr = root;
    for (char ch : prefix) {
      int idx = ch - 'a';
      if (!curr->children[idx])
        return false;
      curr = curr->children[idx];
    }
    return true;
  }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
