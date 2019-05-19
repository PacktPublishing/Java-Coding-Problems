package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("caret");
        trie.insert("bye");

        System.out.println("Contains 'caret': " + trie.contains("caret"));
        System.out.println("Contains 'by': " + trie.contains("by"));
        System.out.println("Contains 'cat': " + trie.contains("cat"));
    }

}
