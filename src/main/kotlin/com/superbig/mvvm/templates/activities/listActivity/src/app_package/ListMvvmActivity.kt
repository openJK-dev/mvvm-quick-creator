package com.superbig.mvvm.templates.activities.listActivity.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/27 14:23
 * description :
 */
fun listMvvmActivity(
    applicationPackage: String,
    activityClass: String,
    layoutName: String,
    activityPackageName: String,
    beanPackageName:String,
    beanName:String,
    itemLayoutName:String
) = """
package ${activityPackageName};

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ${applicationPackage}.BR;
import ${applicationPackage}.R;
import ${applicationPackage}.common.utils.simple.recycler.SimpleBindingConfig;
import com.ddyc.lotterytool.common.utils.simple.recycler.SimpleRecyclerViewAdapter;
import ${applicationPackage}.databinding.Activity${activityClass}Binding;
import ${beanPackageName}.${beanName};
import com.ddyc.lotterytool.ui.base.BaseBindingActivity;
import com.jdd.base.ui.widget.LoadingLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class ${activityClass}Activity extends BaseBindingActivity<Activity${activityClass}Binding> {
    private ${activityClass}ViewModel mViewModel;
    private LoadingLayout mLoadingLayout;
    private SmartRefreshLayout mRefreshLayout;
    private SimpleRecyclerViewAdapter<${beanName}> mAdapter;

    public static void open(Context context){
        Intent intent = new Intent(context,${activityClass}Activity.class);
        context.startActivity(intent);
    }
    @Override
    public int getLayout() {
        return R.layout.${layoutName};
    }

    @Override
    public void initDatas(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(${activityClass}ViewModel.class);
        getLifecycle().addObserver(mViewModel);
        getBinding().setVm(mViewModel);
    }

    @Override
    public void initViews() {
        setToolbarAsBack("",v->finish());
        mLoadingLayout = mBinding.loadingLayout;
        mLoadingLayout.setOnReloadListener(v -> mViewModel.loadData());
        if (mLoadingLayout.getEmptyPage() != null) {
            mLoadingLayout.getEmptyPage().setOnClickListener(v -> mViewModel.loadData());
        }
        mRefreshLayout = mBinding.smartRefresh;
        mRefreshLayout.setOnRefreshListener(refreshLayout -> mViewModel.refresh());

        SparseArray<Object> bindingVariables = new SparseArray<>();
        bindingVariables.put(BR.vm, mViewModel);
        SimpleBindingConfig config = new SimpleBindingConfig(R.layout.${itemLayoutName}, bindingVariables);
        mAdapter = new SimpleRecyclerViewAdapter<>(config);
        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mBinding.recycler.setAdapter(mAdapter);
        mAdapter.canLoadMore(true);
        mAdapter.setLoadMoreListener(() -> {
            mViewModel.loadMore();
        });

        mViewModel.loadData();
    }

    @Override
    public void initEvents() {
        super.initEvents();
        mViewModel.getViewReliedTask().observe(this, baseActivityTask -> {
            if (baseActivityTask == null) {
                return;
            }
            baseActivityTask.execute(this);
        });

        mViewModel.getDataList().observe(this, data -> {
            if (data != null) {
                // 更新列表数据
                mAdapter.setItems(data);
            }
        });

        // 监听刷新状态变化
        mViewModel.getRefreshing().observe(this, refreshing -> {
            if (refreshing == null || !refreshing) {
                mRefreshLayout.finishRefresh();
                mAdapter.loadOrRefreshComplete();
            }
        });
        // 监听加载更多状态变化
        mViewModel.getLoadingMore().observe(this, loadingMore -> {
            if (loadingMore == null || !loadingMore) {
                mAdapter.loadMoreComplete();
            }
        });
        // 监听加载数据状态变化
        mViewModel.getLoadingStatus().observe(this, loadingStatus -> {
            if (loadingStatus != null) {
                mLoadingLayout.setStatus(loadingStatus);
                mAdapter.setListLoadingStatus(loadingStatus);
            }
        });

        //没有更多数据
        mViewModel.getNoMoreData().observe(this, value -> {
            if (value != null) {
                mAdapter.noMoreData(value);
            }
        });

        //网络异常
        mViewModel.getLoadMoreError().observe(this, value -> {
            if (value != null && value) {
                mAdapter.error(true);
            }
        });
    }
}
"""