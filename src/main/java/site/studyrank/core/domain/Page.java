package site.studyrank.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.ReactiveAdapterRegistry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Page {

    public Page(String link) {
        this.link = link;
    }

    @Id @GeneratedValue
    @Column(name = "page_id")
    private Long id;

    private String link;

}
