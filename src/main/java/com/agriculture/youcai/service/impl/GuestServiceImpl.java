package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.repository.GuestRepository;
import com.agriculture.youcai.service.GuestService;
import com.agriculture.youcai.utils.KeyUtils;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest save(Guest guest) {
        guest.setId(KeyUtils.generate());
        //TODO 【管理端】新增客户，加密
        Guest saveResult = guestRepository.save(guest);
        if (saveResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_SAVE_ERROR);
        }
        saveResult.setPwd(null);
        return saveResult;
    }

    @Override
    public Guest update(Guest guest) {
        if (guest.getId() == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_UPDATE_NULL_ID);
        }
        if (guestRepository.findOne(guest.getId()) == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_UPDATE_NOT_EXIST);
        }
        //TODO 【管理端】更新客户，加密
        Guest result = guestRepository.save(guest);
        if (result == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_UPDATE_ERROR);
        }
        result.setPwd(null);
        return result;
    }

    @Override
    public void delete(String id) {
        if (id == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_DELETE_NULL_ID);
        }
        guestRepository.delete(id);
    }

    @Override
    public Guest findOne(String id) {
        if (id == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_FIND_ONE_NULL_ID);
        }
        Guest result = guestRepository.findOne(id);
        if (result == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_FIND_ONE_NOT_EXIST);
        }
        return guestRepository.findOne(id);
    }

    @Override
    public Page<Guest> findAll(Pageable pageable) {
        return guestRepository.findAll(pageable);
    }
}
