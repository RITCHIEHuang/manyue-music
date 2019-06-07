package com.wm.remusic.json;

public class NeteaseLyricInfo {

    /**
     * sgc : false
     * sfy : false
     * qfy : false
     * lrc : {"version":10,"lyric":"[00:00.000] 作曲 : 陈雪凝 [00:00.000] 作词 : 陈雪凝 [00:00.00]编曲：Dadz [00:00.880]若不是你突然闯进我生活 [00:04.370]我怎会把死守的寂寞放任了 [00:25.850]说不痛苦那是假的 [00:29.320]毕竟我的心也是肉做的 [00:33.700]你离开时我心里的彩虹 [00:37.600]就变成灰色 [00:41.570]说不心酸那是假的 [00:45.020]如果我真的没那么爱过 [00:48.940]爱着一个没有灵魂的人 [00:52.430]世界都是黑色 [00:56.670]若不是你突然闯进 我生活 [01:00.520]我怎会把死守的寂寞 放任了 [01:04.459]爱我的话你都说 [01:06.459]爱我的事你不做 [01:08.469]我却把甜言蜜语当做你爱我的躯壳 [01:12.890]你的悲伤难过我不参破 [01:16.310]我也会把曾经的且过 当施舍 [01:20.250]不去计较你太多 [01:22.250]从此你在我心里 [01:23.890]只剩绿色 [01:44.480]说很快活那是假的 [01:47.989]你的名字依然那么深刻 [01:51.940]每个字都刺穿我的心脏 [01:55.739]那鲜明的痛是红色 [01:59.569]若不是你突然闯进 我生活 [02:03.510]我怎会把死守的寂寞 放任了 [02:07.400]爱我的话你都说 [02:09.439]爱我的事你不做 [02:11.400]我却把甜言蜜语当做你爱我的躯壳 [02:15.770]你的悲伤难过我不参破 [02:19.199]我也会把曾经的且过 当施舍 [02:23.210]不去计较你太多 [02:25.129]从此你在我心里 [02:26.810]只剩绿色 [02:31.830]呼～ [03:33.979]若不是你突然闯进 我生活 [03:37.879]我怎会把死守的寂寞 放任了 [03:41.789]爱我的话你都说 [03:43.830]爱我的事你不做 [03:45.800]我却把甜言蜜语当做你爱我的躯壳 [03:50.330]若不是你突然闯进 我生活 [03:53.660]我怎会把死守的寂寞 放任了 [03:57.569]爱我的话你都说 [03:59.580]爱我的事你不做 [04:01.599]我却把甜言蜜语当做你爱我的躯壳 [04:05.990]你的悲伤难过我不参破 [04:09.430]我也会把曾经的且过 当施舍 [04:13.349]若不是你突然闯进 我生活 [04:17.319]我怎会把死守的寂寞 放任了 [04:21.199]爱我的话你都说 [04:23.230]爱我的事你不做 [04:25.250]我却把甜言蜜语当做你爱我的躯壳 [04:31.290]和声：李美灵芝 [04:32.810]混音：一曲不空 [04:34.040]发行：3SEVEN叁七 "}
     * klyric : {"version":0}
     * tlyric : {"version":0}
     * code : 200
     */

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LrcBean lrc;
    private KlyricBean klyric;
    private TlyricBean tlyric;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LrcBean getLrc() {
        return lrc;
    }

    public void setLrc(LrcBean lrc) {
        this.lrc = lrc;
    }

    public KlyricBean getKlyric() {
        return klyric;
    }

    public void setKlyric(KlyricBean klyric) {
        this.klyric = klyric;
    }

    public TlyricBean getTlyric() {
        return tlyric;
    }

    public void setTlyric(TlyricBean tlyric) {
        this.tlyric = tlyric;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LrcBean {
        /**
         * version : 10
         * lyric : [00:00.000] 作曲 : 陈雪凝 [00:00.000] 作词 : 陈雪凝 [00:00.00]编曲：Dadz [00:00.880]若不是你突然闯进我生活 [00:04.370]我怎会把死守的寂寞放任了 [00:25.850]说不痛苦那是假的 [00:29.320]毕竟我的心也是肉做的 [00:33.700]你离开时我心里的彩虹 [00:37.600]就变成灰色 [00:41.570]说不心酸那是假的 [00:45.020]如果我真的没那么爱过 [00:48.940]爱着一个没有灵魂的人 [00:52.430]世界都是黑色 [00:56.670]若不是你突然闯进 我生活 [01:00.520]我怎会把死守的寂寞 放任了 [01:04.459]爱我的话你都说 [01:06.459]爱我的事你不做 [01:08.469]我却把甜言蜜语当做你爱我的躯壳 [01:12.890]你的悲伤难过我不参破 [01:16.310]我也会把曾经的且过 当施舍 [01:20.250]不去计较你太多 [01:22.250]从此你在我心里 [01:23.890]只剩绿色 [01:44.480]说很快活那是假的 [01:47.989]你的名字依然那么深刻 [01:51.940]每个字都刺穿我的心脏 [01:55.739]那鲜明的痛是红色 [01:59.569]若不是你突然闯进 我生活 [02:03.510]我怎会把死守的寂寞 放任了 [02:07.400]爱我的话你都说 [02:09.439]爱我的事你不做 [02:11.400]我却把甜言蜜语当做你爱我的躯壳 [02:15.770]你的悲伤难过我不参破 [02:19.199]我也会把曾经的且过 当施舍 [02:23.210]不去计较你太多 [02:25.129]从此你在我心里 [02:26.810]只剩绿色 [02:31.830]呼～ [03:33.979]若不是你突然闯进 我生活 [03:37.879]我怎会把死守的寂寞 放任了 [03:41.789]爱我的话你都说 [03:43.830]爱我的事你不做 [03:45.800]我却把甜言蜜语当做你爱我的躯壳 [03:50.330]若不是你突然闯进 我生活 [03:53.660]我怎会把死守的寂寞 放任了 [03:57.569]爱我的话你都说 [03:59.580]爱我的事你不做 [04:01.599]我却把甜言蜜语当做你爱我的躯壳 [04:05.990]你的悲伤难过我不参破 [04:09.430]我也会把曾经的且过 当施舍 [04:13.349]若不是你突然闯进 我生活 [04:17.319]我怎会把死守的寂寞 放任了 [04:21.199]爱我的话你都说 [04:23.230]爱我的事你不做 [04:25.250]我却把甜言蜜语当做你爱我的躯壳 [04:31.290]和声：李美灵芝 [04:32.810]混音：一曲不空 [04:34.040]发行：3SEVEN叁七
         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }

    public static class KlyricBean {
        /**
         * version : 0
         */

        private int version;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

    public static class TlyricBean {
        /**
         * version : 0
         */

        private int version;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }
}
