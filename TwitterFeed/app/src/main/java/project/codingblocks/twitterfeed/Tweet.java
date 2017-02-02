package project.codingblocks.twitterfeed;

/**
 * Created by Kabir on 29/12/2016.
 */

public class Tweet {
    private String name;
    private String tweet;
    private boolean like=false;
    private int reTweets;
    private boolean longTweet;

    public Tweet(String name, String tweet) {
        this.name = name;
        this.tweet = tweet;
        this.like = false;
        this.reTweets = 0;
        if(this.tweet.length()>100){
        this.longTweet=true;
        }
        }


    public String getName() {
        return name;
    }

    public String getTweet() {
        return tweet;
    }

    public boolean isLike() {
        return like;
    }

    public Integer getReTweets() {
        return reTweets;
    }


    public void setLike(boolean like) {
        this.like = like;
    }

    public void incReTweets() {
        this.reTweets+= 1;
    }

    public boolean isLongTweet() {
        return longTweet;
    }
}

