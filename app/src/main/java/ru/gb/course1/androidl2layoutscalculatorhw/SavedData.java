package ru.gb.course1.androidl2layoutscalculatorhw;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class SavedData implements Parcelable {
//    public class SavedData implements Serializable {

    public int countArgsSave;
    public float arg1Save;
    public float arg2Save;
    public float totalResultSave;
    public String argumentSave;
    public String textStringSave;
    public char operationSave;
    public boolean afterEqualsSave;

    public SavedData() {
        countArgsSave = 0;
        arg1Save = 0f;
        arg2Save = 0f;
        totalResultSave = 0f;
        operationSave = ' ';
        afterEqualsSave = true;
        argumentSave = "";
        textStringSave = "";
    }

    protected SavedData(Parcel in) {
        countArgsSave = in.readInt();
        arg1Save = in.readFloat();
        arg2Save = in.readFloat();
        totalResultSave = in.readFloat();
        argumentSave = in.readString();
        textStringSave = in.readString();
        operationSave = (char) in.readInt();
        afterEqualsSave = in.readByte() != 0;
    }

    public static final Creator<SavedData> CREATOR = new Creator<SavedData>() {
        @Override
        public SavedData createFromParcel(Parcel in) {
            return new SavedData(in);
        }

        @Override
        public SavedData[] newArray(int size) {
            return new SavedData[size];
        }
    };

    public int getCountArgsSave() { return countArgsSave; }

    public void setCountArgsSave(int countArgsSave) {
        this.countArgsSave = countArgsSave;
    }

    public float getArg1Save() {
        return arg1Save;
    }

    public void setArg1Save(float arg1Save) {
        this.arg1Save = arg1Save;
    }

    public float getArg2Save() {
        return arg2Save;
    }

    public void setArg2Save(float arg2Save) {
        this.arg2Save = arg2Save;
    }

    public float getTotalResultSave() {
        return totalResultSave;
    }

    public void setTotalResultSave(float totalResultSave) {
        this.totalResultSave = totalResultSave;
    }

    public String getArgumentSave() {
        return argumentSave;
    }

    public void setArgumentSave(String argumentSave) {
        this.argumentSave = argumentSave;
    }

    public String getTextStringSave() {
        return textStringSave;
    }

    public void setTextStringSave(String textStringSave) {
        this.textStringSave = textStringSave;
    }

    public char getOperationSave() {
        return operationSave;
    }

    public void setOperationSave(char operationSave) {
        this.operationSave = operationSave;
    }

    public boolean isAfterEqualsSave() {
        return afterEqualsSave;
    }

    public void setAfterEqualsSave(boolean afterEqualsSave) {
        this.afterEqualsSave = afterEqualsSave;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(countArgsSave);
        parcel.writeFloat(arg1Save);
        parcel.writeFloat(arg2Save);
        parcel.writeFloat(totalResultSave);
        parcel.writeString(argumentSave);
        parcel.writeString(textStringSave);
        parcel.writeInt((int) operationSave);
        parcel.writeByte((byte) (afterEqualsSave ? 1 : 0));
    }
}
