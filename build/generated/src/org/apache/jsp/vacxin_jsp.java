package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.bean.User;
import controller.UserServlet;

public final class vacxin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Welcome to quản lý Vắc xin</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">        \n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.5/validator.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js\"></script>\n");
      out.write("        <link href=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            // check session
            User user = (User) session.getAttribute(UserServlet.SESSION_USER);
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <div class=\"panel-heading\">Vacxin Manager<span id='message' class=\"pull-right\"><img src='img/ajax-loader.gif' /> Loading...</span></div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <input class=\"form-control\" id =\"search-key\" placeholder=\"Search for...\"> <span\n");
      out.write("                            class=\"input-group-btn\">\n");
      out.write("                            <button class=\"btn btn-default\" type=\"button\" id=\"search-button\")>\n");
      out.write("                                <span class=\"glyphicon glyphicon-search\"></span> Search\n");
      out.write("                            </button>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>#</th>\n");
      out.write("                            <th>Tên Vắcxin</th>\n");
      out.write("                            <th>Số Mũi</th>\n");
      out.write("                            <th>Mô Tả</th>\n");
      out.write("                            <th>Giá Vắcxin</th>\n");
      out.write("                            <th>Tên Hãng</th>\n");
      out.write("                            \n");
      out.write("                            <th class=\"text-center\">Hành động</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\t\t\t\t\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\t\n");
      out.write("                <ul class=\" pagination pull-right\" id=\"pagination\"></ul>\n");
      out.write("                <div class=\"panel-footer\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <button type=\"button\" data-backdrop=\"static\" data-toggle=\"modal\" data-target=\"#create-item\" class=\"btn btn-success\"><span class=\"glyphicon glyphicon glyphicon-plus\" aria-hidden=\"true\"></span></button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\t\t\t\t\t\t\n");
      out.write("            </div>\n");
      out.write("        </div>      \n");
      out.write("        <ul id=\"pagination\" class=\"pagination-sm\"></ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- view Item Modal -->\n");
      out.write("        <div class=\"modal fade\" id=\"view-item\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">View Vacxin</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form data-toggle=\"validator\" >\n");
      out.write("                            <input type=\"hidden\" name=\"command\" value=\"view\">\n");
      out.write("                            <input type=\"hidden\" name=\"id\" class=\"view-id\">\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Tên Vacxin:</label>\n");
      out.write("                                <input type=\"text\" name=\"tenvacxin\" class=\"form-control\" placeholder=\"Tên Vắc xin\"  data-error=\"Vui lòng nhập tên Vắc xin\"  readonly/>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Số mũi:</label>\n");
      out.write("                                <input type=\"text\" name=\"somui\" class=\"form-control\"  placeholder=\"0 (Số mũi)\" data-error=\"Vui lòng nhập số mũi tiêm\" readonly />\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Giá Vacxin:</label>\n");
      out.write("                                <input type=\"text\" name=\"giavacxin\" class=\"form-control\"  placeholder=\"1000\" data-error=\"Vui lòng nhập giá Vắc xin\" readonly aria-label=\"Amount (to the nearest dollar)\" />\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Tên Hãng:</label>\n");
      out.write("                                <input type=\"text\" name=\"tenhang\" class=\"form-control\"  placeholder=\"Tên hãng\" data-error=\"Vui lòng nhập giá Vắc xin\" readonly />\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Mô tả:</label>\n");
      out.write("                                <textarea name=\"mota\" class=\"form-control\" data-error=\"Vui lòng nhập mô tả\" readonly></textarea>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button  data-dismiss=\"modal\" class=\"btn btn-block btn-warning\">Close</button>\n");
      out.write("                            </div>\t\n");
      out.write("                        </form>\t\n");
      out.write("                    </div>\n");
      out.write("                </div>\t\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Create Item Modal -->\n");
      out.write("        <div class=\"modal fade\" id=\"create-item\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">Create Vacxin</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form data-toggle=\"validator\" name=\"create-item\">\n");
      out.write("                            <input type=\"hidden\" name=\"command\" value=\"register\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Tên Vacxin:</label>\n");
      out.write("                                <input type=\"text\" name=\"tenvacxin\" class=\"form-control\" placeholder=\"Tên Vắc xin\"  data-error=\"Vui lòng nhập tên Vắc xin\"  required/>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Số mũi:</label>\n");
      out.write("                                <input type=\"text\" name=\"somui\" class=\"form-control\"  placeholder=\"0 (Số mũi)\" data-error=\"Vui lòng nhập số mũi tiêm\" required />\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Giá Vacxin:</label>\n");
      out.write("                                <input type=\"text\" name=\"giavacxin\" class=\"form-control\"  placeholder=\"1000\" data-error=\"Vui lòng nhập giá Vắc xin\" required aria-label=\"Amount (to the nearest dollar)\"/>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Mô tả:</label>\n");
      out.write("                                <textarea name=\"mota\" class=\"form-control\" data-error=\"Vui lòng nhập mô tả\"></textarea>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Tên Hãng:</label>\n");
      out.write("                                <input type=\"text\" name=\"tenhang\" class=\"form-control\"  placeholder=\"Tên hãng\" data-error=\"Vui lòng nhập giá Vắc xin\" />\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div id='message-create' class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-block create-item-submit btn-success\">Create</button>\n");
      out.write("                                <button  data-dismiss=\"modal\" class=\"btn btn-block btn-warning\">Close</button>\n");
      out.write("                            </div>\t\n");
      out.write("                        </form>\t\n");
      out.write("                    </div>\n");
      out.write("                </div>\t\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Edit Item Modal -->\n");
      out.write("        <div class=\"modal fade\" id=\"edit-item\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">Edit Vacxin</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form data-toggle=\"validator\"  name=\"form-edit-item\">\n");
      out.write("                            <input type=\"hidden\" name=\"command\" value=\"edit\">\n");
      out.write("                            <input type=\"hidden\" name=\"id\" class=\"edit-id\" value =\"\">\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Tên Vacxin:</label>\n");
      out.write("                                <input type=\"text\" name=\"tenvacxin\" class=\"form-control\" placeholder=\"Tên Vắc xin\"  data-error=\"Vui lòng nhập tên Vắc xin\"  required/>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Số mũi:</label>\n");
      out.write("                                <input type=\"text\" name=\"somui\" class=\"form-control\"  placeholder=\"0 (Số mũi)\" data-error=\"Vui lòng nhập số mũi tiêm\" required />\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Giá Vacxin:</label>\n");
      out.write("                                <input type=\"text\" name=\"giavacxin\" class=\"form-control\"  placeholder=\"1000\" data-error=\"Vui lòng nhập giá Vắc xin\" required aria-label=\"Amount (to the nearest dollar)\"/>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Mô tả:</label>\n");
      out.write("                                <textarea name=\"mota\" class=\"form-control\" data-error=\"Vui lòng nhập mô tả\" ></textarea>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Tên Hãng:</label>\n");
      out.write("                                <input type=\"text\" name=\"tenhang\" class=\"form-control\"  placeholder=\"Tên hãng\" data-error=\"Vui lòng nhập giá Vắc xin\"/>\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div id='message-edit' class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\t\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success form-edit-submit btn-block\">Update</button>\n");
      out.write("                                <button  data-dismiss=\"modal\" class=\"btn btn-block btn-warning\">Close</button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\t\t\n");
      out.write("        <script src=\"myjs/vacxin.js\"></script>\n");
      out.write("        <script src=\"js/jquery.twbsPagination.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
