package com.shanks.joker.filedemo.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by joker on 15/08/2014.
 */
public class RightFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int layoutID = android.R.layout.simple_list_item_1;
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),layoutID,arrayList);
        setListAdapter(arrayAdapter);
    }



}
