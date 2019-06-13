package com.example.rxjavaandretrofit.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavaandretrofit.BaseActivity;
import com.example.rxjavaandretrofit.R;
import com.example.rxjavaandretrofit.models.Action;
import com.example.rxjavaandretrofit.models.Post;
import com.example.rxjavaandretrofit.ui.adapters.PostsListAdapter;
import com.example.rxjavaandretrofit.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    PostsListAdapter mAdapter;

    private MainViewModel mViewModel;
    private Unbinder mUnbinder;

    @BindView(R.id.main_fragment_list_view)
    RecyclerView mListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragments_layout, container, false);
        mUnbinder = ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Set ViewModel
        createViewModel();

        mListView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mListView.setAdapter(mAdapter);
    }

    private void createViewModel() {
        mViewModel = ViewModelProviders.of(getActivity(), providerFactory).get(MainViewModel.class);
        mViewModel.showPostsResponse().observe(this, this::processPostsResponse);
    }

    private void processPostsResponse(Action action) {
        if (action.getStatus() == Action.ACTION_SUCCESS) {
            List<Post> posts = (List<Post>) action.getResult();
            mAdapter.setPosts(posts);
        }
        else {
            ((BaseActivity)getActivity()).showLongToast(action.getError().getMessage());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
