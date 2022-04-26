package com.superbig.mvvm.templates.activities.emptyActivity.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:57
 * description :
 */
fun emptyMvvmViewModel(
    packageName:String,
    activityClass:String
)="""package ${packageName};
    import android.app.Application;
    import com.ddyc.lotterytool.ui.base.BaseViewModel;
        
    public class ${activityClass}ViewModel extends BaseViewModel {
       public ${activityClass}ViewModel(Application application) {
          super(application);
       }
    }"""