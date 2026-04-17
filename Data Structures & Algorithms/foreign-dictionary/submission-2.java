class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character,Set<Character>> graph = new HashMap<>();
      HashMap<Character,Integer> indegree = new HashMap<>();
      for(String word:words){
        for(char c:word.toCharArray()){
            graph.putIfAbsent(c,new HashSet<>());
            indegree.putIfAbsent(c,0);
        }
      }
      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        if(word1.length()>word2.length() && word1.startsWith(word2)){
            return "";
        }
        int minLen = Math.min(word1.length(),word2.length());
        for(int j=0;j<minLen;j++){
            char c1=word1.charAt(j);
            char c2=word2.charAt(j);
            if(c1!=c2){
                if(!graph.get(c1).contains(c2)){
                    graph.get(c1).add(c2);
                    indegree.put(c2,indegree.get(c2)+1);
                }
                break;
            }
        }
      }
      Queue<Character> q = new LinkedList<>();
      for(char key:indegree.keySet()){
        if(indegree.get(key)==0){
            q.offer(key);
        }
      }
      StringBuilder res=new StringBuilder();
      while(!q.isEmpty()){
        char p = q.poll();
        res.append(p);
        for(char c:graph.get(p)){
            indegree.put(c,indegree.get(c)-1);
            if(indegree.get(c)==0){
                q.offer(c);
            }
        }
      }
      if(res.length()!=indegree.size()){
        return "";
      }
      return res.toString();
    }
}

