class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        int count=0;
        q.offer(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();
        vis.add(beginWord);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            while(size!=0){
                String word = q.poll();
                char[] arr = word.toCharArray();
                for(int i=0;i<word.length();i++){
                    for(char c = 'a'; c<='z';c++){
                        if(word.charAt(i)==c){
                            continue;
                        }
                        arr = word.toCharArray();
                        arr[i]=c;
                        String newWord = new String(arr);
                        if(vis.contains(newWord)){
                            continue;
                        }
                        vis.add(newWord);
                        if(wordSet.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return count+1;
                            }
                            q.offer(newWord);
                        }

                    }
                }
                size--;
            }
        }
        return 0;
    }
}
