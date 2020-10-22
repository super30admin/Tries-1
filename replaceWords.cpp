//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using set
//any issues faced? yes

class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
       set<string>set;
        for(auto& word:dictionary)
        {
            set.insert(word);
        }
        stringstream ss(sentence);
        string newsent="";
        string succ;
        while(ss >> succ)
        {
            string str="";
            for(const auto& c:succ)
            {
                str+=c;
                if(set.count(str))
                {
                    succ=str;
                    break;
                }
            }
            if(newsent=="")
                newsent+=succ;
            else
                newsent=newsent+' '+succ;
        }
        return newsent;
    }
};