package cn.wb.dao;

import java.util.List;

import cn.wb.entity.Material;

public interface MaterialDao {
	/** 查看全部物料 */
	List<Material> listAllMaterial();
	/**查询物料*/
	List<Material> getMaterialCheck(String material_name);
	/** 根据物料名称加载物料信息 */
	Material getMaterialByName(String material_name);	
	/**添加物料*/
	int addMaterial(Material material);	
	/**删除物料*/
	int deleteMaterial(int mid);	
	/**编辑物料*/
	int updateMaterial(Material material);
	int countMaterialBymid(int mid);
	Material getMaterialByID(int mid);

}
