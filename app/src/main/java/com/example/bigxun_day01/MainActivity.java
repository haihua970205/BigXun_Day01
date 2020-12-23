package com.example.bigxun_day01;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bigxun_day01.ui.home.HomeFragment;
import com.example.bigxun_day01.ui.my.MyFragment;
import com.example.bigxun_day01.ui.shop.ShopFragment;
import com.example.bigxun_day01.ui.sort.SortFragment;
import com.example.bigxun_day01.ui.topic.TopicFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @BindView(R.id.home_vp)
    ViewPager homeVp;
    @BindView(R.id.home_tab)
    TabLayout homeTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
/*
        bottomNavigationView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_topic, R.id.navigation_sort, R.id.navigation_shop, R.id.navigation_my)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        item.setIcon(R.mipmap.ic_menu_choice_pressed);
                        break;
                    case R.id.navigation_topic:
                        item.setIcon(R.mipmap.ic_menu_topic_pressed);
                        break;
                    case R.id.navigation_sort:
                        item.setIcon(R.mipmap.ic_menu_sort_pressed);
                        break;
                    case R.id.navigation_shop:
                        item.setIcon(R.mipmap.ic_menu_shopping_pressed);
                        break;
                    case R.id.navigation_my:
                        item.setIcon(R.mipmap.ic_menu_me_pressed);
                        break;
                }
                return true;
            }
        });*/
    }

    private void initData() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new TopicFragment());
        list.add(new SortFragment());
        list.add(new ShopFragment());
        list.add(new MyFragment());
        homeVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        homeTab.setupWithViewPager(homeVp);
        homeTab.getTabAt(0).setText("首页").setIcon(R.mipmap.ic_menu_choice_pressed);
        homeTab.getTabAt(1).setText("专题").setIcon(R.mipmap.ic_menu_topic_pressed);
        homeTab.getTabAt(2).setText("分类").setIcon(R.mipmap.ic_menu_sort_pressed);
        homeTab.getTabAt(3).setText("购物车").setIcon(R.mipmap.ic_menu_shopping_pressed);
        homeTab.getTabAt(4).setText("我的").setIcon(R.mipmap.ic_menu_me_pressed);

        Intent intent = getIntent();
        if (intent.hasExtra("infoId")){
            int infoId = intent.getIntExtra("infoId", 0);
            homeVp.setCurrentItem(infoId);
        }

    }
}
/*<!--<com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/nav_view"
        android:layout_width="0dp"
        app:labelVisibilityMode="labeled"
        android:layout_height="wrap_content"
        android:layout_marginStart="0dp"
        android:layout_marginEnd="0dp"
        android:background="?android:attr/windowBackground"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:menu="@menu/bottom_nav_menu" />

<fragment
        android:id="@+id/nav_host_fragment"
                android:name="androidx.navigation.fragment.NavHostFragment"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:defaultNavHost="true"
                app:layout_constraintBottom_toTopOf="@id/nav_view"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:navGraph="@navigation/app_navigation" />*/
