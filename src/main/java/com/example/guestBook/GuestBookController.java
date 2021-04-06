package com.example.guestBook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("guests")
public class GuestBookController {

    @Autowired
    public GuestBookService guestService;

//    public GuestBookController(GuestService animalService) {
//        this.animalService = animalService;
//    }


    @GetMapping
    public List<GuestDto> fetchAll()    {
      //  return new ArrayList<GuestDto>();

        return guestService.getAllComments();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody GuestDto guestDto) throws Exception {
        guestService.addGuest(guestDto);
    }
}
