package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.bean.User;
import controller.UserServlet;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Welcome to login system</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">        \r\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.js\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.5/validator.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js\"></script>\r\n");
      out.write("        <link href=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            // check session
            User user = (User) session.getAttribute(UserServlet.SESSION_USER);
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"panel panel-default\">\r\n");
      out.write("                <div class=\"panel-heading\">User Manager<span id='message' class=\"pull-right\"><img src='img/ajax-loader.gif' /> Loading...</span></div>\r\n");
      out.write("                <div class=\"panel-body\">\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <input class=\"form-control\" id =\"search-key\" placeholder=\"Search for...\"> <span\r\n");
      out.write("                            class=\"input-group-btn\">\r\n");
      out.write("                            <button class=\"btn btn-default\" type=\"button\" id=\"search-button\")>\r\n");
      out.write("                                <span class=\"glyphicon glyphicon-search\"></span> Search\r\n");
      out.write("                            </button>\r\n");
      out.write("                        </span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <table class=\"table\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>#</th>\r\n");
      out.write("                            <th>User Name</th>\r\n");
      out.write("                            <th>First Name</th>\r\n");
      out.write("                            <th>Last Name</th>\r\n");
      out.write("                            <th class=\"text-center\">#</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\t\t\t\t\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\t\r\n");
      out.write("                <ul class=\" pagination pull-right\" id=\"pagination\"></ul>\r\n");
      out.write("                <div class=\"panel-footer\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <button type=\"button\" data-backdrop=\"static\" data-toggle=\"modal\" data-target=\"#create-item\" class=\"btn btn-success\"><span class=\"glyphicon glyphicon glyphicon-plus\" aria-hidden=\"true\"></span></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\t\t\t\t\t\t\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- <button type=\"button\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#create-item\">  Create Item\t</button>\r\n");
      out.write("        <button data-toggle=\"modal\" data-target=\"#edit-item\" class=\"btn btn-primary edit-item\">Edit</button>\r\n");
      out.write("        -->\r\n");
      out.write("        <ul id=\"pagination\" class=\"pagination-sm\"></ul>\r\n");
      out.write("      \r\n");
      out.write("        \r\n");
      out.write("        <!-- view Item Modal -->\r\n");
      out.write("        <div class=\"modal fade\" id=\"view-item\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\r\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">Create User</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form data-toggle=\"validator\" >\r\n");
      out.write("                            <input type=\"hidden\" name=\"command\" value=\"view\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"id\" class=\"view-id\">\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">User name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"User name\"  data-error=\"Please enter username\"  readonly/>\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">First name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"firstname\" class=\"form-control\"  placeholder=\"First name\" data-error=\"Please enter firstname\" readonly />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Last name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"lastname\" class=\"form-control\"  placeholder=\"Last name\" data-error=\"Please enter lastname\" readonly />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\t\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Roles:</label>\r\n");
      out.write("                                <select  name=\"roles\" class=\"form-control\" data-error=\"Please enter roles\" disabled >\r\n");
      out.write("                                    <option value=\"1\">Admin</option>\r\n");
      out.write("                                    <option value=\"2\">User</option>\r\n");
      out.write("                                    <option value=\"3\">Visiter</option>\r\n");
      out.write("                                    <option value=\"4\">Normal</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <button  data-dismiss=\"modal\" class=\"btn btn-block btn-warning\">Close</button>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                        </form>\t\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\t\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Create Item Modal -->\r\n");
      out.write("        <div class=\"modal fade\" id=\"create-item\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\r\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">Create User</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form data-toggle=\"validator\" >\r\n");
      out.write("                            <input type=\"hidden\" name=\"command\" value=\"register\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">User name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"User name\"  data-error=\"Please enter username\"  required/>\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Password:</label>\r\n");
      out.write("                                <input type=\"password\" name=\"password\" id=\"password\"  placeholder=\"Password\" class=\"form-control\" data-error=\"Please enter password\" required />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Re-password:</label>\r\n");
      out.write("                                <input type=\"password\" name=\"password2\" placeholder=\"Re-password\" data-match=\"#password\" data-match-error=\"Password doesn't matched.\" class=\"form-control\" data-error=\"Please enter re-password\" required />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">First name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"firstname\" class=\"form-control\"  placeholder=\"First name\" data-error=\"Please enter firstname\" required />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Last name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"lastname\" class=\"form-control\"  placeholder=\"Last name\" data-error=\"Please enter lastname\" required />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\t\t\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <div id='message-create' class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-block create-item-submit btn-success\">Create</button>\r\n");
      out.write("                                <button  data-dismiss=\"modal\" class=\"btn btn-block btn-warning\">Close</button>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                        </form>\t\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\t\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Edit Item Modal -->\r\n");
      out.write("        <div class=\"modal fade\" id=\"edit-item\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\r\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myModalLabel\">Edit User</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form data-toggle=\"validator\" >\r\n");
      out.write("                            <input type=\"hidden\" name=\"command\" value=\"edit\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"idedit\" class=\"edit-id\" value =\"\">\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">User name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"username\" class=\"form-control\" data-error=\"Please enter username\"  disabled/>\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">First name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"firstname\" class=\"form-control\" data-error=\"Please enter firstname\" required />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Last name:</label>\r\n");
      out.write("                                <input type=\"text\" name=\"lastname\" class=\"form-control\" data-error=\"Please enter lastname\" required />\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\t\t\t\t\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"control-label\" for=\"title\">Roles:</label>\r\n");
      out.write("                                <select  name=\"roles\" class=\"form-control\" data-error=\"Please enter roles\" required >\r\n");
      out.write("                                    <option value=\"1\">Admin</option>\r\n");
      out.write("                                    <option value=\"2\">User</option>\r\n");
      out.write("                                    <option value=\"3\">Visiter</option>\r\n");
      out.write("                                    <option value=\"0\">Normal</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                                <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <div id='message-edit' class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\t\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success edit-item-submit btn-block\">Update</button>\r\n");
      out.write("                                <button  data-dismiss=\"modal\" class=\"btn btn-block btn-warning\">Close</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\t\t\r\n");
      out.write("        \r\n");
      out.write("        <script src=\"myjs/login.js\"></script>\r\n");
      out.write("        <script src=\"myjs/register.js\"></script>\r\n");
      out.write("        <script src=\"myjs/index.js\"></script>\r\n");
      out.write("        <script src=\"js/jquery.twbsPagination.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    </body>\r\n");
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
