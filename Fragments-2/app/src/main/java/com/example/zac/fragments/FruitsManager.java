package com.example.zac.fragments;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by zac on 2/22/17.
 */

public class FruitsManager {
    public static Set<String> getFruitNames(Context context) {
        Map<String, String> fruit_dict = getFruitDict(context);
        return fruit_dict.keySet();
    }

    public static List<String> getFruitImageNames(Context context) {
        Map<String, String> fruit_dict = getFruitDict(context);
        return new ArrayList<String>(fruit_dict.values());
    }

    public static Map<String, String> getFruitDict(Context context) {
        String[] fruit_list = context.getResources().getStringArray(R.array.titles);
        Map<String, String> fruit_dict = new LinkedHashMap<>();
        for(String fruitStr : fruit_list) {
            String[] split = fruitStr.split(":");
            fruit_dict.put(split[0], split[1]);
        }
        return fruit_dict;
    }

    public static String getFruitName(Context context, int i) {
        List<String> fruit_names = new ArrayList<>(getFruitNames(context));
        return fruit_names.get(i);
    }

    public static int getFruitId(Context context, int fruit_index) {
        List<String> fruit_files = new ArrayList<>(getFruitImageNames(context));
        if(fruit_index >= fruit_files.size()) {
            return -1;
        }
        return getFruitId(context, fruit_files.get(fruit_index));
    }

    public static int getFruitId(Context context, String fruit_file) {
        return context.getResources().getIdentifier(fruit_file, "drawable", context.getPackageName());
    }
}
