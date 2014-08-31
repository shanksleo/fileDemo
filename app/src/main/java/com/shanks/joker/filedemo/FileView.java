package com.shanks.joker.filedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by shanks on 14-8-31.
 */
public class FileView extends Activity {
    private ListView leftList;
    private ListView rightList;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,String>> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_list);
        leftList = (ListView)findViewById(R.id.leftList);
        rightList = (ListView)findViewById(R.id.rightList);
        data = getData("/");
        simpleAdapter = new SimpleAdapter(this,data,R.layout.simlple_list,new String[]{"icon","fileName","R/W"},
                new int[]{R.id.icon,R.id.fileName,R.id.read});
        leftList.setAdapter(simpleAdapter);
        rightList.setAdapter(simpleAdapter);

    }
    public List<Map<String,String>> getData (String dir){
        File file = new File(dir);
        for (File f : file.listFiles()){
            if (f.isFile()){
              Map<String,String> map =new HashMap<String, String>();
              map.put("icon","R.drawable.image");
              map.put("fileName",f.getName());
              map.put("R/W","R"+f.canRead()+"W"+f.canWrite());
              data.add(map);
            }
            else{
              Map<String,String> map =new HashMap<String, String>();
              map.put("icon","R.draw.folder");
              map.put("fileName",f.getName());
              map.put("R/W","R"+f.canRead()+"W"+f.canWrite());
              data.add(map);
            }
        }
        return data;
    }
}
