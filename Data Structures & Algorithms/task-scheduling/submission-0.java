class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char task:tasks){
            hm.put(task,hm.getOrDefault(task,0)+1);
        }
        int maxCount =0;
        char maxChar='a';
        for(char key:hm.keySet()){
            if(hm.get(key)>maxCount){
                maxCount=hm.get(key);
                maxChar=key;
            }
        }
        int noOfMaxCount =0;
        for(int val:hm.values()){
            if(val==maxCount){
                noOfMaxCount++;
            }
        }
        int noOfParts = maxCount-1;
        int partLen = n - noOfMaxCount+1;
        int emptySlots = noOfParts * partLen;
        int availableTasks = tasks.length - maxCount * noOfMaxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length+idles;
    }
}

// ["A","A","A","B","B","B","C"]
// A:3 B:3 C:1   n=3

// ["A","A","A","B","B","B",C",C",C","D","D","D","E"] 3.  13
// A:3 B:3 C:3 D:3 E:3 F:1    
