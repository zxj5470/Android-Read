package com.example.studentcontent;

import java.util.LinkedList;

import android.R.color;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

	private LinkedList<StuInfo> data;
	private Context mContext;

	public MyListAdapter(LinkedList<StuInfo> data, Context mContext) {
		this.data = data;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView =LayoutInflater.from(mContext).
				inflate(R.layout.item,parent,false);
		TextView INFO =(TextView)convertView.findViewById(R.id.INFO);
		TextView INFO2 =(TextView)convertView.findViewById(R.id.INFO2);
		INFO.setText(data.get(position).getID()+"\t"+data.get(position).getName());
		INFO2.setText(data.get(position).getS1()+"\t"+
				data.get(position).getS2()+"\t"+data.get(position).getS3()+""
		);
		return convertView;
	}


}
