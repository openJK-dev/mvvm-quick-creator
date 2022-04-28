package com.superbig.mvvm.templates.fragments.emptyFragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * @author : DianHua huang
 * date : 2022/4/28 9:59
 * description :
 */

val emptyMvvmFragmentTemplate
    get() = template {
        name = "DL Empty MVVM Fragment"
        description = "快速创建一个基于 DigitalLottery 项目的 MVVM Fragment（文件包括 Fragment、ViewModel、xml）"
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
            visible = { false }
        }

        val mPathPackageName = stringParameter {
            name = "Fragment 所在的包路径(例如：com.ddyc.lotterytool.module.login)"
            constraints = listOf(Constraint.PACKAGE)
            default = "module"
        }

        val mPageName = stringParameter {
            name = "Fragment 名称"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "NewPage"
        }

        val mLayoutName = stringParameter {
            name = "XML 文件名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "fragment_" + camelCaseToUnderlines(mPageName.value) }
            default = "new_page"
        }

        widgets(
            TextFieldWidget(mRootPackageName),
            PackageNameWidget(mPathPackageName),
            TextFieldWidget(mPageName),
            TextFieldWidget(mLayoutName)
        )

        recipe = { data: TemplateData ->
            emptyMvvmFragmentRecipe(
                data as ModuleTemplateData,
                mRootPackageName.value,
                mPathPackageName.value,
                mPageName.value,
                mLayoutName.value
            )
        }
    }