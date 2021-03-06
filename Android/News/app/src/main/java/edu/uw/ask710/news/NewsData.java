package edu.uw.ask710.news;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by anirudhsubramanyam on 10/23/17.
 */

//Custom class to hold details about news from newsapi and is parcelable.
public class NewsData implements Parcelable {
    public String headline = "";
    public String description = "";
    public String imageUrl = "";
    public long publishedTime = 0;
    public String url = "";
    public String source_id = "";
    public String source_name = "";

    //empty constructor
    public NewsData() {

    }
    public NewsData(String headline, String imageUrl, String description, long publishedTime,
                    String url, String source_id, String source_name){
        this.headline = headline;
        this.imageUrl = imageUrl;
        this.description = description;
        this.publishedTime = publishedTime;
        this.url = url;
        this.source_id = source_id;
        this.source_name = source_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected NewsData(Parcel in){
        headline = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        publishedTime = in.readLong();
        url = in.readString();
        source_id = in.readString();
        source_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(headline);
        parcel.writeString(description);
        parcel.writeString(imageUrl);
        parcel.writeLong(publishedTime);
        parcel.writeString(url);
        parcel.writeString(source_id);
        parcel.writeString(source_name);

    }

    public static final Parcelable.Creator<NewsData> CREATOR = new Parcelable.Creator<NewsData>(){
        @Override
        public NewsData createFromParcel(Parcel parcel) {
            return new NewsData(parcel);
        }

        @Override
        public NewsData[] newArray(int i) {
            return new NewsData[i];
        }
    };

        public String toString(){
            return (this.headline + " " + this.url);
        }

}

