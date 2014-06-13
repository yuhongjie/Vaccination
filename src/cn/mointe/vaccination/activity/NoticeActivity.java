package cn.mointe.vaccination.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.mointe.vaccination.R;

import com.umeng.analytics.MobclickAgent;

public class NoticeActivity extends Activity {

	private Button mNextBtn;

	private TextView mTitleText;
//	private ImageButton mTitleLeftImgbtn;// title左边图标
	private LinearLayout mTitleLeft;
	private ImageView mTitleRightImgbtn;// title右边图标

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notice);

		mNextBtn = (Button) this.findViewById(R.id.notice_btn_next);

		mTitleText = (TextView) this.findViewById(R.id.title_text);
//		mTitleLeftImgbtn = (ImageButton) this
//				.findViewById(R.id.title_left_imgbtn);
		mTitleLeft = (LinearLayout) this.findViewById(R.id.title_left);
		mTitleRightImgbtn = (ImageView) this
				.findViewById(R.id.title_right_imgbtn);

		mTitleText.setText(R.string.app_name);
		mTitleLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// NoticeActivity.this.finish();
			}
		});
		mTitleRightImgbtn.setVisibility(View.GONE);

		mNextBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(NoticeActivity.this,
						RegisterBabyActivity.class));
				NoticeActivity.this.finish();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onPageStart("NoticeActivity"); // 统计页面
		MobclickAgent.onResume(this); // 统计时长
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPageEnd("NoticeActivity");
		MobclickAgent.onPause(this);
	}

}
