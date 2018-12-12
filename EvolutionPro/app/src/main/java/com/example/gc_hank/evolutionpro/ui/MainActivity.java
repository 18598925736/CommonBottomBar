package com.example.gc_hank.evolutionpro.ui;

import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.gc_hank.evolutionpro.R;
import com.example.gc_hank.evolutionpro.ui.bottom.BottomAdapter;
import com.example.gc_hank.evolutionpro.ui.bottom.TabTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_bottom)
    RecyclerView mRvBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottom();
    }

    private void initBottom() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvBottom.setLayoutManager(linearLayoutManager);

        final BottomAdapter adapter = new BottomAdapter(this, getSetting());
        adapter.setOnItemClickListener(new BottomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                adapter.setSelection(position);
                //TODO 并且这里要切换Fragment
                Log.d("onItemClickTag", "" + position);
            }
        });
        mRvBottom.setAdapter(adapter);
    }

    //
    private List<TabTitle> getSetting() {
        List<TabTitle> titleObjectList = new ArrayList<>();
        titleObjectList.add(new TabTitle(R.string.tag_name_home, R.color.home_tab_text_selector, getStateListDrawable(R.mipmap.a_tabbar_home, R.mipmap.a_tabbar_home_p)));
        titleObjectList.add(new TabTitle(R.string.tag_name_quote, R.color.home_tab_text_selector, getStateListDrawable(R.mipmap.a_tabbar_market, R.mipmap.a_tabbar_market_p)));
        titleObjectList.add(new TabTitle(R.string.tag_name_deal, R.color.home_tab_text_selector, getStateListDrawable(R.mipmap.a_tabbar_trade, R.mipmap.a_tabbar_trade_p)));
        titleObjectList.add(new TabTitle(R.string.tag_name_mine, R.color.home_tab_text_selector, getStateListDrawable(R.mipmap.a_tabbar_me, R.mipmap.a_tabbar_me_p)));
        return titleObjectList;
    }

    /**
     * 返回一个Drawable对象，可以根据selected状态改变 图标
     *
     * @param normalIcon
     * @param selectedIcon
     * @return
     */
    private StateListDrawable getStateListDrawable(int normalIcon, int selectedIcon) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_selected}, ContextCompat.getDrawable(this, selectedIcon));//选中之后的drawable
        drawable.addState(new int[]{}, ContextCompat.getDrawable(this, normalIcon));//正常情况下的drawable
        return drawable;
    }
}
