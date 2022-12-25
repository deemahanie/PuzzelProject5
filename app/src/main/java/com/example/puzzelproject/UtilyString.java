package com.example.puzzelproject;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class UtilyString {
   public static String readfromasets(Context context,String fileName) {
        String string ="";
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] byteobject = new byte[size];
            inputStream.read(byteobject);
            inputStream.close();
//         UTF-8 -->هادي الصيغة لنوعية النص الي راح يرجع
            string = new String(byteobject,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

}
