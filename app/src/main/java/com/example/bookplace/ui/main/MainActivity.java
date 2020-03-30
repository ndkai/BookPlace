package com.example.bookplace.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.bookplace.R;
import com.example.bookplace.ui.base.BaseActivity;
import com.example.bookplace.ui.home.HomeFragment;
import com.example.bookplace.ui.me.MeFragment;
import com.example.bookplace.ui.notification.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.nav_bottom)
    BottomNavigationView mNav;

    public static void open(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupEventViews();
        addFragment(R.id.container, new HomeFragment());
    }

    private void setupEventViews() {
        mNav.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.item_menu_notification:
                            replaceFragment(R.id.container, new NotificationFragment());
                            return true;

                        case R.id.item_menu_me:
                            replaceFragment(R.id.container, new MeFragment());
                            return true;

                        default:
                            replaceFragment(R.id.container, new HomeFragment());
                            return true;
                    }
                }
        );
    }

}
