package com.superbig.mvvm.templates.activities.fragmentActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.superbig.mvvm.templates.activities.emptyActivity.res.layout.emptyMvvmActivityXml
import com.superbig.mvvm.templates.activities.emptyActivity.src.app_package.emptyMvvmActivity
import com.superbig.mvvm.templates.activities.emptyActivity.src.app_package.emptyMvvmViewModel
import com.superbig.mvvm.templates.activities.fragmentActivity.res.layout.emptyMvvmFragmentActivityXml
import com.superbig.mvvm.templates.activities.fragmentActivity.src.app_package.emptyMvvmFragmentActivity
import com.superbig.mvvm.templates.activities.fragmentActivity.src.app_package.emptyMvvmFragmentActivityViewModel
import com.superbig.mvvm.templates.fragments.emptyFragment.res.layout.emptyMvvmFragmentXml
import com.superbig.mvvm.templates.fragments.emptyFragment.src.app_package.emptyMvvmFragment
import com.superbig.mvvm.templates.fragments.emptyFragment.src.app_package.emptyMvvmFragmentViewModel
import com.superbig.mvvm.templates.fragments.listFragment.res.layout.listMvvmFragmentItemXml
import com.superbig.mvvm.templates.fragments.listFragment.res.layout.listMvvmFragmentXml
import com.superbig.mvvm.templates.fragments.listFragment.src.app_package.listFragmentMvvmBean
import com.superbig.mvvm.templates.fragments.listFragment.src.app_package.listMvvmFragment
import com.superbig.mvvm.templates.fragments.listFragment.src.app_package.listMvvmFragmentViewModel


/**
 * @author : DianHua huang
 * date : 2022/4/13 17:55
 * description :
 */
fun RecipeExecutor.emptyMvvmFragmentActivityRecipe(
    moduleData: ModuleTemplateData,
    rootPackageName: String,
    activityPathName: String,
    activityClass: String,
    layoutName: String,
    fragmentPackageName:String,
    fragmentClass:String,
    fragmentLayoutName:String,
    isListFragment:Boolean,
    beanPackageName:String,
    beanName:String,
    itemLayoutName:String
) {
    val (projectData, srcOut, resOut) = moduleData
    //val ktOrJavaExt = projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = ".${activityPathName.replace("$rootPackageName.", "")}",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false
    )
    val emptyMvvmFragmentActivity = emptyMvvmFragmentActivity(
        rootPackageName,
        activityClass,
        layoutName,
        activityPathName,
        fragmentClass,
        fragmentPackageName
    )
    save(emptyMvvmFragmentActivity, srcOut.resolve("${activityClass}Activity.java"))
    save(
        emptyMvvmFragmentActivityXml(activityPathName, activityClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    save(
        emptyMvvmFragmentActivityViewModel(activityPathName, activityClass),
        srcOut.resolve("${activityClass}ViewModel.java")
    )

    if(isListFragment){
        val listMvvmFragment = listMvvmFragment(
            rootPackageName,
            fragmentClass,
            fragmentLayoutName,
            fragmentPackageName,
            beanPackageName,
            beanName,
            itemLayoutName
        )
        var path = fragmentPackageName.replace(activityPathName,"")
        if(!path.isNullOrEmpty()){
            path = path.replaceFirst(".","")+"/"
        }else{
            path = ""
        }
        save(listMvvmFragment, srcOut.resolve("${path}${fragmentClass}Fragment.java"))
        save(listFragmentMvvmBean(beanPackageName, beanName), srcOut.resolve("bean/${beanName}.java"))
        save(
            listMvvmFragmentXml(fragmentPackageName, fragmentClass),
            resOut.resolve("layout/${fragmentLayoutName}.xml")
        )
        save(
            listMvvmFragmentItemXml(fragmentPackageName, fragmentClass, beanName, beanPackageName),
            resOut.resolve("layout/${itemLayoutName}.xml")
        )
        save(
            listMvvmFragmentViewModel(fragmentPackageName, fragmentClass, beanPackageName, beanName),
            srcOut.resolve("${path}${fragmentClass}ViewModel.java")
        )
    }else{
        val emptyMvvmFragment = emptyMvvmFragment(
            rootPackageName,
            fragmentClass,
            fragmentLayoutName,
            fragmentPackageName
        )
        var path = fragmentPackageName.replace(activityPathName,"")
        if(!path.isNullOrEmpty()){
            path = path.replaceFirst(".","")+"/"
        }else{
            path = ""
        }
        save(emptyMvvmFragment, srcOut.resolve("${path}${fragmentClass}Fragment.java"))
        save(
            emptyMvvmFragmentXml(fragmentPackageName, fragmentClass),
            resOut.resolve("layout/${fragmentLayoutName}.xml")
        )
        save(
            emptyMvvmFragmentViewModel(fragmentPackageName, fragmentClass),
            srcOut.resolve("${path}${fragmentClass}ViewModel.java")
        )
    }
}
