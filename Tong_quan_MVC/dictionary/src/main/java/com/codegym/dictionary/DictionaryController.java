package com.codegym.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("book", "Quyển sách");
        dictionary.put("computer", "Máy tính");
        dictionary.put("beautiful", "Đẹp");
        dictionary.put("beauty", "Vẻ đẹp");
        dictionary.put("thandong", "Nguyễn Quang Hữu");
        dictionary.put("prodigy", "thandong");
        dictionary.put("Nguyễn Quang Hữu", "Thần đồng");
    }

    @GetMapping("/")
    public String index() {
        return "dictionary";
    }

    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        // Chuyển về chữ thường để tra cứu chính xác hơn
        String result = dictionary.get(word.toLowerCase().trim());

        if (result != null) {
            model.addAttribute("word", word);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("message", "Không tìm thấy từ này trong từ điển!");
        }
        return "dictionary";
    }
}
