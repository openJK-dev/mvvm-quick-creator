package com.superbig.mvvm.templates.activities.listActivity.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/27 14:24
 * description :
 */
fun listMvvmViewModel(
    packageName:String,
    activityClass:String,
    beanPackageName:String,
    beanName:String
)="""
package ${packageName};

import android.app.Application;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

import com.ddyc.lotterytool.common.utils.BaseLoadDelegate;

import ${beanPackageName}.${beanName};
import com.ddyc.lotterytool.ui.base.BaseActivity;
import com.ddyc.lotterytool.ui.base.BaseViewModel;
import com.jdd.base.Callback;
import com.jdd.base.Task;
import com.jdd.base.error.IError;

import java.util.Arrays;
import java.util.List;

public class ${activityClass}ViewModel extends BaseViewModel {
    private BaseLoadDelegate<${beanName}> mLoadDelegate;
    private MutableLiveData<List<${beanName}>> mDataList = new MutableLiveData<>();
    private MutableLiveData<Task<BaseActivity>> mViewReliedTask = new MutableLiveData<>();

    public ${activityClass}ViewModel(Application application) {
        super(application);
        initData();
    }

    private void initData() {
        mLoadDelegate = new BaseLoadDelegate<${beanName}>(10) {
            @Override
            public void requestData(int page, int pageSize, Callback<List<${beanName}>, IError> callback) {
                //TODO:实现真正的网络请求
                
            }

            @Override
            public void onRequestFinish(RequestType type, List<${beanName}> dataList, @Nullable IError error) {
                super.onRequestFinish(type, dataList, error);
                if (error != null) {
                    showToast(error.msg());
                    return;
                }
                mDataList.setValue(dataList);
            }
        };
        mLoadDelegate.setShowNoMoreDataToast(false);
    }

    public MutableLiveData<List<${beanName}>> getDataList() {
        return mDataList;
    }

    public MutableLiveData<Task<BaseActivity>> getViewReliedTask() {
        return mViewReliedTask;
    }

    public LiveData<Boolean> getRefreshing() {
        return mLoadDelegate.getRefreshing();
    }

    public LiveData<Boolean> getLoadingMore() {
        return mLoadDelegate.getLoadingMore();
    }

    public LiveData<Boolean> getNoMoreData() {
        return mLoadDelegate.getNoMoreData();
    }

    public LiveData<Boolean> getLoadMoreError() {
        return mLoadDelegate.getLoadMoreError();
    }

    public LiveData<Integer> getLoadingStatus() {
        return mLoadDelegate.getLoadingStatus();
    }

    public void loadData() {
        mLoadDelegate.load();
    }

    public void refresh() {
        mLoadDelegate.refresh();
    }

    public void loadMore() {
        mLoadDelegate.loadMore();
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner owner){

    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner owner){

    }
}
"""