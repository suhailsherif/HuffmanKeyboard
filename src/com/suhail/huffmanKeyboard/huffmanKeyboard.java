package com.suhail.huffmanKeyboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class huffmanKeyboard extends Activity implements OnClickListener{
	private int mNode;
	private int mLeftChild[] = { 122 , 106 , 0 , 2 , 118 , 98 , 112 , 103 , 4 , 109 , 117 , 46 , 7 , 100 , 9 , 104 , 115 , 105 , 111 , 12 , 116 , 15 , 16 , 18 , 20 , 21 , 23 , 25 };
	private int mRightChild[] = { 113 , 120 , 1 , 107 , 3 , 44 , 121 , 119 , 102 , 99 , 5 , 6 , 108 , 8 , 10 , 114 , 11 , 110 , 97 , 13 , 14 , 101 , 17 , 19 , 32 , 22 , 24 , 26 };
	private String mLeftPossibles[] = { "z", "j", "zq", "zqjx", "v", "b", "p", "g", "vkzqjx", "m", "u", ".", "gw", "d", "mc", "h", "s", "i", "o", "lgw", "t", "hr", "s.py", "oa", "tmcub,", "ehr", "oaldgwfvkzqjx", "ehrsin.py" };
	private String mRightPossibles[] = { "q", "x", "jx", "k", "kzqjx", ",", "y", "w", "f", "c", "b,", "py", "l", "fvkzqjx", "ub,", "r", ".py", "n", "a", "dfvkzqjx", "mcub,", "e", "in", "ldgwfvkzqjx", " ", "sin.py", " tmcub,", " oatldgwfmcuvb,kzqjx" };
	private TextView mLeftPoss, mRightPoss;
	private EditText mEdit;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mEdit = (EditText) findViewById(R.id.edit);
        mLeftPoss = (TextView) findViewById(R.id.left_possibilities);
        mRightPoss = (TextView) findViewById(R.id.right_possibilities);
        updateNode(27);
    }
	
	@Override
	public void onClick(View arg0) {
		int clicked = arg0.getId();
		switch (clicked) {
		case R.id.left:
			updateNode(mLeftChild[mNode]);
			break;
		case R.id.right:
			updateNode(mRightChild[mNode]);
			break;
		}
		
	}
	
	void updateNode(int newNode){
		if(newNode<30){
			mNode = newNode;
		} else {
			mEdit.setText(mEdit.getText().toString()+(char)newNode);
			mNode = 27;
		}
		updatePossibles();
	}
	
	void updatePossibles(){
		mLeftPoss.setText("'"+mLeftPossibles[mNode]+"'");
		mRightPoss.setText("'"+mRightPossibles[mNode]+"'");
	}
}
