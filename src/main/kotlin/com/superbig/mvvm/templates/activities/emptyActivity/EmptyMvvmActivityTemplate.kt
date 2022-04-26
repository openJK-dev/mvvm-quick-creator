package com.superbig.mvvm.templates.activities.emptyActivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:55
 * description :
 */
val emptyMvvmActivityTemplate
    get() = template {
        name = "Min MVVM Activity"
        description = "快速创建一个最精简的 MVVM 页面（文件包括 Activity、ViewModel、xml）"
        minApi = MIN_API
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val mRootPackageName = stringParameter {
            name = "应用的包名"
            constraints = listOf(Constraint.NONEMPTY)
            default = "com.ddyc.lotterytool"
        }

        val mPathPackageName = stringParameter {
            name = "Activity 所在的包路径(例如：com.ddyc.lotterytool.module.login)"
            constraints = listOf(Constraint.PACKAGE)
            default = "module"
        }

        val mPageName = stringParameter {
            name = "Activity 名称"
            constraints = listOf(Constraint.UNIQUE,Constraint.NONEMPTY)
            default = "Main"
        }

        val mLayoutName = stringParameter {
            name = "XML 文件名称"
            constraints = listOf(Constraint.LAYOUT,Constraint.NONEMPTY)
            suggest = { activityToLayout(mPageName.value.toLowerCase())}
            default = "main"
        }

        widgets(
            TextFieldWidget(mRootPackageName),
            PackageNameWidget(mPathPackageName),
            TextFieldWidget(mPageName),
            TextFieldWidget(mLayoutName)
        )

        recipe = {data:TemplateData->
            emptyMvvmActivityRecipe(
                data as ModuleTemplateData,
                mRootPackageName.value,
                mPathPackageName.value,
                mPageName.value,
                mLayoutName.value)
        }
    }
