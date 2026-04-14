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
        Set<Integer> followingIds = fmap.get(userId);
        PriorityQueue<Tweet> pq = 
            new PriorityQueue<>((a,b)->b.priority-a.priority);
        if(tmap.get(userId)!=null){
            pq.addAll(tmap.get(userId));
        }
        if(followingIds != null){
            for(int followingId:followingIds){
            pq.addAll(tmap.get(followingId));
            }
        }
        
        Set<Integer> tweets= new LinkedHashSet<>();
        while(tweets.size()!=10 && !pq.isEmpty()){
            tweets.add(pq.poll().id);
        }
        return new ArrayList<>(tweets);
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
