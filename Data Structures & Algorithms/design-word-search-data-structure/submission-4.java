class WordDictionary {
    Trie root;
    class Trie {
        HashMap<Character,Trie> trie;
        boolean end;
        Trie(){
            trie = new HashMap<>();
            end = false;
        }
    }
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        HashMap<Character,Trie> trie = root.trie;
        Trie prev =root;
        for(char c:word.toCharArray()){
            if(!trie.containsKey(c)){
                trie.put(c,new Trie());
            }
            prev = trie.get(c);
            trie =trie.get(c).trie;
        }
        prev.end = true;
    }

    public boolean search(String word) {
        return helper(word,0,root);
    }

    private boolean helper(String word, int ind,Trie root ){
        if(ind==word.length()){
            return root.end;
        }
        HashMap<Character,Trie> trie = root.trie;
        for(int i=ind;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                if(trie.isEmpty()){
                    return false;
                }
                for(char key:trie.keySet()){
                     if(helper(word,i+1,trie.get(key))){
                        return true;
                     }
                }
                return false;
            }else{
                if(!trie.containsKey(c)){
                    return false;
                }
                root = trie.get(c);
                trie = trie.get(c).trie;
            }
        }
        return root.end;
    }
}
