package com.bytedance.tiktok.bean;

import android.util.Log;

import com.bytedance.tiktok.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * create by giria
 * create on 2020-06-10
 * description 本地数据创建，网络请求总是出问题 方便调试起见
 */
public class MyData {
    public static ArrayList<VideoBean> datas = new ArrayList<>();
    public static ArrayList<VideoBean.UserBean> userList = new ArrayList<>();

    public void initData() {
    String s ="[\n" +
            "   {\n" +
            "      \"_id\":\"5e9830b0ce330a0248e89d86\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/1137e480-170bac9c523-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"王火火\",\n" +
            "      \"description\":\"这是第一条Feed数据\",\n" +
            "      \"likecount\":10000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/f402a0e012b14d41ad07939746844c5e00005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e9833dec47d14020e85f416\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/e0bd348-170bac9c3b8-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"LILILI\",\n" +
            "      \"description\":\"这是一条一起学猫叫的视频\",\n" +
            "      \"likecount\":120000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/8bd6d06878fc4676a62290cbe8b5511f00005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e9833e0c47d14020e85f418\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/2f03c005-170bac9abac-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"新闻启示录\",\n" +
            "      \"description\":\"赶紧把这个转发给你们的女朋友吧，这才是对她们最负责的AI\",\n" +
            "      \"likecount\":45000000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/371ddcdf7bbe46b682913f3d3353192000005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e9833e0a21527020d426e91\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/7bf938c-170bac9c18a-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"综艺大咖秀\",\n" +
            "      \"description\":\"男明星身高暴击\",\n" +
            "      \"likecount\":98777000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/dabe6ca3c71942fd926a86c8996d750f00005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e9833e1c47d14020e85f43a\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/47788f38-170bac9ab8a-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"南翔不爱吃饭\",\n" +
            "      \"description\":\"挑战手抓饼的一百种吃法第七天\",\n" +
            "      \"likecount\":500000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/edac56544e2f43bb827bd0e819db381000005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e983406a21527020d426f1f\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/2d6ffe8f-170bac9ab87-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"王者主播那些事儿\",\n" +
            "      \"description\":\"你有试过蔡文姬打野吗？\",\n" +
            "      \"likecount\":1000000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/531f1e488eb84b898ae9ca7f6ba758ed00005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e98340da21527020d426f43\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/633e0ce-170bac9ab65-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"十秒学做菜\",\n" +
            "      \"description\":\"两款爱吃的三明治分享\",\n" +
            "      \"likecount\":1010102,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/ad0331e78393457d88ded2257d9e47c800005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e983415a21527020d426f7b\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/2d6ffe8f-170bac9ab87-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"九零后老母亲\",\n" +
            "      \"description\":\"从孕期到产后，老公一直要我用这个勺子喝汤\",\n" +
            "      \"likecount\":94321,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/6ae53110f7fd470683587746f027698400005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e98341da21527020d426f97\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/51f7552c-170bac98718-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"FPX电子竞技俱乐部\",\n" +
            "      \"description\":\"甲方的需求：F P X冠军皮肤的起源\",\n" +
            "      \"likecount\":1200000,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/ef384b95897b470c80a4aca4dd1112a500005.jpg\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"_id\":\"5e983423a21527020d426fbb\",\n" +
            "      \"feedurl\":\"http://jzvd.nathen.cn/video/2a101070-170bad88892-0007-1823-c86-de200.mp4\",\n" +
            "      \"nickname\":\"抖音官方广告报名！\",\n" +
            "      \"description\":\"买它！买它！买它！\",\n" +
            "      \"likecount\":480,\n" +
            "      \"avatar\":\"http://jzvd.nathen.cn/snapshot/86a055d08b514c9ca1e76e76862105ec00005.jpg\"\n" +
            "   }\n" +
            "]";
        Gson gson = new Gson();
        List<TestBean> users = gson.fromJson(s, new TypeToken<List<TestBean>>(){}.getType());
        Log.d("GsonDemo", users.get(1).toString());


        VideoBean videoBeanOne = new VideoBean();
        videoBeanOne.setCoverRes(R.mipmap.cover1);
        videoBeanOne.setContent(users.get(0).getDescription());
        videoBeanOne.setVideoRes(R.raw.video1);
        videoBeanOne.setLiked(false);
        videoBeanOne.setLikeCount(users.get(0).getLikecount());
        videoBeanOne.setCommentCount(1111);
        videoBeanOne.setShareCount(111);

        VideoBean.UserBean userBeanOne = new VideoBean.UserBean();
        userBeanOne.setUid(users.get(0).getId());
        userBeanOne.setHead(R.mipmap.avatar);
        userBeanOne.setNickName(users.get(0).getName());
        userBeanOne.setLikeCount(users.get(0).getLikecount());

        userList.add(userBeanOne);
        videoBeanOne.setUserBean(userBeanOne);

        VideoBean videoBeanTwo = new VideoBean();
        videoBeanTwo.setCoverRes(R.mipmap.cover2);
        videoBeanTwo.setContent(users.get(1).getDescription());
        videoBeanTwo.setVideoRes(R.raw.video2);
        videoBeanTwo.setLiked(false);
        videoBeanTwo.setLikeCount(users.get(1).getLikecount());
        videoBeanTwo.setCommentCount(2222);
        videoBeanTwo.setShareCount(222);

        VideoBean.UserBean userBeanTwo = new VideoBean.UserBean();
        userBeanTwo.setUid(users.get(1).getId());
        userBeanTwo.setHead( R.mipmap.avatar);
        userBeanTwo.setNickName(users.get(1).getName());
        userBeanTwo.setLikeCount(users.get(1).getLikecount());

        userList.add(userBeanTwo);
        videoBeanTwo.setUserBean(userBeanTwo);

        VideoBean videoBeanThree = new VideoBean();
        videoBeanThree.setCoverRes(R.mipmap.cover3);
        videoBeanThree.setContent(users.get(2).getDescription());
        videoBeanThree.setVideoRes(R.raw.video3);
        videoBeanThree.setLiked(false);
        videoBeanThree.setLikeCount(users.get(2).getLikecount());
        videoBeanThree.setCommentCount(3333);
        videoBeanThree.setShareCount(333);

        VideoBean.UserBean userBeanThree = new VideoBean.UserBean();
        userBeanThree.setUid(users.get(2).getId());
        userBeanThree.setHead(R.mipmap.avatar);
        userBeanThree.setNickName(users.get(2).getName());
        userBeanThree.setLikeCount(users.get(2).getLikecount());

        userList.add(userBeanThree);
        videoBeanThree.setUserBean(userBeanThree);

        VideoBean videoBeanFour = new VideoBean();
        videoBeanFour.setCoverRes(R.mipmap.cover4);
        videoBeanFour.setContent(users.get(3).getDescription());
        videoBeanFour.setVideoRes(R.raw.video4);
        videoBeanFour.setLiked(false);
        videoBeanFour.setLikeCount(users.get(3).getLikecount());
        videoBeanFour.setCommentCount(4444);
        videoBeanFour.setShareCount(444);

        VideoBean.UserBean userBeanFour = new VideoBean.UserBean();
        userBeanFour.setUid(users.get(3).getId());
        userBeanFour.setHead(R.mipmap.avatar);
        userBeanFour.setNickName(users.get(3).getName());
        userBeanFour.setLikeCount(users.get(3).getLikecount());

        userList.add(userBeanFour);
        videoBeanFour.setUserBean(userBeanFour);

        VideoBean videoBeanFive = new VideoBean();
        videoBeanFive.setCoverRes(R.mipmap.cover5);
        videoBeanFive.setContent(users.get(4).getDescription());
        videoBeanFive.setVideoRes(R.raw.video5);
        videoBeanFive.setLiked(false);
        videoBeanFive.setLikeCount(users.get(4).getLikecount());
        videoBeanFive.setCommentCount(5555);
        videoBeanFive.setShareCount(555);

        VideoBean.UserBean userBeanFive = new VideoBean.UserBean();
        userBeanFive.setUid(users.get(4).getId());
        userBeanFive.setHead(R.mipmap.avatar);
        userBeanFive.setNickName(users.get(4).getName());
        userBeanFive.setLikeCount(users.get(4).getLikecount());

        userList.add(userBeanFive);
        videoBeanFive.setUserBean(userBeanFive);

        VideoBean videoBeanSix = new VideoBean();
        videoBeanSix.setCoverRes(R.mipmap.cover6);
        videoBeanSix.setContent(users.get(5).getDescription());
        videoBeanSix.setVideoRes(R.raw.video6);
        videoBeanSix.setLiked(true);
        videoBeanSix.setLikeCount(users.get(5).getLikecount());
        videoBeanSix.setCommentCount(6666);
        videoBeanSix.setShareCount(666);

        VideoBean.UserBean userBeanSix = new VideoBean.UserBean();
        userBeanSix.setUid(users.get(5).getId());
        userBeanSix.setHead(R.mipmap.avatar);
        userBeanSix.setNickName(users.get(5).getName());
        userBeanSix.setLikeCount(0);

        userList.add(userBeanSix);
        videoBeanSix.setUserBean(userBeanSix);

        VideoBean videoBeanSeven = new VideoBean();
        videoBeanSeven.setCoverRes(R.mipmap.cover7);
        videoBeanSeven.setContent(users.get(6).getDescription());
        videoBeanSeven.setVideoRes(R.raw.video7);
        videoBeanSeven.setLiked(false);
        videoBeanSeven.setLikeCount(users.get(6).getLikecount());
        videoBeanSeven.setCommentCount(7777);
        videoBeanSeven.setShareCount(777);

        VideoBean.UserBean userBeanSeven = new VideoBean.UserBean();
        userBeanSeven.setUid(users.get(6).getId());
        userBeanSeven.setHead(R.mipmap.avatar);
        userBeanSeven.setNickName(users.get(6).getName());
        userBeanSeven.setLikeCount(839);

        userList.add(userBeanSeven);
        videoBeanSeven.setUserBean(userBeanSeven);

        VideoBean videoBeanEight = new VideoBean();
        videoBeanEight.setCoverRes(R.mipmap.cover8);
        videoBeanEight.setContent(users.get(7).getDescription());
        videoBeanEight.setVideoRes(R.raw.video8);
        videoBeanEight.setLiked(false);
        videoBeanEight.setLikeCount(users.get(7).getLikecount());
        videoBeanEight.setCommentCount(8888);
        videoBeanEight.setShareCount(888);

        VideoBean.UserBean userBeanEight = new VideoBean.UserBean();
        userBeanEight.setUid(users.get(7).getId());
        userBeanEight.setHead(R.mipmap.avatar);
        userBeanEight.setNickName(users.get(7).getName());
        userBeanEight.setLikeCount(0);

        userList.add(userBeanEight);
        videoBeanEight.setUserBean(userBeanEight);


        VideoBean videoBeanNine = new VideoBean();
        videoBeanNine.setCoverRes(R.mipmap.cover9);
        videoBeanNine.setContent(users.get(8).getDescription());
        videoBeanNine.setVideoRes(R.raw.video9);
        videoBeanNine.setLiked(false);
        videoBeanNine.setLikeCount(users.get(8).getLikecount());
        videoBeanNine.setCommentCount(9999);
        videoBeanNine.setShareCount(999);

        VideoBean.UserBean userBeanNine = new VideoBean.UserBean();
        userBeanNine.setUid(users.get(8).getId());
        userBeanNine.setHead(R.mipmap.avatar);
        userBeanNine.setNickName(users.get(8).getName());
        userBeanNine.setLikeCount(0);

        userList.add(userBeanNine);
        videoBeanNine.setUserBean(userBeanNine);

        VideoBean videoBeanTen = new VideoBean();
        videoBeanTen.setCoverRes(R.mipmap.cover10);
        videoBeanTen.setContent(users.get(9).getDescription());
        videoBeanTen.setVideoRes(R.raw.video10);
        videoBeanTen.setLiked(false);
        videoBeanTen.setLikeCount(users.get(9).getLikecount());
        videoBeanTen.setCommentCount(101010);
        videoBeanTen.setShareCount(101);

        VideoBean.UserBean userBeanTen= new VideoBean.UserBean();
        userBeanTen.setUid(users.get(9).getId());
        userBeanTen.setHead(R.mipmap.avatar);
        userBeanTen.setNickName(users.get(9).getName());
        userBeanTen.setLikeCount(0);

        userList.add(userBeanTen);
        videoBeanTen.setUserBean(userBeanTen);

        datas.add(videoBeanOne);
        datas.add(videoBeanTwo);
        datas.add(videoBeanThree);
        datas.add(videoBeanFour);
        datas.add(videoBeanFive);
        datas.add(videoBeanSix);
        datas.add(videoBeanSeven);
        datas.add(videoBeanEight);
        datas.add(videoBeanNine);
        datas.add(videoBeanTen);
    }
}
