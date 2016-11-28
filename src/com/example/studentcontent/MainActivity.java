package com.example.studentcontent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	FileHelper fh;
	// 数据
	private List<StuInfo> lf = null;
	// listview 列表
	
	private ListView lv = null;
	// 适配器ListAdapter
	private MyListAdapter sa = null;
	private Context mContext;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Initial();
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				AlertDialog.Builder builder = new Builder(MainActivity.this);
				builder.setTitle("学生信息：");
				String buf=
						lf.get(position).getID()+"\n"+
						lf.get(position).getName()+"\n"+
						lf.get(position).getS1()+"\n"+
						lf.get(position).getS2()+"\n"+
						lf.get(position).getS3();
				builder.setMessage(buf);
				AlertDialog dialog = builder.create();
				dialog.show();
			}
             
        });
	}
	
	private void Initial(){
		lv = (ListView) findViewById(R.id.listView1);
		mContext = MainActivity.this;
		lf = new LinkedList<StuInfo>();
		fh=new FileHelper(mContext,lf);
		try {
			InputStream a=getResources().openRawResource(R.raw.score);
			InputStreamReader rea=new InputStreamReader(a,"utf-8");
			BufferedReader reader = new BufferedReader(rea);
			fh.readFileOnLine(reader);
		} catch (IOException e) {
			 Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		sa = new MyListAdapter((LinkedList<StuInfo>) lf, mContext);
		lv.setAdapter(sa);
	}
	
}
	
	