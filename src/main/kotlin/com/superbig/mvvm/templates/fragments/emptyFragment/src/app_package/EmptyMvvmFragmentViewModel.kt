package com.superbig.mvvm.templates.fragments.emptyFragment.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/28 10:02
 * description :
 */
fun emptyMvvmFragmentViewModel(
    packageName:String,
    fragmentClass:String
)="""package ${packageName};
    import android.app.Application;
    
    import androidx.lifecycle.Lifecycle;
    import androidx.lifecycle.LifecycleOwner;
    import androidx.lifecycle.OnLifecycleEvent;

    import com.ddyc.lotterytool.ui.base.BaseViewModel;
        
    public class ${fragmentClass}ViewModel extends BaseViewModel {
       public ${fragmentClass}ViewModel(Application application) {
          super(application);
       }
   
       @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
       public void onCreate(LifecycleOwner owner){

       }

       @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
       public void onDestroy(LifecycleOwner owner){

       }
    }
    
    """