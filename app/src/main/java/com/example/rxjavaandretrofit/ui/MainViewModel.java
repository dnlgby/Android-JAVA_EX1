package com.example.rxjavaandretrofit.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavaandretrofit.R;
import com.example.rxjavaandretrofit.models.Action;
import com.example.rxjavaandretrofit.models.Comment;
import com.example.rxjavaandretrofit.models.Post;
import com.example.rxjavaandretrofit.network.posts.PostsApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    @Inject
    PostsApi mTodosApi;

    private Context mContext;
    private MutableLiveData<Action> mPostsResponse;
    private MutableLiveData<Action> mCommentsResponse;
    private CompositeDisposable mDisposables;

    @Inject
    MainViewModel(Context context) {
        mContext = context;
        mPostsResponse = new MutableLiveData<>();
        mCommentsResponse = new MutableLiveData<>();
        mDisposables = new CompositeDisposable();
    }


    void makePostsCall() {
        Single<List<Post>> postsSingle = mTodosApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        mDisposables.add(postsSingle.subscribe(
                res -> mPostsResponse.setValue(Action.responseSuccess(mContext.getString(R.string.success_string), res)),
                e -> mPostsResponse.setValue(Action.responseFailure(e))));
    }

    void makeCommentsCall() {
        Single<List<Comment>> commentsSingle = mTodosApi.getComments()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        mDisposables.add(commentsSingle.subscribe(
                res -> mCommentsResponse.setValue(Action.responseSuccess(mContext.getString(R.string.success_string), res)),
                e -> mCommentsResponse.setValue(Action.responseFailure(e))));
    }

    LiveData<Action> showPostsResponse() {
        return mPostsResponse;
    }


    LiveData<Action> showCommentsResponse() {
        return mCommentsResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mContext = null;
        mDisposables.dispose();
    }
}
