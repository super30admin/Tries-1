//Problem 1
//TC O(n)
//SC O(1)

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode()
        {
isEnd=false;
children=new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
       TrieNode cur=root;
     for(int i=0;i<word.length();i++)
     {
        char c= word.charAt(i);
        if(cur.children[c-'a']==null)
        {
            cur.children[c-'a']=new TrieNode();
        }
        cur=cur.children[c-'a'];
     }   
     cur.isEnd=true;  
    }
    
    public boolean search(String word) {
    TrieNode cur=root;
    for(int i=0;i<word.length();i++)
    {
        char c= word.charAt(i);
        if(cur.children[c-'a']==null)
        {
            return false;
        }
        cur=cur.children[c-'a'];
    }
    return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
       TrieNode cur=root;
       for(int i=0;i<prefix.length();i++)
       {
        char c=prefix.charAt(i);
        if(cur.children[c-'a']==null)
        {
            return false;
        }
        cur=cur.children[c-'a'];
       } 
       return true;
    }
}

//Problem 2
//TC O(n)
//SC O(1)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        public TrieNode()
        {
            isEnd=false;
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word)
    {
TrieNode cur=root;
for(int i=0;i<word.length();i++)
{
    char c=word.charAt(i);
    if(cur.children[c-'a']==null)
    {
        cur.children[c-'a']=new TrieNode();

    }
    cur=cur.children[c-'a'];
}
cur.isEnd=true;
    }
    public String longestWord(String[] words) {
       if(words==null || words.length==0)
       {
        return "";
       } 
       root=new TrieNode();
       for(int i=0;i<words.length;i++)
       {
        insert(words[i]);
       }
       
 
       TrieNode cur=root;
       String sb="";
          for(int i=0;i<words.length;i++)
       {
        String word=words[i];
        for(int j=0;j<word.length();j++)
        {sb="";
            char c=word.charAt(j);
            if(cur.children[c-'a']!=null || cur.isEnd!=true)
            {
                break;
            }
            sb=sb+c;
            cur=cur.children[c-'a'];
            
        }
       

       }
       return sb.toString();
    }
}


//Problem 3
//TC O(n)
//SC O(1)

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        public TrieNode()
        {
            isEnd=false;
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word)
    {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(cur.children[c-'a']==null)
            {
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.isEnd=true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
      if(sentence==null || sentence.length()==0)
      {
        return sentence;
      }
root=new TrieNode();
for(String word:dictionary)
{
    insert(word);
}
String str[]=sentence.split(" ");
StringBuilder result=new StringBuilder();
for(int i=0;i<str.length;i++)
{ if(i!=0)
        {
            result.append(" ");
        }
    String word=str[i];
    TrieNode cur=root;
    StringBuilder sb=new StringBuilder();
    for(int j=0;j<word.length();j++)
    {
       
        char c=word.charAt(j);
        if(cur.children[c-'a']==null || cur.isEnd==true)
        {
            break;
        }
        sb.append(c);
        cur=cur.children[c-'a'];
        
    }
    if(cur.isEnd)
        {
            result.append(sb);
        }
        else{
            result.append(word);
        }
}
return result.toString();
    }
}