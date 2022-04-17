package dictionary;

/**
 * class TrieNode
 * authors: Petrea Daniela & Stoica Dragos
 */
class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode(){
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
};
