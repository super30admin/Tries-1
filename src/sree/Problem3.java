package sree;

import java.util.List;

class Problem3 {
    TrieNode root;
    String result;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root= new TrieNode();
        this.result= "";
        for(String word: dictionary){
            insert(word);

        }
        String[] splitArr= sentence.split(" ");
        for(String word: splitArr){
            String shortWord= getShortestWord(word,root);
            result+=(shortWord+ " ");

        }
        return result.trim();
        
    }

    public String getShortestWord(String word, TrieNode curr){
        StringBuilder sb= new StringBuilder();
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']== null || curr.isEnd){
                break;
            }
            curr= curr.children[c-'a'];
            sb.append(c);
            }
            if(curr.isEnd){
                return sb.toString();
            }
            return word;
        }
    }