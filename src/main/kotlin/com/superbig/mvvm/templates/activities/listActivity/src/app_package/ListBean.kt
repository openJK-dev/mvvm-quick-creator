package com.superbig.mvvm.templates.activities.listActivity.src.app_package

/**
 * @author : DianHua huang
 * date : 2022/4/27 15:55
 * description :
 */
fun listMvvmBean(
    beanPackageName: String,
    beanName: String
) = """
    package ${beanPackageName};
    import androidx.annotation.Keep;
    
    @Keep
    public class ${beanName}{
    }
"""