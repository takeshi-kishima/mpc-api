package com.hisol.mpcapi;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="prop")
@Data
public class Prop {
    private final List<String> images;
}
