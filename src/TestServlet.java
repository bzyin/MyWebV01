import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println(request.getPart("setid"));
        System.out.println(request.getQueryString());
        System.out.println(request.getMethod());
//         System.out.println(request.getHeader("Accept"));
//         System.out.println(request.getHeader("Accept-Language"));
//         System.out.println(request.getPathInfo());

        //System.out.println(request.getParameterValues("setid"));
        System.out.println(request.getParameter("user"));
        System.out.println(request.getParameter("password"));


        //request.getPart("setid");
        String data = "your account:  " + request.getParameter("user") + "\r\n Your password:" + request.getParameter("password");
        System.out.println("数据长度" + data.getBytes().length);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        //对数据进行压缩
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        gout.write(data.getBytes());
        gout.close();
        //得到压缩后的数据
        byte gdata[] = bout.toByteArray();
        response.setHeader("Content-Encoding", "gzip");
        response.setHeader("Content-Length", gdata.length + " ");
        response.getOutputStream().write(gdata);


//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        String title = "HTTP Header 请求实例 ";
//        String docType =
//                "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
//                "<tr bgcolor=\"#949494\">\n" +
//                "<th>Header 名称</th><th>Header 值</th>\n"+
//                "</tr>\n");
//        Enumeration headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String paramName = (String)headerNames.nextElement();
//            out.print("<tr><td>" + paramName + "</td>\n");
//            String paramValue = request.getHeader(paramName);
//            out.println("<td> " + paramValue + "</td></tr>\n");
//        }
//        out.println("</table>\n</body></html>");


//        //获取session
//        HttpSession session   =   request.getSession();
//         // 获取session中所有的键值
//        Enumeration<String> attrs = session.getAttributeNames();
//         // 遍历attrs中的
//        while(attrs.hasMoreElements()){
//          // 获取session键值
//            String name = attrs.nextElement().toString();
//            // 根据键值取session中的值
//            Object vakue = session.getAttribute(name);
//            // 打印结果
//            System.out.println("------" + name + ":" + vakue +"--------\n");}


    }



}


