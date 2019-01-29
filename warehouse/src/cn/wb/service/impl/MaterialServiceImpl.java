package cn.wb.service.impl;

import java.util.List;

import cn.wb.dao.MaterialDao;
import cn.wb.dao.impl.MaterialDaoImpl;
import cn.wb.entity.Material;
import cn.wb.service.MaterialService;

public class MaterialServiceImpl implements MaterialService {

	MaterialDao materialDao=new MaterialDaoImpl();
	@Override
	public int countMaterialBymid(int mid) {
		return materialDao.countMaterialBymid(mid);
	}

	@Override
	public List<Material> listAllMaterial() {
		return materialDao.listAllMaterial();
	}

	@Override
	public Material getMaterialByID(int mid) {
		return materialDao.getMaterialByID(mid);
	}

	@Override
	public int deleteMaterial(int mid) {
		// TODO Auto-generated method stub
		return materialDao.deleteMaterial(mid);
	}

	@Override
	public int addMaterial(Material material) {
		return materialDao.addMaterial(material);
	}

	@Override
	public int updateMaterial(Material material) {
		int result = 0;
		/*// 判断物料名称是否存在
		Material m = materialDao.getMaterialByName(material.getMaterial_name());
		if (m == null) {// 物料名不存在，可以修改
			
		} else {// 物料名存在，不允许修改
			result = -1;
		}*/
		System.out.println(material.getMaterial_name());
		result = materialDao.updateMaterial(material);
		return result;
	}

	@Override
	public List<Material> getMaterialCheck(String material_name) {
		return materialDao.getMaterialCheck(material_name);
	}

}
