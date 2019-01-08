package com.plteautech.pooppicker.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.plteautech.pooppicker.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 分析
 *
 * @author yangpf
 */
public class HomeFragment extends Fragment {


    private View mRootView;
    private RecyclerView mHomeRecyclerView;
    private HomeRecyclerViewAdaptor mAdaptor;
    private List<TipBean> list = new ArrayList<>();

    @Override
    public void onStart() {
        super.onStart();
        mHomeRecyclerView = getActivity().findViewById(R.id.home_recyclerView);
        mAdaptor = new HomeRecyclerViewAdaptor(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mHomeRecyclerView.setLayoutManager(layoutManager);
        mHomeRecyclerView.setAdapter(mAdaptor);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        return mRootView;
    }

    private void init() {

        for (int i = 0; i < 5; i++) {
            TipBean tip = new TipBean();
            tip.setName("name");
            tip.setTime("5 min ago");
            tip.setText("今天天气真好啊好，哈哈哈哈哈，是花花似乎死似乎都好了");
            tip.setUserImg("");
            tip.setImg1("");
            tip.setImg2("");
            tip.setImg3("");
            list.add(tip);
        }
    }

    public class HomeRecyclerViewAdaptor extends RecyclerView.Adapter<HomeRecyclerViewAdaptor.HomeViewHolder> {

        private Context content;
        private List<TipBean> list;

        public HomeRecyclerViewAdaptor(Context context, List<TipBean> list) {
            this.content = context;
            this.list = list;
        }

        @Override
        public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycle_view, parent, false);
            HomeViewHolder viewHolder = new HomeViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(HomeViewHolder viewHolder, int pos) {
            viewHolder.mNickName.setText(list.get(pos).getName());
            viewHolder.mContent.setText(list.get(pos).getText());
            viewHolder.mTime.setText(list.get(pos).getTime());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class HomeViewHolder extends RecyclerView.ViewHolder {

            private TextView mNickName;
            private TextView mTime;
            private TextView mContent;
            private ImageView mUserPhoto;
            private ImageView mImg1;
            private ImageView mImg2;
            private ImageView mImg3;

            public HomeViewHolder(View view) {
                super(view);
                mNickName = view.findViewById(R.id.textView);
                mTime = view.findViewById(R.id.textView3);
                mContent = view.findViewById(R.id.textView4);
                mUserPhoto = view.findViewById(R.id.imageView);
                mImg1 = view.findViewById(R.id.home_img_1);
                mImg2 = view.findViewById(R.id.home_img_2);
                mImg3 = view.findViewById(R.id.home_img_3);
            }
        }
    }


}
