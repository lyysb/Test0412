package com.example.lyy.test0412;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by LYY on 2018/4/12.
 */

public class Advert implements Parcelable {

    //职位
    private String position;
    //薪资
    private int salary;
    private String content;
    //构造方法


    public Advert(String position, int salary, String content) {
        this.position = position;
        this.salary = salary;
        this.content = content;
    }


    protected Advert(Parcel in) {

        position = in.readString();
        salary = in.readInt();
        content = in.readString();

    }


    public static final Creator CREATOR = new Creator() {
        @Override
        public Advert createFromParcel(Parcel in) {
            return new Advert(in);
        }

        @Override
        public Advert[] newArray(int size) {
            return new Advert[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(position);
        dest.writeInt(salary);
        dest.writeString(content);
    }

    //get ser方法

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getContent() {
        return content;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

