package com.appdeveloperrakib.viewmodelsandlivedata.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String>  getMyRandomNumber(){

        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createRandomNumber();
        }

        return myRandomNumber;

    }
    public void createRandomNumber(){
        Random random = new Random();
        myRandomNumber.postValue("My Random Number : "+random.nextInt(100-1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
