var replaceWords = function (dictionary, sentence) {
  class TrieNode {
    constructor(char) {
      this.char = char;
      this.isEndWord = false;
      this.children = [];
    }
  }

  class Trie {
    constructor() {
      this.root = new TrieNode("");
    }

    getIndex(char) {
      return char.charCodeAt(0) - "a".charCodeAt(0);
    }

    insert(dictionary) {
      let currentNode = this.root;
      for (const word of dictionary) {
        for (let i = 0; i < word.length; i++) {
          let char = word[i];
          if (currentNode.children[this.getIndex(char)] === undefined) {
            currentNode.children[this.getIndex(char)] = new TrieNode(char);
          }
          currentNode = currentNode.children[this.getIndex(char)];
        }
        currentNode.isEndWord = true;
        currentNode = this.root;
      }
    }

    search(splitSentenceArr) {
      let currentNode = this.root;
      for (let word = 0; word < splitSentenceArr.length; word++) {
        let tempString = "";
        for (let i = 0; i < splitSentenceArr[word].length; i++) {
          let char = splitSentenceArr[word][i];
          if (currentNode.children[this.getIndex(char)] === undefined) {
            break;
          } else {
            tempString += currentNode.children[this.getIndex(char)].char;
            if (currentNode.children[this.getIndex(char)].isEndWord) {
              splitSentenceArr[word] = tempString;
              break;
            }
            currentNode = currentNode.children[this.getIndex(char)];
          }
        }
        currentNode = this.root;
      }
      return splitSentenceArr.join(" ");
    }
  }

  const trie = new Trie();
  trie.insert(dictionary);
  const splitArr = sentence.split(" ");
  return console.log(trie.search(splitArr));
};

replaceWords(["cat", "bat", "rat"], "the cattle was rattled by the battery");
