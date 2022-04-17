package dictionary;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * class MockDictionary
 * authors: Petrea Daniela & Stoica Dragos
 */

public class MockDictionary {
    private ArrayList<String> result=new ArrayList<String>();
    private int ok=0;

    /**
     * we store in a arraylist the dictionary words from the text file
     * @throws IOException
     */
    public MockDictionary() throws IOException
    {
        Scanner s = new Scanner(new File("C:\\Users\\Daniela-211021\\IdeaProjects\\Lab7-Homework\\words.txt"));
        while (s.hasNext()){
            result.add(s.next());
        }
        s.close();

    }
    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public int getOk() {
        return ok;
    }


    public boolean isWord(String word)
    {
        if(result.contains(word))
            setOk(1);
        return result.contains(word);
    }
}
