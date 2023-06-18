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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.widget.AdapterView;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class HomeActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> mapput = new HashMap<>();
	private HashMap<String, Object> mapm = new HashMap<>();
	private double fr = 0;
	private double et = 0;
	private String uri = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ma = new ArrayList<>();
	
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout ad1;
	private ListView listview1;
	private LinearLayout ad2;
	private ImageView imageview2;
	private LinearLayout linear9;
	private ImageView imageview1;
	private EditText edittext1;
	
	private SharedPreferences sh;
	private Intent i = new Intent();
	private TimerTask t;
	private DatabaseReference DBQruan = _firebase.getReference("DBQruan");
	private ChildEventListener _DBQruan_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		ad1 = (LinearLayout) findViewById(R.id.ad1);
		listview1 = (ListView) findViewById(R.id.listview1);
		ad2 = (LinearLayout) findViewById(R.id.ad2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		sh = getSharedPreferences("sh", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
				return true;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), FavoriteActivity.class);
				startActivity(i);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(HomeActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.custom,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				
				final LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				final LinearLayout linear10 = (LinearLayout) bottomSheetView.findViewById(R.id.linear10);
				
				final Button bt1 = (Button) bottomSheetView.findViewById(R.id.bt1);
				
				
				final Button bt2 = (Button) bottomSheetView.findViewById(R.id.bt2);
				
				
				final Button bt3 = (Button) bottomSheetView.findViewById(R.id.bt3);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				_radius_to(linear10, 40, 2, "#7C4DFF");
				_radius_to(bt1, 40, 2, "#7C4DFF");
				_radius_to(bt2, 40, 2, "#7C4DFF");
				_radius_to(bt3, 40, 2, "#7C4DFF");
				bt2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						uri = "com.pea3a5zan";
						String apk = "";
						try { 
							android.content.pm.PackageInfo pi = getPackageManager().getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); 
							apk = pi.applicationInfo.publicSourceDir; 
						}
						catch (Exception e) {
							Toast.makeText(getApplicationContext(), "An error occurred",
							   Toast.LENGTH_LONG).show(); 
						}
						StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build()); 
						Intent intent = new Intent(Intent.ACTION_SEND); 
						intent.setType("*/*"); 
						intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(apk))); 
						
						startActivity(Intent.createChooser(intent, "Pea3A7zan"));
					}
				});
				bt3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						SketchwareUtil.showMessage(getApplicationContext(), "وانا كمان بحبك علفكرا✨");
					}
				});
				bt1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						
						final AlertDialog dialog = new AlertDialog.Builder(HomeActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.inf_dev, null);
						dialog.setView(convertView);
						dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						LinearLayout linear12 = (LinearLayout)
						convertView.findViewById(R.id.linear12);
						
						
						LinearLayout linear6 = (LinearLayout)
						convertView.findViewById(R.id.linear6);
						
						ImageView wts = (ImageView)
						convertView.findViewById(R.id.wts);
						
						ImageView yt = (ImageView)
						convertView.findViewById(R.id.yt);
						
						
						ImageView fes = (ImageView)
						convertView.findViewById(R.id.fes);
						_radius_to(linear12, 40, 2, "#7C4DFF");
						_radius_to(linear6, 40, 2, "#7C4DFF");
						wts.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
								i.setAction(Intent.ACTION_VIEW);
								i.setData(Uri.parse("https://wa.me/+201142634571"));
								startActivity(i);
							}
						});
						yt.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
								i.setAction(Intent.ACTION_VIEW);
								i.setData(Uri.parse("https://www.youtube.com/@S.tohy_MA"));
								startActivity(i);
							}
						});
						fes.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
								i.setAction(Intent.ACTION_VIEW);
								i.setData(Uri.parse("https://www.facebook.com/profile.php?id=100038216388034"));
								startActivity(i);
							}
						});
						dialog.show();
					}
				});
				bottomSheetDialog.show();
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				DBQruan.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (edittext1.getText().toString().length() > 0) {
							fr = map.size() - 1;
							et = map.size();
							for(int _repeat52 = 0; _repeat52 < (int)(et); _repeat52++) {
								if (map.get((int)fr).get("name_postQruan").toString().toLowerCase().contains(edittext1.getText().toString().toLowerCase())) {
									
								}
								else {
									map.remove((int)(fr));
								}
								fr--;
							}
						}
						listview1.setAdapter(new Listview1Adapter(map));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_DBQruan_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				DBQruan.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(map));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		DBQruan.addChildEventListener(_DBQruan_child_listener);
	}
	
	private void initializeLogic() {
		AdView ad1_adView = new AdView(HomeActivity.this);
		
		ad1_adView.setAdSize(AdSize.BANNER);
		        ad1_adView.setAdUnitId("ca-app-pub-8984127746298171/7275212603");
		        ad1.addView(ad1_adView);
		        
		        AdRequest ad1_req = new            AdRequest.Builder().build();
		   ad1_adView.loadAd(ad1_req);
		AdView ad2_adView = new AdView(HomeActivity.this);
		
		ad2_adView.setAdSize(AdSize.BANNER);
		        ad2_adView.setAdUnitId("ca-app-pub-8984127746298171/7275212603");
		        ad2.addView(ad2_adView);
		        
		        AdRequest ad2_req = new            AdRequest.Builder().build();
		   ad2_adView.loadAd(ad2_req);
		_ICC(imageview1, "#7C4DFF", "#7C4DFF");
		_ICC(imageview2, "#7C4DFF", "#7C4DFF");
		DBQruan.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				map = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						map.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				listview1.setAdapter(new Listview1Adapter(map));
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
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
			
			textview10.setText(map.get((int)_position).get("name_postQruan").toString());
			_radius_to(linear8, 40, 2, "#7C4DFF");
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					sh.edit().putString("name_post", map.get((int)_position).get("name_postQruan").toString()).commit();
					
					final AlertDialog dialog = new AlertDialog.Builder(HomeActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.custom_diloag, null);
					dialog.setView(convertView);
					dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					LinearLayout bg = (LinearLayout)
					convertView.findViewById(R.id.bg);
					
					
					TextView  textview1 = (TextView)
					convertView.findViewById(R.id.textview1);
					
					
					TextView  textview2 = (TextView)
					convertView.findViewById(R.id.textview2);
					
					
					
					ImageView  img1 = (ImageView)
					convertView.findViewById(R.id.img1);
					
					
					
					
					ImageView  img2 = (ImageView)
					convertView.findViewById(R.id.img2);
					
					
					
					
					ImageView  img3 = (ImageView)
					convertView.findViewById(R.id.img3);
					img3.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
									
							Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, map.get((int)_position).get("name_postQruan").toString()); startActivity(Intent.createChooser(i,map.get((int)_position).get("name_postQruan").toString()));
						}
					});
					img2.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View _view) {
											
								
							((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview10.getText().toString()));
							SketchwareUtil.showMessage(getApplicationContext(), "تم نسخ اليوست");
						}
					});
					textview1.setText(sh.getString("name_post", ""));
					_ICC(img1, "#FFFFFF", "#FFFFFF");
					_ICC(img2, "#FFFFFF", "#FFFFFF");
					_ICC(img3, "#FFFFFF", "#FFFFFF");
					img1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (sh.getString("saveData", "").equals("")) {
								mapm = new HashMap<>();
								mapm.put("name_postQruan", map.get((int)_position).get("name_postQruan").toString());
								ma.add(mapm);
								sh.edit().putString("saveData", new Gson().toJson(ma)).commit();
								SketchwareUtil.showMessage(getApplicationContext(), "تم الحفظ");
							}
							else {
								ma = new Gson().fromJson(sh.getString("saveData", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
								mapm = new HashMap<>();
								mapm.put("name_postQruan", map.get((int)_position).get("name_postQruan").toString());
								ma.add(mapm);
								sh.edit().putString("saveData", new Gson().toJson(ma)).commit();
								SketchwareUtil.showMessage(getApplicationContext(), "تم الحفظ");
							}
							dialog.dismiss();
						}
					});
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