package cn.wb.entity;

public class Material {
		private int mid;
		private String material_id;//物料编号
		private String material_name;//物料名称
		private String c_name;//物料类别
		private String information;//物料信息
		private int number;//物料数量
		private String price;//物料单价
		public Material(int mid, String material_id, String material_name, String c_name, String information,
				int number, String price) {
			super();
			this.mid = mid;
			this.material_id = material_id;
			this.material_name = material_name;
			this.c_name = c_name;
			this.information = information;
			this.number = number;
			this.price = price;
		}
		public Material(String material_id, String material_name, String c_name, String information, int number,
				String price) {
			super();
			this.material_id = material_id;
			this.material_name = material_name;
			this.c_name = c_name;
			this.information = information;
			this.number = number;
			this.price = price;
		}
		public int getMid() {
			return mid;
		}
		public void setMid(int mid) {
			this.mid = mid;
		}
		public String getMaterial_id() {
			return material_id;
		}
		public void setMaterial_id(String material_id) {
			this.material_id = material_id;
		}
		public String getMaterial_name() {
			return material_name;
		}
		public void setMaterial_name(String material_name) {
			this.material_name = material_name;
		}
		public String getC_name() {
			return c_name;
		}
		public void setC_name(String c_name) {
			this.c_name = c_name;
		}
		public String getInformation() {
			return information;
		}
		public void setInformation(String information) {
			this.information = information;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}	
}
