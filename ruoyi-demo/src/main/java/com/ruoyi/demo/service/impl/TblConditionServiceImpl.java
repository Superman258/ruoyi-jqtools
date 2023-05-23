package com.ruoyi.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.demo.domain.TblCondition;
import com.ruoyi.demo.domain.TblJubao;
import com.ruoyi.demo.mapper.TblConditionMapper;
import com.ruoyi.demo.mapper.TblJubaoMapper;
import com.ruoyi.demo.service.ITblJubaoService;
import com.ruoyi.demo.service.ITblXingshiService;
import com.ruoyi.demo.service.TblConditionService;
import org.springframework.stereotype.Service;

@Service
public class TblConditionServiceImpl extends ServiceImpl<TblConditionMapper, TblCondition> implements TblConditionService {
}
