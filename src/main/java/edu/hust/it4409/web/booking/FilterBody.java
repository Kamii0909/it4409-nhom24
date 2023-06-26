package edu.hust.it4409.web.booking;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect
@Getter
@Setter
public class FilterBody {
    BigDecimal moneyFrom;
    BigDecimal moneyTo;
    List<Integer> starRatings;
    double rankingMin;
}