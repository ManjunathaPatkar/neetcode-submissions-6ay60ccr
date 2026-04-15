class PrefixTree {
    Trie root;
    // HashMap<Character,PrefixTree> root;
    class Trie{
        HashMap<Character,Trie> trie;
        Trie(){
            trie = new HashMap<>();
        }
    }
    public PrefixTree() {
    //    HashMap<Character,PrefixTree> trie=new HashMap<>();
        root = new Trie();
    }

    public void insert(String word) {
        HashMap<Character,Trie> trie = root.trie;
        int i=0;
        while(i<word.length()){
            if(!trie.containsKey(word.charAt(i))){
            trie.put(word.charAt(i),new Trie());
            }
            trie = trie.get(word.charAt(i)).trie;
            i++;
        }
        trie.put('A',new Trie());
    }

    public boolean search(String word) {
        HashMap<Character,Trie> trie = root.trie;
        int i=0;
        while(i<word.length()){
            if(!trie.containsKey(word.charAt(i))){
                return false;
            }
            trie = trie.get(word.charAt(i)).trie;
            i++;
        }
        return trie.containsKey('A');
    }

    public boolean startsWith(String prefix) {
        HashMap<Character,Trie> trie = root.trie;
        int i=0;
        while(i<prefix.length()){
            if(!trie.containsKey(prefix.charAt(i))){
                return false;
            }
            trie = trie.get(prefix.charAt(i)).trie;
            i++;
        }
        return true;
    }
}
