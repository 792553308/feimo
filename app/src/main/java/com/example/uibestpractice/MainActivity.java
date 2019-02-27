package com.example.uibestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView msgListVieiw;
	
	private EditText inputText;
	
	private Button send;
	
	private MsgAdapter adapter;
	
	private List<Msg> msgList = new ArrayList<Msg>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initMsgs();
		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListVieiw = (ListView) findViewById(R.id.msg_list_view);
		msgListVieiw.setAdapter(adapter);
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				Log.d("1111111111", content);
				if (!"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListVieiw.setSelection(msgList.size());
					inputText.setText("");
					
				}
				
			}
		});
		
	}
	
	
	private void initMsgs(){
		Msg msg = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
		msgList.add(msg);
		msg = new Msg("Hello. Who is tha", Msg.TYPE_SENT);
		msgList.add(msg);
		msg = new Msg("This is Tom. Nice talking to you", Msg.TYPE_RECEIVED);
		msgList.add(msg);
	}

	
}
