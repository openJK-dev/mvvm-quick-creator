package com.superbig.mvvm.templates.activities.emptyActivity

import android.databinding.tool.ext.stripNonJava
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.superbig.mvvm.templates.activities.emptyActivity.res.layout.emptyMvvmActivityXml
import com.superbig.mvvm.templates.activities.emptyActivity.src.app_package.emptyMvvmActivity
import com.superbig.mvvm.templates.activities.emptyActivity.src.app_package.emptyMvvmViewModel


/**
 * @author : DianHua huang
 * date : 2022/4/13 17:55
 * description :
 */
fun RecipeExecutor.emptyMvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    rootPackageName:String,
    activityPathName: String,
    activityClass: String,
    layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = ".${activityPathName.replace("$rootPackageName.","")}",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false
    )
    projectData.applicationPackage
    val emptyMvvmActivity = emptyMvvmActivity(
        rootPackageName,
        activityClass,
        layoutName,
        activityPathName
    )
    save(emptyMvvmActivity, srcOut.resolve("${activityClass}Activity.java"))
    save(
        emptyMvvmActivityXml(activityPathName, activityClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    save(
        emptyMvvmViewModel(activityPathName, activityClass),
        srcOut.resolve("${activityClass}ViewModel.java")
    )
}
