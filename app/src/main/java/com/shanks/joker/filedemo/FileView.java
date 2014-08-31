package com.shanks.joker.filedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by shanks on 14-8-31.
 */
public class FileView extends Activity implements AdapterView.OnItemClickListener{
    private ListView leftList;
    private ListView rightList;
    private SimpleAdapter simpleAdapter;

    private List<Map<String,Object>> fdata;
    private List<Map<String,Object>> data;
    private String currentDir = "/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.file_list);
        leftList = (ListView)findViewById(R.id.leftList);
        rightList = (ListView)findViewById(R.id.rightList);
        data = getData("/");
        currentDir = "/";

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getFolder("/"));
        simpleAdapter = new SimpleAdapter(this,data,R.layout.simlple_list,new String[]{"icon","fileName","R/W"},
                new int[]{R.id.icon,R.id.fileName,R.id.read});
        leftList.setAdapter(arrayAdapter);
        leftList.setOnItemClickListener(this);
        rightList.setAdapter(simpleAdapter);
        rightList.setOnItemClickListener(this);

    }

    public List<Map<String,Object>> getData (String dir){
        File file = new File(dir);
        fdata = new ArrayList<Map<String, Object>>();

        for (File f : file.listFiles()){
            if (f.isDirectory()){
                Map<String,Object> map =new HashMap<String, Object>();
              map.put("icon",R.drawable.folder);
              map.put("fileName",f.getName());
              map.put("R/W","R : "+f.canRead()+"W : "+f.canWrite());

              fdata.add(map);
            }
            else{
              Map<String,Object> map =new HashMap<String, Object>();
              map.put("icon",R.drawable.image);
              map.put("fileName",f.getName());
              map.put("R/W","R : "+f.canRead()+"W : "+f.canWrite());
              fdata.add(map);
            }
        }
        return fdata;
    }

    List<String> getFolder(String dir){
        List<String> list = new ArrayList<String>();
        File file = new File(dir);
        for(File f :file.listFiles()){
            if (f.isDirectory()){
                list.add(f.getName());
            }

        }
        return list;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView listView = (ListView) parent;
        Map<String,Object> map = (Map<String, Object>) listView.getItemAtPosition(position);
        String dir = (String)map.get("fileName");
        currentDir = currentDir  + dir + "/";
        Toast.makeText(this, currentDir+ "", Toast.LENGTH_SHORT).show();
        data.clear();
        Toast.makeText(this, data.isEmpty()+ "", Toast.LENGTH_SHORT).show();
        data = getData(currentDir);

        Toast.makeText(this, data.isEmpty()+ "", Toast.LENGTH_SHORT).show();
        simpleAdapter = new SimpleAdapter(this,data,R.layout.simlple_list,new String[]{"icon","fileName","R/W"},
                new int[]{R.id.icon,R.id.fileName,R.id.read});
        rightList.setAdapter(simpleAdapter);

        simpleAdapter.notifyDataSetChanged();

 //       String text = (String)rightList.getItemAtPosition(position);
//        String dir = currentDir + text + "/";
 //       Toast.makeText(this,text,Toast.LENGTH_LONG).show();
//        currentDir = dir;
//        File file = new File(dir);
//        if (file.isDirectory()){
//
//        }
    }
}
