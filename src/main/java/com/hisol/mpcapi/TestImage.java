package com.hisol.mpcapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestImage {
    private final long id;
    private final String name;
    private final String content;
}
