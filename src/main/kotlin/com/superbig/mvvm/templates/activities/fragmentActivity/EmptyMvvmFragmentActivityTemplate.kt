package com.superbig.mvvm.templates.activities.fragmentActivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:55
 * description :空的 Activity 模板
 */
val emptyMvvmFragmentActivityTemplate
    get() = template {
        name = "DL MVVM Activity+Fragment"
        description = "快速创建一个基于 DigitalLottery 项目的 MVVM 页面（文件包括 Activity、Fragment、ViewModel、xml）"
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
            name = "activity XML 文件名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "activity_" + camelCaseToUnderlines(mPageName.value) }
            default = "activity_new_page"
        }

        val mFragmentPackageName = stringParameter {
            name = "Fragment 所在的包路径(例如：com.ddyc.lotterytool.module.login.fragment)"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { mPathPackageName.value + ".fragment" }
            default = "module"
        }

        val mFragmentName = stringParameter {
            name = "Fragment 名称"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "NewPage"
        }

        val mFragmentLayoutName = stringParameter {
            name = "fragment XML 文件名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "fragment_" + camelCaseToUnderlines(mFragmentName.value) }
            default = "fragment_new_page"
        }

        val isListFragment = booleanParameter {
            name = "fragment 是否是列表"
            default = false
            help = "创建的 Fragment 是否是列表"
        }

        val mBeanName = stringParameter {
            name = "列表 Bean 名称"
            constraints = listOf(Constraint.NONEMPTY)
            default = "Bean"
            visible = { isListFragment.value }
        }

        val mBeanPackageName = stringParameter {
            name = "列表 Bean 所在的包名"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { mPathPackageName.value + ".bean" }
            default = "Bean"
            visible = { isListFragment.value }
        }

        val mItemLayoutName = stringParameter {
            name = "列表 Item XML 文件名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "item_" + camelCaseToUnderlines(mFragmentName.value) + "_layout" }
            default = "item_new_page"
            visible = { isListFragment.value }
        }


        widgets(
            TextFieldWidget(mRootPackageName),
            PackageNameWidget(mPathPackageName),
            TextFieldWidget(mPageName),
            TextFieldWidget(mLayoutName),
            TextFieldWidget(mFragmentPackageName),
            TextFieldWidget(mFragmentName),
            TextFieldWidget(mFragmentLayoutName),
            CheckBoxWidget(isListFragment),
            TextFieldWidget(mBeanName),
            TextFieldWidget(mBeanPackageName),
            TextFieldWidget(mItemLayoutName)
        )

        recipe = { data: TemplateData ->
            emptyMvvmFragmentActivityRecipe(
                data as ModuleTemplateData,
                mRootPackageName.value,
                mPathPackageName.value,
                mPageName.value,
                mLayoutName.value,
                mFragmentPackageName.value,
                mFragmentName.value,
                mFragmentLayoutName.value,
                isListFragment.value,
                mBeanPackageName.value,
                mBeanName.value,
                mItemLayoutName.value
            )
        }
    }
