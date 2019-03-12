package com.czy.admin.czyproject.jetPack.dataBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author Create by cpSir on 2019/3/12
 */
public class ObservableIser extends BaseObservable {
    private String sex;

    private String address;


    @Bindable
    public String getSex() {
        return sex;
    }

    @Bindable
    public String getAddress() {
        return address;
    }


    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }
}
