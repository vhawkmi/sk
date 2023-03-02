package com.github.vhawkmi.sk.generator.res.layout

/**
 *
 * @ProjectName:    sk
 * @Package:        com.github.vhawkmi.sk.generator.res.layout
 * @ClassName:      LayoutFragmentTemplate
 * @Description:     java类作用描述
 */

fun simpleLayoutTemp(desc : String) = """
    <?xml version="1.0" encoding="utf-8"?>
<layout>

    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.jdd.base.ui.widget.LoadingLayout
            android:id="@+id/layout_loading"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <com.scwang.smartrefresh.layout.SmartRefreshLayout
                android:id="@+id/layout_refresh"
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/recycle_content"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">


                </androidx.recyclerview.widget.RecyclerView>

            </com.scwang.smartrefresh.layout.SmartRefreshLayout>


        </com.jdd.base.ui.widget.LoadingLayout>

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>

"""