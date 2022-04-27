package com.superbig.mvvm.templates.activities.listActivity.res.layout

/**
 * @author : DianHua huang
 * date : 2022/4/27 14:22
 * description :
 */
fun listMvvmActivityXml(
    activityPackageName: String,
    activityClass: String
) = """
    <layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">

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
        <com.jdd.base.ui.widget.LoadingLayout
            android:id="@+id/loading_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:isFirstVisible="true">
            <com.scwang.smartrefresh.layout.SmartRefreshLayout
                android:id="@+id/smartRefresh"
                android:layout_width="match_parent"
                android:layout_height="match_parent">
                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/recycler"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"/>

            </com.scwang.smartrefresh.layout.SmartRefreshLayout>

        </com.jdd.base.ui.widget.LoadingLayout>

    </LinearLayout>
</layout>
"""