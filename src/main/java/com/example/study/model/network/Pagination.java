package com.example.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Pagination {

    //총 페이지
    private Integer totalPages;

    //총 개수
    private Long totalElements;

    //현재 페이지
    private Integer currentPage;

    //현재 페이징의 개수
    private Integer currentElements;
}
