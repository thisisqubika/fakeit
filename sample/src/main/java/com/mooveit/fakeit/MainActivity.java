package com.mooveit.fakeit;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mooveit.fakeit.databinding.ActivityMainBinding;
import com.mooveit.fakeit.models.AddressData;
import com.mooveit.fakeit.models.BusinessData;
import com.mooveit.fakeit.models.CardData;
import com.mooveit.fakeit.models.DateData;
import com.mooveit.fakeit.models.NameData;
import com.mooveit.library.Fakeit;

import java.util.Calendar;

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
        CardData cardData = new CardData();
        DateData dateData = new DateData();

        setNameData(nameData);
        setBusinessData(businessData);
        setAddressData(addressData);
        setCardData(cardData);
        setDateData(dateData);

        mBinding.setNameData(nameData);
        mBinding.setBusinessData(businessData);
        mBinding.setAddressData(addressData);
        mBinding.setCardData(cardData);
        mBinding.setDateDate(dateData);
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

    private void setCardData(CardData data) {
        data.name.set(Fakeit.card().name());
        data.brand.set(Fakeit.card().brand());
        data.number.set(Fakeit.card().number());
        data.type.set(Fakeit.card().type());
        data.expirationDate.set(Fakeit.card().expirationDate());
    }

    private void setDateData(DateData data) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 05, 10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020, 11, 25);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2017, 01, 20);
        data.date.set(Fakeit.date().date());
        data.dateBetweenRanges.set(Fakeit.date().dateBetweenRanges(calendar, calendar2));
        data.dateInTheFuture.set(Fakeit.date().dateInTheFuture(10));
        data.dateInThePast.set(Fakeit.date().dateInThePast(calendar3));
    }

    public void refresh(View view) {
        setNameData(mBinding.getNameData());
        setBusinessData(mBinding.getBusinessData());
        setAddressData(mBinding.getAddressData());
        setCardData(mBinding.getCardData());
        setDateData(mBinding.getDateDate());
    }
}
