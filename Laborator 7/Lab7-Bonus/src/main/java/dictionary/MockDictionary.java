package dictionary;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * class MockDictionary
 * authors: Petrea Daniela & Stoica Dragos
 */
public class MockDictionary {
    private ArrayList<String> result = new ArrayList<String>();
    private int ok = 0;
    static TrieNode root;

    public MockDictionary() throws IOException {
        Scanner s = new Scanner(new File("C:\\Users\\Daniela-211021\\IdeaProjects\\Lab7-Bonus\\words.txt"));
        while (s.hasNext()) {
            result.add(s.next());
        }
        s.close();
        root = new TrieNode();
        for (String index : result)
            insert(index);
    }

        public void setResult (ArrayList < String > result) {
            this.result = result;
        }

        public ArrayList<String> getResult () {
            return result;
        }

        public void setOk ( int ok){
            this.ok = ok;
        }

        public int getOk () {
            return ok;
        }

    /**
     *
     * @param word
     * @return true if the word given is present in the list of strings
     */
        public boolean isWord (String word)
        {
            if (result.contains(word))
                setOk(1);
            return result.contains(word);
        }

    /**
     * Printing strings that contain given prefix
     * @param prefix - we want the words with this prefix
     */
    public void searchPrefix(String prefix) {
        boolean check;
        for (int i = 0; i < result.size(); i++) {
            check = true;
            for (int j = 0, k = 0; j < result.get(i).length() &&
                    k < prefix.length(); j++, k++) {
                if (result.get(i).charAt(j) != prefix.charAt(k)) {
                    check = false;
                    break;
                }
            }
            if(check)
                System.out.println(result.get(i));
        }
    }
    /**
     * We keep in a list strings that contain given prefix with parallel streams
     * @param prefix - we want the words with this prefix
     */
    public List<String> searchPrefixParallelStreams(String prefix){
        final List<String> filteredList = result.parallelStream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
        return filteredList;
    }

    /**
     * If key is not present, inserts key into trie
     * If the key is prefix of trie node, just marks leaf node
     * @param key we want to insert in the trie
     */

        static void insert (String key)
        {
            int indexTrie;
            int length = key.length();
            int index;


            for (indexTrie = 0; indexTrie < length; indexTrie++) {
                index = key.charAt(indexTrie) - 'a';
                if (root.children[index] == null)
                    root.children[index] = new TrieNode();

                root = root.children[index];
            }

            root.isEndOfWord = true;
        }

    /**
     *
     * @param key
     * @return true if key is present in trie, else false
     */
        public static boolean isWordInTrie (String key)
        {
            int level;
            int length = key.length();
            int index;

            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';

                if (root.children[index] == null)
                    return false;

                root = root.children[index];
            }

            return (root.isEndOfWord);
        }

    /**
     *
     * @param prefix
     * @return true if there is a word with the prefix given in the trie
     */
    public static boolean isPrefixInTrie (String prefix)
    {
        int index = 0;
        int n = prefix.length();
        while (index < n)
        {
            int currentIndex = prefix.charAt(index) - 'a';
            if (root.children[currentIndex] == null)
                return false;
            root = root.children[currentIndex];
            index++;
        }
        return true;
    }

    }
