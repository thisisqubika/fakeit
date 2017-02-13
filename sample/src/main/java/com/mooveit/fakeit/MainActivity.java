package com.mooveit.fakeit;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mooveit.fakeit.databinding.ActivityMainBinding;
import com.mooveit.fakeit.models.AddressData;
import com.mooveit.fakeit.models.BusinessData;
import com.mooveit.fakeit.models.NameData;
import com.mooveit.library.Fakeit;

public class MainActivity extends AppCompatActivity {

    private static final boolean CONSISTENT_ADDRESS = true;

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Fakeit.initWithLocale(this, "es");

        NameData nameData = new NameData();
        BusinessData businessData = new BusinessData();
        AddressData addressData = new AddressData();

        setNameData(nameData);
        setBusinessData(businessData);
        setAddressData(addressData);

        mBinding.setNameData(nameData);
        mBinding.setBusinessData(businessData);
        mBinding.setAddressData(addressData);
    }

    private void setNameData(NameData data) {
        data.fullName.set(Fakeit.name().fullName());
        data.fullMiddleName.set(Fakeit.name().fullWithMiddleName());
        data.firstName.set(Fakeit.name().firstName());
        data.lastName.set(Fakeit.name().lastName());
        data.title.set(Fakeit.name().title());
        data.userName.set(Fakeit.name().userName());
    }

    private void setBusinessData(BusinessData data) {
        data.businessName.set(Fakeit.business().name());
        data.businessType.set(Fakeit.business().type());
        data.businessSubType.set(Fakeit.business().subType());
    }

    private void setAddressData(AddressData data) {
        if (CONSISTENT_ADDRESS) {
            Fakeit.address().initRandomAddress();
        }
        data.city.set(Fakeit.address().city());
        data.streetAddress.set(Fakeit.address().streetAddress());
        data.buildingNumber.set(Fakeit.address().buildingNumber());
        data.zipCode.set(Fakeit.address().zipCode());
        data.state.set(Fakeit.address().state());
        data.stateAbbreviation.set(Fakeit.address().stateAbbreviation());
        data.latitude.set(Fakeit.address().latitude());
        data.longitude.set(Fakeit.address().longitude());
    }

    public void refresh(View view) {
        setNameData(mBinding.getNameData());
        setBusinessData(mBinding.getBusinessData());
        setAddressData(mBinding.getAddressData());
    }
}
