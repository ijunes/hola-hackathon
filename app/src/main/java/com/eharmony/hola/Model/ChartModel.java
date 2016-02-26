package com.eharmony.hola.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lgarcia on 2/26/16.
 */
public class ChartModel implements Parcelable {
    private final int _id;
    private final int value;

    public ChartModel(int _id, int value) {
        this._id = _id;
        this.value = value;
    }

    public int get_id() {
        return _id;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeInt(this.value);
    }

    protected ChartModel(Parcel in) {
        this._id = in.readInt();
        this.value = in.readInt();
    }

    public static final Creator<ChartModel> CREATOR = new Creator<ChartModel>() {
        public ChartModel createFromParcel(Parcel source) {
            return new ChartModel(source);
        }

        public ChartModel[] newArray(int size) {
            return new ChartModel[size];
        }
    };
}
