package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.BookData;
import com.mooveit.library.Fakeit;

public class BookViewModel extends BaseViewModel {

    private BookData mData;

    public BookViewModel(BookData data) {
        this.mData = data;
        setBusinessData();
    }

    public BookData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.bookTitle.set(Fakeit.book().title());
        mData.bookAuthor.set(Fakeit.book().author());
        mData.bookPublisher.set(Fakeit.book().publisher());
        mData.bookGenre.set(Fakeit.book().genre());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}