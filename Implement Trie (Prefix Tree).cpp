//Time Complexity- O(n)
//Space Complexity- O(1)

struct trieNode{
    
    trieNode *children[26];
    bool isEndHere;
};

trieNode *getnode(){
    trieNode* temp=new trieNode;
    for(int i=0;i<26;i++){
        temp->children[i]=NULL;
    }
    temp->isEndHere=false;
    return temp;
}

class Trie {
public:
    
    trieNode* root;
    Trie() {
        root=getnode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        
        trieNode *crawl=root;
        for(int i=0;i<word.size();i++){
            
            int index=word[i]-'a';
            if(!crawl->children[index]){
                crawl->children[index]=getnode();
            }
            crawl=crawl->children[index];
        }
        crawl->isEndHere=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        
        trieNode* crawl=root;
        for(int i=0;i<word.size();i++){
            
            int index=word[i]-'a';
            if(!crawl->children[index]){
                return false;
            }
            crawl=crawl->children[index];
        }
        
        return (crawl!=NULL && crawl->isEndHere);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        
        trieNode* crawl=root;
        for(int i=0;i<prefix.size();i++){
            
            int index=prefix[i]-'a';
            if(!crawl->children[index]){
                return false;
            }
            crawl=crawl->children[index];
        }
        
        return (crawl!=NULL);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */