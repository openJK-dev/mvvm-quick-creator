package com.superbig.mvvm.templates.fragments.emptyFragment.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/28 10:01
 * description :
 */
fun emptyMvvmFragment(
    applicationPackage: String,
    fragmentClass: String,
    layoutName: String,
    fragmentPackageName: String
) = """
    package ${fragmentPackageName};
    import android.os.Bundle;
    import androidx.lifecycle.ViewModelProviders;
    import ${applicationPackage}.R;
    import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding;
    import com.ddyc.lotterytool.ui.base.BaseFragment;
        
    public class ${fragmentClass}Fragment extends BaseFragment<Fragment${fragmentClass}Binding> {
        private ${fragmentClass}ViewModel mViewModel;
        
        public static ${fragmentClass}Fragment newInstance() {
            ${fragmentClass}Fragment fragment = new ${fragmentClass}Fragment();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
            return fragment;
        }
    
        @Override
        public int getLayout() {
            return R.layout.${layoutName};
        }
        
        @Override
        public void initDatas(Bundle savedInstanceState) {
            mViewModel = ViewModelProviders.of(this).get(${fragmentClass}ViewModel.class);
            getLifecycle().addObserver(mViewModel);
            getBinding().setVm(mViewModel);
        }
        
        @Override
        public void initViews() {
            
        }
        
        @Override
        public void initEvents() {

        }
    }"""