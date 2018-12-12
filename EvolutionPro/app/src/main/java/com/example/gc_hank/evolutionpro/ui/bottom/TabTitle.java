package com.example.gc_hank.evolutionpro.ui.bottom;

import android.graphics.drawable.StateListDrawable;

public class TabTitle {
    private int titleName;
    private int textColorStateList;
    private StateListDrawable drawable;

    /**
     * 底部导航栏配置类
     *
     * @param titleName          标题text
     * @param textColorStateList 标题颜色selector
     * @param drawable           标题icon 的selector
     */
    public TabTitle(int titleName, int textColorStateList, StateListDrawable drawable) {
        this.titleName = titleName;
        this.drawable = drawable;
        this.textColorStateList = textColorStateList;
    }

    public int getTitleName() {
        return titleName;
    }

    public StateListDrawable getDrawable() {
        return drawable;
    }

    public int getTextColorStateList() {
        return textColorStateList;
    }


}