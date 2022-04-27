package com.superbig.mvvm.templates.activities.listActivity.res.layout

/**
 * @author : DianHua huang
 * date : 2022/4/27 15:58
 * description :
 */
fun listMvvmItemXml(
    activityPackageName: String,
    activityClass: String,
    beanName:String,
    beanPackageName:String
) = """
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <variable
            name="vm"
            type="${activityPackageName}.${activityClass}ViewModel" />

        <variable
            name="item"
            type="${beanPackageName}.${beanName}" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""