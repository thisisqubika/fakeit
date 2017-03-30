package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.FileData;
import com.mooveit.library.Fakeit;

public class FileViewModel extends BaseViewModel {

    private FileData mData;

    public FileViewModel(FileData data) {
        this.mData = data;
        setBusinessData();
    }

    public FileData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.extension.set(Fakeit.file().extension());
        mData.mimeType.set(Fakeit.file().mimeType());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}