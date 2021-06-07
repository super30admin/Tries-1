class ImplementTries {

    
    TrieNode root;
    ImplementTries() {
        root = new TrieNode();
    }

    public TrieNode insert(String word) {
        //TC: O(N) - Where N is length of the word We will traverse all the character.
        //SC: O(N) - Where N is length of the word, At the worst case, fi word doesn't share the prefix , we have to create a saperate node. 
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            int indexOfChar = word.charAt(i) - 'a';
            if(current.children[indexOfChar] == null) {
                current.children[indexOfChar] =  new TrieNode();
            }
            current =  current.children[indexOfChar];
        }
        current.isEnd = true;
        return current;
    }

    public boolean search(String word) {
        //TC: O(N) - Where N is length of the word We will traverse all the character.
        //SC: O(1) - Not storing any extra space which depends on the input.
        TrieNode currentNode = root;
        for(int i =0;i<word.length();i++) {
            int indexOfChar = word.charAt(i) - 'a';
            if(currentNode.children[indexOfChar] == null) return false;
            else {
                currentNode =  currentNode.children[indexOfChar];
            }
        }
        return currentNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        //TC: O(N) - Where N is length of the word We will traverse all the character.
        //SC: O(1) - Not storing any extra space which depends on the input.
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++) {
            int indexOfChar = prefix.charAt(i) - 'a';
            if(current.children[indexOfChar] == null) return false;
            else {
                current = current.children[indexOfChar];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ImplementTries implementTries = new ImplementTries();
        TrieNode insertedNode = implementTries.insert("macbookpro");
        System.out.println("The Inserted value is: "+insertedNode);
        boolean isFound = implementTries.search("macbook");
        System.out.println("The word is found: "+ isFound);
        boolean isPrefixFound = implementTries.startsWith("mac");
        System.out.println("The prefix is found: "+ isPrefixFound);
    }
}