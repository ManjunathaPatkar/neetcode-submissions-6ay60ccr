class Solution {
    class Trie{
        HashMap<Character,Trie> child;
        String word;
        Trie(){
            child = new HashMap<>();
        }
    }
    Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        Trie t =root;
        for(String word:words){
            t=root;
            for(char c :word.toCharArray()){
                if(!t.child.containsKey(c)){
                    t.child.put(c,new Trie());
                }
                t=t.child.get(c);
            }
            t.word = word;
        }
        List<String> res = new ArrayList<>();
        Trie node;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                node =root;
                dfs(board,i,j,res,node);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, List<String> res,Trie node){
        if(board[i][j]=='#'){
            return;
        }
        if(!node.child.containsKey(board[i][j])){
            return;
        }
        node = node.child.get(board[i][j]);
        if(node.word!=null){
            res.add(node.word);
            node.word = null;
        }
        char temp =board[i][j];
        board[i][j]= '#';
        if(i>0){
            dfs(board,i-1,j,res,node);
        }
        if(j>0){
            dfs(board,i,j-1,res,node);
        }
        if(i<board.length-1){
            dfs(board,i+1,j,res,node);
        }
        if(j<board[i].length-1){
            dfs(board,i,j+1,res,node);
        }
        board[i][j] =temp;

    }
}
