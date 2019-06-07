package com.wm.remusic.net;

import android.util.Log;

/**
 * Created by ritchie-huang on 16-8-6.
 */
public class API {

    private static final String TAG = "API";
    private static final String BASE = "http://music.163.com/api/playlist/list?cat=全部&order=hot";

    // 网易云音乐接口
    //GET求
    //http://music.163.com/api/playlist/detail?id=xxx;
    private static String GEDAN_DETAIL_BASE = "http://music.163.com/api/playlist/detail?id=";

    //http://music.163.com/api/song/lyric?os=osx&id=xxx&lv=-1&kv=-1&tv=-1;
    private static String SONG_LYRIC_BASE = "http://music.163.com/api/song/lyric?os=osx";
    //http://music.163.com/api/song/detail/?id=xxx&ids=[xxx];
    private static String SONG_DETAIL_BASE = "http://music.163.com/api/song/detail/?id=";

    //https://music.163.com/song/media/outer/url?id=[xxx].mp3
    private static String SONG_MP3_BASE = "https://music.163.com/song/media/outer/url?id=";


    /**
     * 歌单
     *
     * @param pageNo   页码 从1开始
     * @param pageSize 每页数量
     * @return http://music.163.com/api/playlist/list?cat=全部&order=hot&offset=0&total=true&limit=1470;
     */
    public static String geDan(int pageNo, int pageSize) {
        StringBuffer sb = new StringBuffer(BASE);
        long offset = (pageNo - 1) * pageSize;
        sb.append("&offset=").append(offset)
                .append("&limit=").append(pageSize);
        Log.d(TAG, "geDan: " + sb.toString());
        return sb.toString();
    }


    /**
     * 歌单信息和歌曲
     *
     * @param listid 歌单id
     * @return
     */
    public static String geDanInfo(String listid) {
        StringBuffer sb = new StringBuffer(GEDAN_DETAIL_BASE);
        sb.append(listid);
        Log.d(TAG, "geDanInfo: " + sb.toString());
        return sb.toString();
    }


    /**
     * 获取歌词信息
     *
     * @param songid 歌曲id
     * @return
     */
    public static String getLyricInfo(String songid) {
        StringBuffer sb = new StringBuffer(SONG_LYRIC_BASE);
        sb.append("&id=").append(songid)
                .append("&id=-1&kv=-1&tv=-1");
        Log.d(TAG, "getLyricInfo: " + sb.toString());
        return sb.toString();
    }


    /**
     * 获取歌曲详情信息
     *
     * @param songid
     * @return
     */
    public static String getSongDetail(String songid) {
        StringBuffer sb = new StringBuffer(SONG_DETAIL_BASE);
        sb.append(songid)
                .append("&ids=[")
                .append(songid)
                .append("]");
        Log.d(TAG, "getSongDetail: " + sb.toString());
        return sb.toString();
    }




    /**
     * 获取歌曲Mp3地址
     *
     * @param songid
     * @return
     */
    public static String getSongMp3Url(String songid) {
        StringBuffer sb = new StringBuffer(SONG_MP3_BASE);
        sb.append("[")
                .append(songid)
                .append("].mp3");
        Log.d(TAG, "getSongMp3Url: " + sb.toString());
        return sb.toString();
    }


    /**
     * 获取歌词信息
     *
     * @param songid 歌曲id
     * @return
     */
    public static String getLyric(String songid) {
        String base = "https://api.imjad.cn/cloudmusic/?type=lyric&id=";
        StringBuffer sb = new StringBuffer(base);
        sb.append(songid);
        Log.d(TAG, "getLyric: " + sb.toString());
        return sb.toString();
    }

    public static String getMp3(String songid) {
        String base = "https://api.imjad.cn/cloudmusic/?type=song&id=";
        StringBuffer sb = new StringBuffer(base);
        sb.append(songid);
        Log.d(TAG, "getSongMp3: " + sb.toString());
        return sb.toString();
    }


    //POST请求
    public static String SEARCH = "http://music.163.com/api/search/get";
//    data = {
//            's': s,
//            'type': stype,搜索单曲(1)，歌手(100)，专辑(10)，歌单(1000)，用户(1002) *(type)*
//            'offset': offset,
//            'total': total,
//            'limit': 60
//   }

    // 百度音乐
    // GET
    //http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.song.play&songid=[xxx]
    public static String SONG_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.song.play&songid=";
}
