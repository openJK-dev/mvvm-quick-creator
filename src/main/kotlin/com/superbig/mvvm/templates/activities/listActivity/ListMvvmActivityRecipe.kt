package com.superbig.mvvm.templates.activities.listActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.superbig.mvvm.templates.activities.emptyActivity.res.layout.emptyMvvmActivityXml
import com.superbig.mvvm.templates.activities.emptyActivity.src.app_package.emptyMvvmActivity
import com.superbig.mvvm.templates.activities.emptyActivity.src.app_package.emptyMvvmViewModel
import com.superbig.mvvm.templates.activities.listActivity.res.layout.listMvvmActivityXml
import com.superbig.mvvm.templates.activities.listActivity.res.layout.listMvvmItemXml
import com.superbig.mvvm.templates.activities.listActivity.src.app_package.listMvvmActivity
import com.superbig.mvvm.templates.activities.listActivity.src.app_package.listMvvmBean
import com.superbig.mvvm.templates.activities.listActivity.src.app_package.listMvvmViewModel

/**
 * @author : DianHua huang
 * date : 2022/4/27 14:21
 * description :
 */
fun RecipeExecutor.listMvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    rootPackageName: String,
    activityPathName: String,
    activityClass: String,
    layoutName: String,
    beanName:String,
    beanPackageName:String,
    itemLayoutName:String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = ".${activityPathName.replace("$rootPackageName.", "")}",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false
    )
    val listMvvmActivity = listMvvmActivity(
        rootPackageName,
        activityClass,
        layoutName,
        activityPathName,
        beanPackageName,
        beanName,
        itemLayoutName
    )
    save(listMvvmActivity, srcOut.resolve("${activityClass}Activity.java"))
    save(listMvvmBean(beanPackageName,beanName),srcOut.resolve("bean/${beanName}.java"))
    save(
        listMvvmActivityXml(activityPathName, activityClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    save(
        listMvvmItemXml(activityPathName, activityClass,beanName,beanPackageName),
        resOut.resolve("layout/${itemLayoutName}.xml")
    )
    save(
        listMvvmViewModel(activityPathName, activityClass,beanPackageName,beanName),
        srcOut.resolve("${activityClass}ViewModel.java")
    )
}
