package com.superbig.mvvm.templates.fragments.listFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.superbig.mvvm.templates.activities.listActivity.res.layout.listMvvmActivityXml
import com.superbig.mvvm.templates.activities.listActivity.res.layout.listMvvmItemXml
import com.superbig.mvvm.templates.activities.listActivity.src.app_package.listMvvmActivity
import com.superbig.mvvm.templates.activities.listActivity.src.app_package.listMvvmBean
import com.superbig.mvvm.templates.activities.listActivity.src.app_package.listMvvmViewModel
import com.superbig.mvvm.templates.fragments.listFragment.res.layout.listMvvmFragmentItemXml
import com.superbig.mvvm.templates.fragments.listFragment.res.layout.listMvvmFragmentXml
import com.superbig.mvvm.templates.fragments.listFragment.src.app_package.listFragmentMvvmBean
import com.superbig.mvvm.templates.fragments.listFragment.src.app_package.listMvvmFragment
import com.superbig.mvvm.templates.fragments.listFragment.src.app_package.listMvvmFragmentViewModel

/**
 * @author : DianHua huang
 * date : 2022/4/28 11:20
 * description :
 */

fun RecipeExecutor.listMvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    rootPackageName: String,
    activityPathName: String,
    activityClass: String,
    layoutName: String,
    beanName: String,
    beanPackageName: String,
    itemLayoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    //val ktOrJavaExt = projectData.language.extension
    val listMvvmFragment = listMvvmFragment(
        rootPackageName,
        activityClass,
        layoutName,
        activityPathName,
        beanPackageName,
        beanName,
        itemLayoutName
    )
    save(listMvvmFragment, srcOut.resolve("${activityClass}Fragment.java"))
    save(listFragmentMvvmBean(beanPackageName, beanName), srcOut.resolve("bean/${beanName}.java"))
    save(
        listMvvmFragmentXml(activityPathName, activityClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    save(
        listMvvmFragmentItemXml(activityPathName, activityClass, beanName, beanPackageName),
        resOut.resolve("layout/${itemLayoutName}.xml")
    )
    save(
        listMvvmFragmentViewModel(activityPathName, activityClass, beanPackageName, beanName),
        srcOut.resolve("${activityClass}ViewModel.java")
    )
}
