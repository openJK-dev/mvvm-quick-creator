package com.superbig.mvvm.templates

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.superbig.mvvm.templates.activities.emptyActivity.emptyMvvmActivityTemplate
import com.superbig.mvvm.templates.activities.listActivity.listMvvmActivityTemplate
import com.superbig.mvvm.templates.fragments.emptyFragment.emptyMvvmFragmentTemplate
import com.superbig.mvvm.templates.fragments.listFragment.listMvvmFragmentTemplate

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:51
 * description :
 */
class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> =
        listOf(
            emptyMvvmActivityTemplate,
            listMvvmActivityTemplate,
            emptyMvvmFragmentTemplate,
            listMvvmFragmentTemplate
        )
}