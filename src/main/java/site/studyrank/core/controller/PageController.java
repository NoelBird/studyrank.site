package site.studyrank.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.studyrank.core.domain.Page;
import site.studyrank.core.service.PageService;

import java.util.List;

@Controller
@AllArgsConstructor
public class PageController {

    private final PageService pageService;
    
    @GetMapping("/pages")
    public String pageForm(Model model) {
        List<Page> list = pageService.list();
        model.addAttribute("page", list);
        return "index";
    }
}
