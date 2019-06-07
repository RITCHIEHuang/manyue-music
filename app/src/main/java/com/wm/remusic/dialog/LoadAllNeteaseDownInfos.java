package com.wm.remusic.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wm.remusic.R;
import com.wm.remusic.downmusic.DownService;
import com.wm.remusic.json.MusicFileDownInfo;
import com.wm.remusic.json.NeteaseSongList.ResultBean.TracksBean;
import com.wm.remusic.net.API;
import com.wm.remusic.net.RequestThreadPool;
import com.wm.remusic.uitl.IConstants;

import java.util.ArrayList;
import java.util.List;

public class LoadAllNeteaseDownInfos extends AsyncTask<Void, Void, Boolean> {
    private Activity mContext;

    private List<TracksBean> mList = new ArrayList<>();
    private PopupWindow popupWindow;
    private int totalSize;
    private ArrayList<String> mUrlList = new ArrayList<>();

    public LoadAllNeteaseDownInfos(Activity context, List<TracksBean> list) {
        mContext = context;
        mList = list;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        View view;
        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.loading_circle, null);
            popupWindow = new PopupWindow(view, 200, 220);
        }
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popupWindow.showAtLocation(mContext.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                RequestThreadPool.finish();
                cancel(true);
            }
        });

    }


    @Override
    protected Boolean doInBackground(Void... params) {

        try {
            int le = mList.size();
            for (int i = 0; i < le; ++i) {
                String song_mp3_url = API.getSongMp3Url(mList.get(i).getId() + "");
                mUrlList.add(song_mp3_url);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }


    @Override
    protected void onPostExecute(Boolean correct) {
        super.onPostExecute(correct);
        if (correct) {
            String result = null;
            totalSize = totalSize / (1024 * 1024);
            Log.e("totalSize", totalSize + "");
            if (totalSize > 1024) {
                result = (float) Math.round((float) totalSize / (1024 * 10)) / 10 + "G";
            } else {
                result = totalSize + "M";

            }

            new AlertDialog.Builder(mContext).setTitle("将下载歌曲,大约占用" + result + "空间,确定下载吗")
                    .setPositiveButton(mContext.getString(R.string.sure), new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int len = mList.size();
                            String[] names = new String[len];
                            String[] artists = new String[len];
                            for (int i = 0; i < len; i++) {
                                names[i] = mList.get(i).getName();
                                artists[i] = mList.get(i).getArtists().get(0).getName();
                            }
                            Intent intent = new Intent();
                            intent.putExtra("names", names);
                            intent.putExtra("artists", artists);
                            intent.putExtra("urls", mUrlList);
                            intent.setAction(DownService.ADD_MULTI_DOWNTASK);
                            intent.setPackage(IConstants.PACKAGE);
                            mContext.startService(intent);


                            dialog.dismiss();
                        }
                    }).
                    setNegativeButton(mContext.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            RequestThreadPool.finish();
                            cancel(true);
                            dialog.dismiss();
                        }
                    }).show();

        } else {
            Toast.makeText(mContext, "歌单列表中有信息错误，请重试", Toast.LENGTH_SHORT).show();
        }
        popupWindow.dismiss();

    }
}