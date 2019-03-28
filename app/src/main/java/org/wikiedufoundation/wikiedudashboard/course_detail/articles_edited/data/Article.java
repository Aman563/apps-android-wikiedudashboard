package org.wikiedufoundation.wikiedudashboard.course_detail.articles_edited.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Article {
    private String id;
    private String title;
    private String character_sum;
    private String view_count;
    private String url;
}
