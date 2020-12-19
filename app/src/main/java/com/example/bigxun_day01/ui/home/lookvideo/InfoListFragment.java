package com.example.bigxun_day01.ui.home.lookvideo;

import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigxun_day01.R;
import com.example.bigxun_day01.adapter.lookinfo.LookFragmentAdapter;
import com.example.bigxun_day01.base.BaseFragment;
import com.example.bigxun_day01.interfaces.lookactivityinterface.ILookFragment;
import com.example.bigxun_day01.model.lookactivitybean.LookInfoFragmentBean;
import com.example.bigxun_day01.presenter.lookactivitypresent.LookFragmentPresent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InfoListFragment extends BaseFragment<ILookFragment.Presenter> implements ILookFragment.View {

    @BindView(R.id.look_fragment_recycle)
    RecyclerView lookFragmentRecycle;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_info)
    TextView txtInfo;
    private List<LookInfoFragmentBean.DataBeanX.DataBean> list;
    private LookFragmentAdapter lookFragmentAdapter;

    public InfoListFragment() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_look_info;
    }

    @Override
    protected LookFragmentPresent createPrenter() {
        return new LookFragmentPresent(this);
    }

    @Override
    protected void initView() {
        String name = getArguments().getString("name");
        String infoname = getArguments().getString("infoname");
        lookFragmentRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        list = new ArrayList<>();
        if (name!=null&&infoname!=null){
            txtName.setText(name);
            txtInfo.setText(infoname);
        }
        lookFragmentAdapter = new LookFragmentAdapter(getActivity(), list);
        lookFragmentRecycle.setAdapter(lookFragmentAdapter);
    }

    @Override
    protected void initData() {
        int id = getArguments().getInt("id");
        Log.e("TAG", "initData: ====" + id);
        presenter.getFragList(id);
    }

    @Override
    public void getFragListReturn(LookInfoFragmentBean lookInfoFragmentBean) {
        List<LookInfoFragmentBean.DataBeanX.DataBean> data = lookInfoFragmentBean.getData().getData();
        list.addAll(data);
        lookFragmentAdapter.notifyDataSetChanged();
    }
}
