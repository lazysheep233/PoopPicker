package com.plteautech.pooppicker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.plteautech.pooppicker.fragment.HomeFragment;
import com.plteautech.pooppicker.fragment.PublishFragment;
import com.plteautech.pooppicker.fragment.FindFragment;
import com.plteautech.pooppicker.fragment.FinanceFragment;
import com.plteautech.pooppicker.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static String homepage = "mAnalysisFragment";
    protected TextView tvProtruding;
    protected ImageView imgProtruding;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private PublishFragment mPublishFragment;
    private FinanceFragment mFinanceFragment;
    private MeFragment mMeFragment;

    private FragmentManager fm;
    FragmentTransaction transaction;
    private RadioGroup mRadioButtonRg;
    private FragmentTransaction transaction1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            mHomeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fl, mHomeFragment, homepage).commit();
        }
    }


    /**
     * 初始化控件
     */
    private void initView() {
        mRadioButtonRg = (RadioGroup) findViewById(R.id.rg_oper);
        mRadioButtonRg.setOnCheckedChangeListener(this);
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        mHomeFragment = (HomeFragment) fm.findFragmentByTag(homepage);
        mFindFragment = (FindFragment) fm.findFragmentByTag("mEducationalAdminFragment");
        mPublishFragment = (PublishFragment) fm.findFragmentByTag("mDailyFragment");
        mFinanceFragment = (FinanceFragment) fm.findFragmentByTag("mFinanceFragment");
        mMeFragment = (MeFragment) fm.findFragmentByTag("mMeFragment");
        imgProtruding = (ImageView) findViewById(R.id.img_protruding);
    }


    /**
     * tab切换事件处理
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction1 = fm.beginTransaction();
        if (mHomeFragment != null) {
            transaction1.hide(mHomeFragment);
        }
        if (mFindFragment != null) {
            transaction1.hide(mFindFragment);
        }
        if (mPublishFragment != null) {
            transaction1.hide(mPublishFragment);
        }
        if (mFinanceFragment != null) {
            transaction1.hide(mFinanceFragment);
        }
        if (mMeFragment != null) {
            transaction1.hide(mMeFragment);
        }
        if (checkedId == R.id.rd_analysis) {
            if (mHomeFragment == null) {
                mHomeFragment = new HomeFragment();
                transaction1.add(R.id.fl, mHomeFragment, homepage);
            } else {
                transaction1.show(mHomeFragment);
            }
            imgProtruding.setImageResource(R.mipmap.cat1);

        } else if (checkedId == R.id.rd_educationadmin) {
            if (mFindFragment == null) {
                mFindFragment = new FindFragment();
                transaction1.add(R.id.fl, mFindFragment, "mEducationalAdminFragment");
            } else {
                transaction1.show(mFindFragment);
            }
            imgProtruding.setImageResource(R.mipmap.cat1);

        } else if (checkedId == R.id.rd_daily) {
            if (mPublishFragment == null) {
                mPublishFragment = new PublishFragment();
                transaction1.add(R.id.fl, mPublishFragment, "mDailyFragment");
            } else {
                transaction1.show(mPublishFragment);
            }
            imgProtruding.setImageResource(R.mipmap.cat1);

        } else if (checkedId == R.id.rd_finance) {
            if (mFinanceFragment == null) {
                mFinanceFragment = new FinanceFragment();
                transaction1.add(R.id.fl, mFinanceFragment, "mFinanceFragment");
            } else {
                transaction1.show(mFinanceFragment);
            }
            imgProtruding.setImageResource(R.mipmap.cat1);

        } else if (checkedId == R.id.rd_me) {
            if (mMeFragment == null) {
                mMeFragment = new MeFragment();
                transaction1.add(R.id.fl, mMeFragment, "mMeFragment");
            } else {
                transaction1.show(mMeFragment);
            }
            imgProtruding.setImageResource(R.mipmap.cat1);

        }
        transaction1.commit();
    }
}
