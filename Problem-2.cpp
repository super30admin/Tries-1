//NOT a trie solution. Will do it over weekend for interview
//O(nlogn)+O(n), time + space complexity
//I'm still practicing tries, so this is a makeshift, is accepted on LC as well
//iterate over sorted words, use hashset to build the solution and go on, pretty intuitive thought process
class Solution {
public:
    string longestWord(vector<string>& words) {
        sort(words.begin(), words.end());
      
        unordered_set<string> built;
        string res;
        for (string w : words) {
          //this is O(1) because strings are mutable in C++. can't recommejava because substr does a deep copy there then erases words
            if (w.size() == 1 || built.count(w.substr(0, w.size() - 1))) {
                res = w.size() > res.size() ? w : res;
                built.insert(w);
            }
        }
        return res;
    }
};
