package jp.mixi.practice.serializable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class User implements Parcelable {

    // 2. UserクラスにParcelableインターフェイスを実装してください。
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private int mData;

    public User (){}

    public User (Parcel in) {
        mData = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mData);
    }

    public void setData(int data){
        mData = data;
    }

    public int getData(){
        return mData;
    }

    private String name;
    private int id;
    private int age;
    private String keyword;
    private Status status;
    
    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static class Status{
        private Date mPostedDate;
        private String mText;
        public Date getPostedDate() {
            return mPostedDate;
        }
        public String getText(){
            return mText;
        }
        public void setPostedDate(Date date){
            mPostedDate = date;
        }
        public void setText(String text) {
            mText = text;
        }
    }

}
