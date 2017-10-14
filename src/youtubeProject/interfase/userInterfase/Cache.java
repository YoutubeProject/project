package youtubeProject.interfase.userInterfase;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 1 on 03.10.2017.
 */
public class Cache {
    private String channellName;
    private String saveToCache;
    private String time;
    private ArrayList<String> list = new ArrayList<>();


    public Cache(String channelName, String saveToCache, String time) {
        this.channellName = channelName;
        this.saveToCache = saveToCache;
        this.time = time;
    }

    public boolean save() {
        boolean result = true;
        if (saveToCache.equals("TRUE") || saveToCache.equals("True") || saveToCache.equals("true")) {
            result = true;
        } else result = false;
        return result;
    }

    public boolean showTime() {
        boolean result = true;
        if (time.equals("TRUE") || time.equals("True") || time.equals("true")) {
            result = true;
        } else result = false;
        return result;
    }


    public void useTheCache() throws IOException {
        if (save()) {
            if (list.isEmpty()) {
                list.add(channellName);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (channellName.equals(list.get(i))) {
                        return;
                    }else list.add(channellName);
                }
            }

        }
    }
}
