package com.superbig.mvvm.templates.activities.listActivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.superbig.mvvm.templates.activities.emptyActivity.emptyMvvmActivityRecipe

/**
 * @author : DianHua huang
 * date : 2022/4/27 14:19
 * description : 列表 Activity 模板
 */
val listMvvmActivityTemplate
    get() = template {
        name = "DL List MVVM Activity"
        description = "快速创建一个基于 DigitalLottery 项目的 List MVVM 页面（文件包括 Activity、ViewModel、xml）"
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
            visible = {false}
        }

        val mPathPackageName = stringParameter {
            name = "Activity 所在的包路径(例如：com.ddyc.lotterytool.module.login)"
            constraints = listOf(Constraint.PACKAGE)
            default = "module"
        }

        val mPageName = stringParameter {
            name = "Activity 名称"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "NewPage"
        }

        val mLayoutName = stringParameter {
            name = "XML 文件名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "activity_" + camelCaseToUnderlines(mPageName.value) }
            default = "new_page"
        }

        val mBeanName = stringParameter {
            name = "列表 Bean 名称"
            constraints = listOf(Constraint.NONEMPTY)
            default = "Bean"
        }

        val mBeanPackageName = stringParameter {
            name = "列表 Bean 所在的包名"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { mPathPackageName.value+".bean"}
            default = "Bean"
            visible = {false}
        }

        val mItemLayoutName = stringParameter {
            name = "列表 Item XML 文件名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "item_" + camelCaseToUnderlines(mPageName.value)+"_layout" }
            default = "item_new_page"
        }

        widgets(
            TextFieldWidget(mRootPackageName),
            PackageNameWidget(mPathPackageName),
            TextFieldWidget(mPageName),
            TextFieldWidget(mLayoutName),
            TextFieldWidget(mBeanName),
            TextFieldWidget(mBeanPackageName),
            TextFieldWidget(mItemLayoutName)
        )

        recipe = { data: TemplateData ->
            listMvvmActivityRecipe(
                data as ModuleTemplateData,
                mRootPackageName.value,
                mPathPackageName.value,
                mPageName.value,
                mLayoutName.value,
                mBeanName.value,
                mBeanPackageName.value,
                mItemLayoutName.value
            )
        }
    }