package com.gs.service.organ.impl;

import com.gs.dao.OrganMapper;
import com.gs.entity.OrganInfo;
import com.gs.service.organ.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganServiceImpl implements OrganService {
    @Autowired
    private OrganMapper organDao;

    @Override
    public List<Map<String, Object>> queryTypeBrandTreeMenu() {
        List<OrganInfo> organList=organDao.queryTypeBrandTreeMenu();
        return getTypeBrandTree("0", organList);
    }

    private List<Map<String, Object>> getTypeBrandTree(String pid, List<OrganInfo> organList) {
        List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
        organList.forEach(organ ->{
            Map<String, Object> map = null;
            if (pid.equals(organ.getPid())){
                map=new HashMap<String, Object>();
                map.put("id", organ.getId());
                map.put("name", organ.getName());
                map.put("checked", organ.getChecked());
                //第二次走当前方法将查询出的list集合里面数据pid与之前传过去的数据的id进行比较,判断是否有相同pid的数据,有的话将此数据当做之前传过去数据的子节点进行返回
                map.put("children",getTypeBrandTree(organ.getId(), organList));
            }
            if (map != null){
                list.add(map);
            }
        });
        return list;
    }
}
