package com.example.rxjavaandretrofit.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.example.rxjavaandretrofit.BaseActivity;
import com.example.rxjavaandretrofit.R;
import com.example.rxjavaandretrofit.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private static final String POSTS_FRAGMENT_TAG = "Posts";
    private static final String COMMENTS_FRAGMENT_TAG = "Comments";

    @BindView(R.id.activity_main_load_posts_btn)
    Button mLoadPostsBtn;

    @BindView(R.id.activity_main_load_comments_btn)
    Button mLoadCommentsBtn;

    @Inject
    ViewModelProviderFactory mViewModelProviderFactory;

    private MainViewModel mViewModel;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Set ViewModel
        mViewModel = ViewModelProviders.of(this, mViewModelProviderFactory).get(MainViewModel.class);
        mFragmentManager = getSupportFragmentManager();

    }

    @OnClick(R.id.activity_main_load_posts_btn)
    void onLoadPostsClicked() {
        mViewModel.makePostsCall();
        selectFragment(POSTS_FRAGMENT_TAG);
    }


    @OnClick(R.id.activity_main_load_comments_btn)
    void onLoadCommentsClicked() {
        mViewModel.makeCommentsCall();
        selectFragment(COMMENTS_FRAGMENT_TAG);
    }


    private void selectFragment(String fragmentKey) {
        Fragment commentsFragment = mFragmentManager.findFragmentByTag(COMMENTS_FRAGMENT_TAG);
        Fragment postsFragment = mFragmentManager.findFragmentByTag(POSTS_FRAGMENT_TAG);

        switch (fragmentKey) {

            case COMMENTS_FRAGMENT_TAG:
                if (commentsFragment != null)
                    mFragmentManager.beginTransaction().show(commentsFragment).commit();
                else
                    mFragmentManager.beginTransaction().add(R.id.fragments_place_holder, new CommentsFragment(), COMMENTS_FRAGMENT_TAG).commit();

                if (postsFragment != null)
                    mFragmentManager.beginTransaction().hide(postsFragment).commit();
                break;

            case POSTS_FRAGMENT_TAG:
                if (postsFragment != null)
                    mFragmentManager.beginTransaction().show(postsFragment).commit();
                else
                    mFragmentManager.beginTransaction().add(R.id.fragments_place_holder, new PostsFragment(), POSTS_FRAGMENT_TAG).commit();

                if (commentsFragment != null)
                    mFragmentManager.beginTransaction().hide(commentsFragment).commit();
                break;
        }
    }
}
