package com.example.smzad8;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {
    private final BookDao bookDao;
    private final LiveData<List<Book>> books;


    public BookRepository(Application application) {
        BookDatabase database =  BookDatabase.getDatabase(application);
        bookDao = database.bookDao();
        books = bookDao.findAll();
    }

    LiveData<List<Book>> findAll() {return books;}

    void insert(Book book){
        BookDatabase.databaseWriteExecutor.execute(() -> bookDao.insert(book));
    }
    void update(Book book){
        BookDatabase.databaseWriteExecutor.execute(() -> bookDao.update(book));
    }
    void delete(Book book){
        BookDatabase.databaseWriteExecutor.execute(() -> bookDao.delete(book));
    }

    /*
    void findBookWithName(String name){
        BookDatabase.databaseWriteExecutor.execute(() -> bookDao.findBookWithName(name));
    }
    */



}
