package com.superbig.mvvm.templates.activities.fragmentActivity.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:57
 * description :
 */
fun emptyMvvmFragmentActivity(
    applicationPackage: String,
    activityClass: String,
    layoutName: String,
    activityPackageName: String,
    fragmentClass:String,
    fragmentPackageName:String
) = """
    package ${activityPackageName};
    import android.os.Bundle;
    
    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.lifecycle.ViewModelProviders;
    import ${applicationPackage}.R;
    import com.ddyc.lotterytool.customView.ShowHideFragmentPagerAdapter;
    import ${applicationPackage}.databinding.Activity${activityClass}Binding;
    import com.ddyc.lotterytool.ui.base.BaseBindingActivity;
    import ${fragmentPackageName}.${fragmentClass}Fragment;
    
    import java.util.Collections;
    import java.util.List;
        
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
            getBinding().viewpager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(),1));
        }
        
        @Override
        public void initEvents() {
            super.initEvents();
        }
        
        public static class ViewPageAdapter extends ShowHideFragmentPagerAdapter{

            public ViewPageAdapter(@NonNull FragmentManager fm, int cashSize) {
                super(fm, cashSize);
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return ${fragmentClass}Fragment.newInstance();
            }

            @Override
            public List<Integer> noDestroyPositions() {
                return Collections.singletonList(0);
            }

            @Override
            public int getCount() {
                return 1;
            }
        }
    }"""