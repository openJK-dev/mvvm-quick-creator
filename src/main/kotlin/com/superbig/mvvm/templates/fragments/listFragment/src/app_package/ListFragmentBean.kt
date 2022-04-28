package com.superbig.mvvm.templates.fragments.listFragment.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/28 11:40
 * description :
 */
fun listFragmentMvvmBean(
    beanPackageName: String,
    beanName: String
) = """
    package ${beanPackageName};
    import androidx.annotation.Keep;
    
    @Keep
    public class ${beanName}{
    }
"""