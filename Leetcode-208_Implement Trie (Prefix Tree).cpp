// Time Complexity : O(N*k) for search and insert operations where k is length of string.
// Space Complexity :  O(N*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Node
{
  private:
    
    unordered_map<char, Node*> child;
    bool terminalNode = false;
    char data;
    public:
    
    Node(char d)
    {
        data = d;
    }
    
    int NodeExists(char ch)
    {
        return this->child.count(ch);
    }
    
    Node* getChildNode(char ch)
    {
        if(this->child.count(ch))
            return this->chaild[ch];
        return NULL;
    }
    
    void setChildNode(Node* childNode, char ch)
    {
        this->child[ch]= childNode;
    }
    
    void setToTerminalNode()
    {
        this->terminalNode = true;
    }
    
    bool isTerminalNode()
    {
        return this->terminalNode;
    }
};

class Trie 
{
    Node* root;
public:
    Trie() 
    {
        root = new Node('\n');
    }
    
    void insert(string word) 
    {
        Node * temp= root;
        
        for(int i=0;i<word.size(); i++)
        {
            if(temp->NodeExists(word[i]))
            {
                temp = temp->getChildNode(word[i]);
            }
            else
            {
                Node* newNode = new Node(word[i]);
                temp->setChildNode(newNode, word[i]);
                temp = newNode;
            }
        }
        temp->setToTerminalNode();
    }
    
    bool search(string word) 
    {
        Node * temp = root;
        for(int i=0;i<word.size(); i++)
        {
            if(temp->NodeExists(word[i]))
            {
                temp = temp->getChildNode(word[i]);
            }
            else
                return false;
        }
        
        return temp->isTerminalNode();
    }
    
    bool startsWith(string prefix) 
    {
        Node * temp = root;
        for(int i=0;i<prefix.size(); i++)
        {
            if(temp->NodeExists(prefix[i]))
            {
                temp = temp->getChildNode(prefix[i]);
            }
            else
                return false;
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