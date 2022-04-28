package com.superbig.mvvm.templates.fragments.emptyFragment.res.layout

/**
 * @author : DianHua huang
 * date : 2022/4/28 10:01
 * description :
 */

fun emptyMvvmFragmentXml(
    fragmentPackageName: String,
    fragmentClass: String
) = """
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <import type="android.view.View"/>
        <variable
            name="vm"
            type="${fragmentPackageName}.${fragmentClass}ViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

    </LinearLayout>
</layout>
"""