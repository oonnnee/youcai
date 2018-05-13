package com.agriculture.youcai.controller;


import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.service.GuestService;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/guest")
public class ManageGuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/save")
    public ResultVO save(Guest guest){
        return guestService.save(guest);
    }

}
