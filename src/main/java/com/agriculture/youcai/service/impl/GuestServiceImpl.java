package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.repository.GuestRepository;
import com.agriculture.youcai.service.GuestService;
import com.agriculture.youcai.utils.KeyUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public ResultVO save(Guest guest) {
        ResultVO resultVO = new ResultVO();

        //TODO 【新增客户后端】校验客户信息

        guest.setId(KeyUtils.generate());
        Guest result = guestRepository.save(guest);

        if (result == null){
            return ResultVO.error("新增客户失败");
        }
        return ResultVO.success(result);
    }
}
