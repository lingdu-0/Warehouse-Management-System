package cn.wb.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.plaf.synth.SynthSeparatorUI;

import cn.wb.entity.Material;
import cn.wb.entity.User;
import cn.wb.service.UserService;
import cn.wb.service.impl.MaterialServiceImpl;
import cn.wb.service.impl.UserServiceImpl;

/**
 * 用户控制器
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();		
		//判断是登录还是注销登录的标识
		String flag=request.getParameter("flag");
		if (flag.equals("login")) {// 处理登录
			// 读取用户名和密码
			String uname = request.getParameter("uname").trim();// 去除用户名前后的空格
			String upwd = request.getParameter("upwd").trim();
			User user = new User(uname, upwd);
			// 判断数据中是否优user对象
			UserService service = new UserServiceImpl();
			User loginUser = service.login(user);
			if (loginUser != null) {// 登录成功
				session.setAttribute("loginUser", loginUser);
				MaterialServiceImpl materialServiceImpl = new MaterialServiceImpl();
				List<Material> materialList = materialServiceImpl.listAllMaterial();
				session.setAttribute("materialList", materialList);
				response.sendRedirect("material/interface.jsp");			
			} else {// 登录失败
				String mess = "用户不存在！";
				request.setAttribute("mess", mess);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else if (flag.equals("logout")) {// 注销登录
			session.invalidate();
			response.sendRedirect("index.jsp");		
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
