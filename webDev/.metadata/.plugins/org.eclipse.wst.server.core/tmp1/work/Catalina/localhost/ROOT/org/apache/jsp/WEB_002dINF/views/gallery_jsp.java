/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-02-09 07:00:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gallery_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1644279642331L));
    _jspx_dependants.put("jar:file:/C:/Java/webDev/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/SpringShop/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
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
      out.write("<style>\r\n");
      out.write("a {\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("	color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#pageNav {\r\n");
      out.write("	font-size: 50px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<main class=\"container\">\r\n");
      out.write("		<section class=\"py-5 text-center container\">\r\n");
      out.write("			<div class=\"row py-lg-5\">\r\n");
      out.write("				<div class=\"col-lg-6 col-md-8 mx-auto\">\r\n");
      out.write("					<h1 class=\"fw-light\">Album example</h1>\r\n");
      out.write("					<p class=\"lead text-muted\">Something short and leading about\r\n");
      out.write("						the collection below—its contents, the creator, etc. Make it short\r\n");
      out.write("						and sweet, but not too short so folks don’t simply skip over it\r\n");
      out.write("						entirely.</p>\r\n");
      out.write("					<p>\r\n");
      out.write("						<a href=\"#\" class=\"btn btn-primary my-2\">Main call to action</a> <a\r\n");
      out.write("							href=\"#\" class=\"btn btn-secondary my-2\">Secondary action</a>\r\n");
      out.write("					</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</section>\r\n");
      out.write("\r\n");
      out.write("		<div class=\"album py-5 bg-light\">\r\n");
      out.write("			<div class=\"container\">\r\n");
      out.write("				<select id=\"searchType\">\r\n");
      out.write("					<option value=\"all\">전체</option>\r\n");
      out.write("					<option value=\"gi_title\">제목</option>\r\n");
      out.write("					<option value=\"gi_content\">내용</option>\r\n");
      out.write("					<option value=\"gi_writer\">작성자</option>\r\n");
      out.write("				</select> <input type=\"text\" name=\"keyword\" id=\"keyword\">\r\n");
      out.write("				<button class=\"w-49 btn btn-lg btn-primary\" id=\"doSearch\">검색</button>\r\n");
      out.write("				<div class=\"row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3\" id=\"list\">\r\n");
      out.write("					\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	<div id=\"pageNav\" class='btn btn-sm btn-outline-secondary' style=''>pageNav</div>\r\n");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		search(1);\r\n");
      out.write("		$(\"#doSearch\").click(function() {\r\n");
      out.write("			search(1);\r\n");
      out.write("		})\r\n");
      out.write("	})\r\n");
      out.write("\r\n");
      out.write("	function goPage(selPage) {\r\n");
      out.write("		search(selPage);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function search(selPage) {\r\n");
      out.write("		var data = {};\r\n");
      out.write("		data.pagePerCnt = 9;\r\n");
      out.write("		data.curPage = selPage;\r\n");
      out.write("		data.keyword = $(\"#keyword\").val();\r\n");
      out.write("		data.searchType = $(\"#searchType\").val();\r\n");
      out.write("		console.log(data);\r\n");
      out.write("		\r\n");
      out.write("		$\r\n");
      out.write("				.ajax({\r\n");
      out.write("					type : 'POST',\r\n");
      out.write("					url : \"/getGalleryList\",\r\n");
      out.write("					data : data,\r\n");
      out.write("					error : function(error) {\r\n");
      out.write("						alert('Error!');\r\n");
      out.write("					},\r\n");
      out.write("					success : function(value) {\r\n");
      out.write("						console.log(value);\r\n");
      out.write("						var html = \"\";\r\n");
      out.write("						var list = \"\";\r\n");
      out.write("\r\n");
      out.write("						$('#list').children().remove();\r\n");
      out.write("						if (value.list.length > 0) {\r\n");
      out.write("							for (var i = 0; i < value.list.length; i++) {\r\n");
      out.write("								list = value.list[i];\r\n");
      out.write("								html += \"<div class='col'>\";\r\n");
      out.write("								html += \"<img src='/resources/file/\"+list.saved_file_name+\"' class='bd-placeholder-img card-img-top' width='100%' height='180' alt='Thumbnail'>\";\r\n");
      out.write("								html += \"<div class='card-body'>\";\r\n");
      out.write("								html += \"<p class='card-text'><a href='/gallery/writeGallery?gi_no=\" + list.gi_no + \"'>\"+ list.gi_title + \"</a></p>\";\r\n");
      out.write("								html += \"<div class='d-flex justify-content-between align-items-center'>\";\r\n");
      out.write("								html += \"<div class='btn-group'>\";\r\n");
      out.write("							//	html += \"<button type='button' class='btn btn-sm btn-outline-secondary'><a href='/gallery/writeGallery?gi_no=\" + list.gi_no + \"''>수정</a></button>\";\r\n");
      out.write("							//	html += \"<button type='button' class='btn btn-sm btn-outline-secondary'><a href='/gallery/delete?gi_no=\" + list.gi_no + \"'>삭제</a></button>\";\r\n");
      out.write("								html += \"</div>\";\r\n");
      out.write("								html += \"<small class='text-muted'>\" + list.gi_writer + \"</small>\";\r\n");
      out.write("								html += \"</div>\";\r\n");
      out.write("								html += \"</div>\";\r\n");
      out.write("								html += \"</div>\";\r\n");
      out.write("								html += \"</div>\";\r\n");
      out.write("							}\r\n");
      out.write("						} else {\r\n");
      out.write("							html += \"<div>검색결과가 없습니다</div>\";\r\n");
      out.write("						}\r\n");
      out.write("						console.log(html);\r\n");
      out.write("						$(\"#list\").append(html);\r\n");
      out.write("						$(\"#pageNav\").paging({\r\n");
      out.write("							pageSize : data.pagePerCnt,\r\n");
      out.write("							PAGE_PER_CNT : data.pagePerCnt,\r\n");
      out.write("							currentPage : value.paging.CUR_PAGE,\r\n");
      out.write("							pageTotal : value.paging.TOTAL_CNT\r\n");
      out.write("						});\r\n");
      out.write("\r\n");
      out.write("					},\r\n");
      out.write("				});\r\n");
      out.write("	}\r\n");
      out.write("</script>");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f0_reused = false;
    try {
      _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f0.setParent(null);
      int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
      if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      _jspx_th_c_005fchoose_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f0_reused = false;
    try {
      _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      // /WEB-INF/views/gallery.jsp(47,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.mi_id ne null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
      if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("		<a href=\"/gallery/writeGallery\" class=\"btn btn-primary my-2\"\r\n");
          out.write("			type=\"button\">글쓰기</a>\r\n");
          out.write("	");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      _jspx_th_c_005fwhen_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
    }
    return false;
  }
}