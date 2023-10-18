package com.example.pcsin

import com.example.pcsin.common.annotation.Service
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.example.pcsin"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                Service::class
            ]
        )
    ]
)
class ComponentScanConfig