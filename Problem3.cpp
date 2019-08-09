//
// Created by shazm on 8/8/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    int longestPalindrome(string s) {
        map<char,int> hashmap; int retVal = 0;
        for(int x = 0; x<s.size(); x++){
            bool temp = hashmap.insert(pair<char,int>(s[x],1)).second;
            if(!temp){
                hashmap[s[x]]+=1;
                if(hashmap[s[x]]==2){
                    retVal+=2; hashmap[s[x]] = 0;
                }
            }
        }

        map<char,int>::iterator it = hashmap.begin();
        while(it!=hashmap.end() && (*it).second!=1){
            it++;
        }
        if(it!=hashmap.end() && (*it).second==1){retVal++;}
        return retVal;
    }
};