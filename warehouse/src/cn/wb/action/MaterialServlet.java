 package cn.wb.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.wb.entity.Material;
import cn.wb.service.MaterialService;
import cn.wb.service.impl.MaterialServiceImpl;

@WebServlet("/MaterialServlet")
public class MaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				// 调用物料服务接口
				MaterialService materialService = new MaterialServiceImpl();
				request.setCharacterEncoding("utf-8");
				// js弹窗乱码解决
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();				
				String flag = request.getParameter("flag");
				HttpSession session = request.getSession();
				if(flag.equals("list")){
					List<Material> materialList =materialService.listAllMaterial();
					session.setAttribute("materialList",materialList);
					response.sendRedirect("material/interface.jsp");
				}				
				if(flag.equals("check")){
					// 获取物料名称
					String material_name = request.getParameter("material_name");
					// 加载物料
					List<Material> materialList=materialService.getMaterialCheck(material_name);
					// 跳转到物料编辑页面
					if(materialList==null){
						out.print(
								"<script type='text/javascript'>alert('该物料不存在！');location.href='MaterialServlet?flag=list';</script>");
					}
					session.setAttribute("materialList", materialList);
					response.sendRedirect("material/material_check.jsp");
				}
				if(flag.equals("delete")){//删除物料
	
					int mid=Integer.valueOf(request.getParameter("mid"));
					int result=materialService.countMaterialBymid(mid);
					int condition=materialService.deleteMaterial(mid);
					if(condition>0){// 删除物料成功
						out.print(
								"<script type='text/javascript'>alert('删除物料成功！');location.href='MaterialServlet?flag=list';</script>");						
					} else {// 删除物料失败
						out.print(
								"<script type='text/javascript'>alert('删除物料失败！');location.href='MaterialServlet?flag=list';</script>");
					}
				}
				if(flag.equals("load")){//修改物料
					// 获取物料序号
					int mid = Integer.valueOf(request.getParameter("mid"));
					// 加载物料
					Material material= materialService.getMaterialByID(mid);
					// 跳转到物料编辑页面
					session.setAttribute("material", material);
					response.sendRedirect("material/material_modify.jsp");
				}
				if(flag.equals("update")){//修改物料
					int mid = Integer.valueOf(request.getParameter("mid"));
					//获取物料编号
					String material_id=request.getParameter("material_id");
					// 获取物料名称
					String material_name = request.getParameter("material_name");
					//获取物料类别
					String c_name = request.getParameter("c_name");
					//获取物料数量
					int number =Integer.valueOf(request.getParameter("number"));
					//获取物料单价
					String price = request.getParameter("price");
					//获取物料信息
					String information = request.getParameter("information");
					Material material = new Material( mid,material_id,material_name,c_name,information,number,price);				
					int result = materialService.updateMaterial(material);// 更新物料		
					if (result > 0) {// 更新物料成功
						out.print(
								"<script type='text/javascript'>alert('更新物料成功！');location.href='MaterialServlet?flag=list';</script>");
					} else if (result == -1) {// 物料名已存在，更新物料失败
						session.setAttribute("material_name", material_name);
						session.setAttribute("mid", mid);
						out.print(
								"<script type='text/javascript'>alert('改物料已经存在，请确认物料名称！');location.href='material/material_modify.jsp';</script>");
					} else {// 其他更新失败
						out.print(
								"<script type='text/javascript'>alert('更新物料失败！');location.href='MaterialServlet?flag=list';</script>");
					}				
				}				
				if (flag.equals("add")) {// 添加物料
					 String material_id="";//物料编号
					 String material_name="";//物料名称
					 String c_name="";//物料类别
					 String information="";//物料信息
					 int number=0;//物料数量
					 String price="";//物料单价
					 String fieldName = "";//表单字段名
					boolean isMultipart = ServletFileUpload.isMultipartContent(request);					
					// 判断是否是multipart类型数据的表单提交
					if (isMultipart) {
						// 创建FileItemFactory对象
						FileItemFactory factory = new DiskFileItemFactory();
						// 创建ServletFileUpload对象
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setHeaderEncoding("utf-8");// 中文文件名乱码问题处理
						// 解析form表单中所有文件
						try {
							List<FileItem> items = upload.parseRequest(request);
							Iterator<FileItem> iter = items.iterator();
							while (iter.hasNext()) {
								FileItem item = iter.next();
								if (item.isFormField()) { // 普通表单字段
									// 获取表单字段的name属性值
									fieldName = item.getFieldName();
									if ("material_id".equals(fieldName)) {// 获取物料编号
										material_id = item.getString("utf-8");// 物料
									}
									if ("material_name".equals(fieldName)) {// 获取物料名称
										material_name = item.getString("utf-8");
									}
									if ("c_name".equals(fieldName)) {// 获取类別名
										c_name = item.getString("utf-8");
									}
									if ("information".equals(fieldName)) {// 获取物料信息
										information = item.getString("utf-8");
									}
									if ("number".equals(fieldName)) {// 获取物料数量
										number = Integer.valueOf(item.getString("utf-8"));
									}
									if("price".equals(fieldName)) {// 获取物料单价
										price = item.getString("utf-8");
									}
								} else { // 文件表单字段
									// 获取文件名
									String fileName = item.getName();// 获得原始文件名
									if (fileName != null && !fileName.equals("")) {
										// 获取源文件扩展名
										String exName = fileName.substring(fileName.lastIndexOf(".") + 1);
										// 重命名文件
										Random random = new Random();
										int ranName = random.nextInt(100);// 0-100之间随机数
										Long longName = System.currentTimeMillis() + ranName;									
									}
								}
							}
						} catch (FileUploadException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("普通表单！");
					}
					// 实例化新闻对象：nid数据库自动生成
					Material material = new Material( 0,material_id,material_name,c_name,information,number,price);
					int result = materialService.addMaterial(material);
					if (result > 0) {// 添加成功
						out.print(
								"<script type='text/javascript'>alert('添加物料成功！点击确定返回后台主页！');location.href='MaterialServlet?flag=list';</script>");
						out.print(
								
								"<script type='text/javascript'>alert('添加物料失败！点击确定返回添加页！');location.href='material/material_add.jsp?flag=add';</script>");
					}
				}
				out.flush();
				out.close();
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
