import java.util.*;
class Twitter {
    public int twSeq = 0;
    Map<Integer, Integer> twRanks = new HashMap<>();

    Map<Integer, Set<Integer>> followers = null;
    Map<Integer, List<Integer>> userTweets = null;
    /** Initialize your data structure here. */
    public Twitter() {
        followers = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
       if (!userTweets.containsKey(userId)) {
           userTweets.put(userId, new LinkedList<Integer>());
       }
       userTweets.get(userId).add(tweetId);
       twRanks.put(tweetId, twSeq++);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> twList = new ArrayList<>();
        Set<Integer> fls = followers.getOrDefault(userId, new HashSet<Integer>());
        fls.add(userId);
        PriorityQueue<Integer> pr = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer t1, Integer t2) {
                return twRanks.get(t2) - twRanks.get(t1);
            }
        });
        //System.out.println(fls);
        for(Integer fid : fls) {
           List<Integer> list = userTweets.get(fid);
           if (list == null) continue;
           int times = 0, i = list.size() - 1;
           while (times < 10 && i >= 0) {
               pr.add(list.get(i--));
           }
        }
        int i = 0;
        while (i < 10 && !pr.isEmpty()) {
            Integer latesttwid = pr.poll();
            twList.add(latesttwid);
            i++;
        }
        return twList;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<Integer>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            return;
        }
        followers.get(followerId).remove(followeeId);
    }
    public static void main(String args[]) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        List<Integer> res = null;
        res = twitter.getNewsFeed(1);
        System.out.println(res);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        res = twitter.getNewsFeed(1);
        System.out.println(res);
        twitter.unfollow(1, 2);
        res = twitter.getNewsFeed(1);
        System.out.println(res);
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
class Twitter1 {

    class Tweet {
        public Tweet next;
        public int tweetId;
        public int rank;
        public Tweet(int id, int rank) {
            this.tweetId = id;
            this.rank = rank;
        }
    }
    int gobalRank = 0;
    /** Initialize your data structure here. */
    Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    Map<Integer, Set<Integer>> userFollowees = new HashMap<>();
    public Twitter1() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<Tweet>());
        }
        List<Tweet> usertws = userTweets.get(userId);
        Tweet newTw = new Tweet(tweetId, gobalRank++);
        if (usertws.size() > 0) {
            Tweet lstTw = usertws.get(usertws.size() - 1);
            newTw.next = lstTw;
        }
        usertws.add(newTw);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees = userFollowees.getOrDefault(userId, new HashSet<Integer>());
        followees.add(userId);
        
        PriorityQueue<Tweet> pr = new PriorityQueue<>(new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t2.rank - t1.rank;
            }
        });
        for (int fid: followees) {
            List<Tweet> fwts = userTweets.getOrDefault(fid, new ArrayList<Tweet>());
            if (fwts.size() > 0) {
                pr.add(fwts.get(fwts.size() - 1));
            }

        }
        List<Integer> rs = new ArrayList<>();
        while (rs.size() < 10 && !pr.isEmpty()) {
            Tweet t = pr.poll();
            rs.add(t.tweetId);
            if (t.next != null) {
                pr.add(t.next);
            }
        }
        return rs;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userFollowees.containsKey(followerId)) {
            userFollowees.put(followerId, new HashSet<Integer>());
        }
        userFollowees.get(followerId).add(followeeId);
      
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userFollowees.containsKey(followerId)) {
            return;
        }
        userFollowees.get(followerId).remove(followeeId);

    }
    public static void main(String args[]) {
        Twitter1 twitter = new Twitter1();
        twitter.postTweet(1, 5);
        List<Integer> res = null;
        res = twitter.getNewsFeed(1);
        System.out.println(res);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        res = twitter.getNewsFeed(1);
        System.out.println(res);
        twitter.unfollow(1, 2);
        res = twitter.getNewsFeed(1);
        System.out.println(res);
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
