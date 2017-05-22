package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SysDictMapper;
import com.model.SysDictionary;
import com.pageModel.Data;
import com.pageModel.Dictionary;
import com.pageModel.Errcode;
import com.pageModel.TypeCode;
import com.service.DictServiceI;

/**
 * 用户service
 * 
 * @author xyl1153
 * 
 */
@Service("dictService")
public class DictServiceImpl extends BaseServiceImpl implements DictServiceI {
	private static final Logger logger = Logger
			.getLogger(DictServiceImpl.class);
	@Autowired
	private SysDictMapper sysDictMapper;

	@Override
	@Transactional
	public Data addDict(String typeCode, String name, String pCode) {
		String code;// 代码
		Integer level = 0;// 级别
		Integer index = 1;// 顺序
		Integer valid = 1;// 是否生效
		String prefix = "A";// 前缀
		SysDictionary dict = null;
		if (typeCode == null || typeCode.isEmpty()) {
			return Data.build(Errcode.FAILURE.ordinal(), false, "内部参数错误");
		}

		if (name == null || name.isEmpty()) {
			return Data.build(Errcode.FAILURE.ordinal(), false, "参数错误");
		}
		List<SysDictionary> dictList = this.sysDictMapper
				.findByTypeCode(typeCode);

		if (dictList != null && dictList.size() > 0) {
			dict = dictList.get(0);
		}
		if (dict != null) {
			index = Integer.parseInt(dict.getDictCode()
					.replaceAll("[^\\d]", "")) + 1;
		}
		prefix = TypeCode.getPrefix(typeCode);
		if (!(pCode == null || pCode.isEmpty())) {
			dict = this.sysDictMapper.findByDictCode(pCode);
			level = dict.getDictLevel() + 1;
		}

		code = prefix + String.format("%07d", index);

		dict = new SysDictionary();
		dict.setDictCode(code);
		dict.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		dict.setDictIndex(index);
		dict.setDictLevel(level);
		dict.setDictName(name);
		dict.setParentCode(pCode);
		dict.setTypeCode(typeCode);
		dict.setValid(valid);
		this.sysDictMapper.insert(dict);
		return Data.build(Errcode.SUCCESS.ordinal(), true, "添加成功");
	}

	@Override
	public Data getDictList(String typeCode) {
		List<Dictionary> l=new ArrayList();
		List<SysDictionary> dictList = this.sysDictMapper
				.findByTypeCode(typeCode);
		
		for(SysDictionary dict:dictList){
			Dictionary d=new Dictionary();
			BeanUtils.copyProperties(dict, d);
			l.add(d);
		}
		return Data.build(Errcode.SUCCESS.ordinal(), true, l,l.size());
	}

}
