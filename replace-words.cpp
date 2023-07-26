// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

class TrieNode {
public:
    char c;
    unordered_map<char, TrieNode*> map;
    bool isWord;

    TrieNode(char c) : c(c), isWord(false) {}
};

class Solution {
public:
    string replaceWords(vector<string>& dict, string sentence) {
        TrieNode* root = new TrieNode('-');

        for (const string& word : dict) {
            insert(root, word);
        }

        string result;
        string delimiter = " ";
        size_t pos = 0;

        while ((pos = sentence.find(delimiter)) != string::npos) {
            string word = sentence.substr(0, pos);
            result += getRoot(root, word) + " ";
            sentence.erase(0, pos + delimiter.length());
        }

        result += getRoot(root, sentence);

        return result;
    }

    void insert(TrieNode* node, const string& word) {
        TrieNode* temp = node;
        for (char c : word) {
            if (temp->map.find(c) != temp->map.end()) {
                temp = temp->map[c];
            } else {
                temp->map[c] = new TrieNode(c);
                temp = temp->map[c];
            }
        }
        temp->isWord = true;
    }

    string getRoot(TrieNode* root, const string& word) {
        TrieNode* temp = root;
        string result;

        for (char c : word) {
            if (temp->map.find(c) != temp->map.end()) {
                temp = temp->map[c];
                result += c;
                if (temp->isWord) {
                    return result;
                }
            } else {
                break;
            }
        }

        return word;
    }
};
