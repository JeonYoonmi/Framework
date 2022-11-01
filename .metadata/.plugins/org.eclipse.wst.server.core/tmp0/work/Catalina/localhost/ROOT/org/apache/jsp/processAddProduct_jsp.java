/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.81
 * Generated at: 2022-07-06 02:47:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.commons.fileupload.DiskFileUpload;
import java.io.File;
import org.apache.commons.fileupload.FileItem;
import java.util.Iterator;
import java.util.List;
import kr.or.ddit.dao.ProductRepository;
import kr.or.ddit.dto.Product;

public final class processAddProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("org.apache.commons.fileupload.DiskFileUpload");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("org.apache.commons.fileupload.FileItem");
    _jspx_imports_classes.add("kr.or.ddit.dao.ProductRepository");
    _jspx_imports_classes.add("kr.or.ddit.dto.Product");
    _jspx_imports_classes.add("java.io.File");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

request.setCharacterEncoding("UTF-8");

//이미지 파일업로드 처리
String path = "D:\\A_TeachingMaterial\\08_Framework\\workspace\\JSPBook\\WebContent\\images";
//파일업로드 처리용 클래스
DiskFileUpload upload = new DiskFileUpload();

upload.setSizeMax(1000000);   //1Mb
upload.setSizeThreshold(4096);   //1 * 1024 * 1024 => 1Mb
upload.setRepositoryPath(path);   //임시 저장경로 : 생략가능
//request 객체에 있는 모든 요청 파라미터를 분석하여 List타입의 items 변수에 저장
List items = upload.parseRequest(request);
Iterator params = items.iterator();   //열거형으로 처리

String productId = "";
String pname = "";
String unitPrice = "";
String description = "";
String manufacturer = "";
String category = "";
String unitsInStock = "";
String condition = "";
//unitPrice는 문자형 데이터. -> 숫자형으로 변환
double price = 0d;
long stock = 0L;

String fileFieldName = "";
String fileName = "";
String contentType = "";

//vo객체에 요청파라미터를 setting => spring에서는 골뱅이 ModelAttribute로 쉽게 처리될것임
while(params.hasNext()){   //다음 항목이 있는지? 
   FileItem item = (FileItem)params.next();   //있으면 그 항목을 가져오자
   if(item.isFormField()){   //일반 항목일때
      //item : {productId=P1234}
      String name = item.getFieldName();   //productId
      if(name.equals("productId")){   
         //P1234
         productId    = item.getString("UTF-8");
      }else if(name.equals("pname")){
         pname        = item.getString("UTF-8");
      }else if(name.equals("unitPrice")){
         unitPrice    = item.getString("UTF-8");   //문자
         
         //가격이 비어있다면..
         if(unitPrice.isEmpty()){
            price = 0d;
         }else{//비어있지 않다면..
            price = Double.parseDouble(unitPrice);
         }
      }else if(name.equals("description")){
         description  = item.getString("UTF-8");
      }else if(name.equals("manufacturer")){
         manufacturer = item.getString("UTF-8");
      }else if(name.equals("category")){
         category     = item.getString("UTF-8");
      }else if(name.equals("unitsInStock")){
         unitsInStock = item.getString("UTF-8");   //문자
         
         if(unitsInStock.isEmpty())
            stock = 0;
         else
            stock = Long.valueOf(unitsInStock);
      }else if(name.equals("condition")){
         condition    = request.getParameter("condition");
      }

   }else{   //파일객체일 때
      fileFieldName = item.getFieldName();   //productImage
      fileName = item.getName();   //C:\\Users\\SEM-PC\\Pictures\\tomcate.PNG
      contentType = item.getContentType();   //images/jpeg
      
      //C:\\Users\\SEM-PC\\Pictures\\tomcate.PNG ->    tomcate.PNG
      fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
      long fileSize = item.getSize();   //파일 크기
      
      //설계 => 복사될 위치 및 파일명 결합연산
      File file = new File(path + "/" + fileName);// 복사될 위치\\tomcate.PNG
      //복사 처리
      item.write(file);
   }
}

//Product(dto) 객체 생성
Product newProduct = new Product();
newProduct.setProductId(productId);
newProduct.setPname(pname);
newProduct.setUnitPrice(price);   //Integer형변환 됨.
newProduct.setDescription(description);
newProduct.setManufacturer(manufacturer);
newProduct.setCategory(category);
newProduct.setUnitsInStock(stock); //long형변환 됨.
newProduct.setCondition(condition);
newProduct.setFilename(fileName);   //tomcate.PNG

//싱글톤 객체로 생성
ProductRepository dao = ProductRepository.getInstance();
//새로운 상품 등록(Product 타입의 파라미터를 Product 타입(dto, vo)의 매개변수로 받음)
dao.addProduct(newProduct);

//목록으로 이동
response.sendRedirect("products.jsp");

      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
