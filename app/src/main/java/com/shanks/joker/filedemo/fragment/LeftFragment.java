package com.shanks.joker.filedemo.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.shanks.joker.filedemo.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by joker on 15/08/2014.
 */
public class LeftFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int layoutID = android.R.layout.simple_list_item_1;
        ArrayList<String> arrayList = new ArrayList<String>();
        File file  = new File("/");
        String[] files = file.list();

        for (String f : files){
            arrayList.add(f);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),layoutID,arrayList);
        setListAdapter(arrayAdapter);

    }

}
