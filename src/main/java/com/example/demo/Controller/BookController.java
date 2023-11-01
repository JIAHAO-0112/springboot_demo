package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    @GetMapping("/book-list")
    public String bookList() {
        return "book"; // Return the template name without the file extension
    }
}
