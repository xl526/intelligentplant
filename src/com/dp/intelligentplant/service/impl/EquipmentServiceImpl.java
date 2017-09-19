package com.dp.intelligentplant.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dp.intelligentplant.dao.IEquipmentDao;
import com.dp.intelligentplant.dao.IEquipmentbrandDao;
import com.dp.intelligentplant.dao.IEquipmentregionDao;
import com.dp.intelligentplant.dao.IEquipmenttypeDao;
import com.dp.intelligentplant.domain.Equipment;
import com.dp.intelligentplant.domain.EquipmentBrand;
import com.dp.intelligentplant.domain.EquipmentRegion;
import com.dp.intelligentplant.domain.EquipmentType;
import com.dp.intelligentplant.fbox.DeviceVO;
import com.dp.intelligentplant.fbox.FBoxConfig;
import com.dp.intelligentplant.fbox.FBoxHelper;
import com.dp.intelligentplant.service.api.EquipmentService;
import com.dp.intelligentplant.vo.EquipmentVO;

@Service
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private IEquipmentDao equipmentDao;
	@Autowired
	private IEquipmenttypeDao equipmenttype;
	@Autowired
	private IEquipmentbrandDao equipmentbrandDao;
	@Autowired
	private IEquipmentregionDao equipmentregionDao;
	
	@Override
	@Transactional(readOnly = true)
	public Equipment findEquipmentById(Long equipmentId) {
		return equipmentDao.findOne(equipmentId);
	}
	
	@Override
	public EquipmentBrand findEquipmentBrandById(Long equipmentBrandId) {
		return equipmentbrandDao.findOne(equipmentBrandId);
	}
	
	@Override
	public EquipmentType findEquipmentTypeById(Long equipmentTypeId) {
		return equipmenttype.findOne(equipmentTypeId);
	}
	
	@Override
	public EquipmentRegion findEquipmentRegionById(Long equipmentRegionId) {
		return equipmentregionDao.findOne(equipmentRegionId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Equipment> listEquipment(EquipmentVO equipmentVO) {
		List<Equipment> list = equipmentDao.findAll(new Specification<Equipment>() {
			@Override
			public Predicate toPredicate(Root<Equipment> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				if (equipmentVO != null) {
					Predicate typeId = null;
					Predicate brandId = null;
					List<Predicate> list = new ArrayList<Predicate>();
					
					if (null != equipmentVO.getBrandId()) {
//						Join<Equipment, EquipmentBrand> innerJoin = root.join(root.getModel().getSingularAttribute("brand", EquipmentBrand.class), JoinType.INNER);
						brandId = cb.equal(root.get("brand").get("id").as(Long.class), equipmentVO.getBrandId());
					}
					if (null != equipmentVO.getTypeId()) {
						typeId = cb.equal(root.get("brand").get("type").get("id").as(Long.class), equipmentVO.getTypeId());
					}
					if (brandId != null) {
						list.add(brandId);
					}
					if (typeId != null) {
						list.add(typeId);
					}
					Predicate[] queryArr = new Predicate[list.size()];
					list.toArray(queryArr);
					query.where(queryArr);
				}
				return null;
			}
		});
		
		return list;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveOrUpdateEquipment(Equipment equipment) {
		equipmentDao.save(equipment);
	}
	
	@Override
	public void saveOrUpdateEquipmentBrand(EquipmentBrand equipmentBrand) {
		equipmentbrandDao.save(equipmentBrand);
	}
	
	@Override
	public void saveOrUpdateEquipmentType(EquipmentType equipmentType) {
		equipmenttype.save(equipmentType);
	}
	
	@Override
	public void saveOrUpdateEquipmentRegion(EquipmentRegion equipmentRegion) {
		equipmentregionDao.save(equipmentRegion);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteEquipment(Long equipmentId) {
		equipmentDao.delete(equipmentId);
	}
	
	@Override
	public void deleteEquipmentType(Long equipmentTypeId) {
		equipmenttype.delete(equipmentTypeId);
	}
	
	@Override
	public void deleteEquipmentBrand(Long equipmentBrandId) {
		equipmentbrandDao.delete(equipmentBrandId);
	}
	
	@Override
	public void deleteEquipmentRegion(Long equipmentRegionId) {
		equipmentregionDao.delete(equipmentRegionId);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Equipment> listFBoxEquipment() {
		
		String accessToken = null;
		String result = null;
		List<Equipment> list = new ArrayList<Equipment>();
		
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		Object obj = servletContext.getAttribute("accessToken");
		if (obj == null) {
			accessToken = FBoxHelper.login();
			servletContext.setAttribute("accessToken", accessToken);
		} else {
			accessToken = (String) obj;
		}
		
		for (String box_uid : FBoxConfig.BOX_UID_ARRAY) {
			result = FBoxHelper.listDevice(accessToken, box_uid);
			//token过期
			if (result.contains("Authorization has been denied for this request")) {
				accessToken = FBoxHelper.login();
				result = FBoxHelper.listDevice(accessToken, box_uid);
				servletContext.setAttribute("accessToken", accessToken);
			}
			
			JSONArray jsonArray = JSONArray.parseArray(result);
			
			for (Iterator<Object> iterator = jsonArray.iterator(); iterator.hasNext();) {
				JSONObject json = (JSONObject) iterator.next();
				DeviceVO deviceVO = JSONObject.toJavaObject(json, DeviceVO.class);
				Equipment equipment = fboxDevice2Equipment(deviceVO);
				list.add(equipment);
			}
		}
		
		return list;
	}
	
	private Equipment fboxDevice2Equipment(DeviceVO deviceVO) {
		Equipment equipment = new Equipment();
		equipment.setEno(deviceVO.getDeviceId());
		equipment.setEname(deviceVO.getDeviceName());
		
		return equipment;
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<EquipmentType> listEquipmenttype() {
		// TODO Auto-generated method stub
		return equipmenttype.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<EquipmentBrand> listEquipmentbrand() {
		// TODO Auto-generated method stub
		return equipmentbrandDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<EquipmentRegion> listEquipmentregion() {
		return equipmentregionDao.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void syncEquipment(List<Equipment> equipments) {
		equipmentDao.deleteAll();
		for (Equipment equip : equipments) {
			saveOrUpdateEquipment(equip);
		}
	}

}
