package cn.com.ljy.retrofitrxjavademo.retrofit;

/**
 * Created by shuihan on 2016/12/12.
 */

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.wou.commonutils.Des;

import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException{
        try {
            JSONObject jsonObject = new JSONObject(value.string());
            if (jsonObject.has("result")) {
                String content = jsonObject.getString("result");
                byte[] over = Base64.decode(content, 0);
                Des des = new Des("undercover0601");
                String dejson = new String(des.decrypt(over), "utf-8");
                Log.d("main","解密结果--" + dejson);
                Reader reader = new StringReader(dejson);
                JsonReader jsonReader = gson.newJsonReader(reader);
                //JsonReader jsonReader = new JsonReader(reader);
                return adapter.read(jsonReader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            value.close();
        }
        return null;

       /* JsonReader jsonReader = gson.newJsonReader(value.charStream());
        try {
            return adapter.read(jsonReader);
        }  finally {
            value.close();
        }*/
    }
}
