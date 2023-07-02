package edu.hust.it4409.web.booking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect
@Getter
@Setter
public class FilterBody {
    private Integer moneyFrom;
    private Integer moneyTo;
    private List<Integer> starRatings;
    private Double rankingMin;
}