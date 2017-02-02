package project.codingblocks.twitterfeed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

        RecyclerView rvTweetList;
        ArrayList<Tweet> tweetList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tweetList= new ArrayList<>();
        tweetList.add(new Tweet("pakalu papito","i might be annoying but atleast my lock screen isn’t a selfie"));
        tweetList.add(new Tweet(" Princess Buttercup","My therapist told me \"time heals all wounds\", \n" +
                "\n" +
                "So I stabbed him. Now we wait... "));
        tweetList.add(new Tweet("Shakti Shetty "," If my phone is fully charged, my self-confidence automatically rises a bit."));

        tweetList.add(new Tweet("pakalu papito ","my morning routine includes 20 minutes of staring at the ceiling thinking about how tired I am and debating if I really need to live today "));


        tweetList.add(new Tweet("dorku "," Year change ho raha hai. Tumhari life nahi. Itna optimistic mat ho."));

        tweetList.add(new Tweet("pnkj ","Mujhe toh 2000 ka change milte hi IT Dept ki raid ka darr lagne lagta hai. "));
        tweetList.add(new Tweet("Shakti Shetty ","Relatives at weddings are the most brutally honest version of food bloggers. "));

        tweetList.add(new Tweet("pakalu papito ","the only running i do is running out of money "));


        tweetList.add(new Tweet("dorku ","\"Any NYE plans?\"\n" +
                "\n" +
                "*flashes of drinking room temp frooti with uncle chips while watching award shows on TV* \n" +
                "\n" +
                "\"Not really an NYE person\" "));

        tweetList.add(new Tweet("pnkj ","News channels tell a different magnitude of the same earthquake. It's like school kids copying from one person in exam with a slight change. "));
        tweetList.add(new Tweet("Pakalu Papito ","that awkward moment between birth and death "));

        tweetList.add(new Tweet("pakalu papito ","how am i supposed to lose weight when the best part about life is food "));


        tweetList.add(new Tweet("dorku ","Feel bad for wrapping paper that is used to wrap empty gift boxes to be placed under decorative Christmas trees in offices/malls. "));

        tweetList.add(new Tweet("pnkj ","\"If you're lucky you can win the grand prize of Rs. 1 crore.\"\n" +
                "\"Go fool someone else. I've never even been lucky enough to win a Housie.\" "));


        rvTweetList = (RecyclerView) findViewById(R.id.rvTweetFeed);

        TweetAdapter tweetAdapter = new TweetAdapter();

        rvTweetList.setLayoutManager(new LinearLayoutManager(this));
        rvTweetList.setAdapter(tweetAdapter);
    }
    class TweetHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvTweet;
        TextView tvReTweets;
        private final View itemView;
        LikeButton btnLike;
        Button btnReTweet;


        public TweetHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvTweet= (TextView) itemView.findViewById(R.id.tvTweet);
            this.tvReTweets=(TextView) itemView.findViewById(R.id.tvReTweets);
            this.itemView = itemView;

            this.btnLike=(LikeButton) itemView.findViewById(R.id.btnLike);
            this.btnReTweet=(Button) itemView.findViewById(R.id.btnReTweet);

        }
    }

    class TweetAdapter extends RecyclerView.Adapter<TweetHolder>{


        @Override
        public TweetHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            LayoutInflater li= getLayoutInflater();
            View itemView= li.inflate(R.layout.list_item_tweet,parent, false);

            return new TweetHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final TweetHolder holder, int position) {
            final Tweet tweet= tweetList.get(position);
            holder.tvName.setText(tweet.getName());
            holder.tvTweet.setText(tweet.getTweet());
            if (tweet.getTweet().length()<100){
                holder.tvTweet.setTextSize((float) 35.0);

            }else{
                holder.tvTweet.setTextSize((float) 20.0);

            }
            holder.btnLike.setLiked(tweet.isLike());

            holder.btnReTweet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tweet.incReTweets();
                    holder.tvReTweets.setText("ReTweets: " + tweet.getReTweets().toString());

                }
            });

            holder.tvReTweets.setText("ReTweets: " + tweet.getReTweets().toString());
            holder.btnLike.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {
                    tweet.setLike(true);
                    likeButton.setLiked(tweet.isLike());

                }

                @Override
                public void unLiked(LikeButton likeButton) {
                    tweet.setLike(false);
                    likeButton.setLiked(tweet.isLike());

                }
            });

        }

        @Override
        public int getItemCount() {
            return tweetList.size();
        }
    }

}
