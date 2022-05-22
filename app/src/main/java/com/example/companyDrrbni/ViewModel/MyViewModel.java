package com.example.companyDrrbni.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.google.firebase.auth.FirebaseUser;

public class MyViewModel extends AndroidViewModel {

    private Repository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void register (String email , String password ,
                          MyListener<FirebaseUser> isSuccessful , MyListener<String> isFailure){
        repository.register(email, password , isSuccessful , isFailure);
    }

    public void storeNo1 (FirebaseUser firebaseUser ,String name ,MyListener<Boolean> isSuccessful  ){
       repository.storeNo1(firebaseUser , name , isSuccessful);
    }

    public void storeNo2 (String governorate , String address , MyListener<Boolean> isSuccessful){
        repository.storeNo2(governorate , address , isSuccessful);
    }

    public void storeNo3 (String college , String major , MyListener<Boolean> isSuccessful){
        repository.storeNo3(college , major , isSuccessful);
    }

    public void storeNo4 (String whatsapp  , MyListener<Boolean> isSuccessful){
        repository.storeNo4(whatsapp , isSuccessful);
    }

}
