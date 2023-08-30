355. Design Twitter

   class Twitter {

    HashMap<Integer,ArrayList<Pair<Integer,Integer>>> posttweet ; // map<userid, < tweetId, time>>
    HashMap<Integer,Set<Integer>> followers ;
    int time;

    public Twitter() {
        posttweet = new HashMap<>();
        followers = new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Pair<Integer,Integer> pair = new Pair<>(tweetId,time);
        ArrayList temp = posttweet.getOrDefault(userId,new ArrayList<>());
        temp.add(pair);
        posttweet.put(userId,temp);
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = followers.getOrDefault(userId,new HashSet<>());
        set.add(userId);
        list.addAll(set);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : list){
            if(posttweet.get(i)!=null)
                for(Pair<Integer,Integer> j : posttweet.get(i)){
                    map.put(j.getKey(),j.getValue());
                }
        }
        
PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(((x,y)->x.getValue()-y.getValue()));
        pq.addAll(map.entrySet());
        while(pq.size()>10){
            pq.poll();
        }
        List<Integer> ans = new ArrayList<>();
        while(pq.size()!=0){
            ans.add(pq.poll().getKey());
        }Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followers.put(followerId,set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet<>());
        if(set.contains(followeeId))
        set.remove(followeeId);
        followers.put(followerId,set);
    }
} 

// 2nd Solution 


class Twitter {

    HashMap<Integer,Set<Integer>>following;
    HashMap<Integer,Set<Integer>>followers;
    HashMap<Integer,LinkedList<Pair<Integer,Integer>>>mp;
    HashMap<Integer,Integer>time;
    HashMap<Integer,Integer>time2;
    int clock=0;

    public Twitter() {

    followers=new HashMap<>();
    following=new HashMap<>();
    mp=new HashMap<>();
    time=new HashMap<>();
    time2=new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        
    if(!mp.containsKey(userId)){

    mp.put(userId,new LinkedList<Pair<Integer,Integer>>());

    }

    mp.get(userId).addFirst(new Pair<Integer,Integer>(tweetId,userId));

    if(followers.containsKey(userId)){

    for(int m:followers.get(userId)){

    mp.get(m).addFirst(new Pair<Integer,Integer>(tweetId,userId));

    }

    }

    time.put(tweetId,clock);

    time2.put(clock,tweetId);

    clock++;

    }
    
    public List<Integer> getNewsFeed(int userId) {

    List<Integer>ans=new ArrayList<Integer>();

    List<Integer>temp=new ArrayList<Integer>();

    if(!mp.containsKey(userId))return ans;

    for(Pair<Integer,Integer>p:mp.get(userId)){

    if(p.getValue()==userId||following.get(userId).contains(p.getValue())){

    temp.add(time.get(p.getKey()));

    }

    }

    Collections.sort(temp);

    int count=0;

    for(int i=temp.size()-1;i>=0&&count<10;i--,count++){

    ans.add(time2.get(temp.get(i)));

    }

    return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {

    if(following.containsKey(followerId)&&following.get(followerId).contains(followeeId))return;


    if(!following.containsKey(followerId)){

    following.put(followerId,new HashSet<Integer>());

    }

    following.get(followerId).add(followeeId);

    if(!followers.containsKey(followeeId)){

    followers.put(followeeId,new HashSet<Integer>());

    }

    followers.get(followeeId).add(followerId);


    if(!mp.containsKey(followerId)){

    mp.put(followerId,new LinkedList<Pair<Integer,Integer>>());
    
    }

    if(mp.containsKey(followeeId)){

      Iterator<Pair<Integer,Integer>>iterator = mp.get(followeeId).descendingIterator();

      while (iterator.hasNext()) 
        {
        
        Pair<Integer,Integer>p=iterator.next();

        if(p.getValue()==followeeId){

mp.get(followerId).addFirst(new Pair<Integer,Integer>(p.getKey(),p.getValue()));

    }

        }
    }

    }
    
    public void unfollow(int followerId, int followeeId) {
        
    if(following.containsKey(followerId))
    following.get(followerId).remove(followeeId);
    

    if(followers.containsKey(followeeId))
    followers.get(followeeId).remove(followerId);

    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
