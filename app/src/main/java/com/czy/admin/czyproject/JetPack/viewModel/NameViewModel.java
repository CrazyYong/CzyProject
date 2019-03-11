package com.czy.admin.czyproject.jetPack.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * liveData + viewModel
 */
public class NameViewModel extends ViewModel {


    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName(){
        if (currentName==null){
            currentName = new MutableLiveData<String>();
        }

        return currentName;
    }
}
