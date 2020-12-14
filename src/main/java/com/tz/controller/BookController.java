package com.tz.controller;

import com.tz.pojo.Books;
import com.tz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public  String list(Model model){
        List<Books> list=bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public  String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public  String updateBook(Books books){
        System.out.println(books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public  String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }
    //根据名称查询书籍
    @RequestMapping("/queryBookByName")
    public  String queryBook(String queryBookName,Model model){
        List<Books> list = bookService.queryBookByName(queryBookName);
        //如果没有查询到，就返回全部书籍，并且将错误信息提交给前端
        if (list==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未找到");
        }
        model.addAttribute("list",list);
        return "allBook";

    }

}
