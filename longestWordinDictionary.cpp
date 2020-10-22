//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using set
//any issues faced? yes


class Solution {
public:
    string longestWord(vector<string>& words) {
        string res="";
        set<string>set;
        sort(words.begin(),words.end());
        for(string w:words)
        {
            if(w.size()==1 || set.find(w.substr(0,w.size()-1))!=set.end())
            {
                if(w.size()>res.size())
                    res=w;
                set.insert(w);
            }
               
        }
        return res;
    }
};