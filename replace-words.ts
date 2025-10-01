class TrieNode {
	children?: TrieNode[];
	isEnd: boolean;
	constructor() {
		this.children = new Array(26);
		this.isEnd = false;
	}
}
// Time Complexity: O(M*L + N*L) where M is the number of words in dictionary, N is number of words in sentence and L is the average word length
// Space Complexity: O(M*L + N*L)
function replaceWords(dictionary: string[], sentence: string): string {
	const root = new TrieNode();
	for (let word of dictionary) {
		insert(word);
	}

	let result = "";
	let words = sentence.split(" ");

	for (let i = 0; i < words.length; i++) {
		if (i > 0) result += " ";
		result += getShortestToRoot(root, words[i]);
	}
	return result;

	function insert(word: string): void {
		let curr = root;

		for (let i = 0; i < word.length; i++) {
			let index = word.charCodeAt(i) - "a".charCodeAt(0);
			if (!curr.children[index]) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.isEnd = true;
	}
	function getShortestToRoot(root: TrieNode, word: string) {
		let curr = root;
		let shortestStr = "";
		for (let i = 0; i < word.length; i++) {
			const index = word.charCodeAt(i) - "a".charCodeAt(0);
			if (!curr.children[index]) break;
			curr = curr.children[index];
			shortestStr += word[i];
			if (curr.isEnd) return shortestStr;
		}
		return word;
	}
}
