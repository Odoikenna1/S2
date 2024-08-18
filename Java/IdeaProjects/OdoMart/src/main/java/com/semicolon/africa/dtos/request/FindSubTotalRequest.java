package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FindSubTotalRequest {
    List<Item> items = new ArrayList<>();
}
