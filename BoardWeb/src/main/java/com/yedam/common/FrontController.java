package com.yedam.common;
// ��Ʈ�ѷ� : url -> ���� ����.

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.BoardListControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardControl;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.member.command.GetMemberControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;
import com.yedam.member.command.MemberListControl;
import com.yedam.reply.command.AddReplyJson;
import com.yedam.reply.command.DelReplyJson;
import com.yedam.reply.command.ReplyListJson;
import com.yedam.student.command.StudInfoCont;
import com.yedam.student.command.StudentListCont;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// �����ֱ� : ������ -> init -> service() -> destroy()
	Map<String, Control> map; // <Ű(?) , ���(����)>

	public FrontController() {
		System.out.println("������ ȣ��.");
		map = new HashMap<String, Control>(); // Ű���� String, ���� ��û�� ����(����)�� ����
	}

	@Override
	public void init(ServletConfig config) throws ServletException { // init�� ���� ���� �ʱ�ȭ�� ���� ����Ǵ�. �� �ʱⰪ�� �����ϱ� ���� �ִ� �Լ�
		System.out.println("init() ȣ��.");
//		map.put("/main.do", new MainControl());
//		map.put("/sub.do", new SubControl());
		// �Խ��ǰ���.
		map.put("/boardList.do", new BoardListControl()); // /boardList.do��� url�� �ԷµǸ� BoardListControl�� ����
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/getBoard.do", new GetBoardControl());
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeForm.do", new RemoveFormControl()); //
		map.put("/removeBoard.do", new RemoveBoardControl());//

		// ȸ������.
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		// ������.
		map.put("/memberList.do", new MemberListControl());
		map.put("/getMember.do", new GetMemberControl());
		
		// tiles.����...
		map.put("/studentList.do",new StudentListCont());
		map.put("/studInfo.do",new StudInfoCont());
		
		// ��۰���. json ������ �����͸� �����ؼ� ��ȯ.
		map.put("/replyListJson.do", new ReplyListJson());
		map.put("/delReplyJson.do", new DelReplyJson());
		map.put("/addReplyJson.do", new AddReplyJson());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // map��
																													// url
																													// ����
																													// ����
		req.setCharacterEncoding("utf-8");

		System.out.println("service() ȣ��.");
		// http:..localhost/BoardWeb/main.do ->mainControl.
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length()); // �Ķ���� �ν� ���� ����
		System.out.println(path);

		Control ctrl = map.get(path); // �Ķ���͸� Ű������ �ް�
		ctrl.execute(req, resp); // ������ ���� ���
	}

	@Override
	public void destroy() {
		System.out.println("destroy() ȣ��.");
	}
}
