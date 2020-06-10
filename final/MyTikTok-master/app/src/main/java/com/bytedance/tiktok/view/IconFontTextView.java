package com.bytedance.tiktok.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

//侧边栏文字图标
public class IconFontTextView extends AppCompatTextView {
    private static Typeface typeface;

    public IconFontTextView(Context context) {
        super(context);
    }

    public IconFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        typeface = Typeface.createFromAsset(getContext().getAssets(), "iconfont.ttf");//直接导入icon
        setTypeface(typeface);
    }

}
