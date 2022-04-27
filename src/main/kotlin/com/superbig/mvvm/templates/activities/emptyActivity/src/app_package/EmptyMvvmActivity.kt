package com.superbig.mvvm.templates.activities.emptyActivity.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:57
 * description :
 */
fun emptyMvvmActivity(
    applicationPackage: String,
    activityClass: String,
    layoutName: String,
    activityPackageName: String
) = """
    package ${activityPackageName};
    import android.os.Bundle;
    import androidx.lifecycle.ViewModelProviders;
    import ${applicationPackage}.R;
    import ${applicationPackage}.databinding.Activity${activityClass}Binding;
    import com.ddyc.lotterytool.ui.base.BaseBindingActivity;
        
    public class ${activityClass}Activity extends BaseBindingActivity<Activity${activityClass}Binding> {
        private ${activityClass}ViewModel mViewModel;
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
        }
        
        @Override
        public void initEvents() {
            super.initEvents();
        }
    }"""