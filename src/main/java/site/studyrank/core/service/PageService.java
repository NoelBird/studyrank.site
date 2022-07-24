package site.studyrank.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.studyrank.core.domain.Page;
import site.studyrank.core.repository.PageRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PageService {
    private final PageRepository pageRepository;

    public Long savePage(Page page) {
        pageRepository.save(page);
        return page.getId();
    }

    public Page readPage(Long id) {
        return pageRepository.findOne(id);
    }

    public List<Page> list() {
        return pageRepository.findAll();
    }
}
