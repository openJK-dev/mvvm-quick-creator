package com.superbig.mvvm.templates.fragments.listFragment.res.layout

/**
 * @author : DianHua huang
 * date : 2022/4/28 11:34
 * description :
 */
fun listMvvmFragmentItemXml(
    fragmentPackageName: String,
    fragmentClass: String,
    beanName:String,
    beanPackageName:String
) = """
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <variable
            name="vm"
            type="${fragmentPackageName}.${fragmentClass}ViewModel" />

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