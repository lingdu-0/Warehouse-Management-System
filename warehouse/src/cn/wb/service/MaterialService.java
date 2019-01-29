package cn.wb.service;

import java.util.List;

import cn.wb.entity.Material;

public interface MaterialService {
	/**根据物料编号统计物料数量*/
	int countMaterialBymid(int mid);
	/**查询全部物料*/
	List<Material> listAllMaterial();
	/**根据物料编号加载物料信息*/
	Material getMaterialByID(int mid);
	/**删除物料*/
	int deleteMaterial(int mid);
	/**添加物料*/
	int addMaterial(Material material);
	/**编辑物料*/
	int updateMaterial(Material material);
	/**查询物料*/
	List<Material> getMaterialCheck(String material_name);
	
}
