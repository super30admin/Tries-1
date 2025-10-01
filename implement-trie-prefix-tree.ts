class TrieNode {
	children?: TrieNode[];
	isEnd: boolean;
	constructor() {
		this.children = new Array(26);
		this.isEnd = false;
	}
}

// Time Complexity: O(L) for all operations, where L is the length of the word
// Space Complexity: O(N*L), where N is number of words and L is average word length
class Trie {
	root: TrieNode;
	readonly A_CHAR_CODE = "a".charCodeAt(0);
	constructor() {
		this.root = new TrieNode();
	}

	insert(word: string): void {
		let curr = this.root;

		for (let i = 0; i < word.length; i++) {
			let index = word.charCodeAt(i) - this.A_CHAR_CODE;
			if (!curr.children[index]) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.isEnd = true;
	}

	search(word: string): boolean {
		let curr = this.root;

		for (let i = 0; i < word.length; i++) {
			let index = word.charCodeAt(i) - this.A_CHAR_CODE;
			if (!curr.children[index]) {
				return false;
			}
			curr = curr.children[index];
		}
		return curr.isEnd;
	}

	startsWith(prefix: string): boolean {
		let curr = this.root;

		for (let i = 0; i < prefix.length; i++) {
			let index = prefix.charCodeAt(i) - this.A_CHAR_CODE;
			if (!curr.children[index]) {
				return false;
			}
			curr = curr.children[index];
		}
		return true;
	}
}
