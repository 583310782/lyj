package com.lyj.gitdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lyj.gitdemo.R;

/**
 * Created by 1 on 2016/7/27.
 */
public class HotspotFragment extends Fragment{
    private ListView lvRepos;
    private ArrayAdapter<String> adapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_repo_list,container,false);
        lvRepos= (ListView) view.findViewById(R.id.lvRepos);
        String[] datas = {"444"};
        adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                datas
        );
        lvRepos.setAdapter(adapter);
        return view;
    }
}
