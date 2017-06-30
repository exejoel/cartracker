package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.service.AlertService;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Joel on 6/26/17.
 */

@CrossOrigin(origins = "*")
@RestController("/readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;
    AlertService alertService;
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Reading create(@RequestBody Reading reading) {
        return readingService.create(reading);
    }
}

