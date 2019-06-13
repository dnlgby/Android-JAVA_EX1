package com.example.rxjavaandretrofit.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavaandretrofit.R;
import com.example.rxjavaandretrofit.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.PostsViewHolder> {

    private List<Post> mPosts = new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item_layout, parent, false);
        return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.mPostTitleTv.setText(post.getTitle());
        holder.mPostBodyTv.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void setPosts(List<Post> posts){
        mPosts = posts;
        notifyDataSetChanged();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder{

        TextView mPostTitleTv;
        TextView mPostBodyTv;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            mPostTitleTv = itemView.findViewById(R.id.post_title);
            mPostBodyTv = itemView.findViewById(R.id.post_body);
        }
    }

}
