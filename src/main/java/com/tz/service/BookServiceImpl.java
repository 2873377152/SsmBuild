package com.tz.service;

import com.tz.mapper.BookMapper;
import com.tz.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //service层调用持久层：组合dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books>  queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
