package site.studyrank.core.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.studyrank.core.domain.Page;
import site.studyrank.core.service.PageService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final PageService pageService;

    @GetMapping("/pages")
    public Result listPages() {
        List<Page> list = pageService.list();
        List<ReadPageResponse> collect = list.stream()
                .map(ReadPageResponse::new).toList();
        return new Result<>(collect);
    }

    @PostMapping("/pages")
    public CreatePageResponse createPage(@RequestBody @Valid Page page) {
        Long id = pageService.savePage(page);
        return new CreatePageResponse(id);
    }

    @GetMapping("/pages/{pageId}")
    public ReadPageResponse readPage(@PathVariable("pageId") Long id) {
        Page page = pageService.readPage(id);
        return new ReadPageResponse(page);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    static class ReadPageResponse {
        private Long id;
        private String link;

        public ReadPageResponse(Page page) {
            this.id = page.getId();
            this.link = page.getLink();
        }
    }

    @Data
    @AllArgsConstructor
    private static class CreatePageResponse {
        private Long id;
    }
}
