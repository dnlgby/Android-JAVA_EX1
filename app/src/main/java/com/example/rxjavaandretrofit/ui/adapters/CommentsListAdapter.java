package com.example.rxjavaandretrofit.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavaandretrofit.R;
import com.example.rxjavaandretrofit.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentsListAdapter extends RecyclerView.Adapter<CommentsListAdapter.CommentsViewHolder> {

    private List<Comment> mComments = new ArrayList<>();

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item_layout, parent, false);
        return new CommentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        Comment item = mComments.get(position);
        holder.mCommentEmailTv.setText(item.getEmail());
        holder.mCommentBodyTv.setText(item.getBody());
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
        notifyDataSetChanged();
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder {

        TextView mCommentEmailTv;
        TextView mCommentBodyTv;

        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            mCommentEmailTv = itemView.findViewById(R.id.comment_email);
            mCommentBodyTv = itemView.findViewById(R.id.comment_body);
        }
    }
}
