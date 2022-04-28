package com.superbig.mvvm.templates.fragments.emptyFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.superbig.mvvm.templates.fragments.emptyFragment.res.layout.emptyMvvmFragmentXml
import com.superbig.mvvm.templates.fragments.emptyFragment.src.app_package.emptyMvvmFragment
import com.superbig.mvvm.templates.fragments.emptyFragment.src.app_package.emptyMvvmFragmentViewModel

/**
 * @author : DianHua huang
 * date : 2022/4/28 9:58
 * description :
 */
fun RecipeExecutor.emptyMvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    rootPackageName: String,
    fragmentPathName: String,
    fragmentClass: String,
    layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    projectData.applicationPackage
    val emptyMvvmFragment = emptyMvvmFragment(
        rootPackageName,
        fragmentClass,
        layoutName,
        fragmentPathName
    )
    save(emptyMvvmFragment, srcOut.resolve("${fragmentClass}Fragment.java"))
    save(
        emptyMvvmFragmentXml(fragmentPathName, fragmentClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    save(
        emptyMvvmFragmentViewModel(fragmentPathName, fragmentClass),
        srcOut.resolve("${fragmentClass}ViewModel.java")
    )
}