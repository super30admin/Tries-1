// Time Complexity: O(N*L), where N is number of words and L is average word length
// Space Complexity: O(N*L)
function longestWord(words: string[]): string {
	class TrieNode {
		children: (TrieNode | undefined)[];
		isEnd: boolean;

		constructor() {
			this.children = new Array(26).fill(undefined);
			this.isEnd = false;
		}
	}

	let root = new TrieNode();
	const A_CHAR_CODE = "a".charCodeAt(0);
	let result = "";

	for (let word of words) {
		insert(word);
	}

	dfs(root, "");
	return result;

	function dfs(curr: TrieNode, currStr: string) {
		if (currStr.length > result.length) {
			result = currStr;
		}

		for (let i = 0; i < 26; i++) {
			const child = curr.children[i];

			if (!!child && child.isEnd) {
				const nextChar = String.fromCharCode(i + A_CHAR_CODE);
				dfs(child, currStr + nextChar);
			}
		}
	}

	function insert(word: string) {
		let curr = root;
		for (let i = 0; i < word.length; i++) {
			const index = word.charCodeAt(i) - A_CHAR_CODE;
			if (!curr.children[index]) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.isEnd = true;
	}
}
