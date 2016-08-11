package base.fire.com.listviewadapter.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by prem on 11/8/16.
 */
public class ModelItem {
    private int imageId;
    private String title;
    private String desc;

    public ModelItem(int imageId, String title, String desc) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
    }

    /**
     *

    Mostly JSONOBJECT WILL BE SEND TO THIS YOU HAVE TO PARSE IT ONE BY ONE AS THE EXAMPLE GIVEN BELOW**
    if they pass JSONObject for (All JSONArray send by the parent class one by on in for loop) then this is to be used
    public AbstractProductModel(JSONObject object) throws JSONException {
    try {
        city = object.getString(JsonParser.JSON_KEY_SELLER_CITY);
    } catch (JSONException e) {
        city = "";
    }
    }

     BY THIS WE GET THE GETTER OK
     public String getSellerCity() {
     return sellerCity;
     }

     */
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return title + "\n" + desc;
    }
}