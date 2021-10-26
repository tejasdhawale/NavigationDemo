package com.tjprojects.navigationdemo.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;

import java.util.List;

public class BindingUtils {

    public static final String ADD_VIEWS = "addViews";

    @BindingAdapter({ADD_VIEWS})
    public static void addView(LinearLayout linearLayout, List<View> viewList) {
        linearLayout.removeAllViews();
        for (View view : viewList) {
            if (view.getParent() == null) {
                linearLayout.addView(view);
            } else {
                ViewGroup parent = (ViewGroup) view.getParent();
                parent.removeView(view);
                linearLayout.addView(view);
            }
        }
    }
}
