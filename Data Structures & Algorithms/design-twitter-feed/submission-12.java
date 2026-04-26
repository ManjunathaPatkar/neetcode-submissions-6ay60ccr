class Twitter {
    HashMap<Integer,Set<Integer>> fmap;
    HashMap<Integer,List<Tweet>> tmap;
    Integer postCount;
    class Tweet{
        Integer id;
        Integer priority;
        Tweet(int id, int priority){
            this.id =id;
            this.priority = priority;
        }
    }
    public Twitter() {
        fmap = new HashMap<>();
        tmap = new HashMap<>();
        postCount = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tmap.containsKey(userId)){
            tmap.put(userId,new ArrayList<>());
        }
        tmap.get(userId).add(new Tweet(tweetId,postCount));
        postCount++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a,b)->b[0]-a[0]);
        fmap.putIfAbsent(userId,new HashSet<>());
        fmap.get(userId).add(userId);
        for(int user:fmap.get(userId)){
            List<Tweet> tweets = tmap.get(user);
            if(tweets!=null && tweets.size()!=0){
                Tweet t = tweets.get(tweets.size()-1);
                pq.offer(new int[]{t.priority,t.id,user,tweets.size()-1});
            }
        }
        List<Integer> res= new ArrayList<>();
        int count=10;
        while(!pq.isEmpty() && count!=0){
            int[] polled = pq.poll();
            res.add(polled[1]);
            if(polled[3]!=0){
                Tweet t = tmap.get(polled[2]).get(polled[3]-1);
                pq.offer(new int[]{t.priority,t.id,polled[2],polled[3]-1});
            }
            count--;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!fmap.containsKey(followerId)){
            fmap.put(followerId,new HashSet<>());
        }
        fmap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!fmap.containsKey(followerId)){
            return;
        }
        fmap.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
