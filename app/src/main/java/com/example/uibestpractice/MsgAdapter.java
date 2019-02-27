package com.example.uibestpractice;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;
	MsgHolder msgHolder;

	public MsgAdapter(Context context, int textViewResourceId, List objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Msg msg = getItem(position);
		View view;

		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			msgHolder = new MsgHolder();
			msgHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layou);
			msgHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layou);
			msgHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
			msgHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
			view.setTag(msgHolder);
		} else {
			view = convertView;
			msgHolder = (MsgHolder) view.getTag();
		}

		if (msg.getType() == Msg.TYPE_SENT) {
			msgHolder.rightLayout.setVisibility(View.VISIBLE);
			msgHolder.leftLayout.setVisibility(View.GONE);
			msgHolder.rightMsg.setText(msg.getContent());
		}else if (msg.getType() == Msg.TYPE_RECEIVED) {
			msgHolder.leftLayout.setVisibility(View.VISIBLE);
			msgHolder.rightLayout.setVisibility(View.GONE);
			msgHolder.leftMsg.setText(msg.getContent());
		}

		return view;
	}

	class MsgHolder {
		
		LinearLayout leftLayout;

		LinearLayout rightLayout;

		TextView leftMsg;

		TextView rightMsg;

	}

}
