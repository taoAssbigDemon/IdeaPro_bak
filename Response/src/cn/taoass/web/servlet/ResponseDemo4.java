package cn.taoass.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码 ISO-8859-1 设置为 GBK
//        response.setCharacterEncoding("GBK");

        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
//        response.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式来设置编码
        response.setContentType("text/html;charset=utf-8");


        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
//        pw.write("<h1>Hello Response</h1>");
        //乱码的原因是编解码使用的字符集不一致

        pw.write("你好，李焕英-贾玲 response");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
