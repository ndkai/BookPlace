package com.example.bookplace.ui.base;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bookplace.di.MyApp;
import com.example.bookplace.di.component.DaggerIActivityComponent;
import com.example.bookplace.di.component.IActivityComponent;
import com.example.bookplace.di.module.ActivityModule;

/*
* The common class for all Activity later
* Each Activity must to extend this class
* */
public class BaseActivity extends AppCompatActivity implements IBaseView{

    IActivityComponent mIActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // make status bar background transparent
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        MyApp myApp = (MyApp) getApplication();
        mIActivityComponent = DaggerIActivityComponent.builder()
                .iAppComponent(myApp.getIAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    /*
    * get the interface used to inject dependencies into
    * derived classes later, like MainActivity
    * */
    public IActivityComponent getIActivityComponent() {
        return mIActivityComponent;
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    public void replaceFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    public void addFragment(int containerId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(containerId, fragment)
                .addToBackStack("")
                .commit();
    }

    public void backFragment() {
        getSupportFragmentManager().popBackStack();
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /*
    *  set auto show / hide keyboard when a editext focused.
    * */
    public void setAutoShowHideKeyboardFor(EditText editText) {
        editText.setOnFocusChangeListener((v, hasFocus) -> {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (hasFocus)
                inputMethodManager.showSoftInput(editText, 0);
            else
                inputMethodManager.hideSoftInputFromWindow(
                    editText.getWindowToken(), 0);
        });
    }

}
