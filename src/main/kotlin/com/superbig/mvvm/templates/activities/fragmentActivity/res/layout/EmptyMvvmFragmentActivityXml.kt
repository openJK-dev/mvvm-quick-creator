package com.superbig.mvvm.templates.activities.fragmentActivity.res.layout

/**
 * @author : DianHua huang
 * date : 2022/4/13 17:56
 * description :
 */
fun emptyMvvmFragmentActivityXml(
    activityPackageName: String,
    activityClass: String
) = """
    <layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <import type="android.view.View" />

        <variable
            name="vm"
            type="${activityPackageName}.${activityClass}ViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <include
            android:id="@+id/toolbar"
            layout="@layout/toolbar" />
        <androidx.viewpager.widget.ViewPager
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/viewpager"/>

    </LinearLayout>
</layout>
"""