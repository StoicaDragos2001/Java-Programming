import dictionary.MockDictionary;
import java.io.IOException;
import java.util.List;

/**
 * class Main
 * authors: Petrea Daniela & Stoica Dragos
 */
public class Main {

    public static void main(String args[]) throws IOException {

        MockDictionary dictionary=new MockDictionary();
        System.out.println("Words with prefix ye");
        dictionary.searchPrefix("ye");
        List<String> prefixList;
        prefixList=dictionary.searchPrefixParallelStreams("ye");
        System.out.println(prefixList);
        System.out.println("---------------------------------------------");
        System.out.println("Words with prefix yea");
        dictionary.searchPrefix("yea");
        prefixList=dictionary.searchPrefixParallelStreams("yea");
        System.out.println(prefixList);
        System.out.println("---------------------------------------------");
        if(dictionary.isWordInTrie("yes") == true)
            System.out.println("yes: present in trie");
        else System.out.println("yes: not present in trie");
        if(dictionary.isWordInTrie("yeszx") == true)
            System.out.println("yeszx: present in trie");
        else System.out.println("yeszx: not present in trie");
        System.out.println("---------------------------------------------");
        if(dictionary.isPrefixInTrie("ye"))
            System.out.println("ye: prefix in trie");
        else
            System.out.println("ye: not prefix in trie");
        System.out.println("----------------------------------------------");
        long startTime = System.nanoTime();
        if(dictionary.isPrefixInTrie("yepp"))
            System.out.println("yepp: prefix in trie");
        else
            System.out.println("yepp: not prefix in trie");
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        long startTime1 = System.nanoTime();
        prefixList=dictionary.searchPrefixParallelStreams("yepp");
        if(prefixList.isEmpty())
            System.out.println("yepp: not prefix");
        else
            System.out.println("yepp: prefix");
        long endTime1   = System.nanoTime();
        long totalTime1 = endTime1 - startTime1;
        System.out.println(totalTime1);
    }
}