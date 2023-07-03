
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    string longestWord(vector<string>& words) {
        string ans="";
        unordered_set<string> s(words.begin(),words.end());
        for(auto x:words){
            int i=0;
            while(i<x.size()){
                if(s.find(x.substr(0,i+1))!=s.end())
                    i++;
                else break;
            }
            if(i==x.size()){
                if(x.size()>ans.size()){
                    ans=x;
                }
                if(x.size()==ans.size()){
                    ans=min(ans,x);
                }
            }
        }
        return ans;
    }
};