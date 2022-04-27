package com.superbig.mvvm.templates.activities.emptyActivity.res.layout

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:56
 * description :
 */
fun emptyMvvmActivityXml(
    activityPackageName: String,
    activityClass: String
) = """
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <import type="android.view.View"/>
        <variable
            name="vm"
            type="${activityPackageName}.${activityClass}ViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <include layout="@layout/toolbar" android:id="@+id/toolbar"/>

    </LinearLayout>
</layout>
"""