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
import com.example.rxjavaandretrofit.models.Comment;
import com.example.rxjavaandretrofit.ui.adapters.CommentsListAdapter;
import com.example.rxjavaandretrofit.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public class CommentsFragment extends DaggerFragment {

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    CommentsListAdapter mAdapter;

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
        mViewModel.showCommentsResponse().observe(this, this::processCommentsResponse);
    }

    private void processCommentsResponse(Action action) {
        if (action.getStatus() == Action.ACTION_SUCCESS) {
            List<Comment> comments = (List<Comment>) action.getResult();
            mAdapter.setComments(comments);
        } else {
            ((BaseActivity) getActivity()).showLongToast(action.getError().getMessage());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
