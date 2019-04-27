package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.*;
import java.util.ArrayList;
import model.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/mainpage.css\" />\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
 EmployeeAccount ea = null;
            SavingDAO sdao = new SavingDAO();
            LoanDAO ldao = new LoanDAO();
            CustomerDAO cdao = new CustomerDAO();
            ProfileDAO pdao = new ProfileDAO();
            EmployeeDAO edao = new EmployeeDAO();
            HusbandryDAO hdao = new HusbandryDAO();
            LendDAO ledao = new LendDAO();
            ArrayList<Saving> savingList = new ArrayList<>();
            ArrayList<Loan> loanList = new ArrayList<>();
            Customer c = new Customer();
            Profile p = new Profile();
            Employee e = new Employee();
            Husbandry h = new Husbandry();
            Lend le = new Lend();
            if (session.getAttribute("currentSessionUser") != null) {
                ea = (EmployeeAccount) session.getAttribute("currentSessionUser");
            }
            if (request.getAttribute("savingList") == null) {
                savingList = sdao.GetSaving("all", "all", "all");
            } else {
                savingList = (ArrayList<Saving>) request.getAttribute("savingList");
            }
            if (request.getAttribute("loanList") == null) {
                loanList = ldao.GetLoan("all", "all");
            } else {
                savingList = (ArrayList<Saving>) request.getAttribute("savingList");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <p id=\"thongbao\">");
 if (session.getAttribute("thongbao") != null) {
      out.write(' ');
      out.print(session.getAttribute("thongbao"));
      out.write(' ');
} 
      out.write(" </p>\n");
      out.write("        <p> TRANG CHỦ <p>\n");
      out.write("            <a href=\"main.jsp\"> <img  src=\"images/logo.png\" alt=\"Vietcombank\" style=\"width:15%\"> </a>\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <!-- Tab -->\n");
      out.write("            <div class=\"tab\">\n");
      out.write("                <a href=\"#stk\"> <button class=\"tablinks\" onclick=\"openTab(event, 'STK')\">Sổ tiết kiệm</button> </a>\n");
      out.write("                <a href=\"#vl\"> <button class=\"tablinks\" onclick=\"openTab(event, 'VL')\">Vay lãi</button> </a>\n");
      out.write("                <a href=\"#xbc\"> <button class=\"tablinks\" onclick=\"openTab(event, 'BC')\">Xuất báo cáo</button> </a>\n");
      out.write("                ");
 if (ea != null) {
                    System.out.println("Idla"+ea.getId());
                        if (!ea.getId().equalsIgnoreCase("ada01")) { 
      out.write("\n");
      out.write("                <a href=\"#ch\"><button class=\"tablinks\" onclick=\"openTab(event, 'CH')\" id=\"moCH\">Cấu hình</button> </a>\n");
      out.write("                ");
}
                    }
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Tab content -->\n");
      out.write("            <div id=\"STK\" class=\"tabcontent\" \n");
      out.write("                 ");
 if (request.getAttribute("savingList") != null) {
      out.write("  style=\"display: block\" ");
} 
      out.write("  >\n");
      out.write("                <div>\n");
      out.write("                    <button onclick=\"openForm('themstk')\">Thêm sổ tiết kiệm </button>\n");
      out.write("                    <form action=\"SavingListServlet\" method=\"get\">\n");
      out.write("                        <span>Loại tiết kiệm: </span>\n");
      out.write("                        <select name=\"loaistk\">\n");
      out.write("                            <option value=\"all\">Tất cả</option>\n");
      out.write("                            <option value=\"hus01\">Tích lũy đầu tư</option>\n");
      out.write("                            <option value=\"hus06\">AUD ưu đãi</option>\n");
      out.write("                            <option value=\"hus010\">Tích lũy cho con</option>\n");
      out.write("                            <option value=\"hus011\">Tiền gửi cán bộ công nhân viên</option>\n");
      out.write("                            <option value=\"hus012\">Tiền gửi trực tuyến</option>\n");
      out.write("                            <option value=\"hus016\">Tích lũy kiểu hối</option>\n");
      out.write("                            <option value=\"hus017\">Tiết kiệm tự động</option>\n");
      out.write("                            <option value=\"hus018\">Tiết kiệm lĩnh lãi định kỳ</option>\n");
      out.write("                            <option value=\"hus019\">Tiết kiệm trả lãi trước</option>\n");
      out.write("                            <option value=\"hus020\">Tiết kiệm thường</option>\n");
      out.write("                        </select>\n");
      out.write("                        <span>Loại tiền: </span>\n");
      out.write("                        <select name=\"loaitien\">\n");
      out.write("                            <option value=\"all\">Tất cả</option>\n");
      out.write("                            <option value=\"vnd\">VND</option>\n");
      out.write("                            <option value=\"usd\">USD</option>\n");
      out.write("                            <option value=\"eur\">EUR</option>\n");
      out.write("                            <option value=\"aud\">AUD</option>\n");
      out.write("                        </select>\n");
      out.write("\n");
      out.write("                        <span>Tình trạng: </span>\n");
      out.write("                        <select name=\"tinhtrang\">\n");
      out.write("                            <option value=\"all\">Tất cả</option>\n");
      out.write("                            <option value=\"open\">Đang mở</option>\n");
      out.write("                            <option value=\"close\">Đã rút sổ</option>\n");
      out.write("                        </select>\n");
      out.write("                        <button type=\"submit\"> Xác nhận </button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>STT</th>\n");
      out.write("                        <th>Tên chủ sổ</th>\n");
      out.write("                        <th>Tên NV quản lý</th>\n");
      out.write("                        <th>Loại tiết kiệm</th>\n");
      out.write("                        <th>Ngày mở sổ</th>\n");
      out.write("                        <th>Ngày hết hạn</th>\n");
      out.write("                        <th>Loại tiền</th>\n");
      out.write("                        <th>Tiền gửi</th>\n");
      out.write("                        <th>Tiền lãi</th>\n");
      out.write("                        <th>Tình trạng</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        int stt = 0;
                        for (Saving s : savingList) {
                            stt++;
                            c = cdao.GetCustomer(s.getIdcustomer());
                            e = edao.GetEmployee(s.getIdemployee());
                            h = hdao.GetHusbandry(s.getIdhusbandry());
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(stt);
      out.write("</td>\n");
      out.write("                        ");
 p = pdao.GetProfile(c.getIdprofile());
      out.write("\n");
      out.write("                        <td>");
      out.print(p.getName());
      out.write("</td>\n");
      out.write("                        ");
p = pdao.GetProfile(e.getIdProfile());
      out.write("\n");
      out.write("                        <td>");
      out.print(p.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(h.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getProvisionDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getExpirationDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getTypeofmoney());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getDepositTotal());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(s.getInterestTotal());
      out.write("</td>\n");
      out.write("                        ");
 if (s.isMo()) {
      out.write("\n");
      out.write("                        <td>Mở</td>\n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("                        <td>Đóng</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
                        }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"VL\" class=\"tabcontent\"\n");
      out.write("                 ");
 if (request.getAttribute("loanList") != null) {
      out.write("  style=\"display: block\" ");
} 
      out.write("  >\n");
      out.write("                <div>\n");
      out.write("                    <!--                    <button onclick=\"openForm('themstk')\">Thêm sổ tiết kiệm </button>\n");
      out.write("                                        <button onclick=\"openForm('xoastk')\">Xóa sổ tiết kiệm </button>-->\n");
      out.write("                    <form action=\"LoanListServlet\" method=\"get\">\n");
      out.write("                        <span>Loại vay lãi: </span>\n");
      out.write("                        <select name=\"loaivl\">\n");
      out.write("                            <option value=\"all\">Tất cả</option>\n");
      out.write("                            <option value=\"lo01\">Cho vay sửa nhà</option>\n");
      out.write("                            <option value=\"lo02\">Ngôi nhà mơ ước</option>\n");
      out.write("                            <option value=\"lo03\">Gia đình thịnh vượng</option>\n");
      out.write("                            <option value=\"lo04\">Cho vay mua nhà dự án</option>\n");
      out.write("                            <option value=\"lo05\">Cho vay hỗ trợ mua nhà ở xã hội/thương mại</option>\n");
      out.write("                            <option value=\"lo06\">Cho vay cá nhân</option>\n");
      out.write("                            <option value=\"lo14\">Cho vay cán bộ công nhân viên</option>\n");
      out.write("                            <option value=\"lo07\">Cho vay cán bộ quản lý điều hành/option>\n");
      out.write("                            <option value=\"lo08\">Cho vay mua ô tô</option>\n");
      out.write("                            <option value=\"lo09\">Thấu chi tài khoản cá nhân</option>\n");
      out.write("                            <option value=\"lo10\">Kinh doanh tài lộc</option>\n");
      out.write("                            <option value=\"lo11\">Cho vay cầm cố chứng khoán niêm yết</option>\n");
      out.write("                            <option value=\"lo12\">Cho vay cầm cố giấy tờ</option>\n");
      out.write("                            <option value=\"lo13\">Thấu chi cầm cố giấy tờ</option>\n");
      out.write("                        </select>\n");
      out.write("\n");
      out.write("                        <span>Tình trạng: </span>\n");
      out.write("                        <select name=\"tinhtrang\">\n");
      out.write("                            <option value=\"all\">Tất cả</option>\n");
      out.write("                            <option value=\"open\">Đang mở</option>\n");
      out.write("                            <option value=\"close\">Đã rút sổ</option>\n");
      out.write("                        </select>\n");
      out.write("                        <button type=\"submit\"> Xác nhận </button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>STT</th>\n");
      out.write("                        <th>Tên chủ sổ</th>\n");
      out.write("                        <th>Tên NV quản lý</th>\n");
      out.write("                        <th>Loại vay lãi</th>\n");
      out.write("                        <th>Ngày vay lãi</th>\n");
      out.write("                        <th>Ngày trả lãi</th>\n");
      out.write("                        <th>Tiền vay</th>\n");
      out.write("                        <th>Tiền lãi phải trả</th>\n");
      out.write("                        <th>Tình trạng</th>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        stt = 0;
                        for (Loan lo : loanList) {
                            stt++;
                            c = cdao.GetCustomer(lo.getIdcustomer());
                            e = edao.GetEmployee(lo.getIdemployee());
                            le = ledao.GetLend(lo.getIdlend());
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(stt);
      out.write("</td>\n");
      out.write("                        ");
 p = pdao.GetProfile(c.getIdprofile());
      out.write("\n");
      out.write("                        <td>");
      out.print(p.getName());
      out.write("</td>\n");
      out.write("                        ");
p = pdao.GetProfile(e.getIdProfile());
      out.write("\n");
      out.write("                        <td>");
      out.print(p.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(le.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(lo.getProvisionDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(lo.getExpirationDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(lo.getLoanamount());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(lo.getInterestTotal());
      out.write("</td>\n");
      out.write("                        ");
 if (lo.isMo()) {
      out.write("\n");
      out.write("                        <td>Mở</td>\n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("                        <td>Đóng</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
                        }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"BC\" class=\"tabcontent\">\n");
      out.write("                <form action=\"ReportServlet\"  method=\"post\" > \n");
      out.write("                    <span>Chọn kì hạn: </span>\n");
      out.write("                    <select name=\"term\">>\n");
      out.write("                        <option selected value=\"LSTK\">Tháng</option>\n");
      out.write("                        <option value=\"LVN\">Quý</option>\n");
      out.write("                        <option value=\"TDT\">Năm</option>\n");
      out.write("                    </select>\n");
      out.write("                    <span>Chọn thời gian cuối: </span> <input class=\"endDate\" type=\"date\" name=\"endDate\"  min='2000-01-01' max='2000-13-13' required>\n");
      out.write("                    <button type=\"submit\">Xuất báo cáo</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"CH\" class=\"tabcontent\">\n");
      out.write("                <form action=\"ConfigurationServlet\" class=\" DTG\" method=\"post\">\n");
      out.write("                    <span>Chọn loại: </span>\n");
      out.write("                    <select id=\"mainselect\" name=\"type\" onchange=\"showDiv1(this)\">\n");
      out.write("                        <option selected value=\"\">---</option>\n");
      out.write("                        <option value=\"CLSTK\" id=\"chonstk\">Sổ tiết kiệm</option>\n");
      out.write("                        <option value=\"CLVL\">Vay lãi</option>\n");
      out.write("                    </select>\n");
      out.write("                    <div class=\"basichide\" id=\"CLSTK\"><span>Loại sổ tiết kiệm: </span>\n");
      out.write("                        <select class=\" stk\" name=\"typestk\" onchange=\"showDiv2(this)\">\n");
      out.write("                            <option selected value=\"\">---</option>\n");
      out.write("                            <option value=\"inter01\" id=\"tlcc\">Tích lũy cho con - mở tài khoản</option>\n");
      out.write("                            <option value=\"inter02\">Tích lũy cho con - sau 3 tháng</option>\n");
      out.write("                            <option value=\"inter03\">Tích lũy cho con - sau 6 tháng</option>\n");
      out.write("                            <option value=\"inter04\">Tích lũy cho con - 9 tháng</option>\n");
      out.write("                            <option value=\"inter05\">Tích lũy cho con rút trước hạn</option>\n");
      out.write("                            <option value=\"inter07\">Tích lũy kiều hối</option>\n");
      out.write("                            <option value=\"inter08\">Lĩnh lãi định kỳ - VND</option>\n");
      out.write("                            <option value=\"inter09\">Lĩnh lãi định kỳ - USD</option>\n");
      out.write("                            <option value=\"inter10\">Trần lãi xuất không kỳ hạn</option>\n");
      out.write("                            <option value=\"inter11\">Trần lãi xuất 7 ngày</option>\n");
      out.write("                            <option value=\"inter12\">Trần lãi xuất 14 ngày</option>\n");
      out.write("                            <option value=\"inter13\">Trần lãi xuất 1 tháng</option>\n");
      out.write("                            <option value=\"inter15\">Trần lãi xuất 3 tháng</option>\n");
      out.write("                            <option value=\"inter16\">Trần lãi xuất 6 tháng</option>\n");
      out.write("                            <option value=\"inter17\">Trần lãi xuất 9 tháng</option>\n");
      out.write("                            <option value=\"inter18\">Trần lãi xuất 12 tháng</option>\n");
      out.write("                            <option value=\"inter19\">Trần lãi xuất 24 tháng</option>\n");
      out.write("                            <option value=\"inter21\">Trần lãi xuất 48 tháng</option>\n");
      out.write("                            <option value=\"inter22\">Trần lãi xuất 60 tháng</option>\n");
      out.write("                        </select></div>\n");
      out.write("                    <div class=\"basichide \" id=\"CLVL\"><span>Loại vay lãi: </span>\n");
      out.write("                        <select class=\" vl\" onchange=\"showDiv2(this)\">\n");
      out.write("                            <option selected value=\"\">---</option>\n");
      out.write("                            <option value=\"tldt\">Tích lũy đầu tư</option>\n");
      out.write("                            <option value=\"aud\">AUD ưu đãi</option>\n");
      out.write("                            <option value=\"tlcc\">Tích lũy cho con</option>\n");
      out.write("                            <option value=\"tgcbcnv\">Tiền gửi cán bộ công nhân viên</option>\n");
      out.write("                            <option value=\"tgtt\">Tiền gửi trực tuyến</option>\n");
      out.write("                            <option value=\"tlkh\">Tích lũy kiểu hối</option>\n");
      out.write("                            <option value=\"tktd\">Tiết kiệm tự động</option>\n");
      out.write("                            <option value=\"tklldk\">Tiết kiệm lĩnh lãi định kỳ</option>\n");
      out.write("                            <option value=\"tktlt\">Tiết kiệm trả lãi trước</option>\n");
      out.write("                            <option value=\"tkt\">Tiết kiệm thường</option>\n");
      out.write("                        </select></div>\n");
      out.write("                    <div class=\"basichide\" id=\"CLT\">\n");
      out.write("                        <span>Loại tiền: </span>\n");
      out.write("                        <select onchange=\"enabletype(this)\" name=\"typeofmoney\">\n");
      out.write("                            <option value=\"\">---</option>\n");
      out.write("                            <option value=\"vnd\" id=\"vnd\">VND</option>\n");
      out.write("                            <option value=\"usd\">USD</option>\n");
      out.write("                            <option value=\"eur\">EUR</option>\n");
      out.write("                            <option value=\"aud\">AUD</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    Đổi tỉ giá: <input type=\"text\" id=\"tigia\" name=\"interestrate\" placeholder=\"0.00\" disabled ><br>\n");
      out.write("                    <input type=\"submit\" id=\"thaydoi\" value=\"Thay đổi\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-popup\" id=\"themstk\">\n");
      out.write("                <form action=\"AddSavingServlet\" method=\"post\" class=\"form-container\">\n");
      out.write("                    <p id=\"title\">Thêm sổ tiết kiệm</p>\n");
      out.write("                    <input type=\"text\" name=\"id\" placeholder='ID' required> <br>\n");
      out.write("                    <input  type=\"text\"name=\"idcustomer\" placeholder='IDCustomer' required> <br>\n");
      out.write("                    <input type=\"text\" name=\"idemployee\" placeholder='IDEmployee' required> <br>\n");
      out.write("                    <input type=\"text\" name=\"idhusbandry\" placeholder='IDHusbandry' required> <br>\n");
      out.write("                    <label>Ngày mở sổ: </label><input type=\"date\" name=\"provisionDate\" placeholder='Provision Date' class=\"endDate\" type=\"date\" name=\"endDate\"  min='2000-01-01' max='2000-13-13' required> <br>\n");
      out.write("                    <span>Kì hạn: </span>\n");
      out.write("                    <select name=\"term\" required>\n");
      out.write("                        <option value=\"1\">1 tháng</option>\n");
      out.write("                        <option value=\"3\">3 tháng</option>\n");
      out.write("                        <option value=\"6\">6 tháng</option>\n");
      out.write("                        <option value=\"9\">9 tháng</option>\n");
      out.write("                        <option value=\"12\">12 tháng</option>\n");
      out.write("                    </select>\n");
      out.write("                    <span>Loại tiền: </span>\n");
      out.write("                    <select name=\"term\" required>\n");
      out.write("                        <option value=\"vnd\">VND</option>\n");
      out.write("                        <option value=\"usd\">USD</option>\n");
      out.write("                        <option value=\"eur\">EUR</option>\n");
      out.write("                        <option value=\"aud\">AUD</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"text\" name=\"depositTotal\" placeholder='Deposit Total' required> <br>\n");
      out.write("                    <input type=\"text\" name=\"interestTotal\" placeholder='Interest Total' required> <br>\n");
      out.write("                    <input type=\"submit\" value=\"Xác nhận\">\n");
      out.write("                    <button class=\"closeform\" onclick=\"closeForm('themstk')\" type=\"button\">X</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function openTab(evt, tabName) {\n");
      out.write("                // Declare all variables\n");
      out.write("                var i, tabcontent, tablinks;\n");
      out.write("                // Get all elements with class=\"tabcontent\" and hide them\n");
      out.write("                tabcontent = document.getElementsByClassName(\"tabcontent\");\n");
      out.write("                for (i = 0; i < tabcontent.length; i++) {\n");
      out.write("                    tabcontent[i].style.display = \"none\";\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Get all elements with class=\"tablinks\" and remove the class \"active\"\n");
      out.write("                tablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("                for (i = 0; i < tablinks.length; i++) {\n");
      out.write("                    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                // Show the current tab, and add an \"active\" class to the button that opened the tab\n");
      out.write("                document.getElementById(tabName).style.display = \"block\";\n");
      out.write("                evt.currentTarget.className += \" active\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function showDiv1(t) {\n");
      out.write("                if (t.value === \"CLSTK\") {\n");
      out.write("                    document.getElementById(t.value).style.display = \"inline-block\";\n");
      out.write("                    document.getElementById(\"CLVL\").style.display = \"none\";\n");
      out.write("                } else if (t.value === \"CLVL\") {\n");
      out.write("                    document.getElementById(t.value).style.display = \"inline-block\";\n");
      out.write("                    document.getElementById(\"CLSTK\").style.display = \"none\";\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"CLVL\").style.display = \"none\";\n");
      out.write("                    document.getElementById(\"CLSTK\").style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function showDiv2(t) {\n");
      out.write("                if (t.value !== \"\")\n");
      out.write("                    document.getElementById(\"CLT\").style.display = \"inline-block\";\n");
      out.write("                else\n");
      out.write("                    document.getElementById(\"CLT\").style.display = \"none\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function enabletype(t) {\n");
      out.write("                if (t.value !== \"\")\n");
      out.write("                    document.getElementById(\"tigia\").disabled = false;\n");
      out.write("                else\n");
      out.write("                    document.getElementById(\"tigia\").disabled = true;\n");
      out.write("            }\n");
      out.write("            function openForm(form) {\n");
      out.write("                document.getElementById(form).style.display = \"block\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function closeForm(form) {\n");
      out.write("                document.getElementById(form).style.display = \"none\";\n");
      out.write("                ;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var today = new Date();\n");
      out.write("            var dd = today.getDate();\n");
      out.write("            var mm = today.getMonth() + 1; //January is 0!\n");
      out.write("            var yyyy = today.getFullYear();\n");
      out.write("            if (dd < 10) {\n");
      out.write("                dd = '0' + dd\n");
      out.write("            }\n");
      out.write("            if (mm < 10) {\n");
      out.write("                mm = '0' + mm\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            today = yyyy + '-' + mm + '-' + dd;\n");
      out.write("            document.getElementByClass(\"endDate\").setAttribute(\"max\", today);\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
