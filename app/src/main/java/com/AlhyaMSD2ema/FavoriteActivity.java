package com.AlhyaMSD2ema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class FavoriteActivity extends AppCompatActivity {
	
	private String fontName = "";
	private String typeace = "";
	
	private ArrayList<HashMap<String, Object>> mapfav = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ListView listview1;
	
	private SharedPreferences sh;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.favorite);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		listview1 = (ListView) findViewById(R.id.listview1);
		sh = getSharedPreferences("sh", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		AdView linear2_adView = new AdView(FavoriteActivity.this);
		
		linear2_adView.setAdSize(AdSize.BANNER);
		        linear2_adView.setAdUnitId("");
		        linear2.addView(linear2_adView);
		        
		        AdRequest linear2_req = new            AdRequest.Builder().build();
		   linear2_adView.loadAd(linear2_req);
		if (sh.contains("saveData")) {
			mapfav = new Gson().fromJson(sh.getString("saveData", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(mapfav));
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "لم يتم إضافة اي بوست");
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _radius_to (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	
	public void _ICC (final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.posta, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear8 = (LinearLayout) _view.findViewById(R.id.linear8);
			final ImageView imageview13 = (ImageView) _view.findViewById(R.id.imageview13);
			final LinearLayout linear28 = (LinearLayout) _view.findViewById(R.id.linear28);
			final TextView textview10 = (TextView) _view.findViewById(R.id.textview10);
			
			if (mapfav.get((int)_position).containsKey("name_postQruan")) {
				textview10.setText(mapfav.get((int)_position).get("name_postQruan").toString());
			}
			_radius_to(linear8, 40, 2, "#7C4DFF");
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sh.edit().putString("name_post", mapfav.get((int)_position).get("name_postQruan").toString()).commit();
					
					final AlertDialog dialog = new AlertDialog.Builder(FavoriteActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.cus_fav, null);
					dialog.setView(convertView);
					dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					LinearLayout bg = (LinearLayout)
					convertView.findViewById(R.id.bg);
					
					
					TextView  textview1 = (TextView)
					convertView.findViewById(R.id.textview1);
					
					ImageView  img1 = (ImageView)
					convertView.findViewById(R.id.img1);
					
					
					
					
					ImageView  img2 = (ImageView)
					convertView.findViewById(R.id.img2);
					
					
					
					
					ImageView  img3 = (ImageView)
					convertView.findViewById(R.id.img3);
					img2.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
									
							((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview10.getText().toString()));
							SketchwareUtil.showMessage(getApplicationContext(), "تم نسخ البوست");
						}
					});
					img3.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
									
							Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, mapfav.get((int)_position).get("name_postQruan").toString()); startActivity(Intent.createChooser(i,mapfav.get((int)_position).get("name_postQruan").toString()));
						}
					});
					img1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							mapfav.remove((int)(_position));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							sh.edit().putString("saveData", new Gson().toJson(mapfav)).commit();
							dialog.dismiss();
						}
					});
					textview1.setText(sh.getString("name_post", ""));
					_ICC(img1, "#FFFFFF", "#FFFFFF");
					_ICC(img2, "#FFFFFF", "#FFFFFF");
					_ICC(img3, "#FFFFFF", "#FFFFFF");
					dialog.show();
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}