package com.mooveit.fakeit;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mooveit.fakeit.databinding.ActivityMainBinding;
import com.mooveit.fakeit.models.AddressData;
import com.mooveit.fakeit.models.AncientData;
import com.mooveit.fakeit.models.BusinessData;
import com.mooveit.fakeit.models.CardData;
import com.mooveit.fakeit.models.NameData;
import com.mooveit.library.Fakeit;

public class MainActivity extends AppCompatActivity {

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
        AncientData ancientData = new AncientData();

        setNameData(nameData);
        setBusinessData(businessData);
        setAddressData(addressData);
        setCardData(cardData);
        setAncientData(ancientData);

        mBinding.setNameData(nameData);
        mBinding.setBusinessData(businessData);
        mBinding.setAddressData(addressData);
        mBinding.setCardData(cardData);
        mBinding.setAncientData(ancientData);
    }

    private void setNameData(NameData data) {
        data.fullName.set(Fakeit.name().firstName() + " " + Fakeit.name().lastName());
        data.fullMiddleName.set(Fakeit.name().name());
        data.firstName.set(Fakeit.name().firstName());
        data.lastName.set(Fakeit.name().lastName());
        data.title.set(Fakeit.name().title());
        data.userName.set("avatar4242");
    }

    private void setBusinessData(BusinessData data) {
        data.businessName.set(Fakeit.business().name());
        data.businessType.set(Fakeit.business().type());
        data.businessSubType.set(Fakeit.business().subType());
    }

    private void setAddressData(AddressData data) {
        data.city.set(Fakeit.address().city());
        data.streetAddress.set(Fakeit.address().streetAddress());
        data.buildingNumber.set(Fakeit.address().buildingNumber());
        data.zipCode.set(Fakeit.address().zipCode());
        data.state.set(Fakeit.address().state());
        data.stateAbbreviation.set(Fakeit.address().stateAbbreviation());
    }

    private void setCardData(CardData data) {
        data.name.set(Fakeit.card().name());
        data.brand.set(Fakeit.card().brand());
        data.number.set(Fakeit.card().number());
        data.type.set(Fakeit.card().type());
        data.expirationDate.set(Fakeit.card().expirationDate());
    }

    public void setAncientData(AncientData data) {
        data.god.set(Fakeit.ancient().god());
        data.primordial.set(Fakeit.ancient().primordial());
        data.titan.set(Fakeit.ancient().titan());
        data.hero.set(Fakeit.ancient().hero());
    }

    public void refresh(View view) {
        setNameData(mBinding.getNameData());
        setBusinessData(mBinding.getBusinessData());
        setAddressData(mBinding.getAddressData());
        setCardData(mBinding.getCardData());
        setAncientData(mBinding.getAncientData());
    }
}
