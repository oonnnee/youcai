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
import org.springframework.util.StringUtils;

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
        /*------------ 1.准备 -------------*/
        // 填充密码
        Guest findResult = guestRepository.findOne(guest.getId());
        guest.setPwd(findResult.getPwd());
        /*------------ 2.更新 -------------*/
        Guest updateResult = guestRepository.save(guest);
        if (updateResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_GUEST_UPDATE_ERROR);
        }
        /*------------ 3.结果处理 -------------*/
        updateResult.setPwd(null);
        /*------------ 4.返回结果 -------------*/
        return updateResult;
    }

    @Override
    public void delete(String id) {
        guestRepository.delete(id);
    }

    @Override
    public Guest findOne(String id) {
        /*------------ 1.查询 -------------*/
        Guest result = guestRepository.findOne(id);
        /*------------ 2.结果处理 -------------*/
        // 密码置空
        result.setPwd(null);
        /*------------ 3.返回结果 -------------*/
        return result;
    }

    @Override
    public Page<Guest> findAll(Pageable pageable) {
        /*------------ 1.查询 -------------*/
        Page<Guest> guestPage = guestRepository.findAll(pageable);
        /*------------ 2.结果处理 -------------*/
        // 密码置空
        for (Guest guest : guestPage.getContent()){
            guest.setPwd(null);
        }
        /*------------ 3.返回结果 -------------*/
        return guestPage;
    }

    @Override
    public Page<Guest> findByNameLike(String name, Pageable pageable) {
        if (StringUtils.isEmpty(name)){
            return guestRepository.findAll(pageable);
        }
        return guestRepository.findByNameLike("%"+name+"%", pageable);
    }

    @Override
    public Page<Guest> findByIdLike(String id, Pageable pageable) {
        if (StringUtils.isEmpty(id)){
            return guestRepository.findAll(pageable);
        }
        return guestRepository.findByIdLike("%"+id+"%", pageable);
    }

    @Override
    public void updatePwd(String id, String pwd) {
        /*------------ 1.查询用户 -------------*/
        Guest findResult = guestRepository.findOne(id);
        /*------------ 2.更新密码 -------------*/
        //TODO 加密
        findResult.setPwd(pwd);
        guestRepository.save(findResult);
    }
}