package com.czy.admin.czyproject.jetPack.dataBinding;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * @author Create by cpSir on 2019/3/11
 */
public class Student {
    public final ObservableField<String> phoneNumber = new ObservableField<>();
    public final ObservableField<String> schoolName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
