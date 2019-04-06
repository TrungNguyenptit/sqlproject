<%-- 
    Document   : main
    Created on : Mar 12, 2019, 8:08:20 PM
    Author     : ADMIN
--%>
<%@page import="controller.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="css/mainpage.css" />
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
    </head>

    <body>

        <% SavingDAO sdao = new SavingDAO();
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
        %>

        <p id="thongbao"><% if (session.getAttribute("thongbao") != null) {%> <%=session.getAttribute("thongbao")%> <%} %> </p>
        <p> TRANG CHỦ <p>
            <a href="main.jsp"> <img  src="images/logo.png" alt="Vietcombank" style="width:15%"> </a>
        <div class="menu">
            <!-- Tab -->
            <div class="tab">
                <a href="#stk"> <button class="tablinks" onclick="openTab(event, 'STK')">Sổ tiết kiệm</button> </a>
                <a href="#vl"> <button class="tablinks" onclick="openTab(event, 'VL')">Vay lãi</button> </a>
                <a href="#xbc"> <button class="tablinks" onclick="openTab(event, 'BC')">Xuất báo cáo</button> </a>
                <a href="#ch"><button class="tablinks" onclick="openTab(event, 'CH')" id="moCH">Cấu hình</button> </a>
            </div>
            <!-- Tab content -->
            <div id="STK" class="tabcontent" 
                 <% if (request.getAttribute("savingList") != null) {%>  style="display: block" <%} %>  >
                <div>
                    <button onclick="openForm('themstk')">Thêm sổ tiết kiệm </button>
                    <form action="SavingListServlet" method="get">
                        <span>Loại tiết kiệm: </span>
                        <select name="loaistk">
                            <option value="all">Tất cả</option>
                            <option value="hus01">Tích lũy đầu tư</option>
                            <option value="hus06">AUD ưu đãi</option>
                            <option value="hus010">Tích lũy cho con</option>
                            <option value="hus011">Tiền gửi cán bộ công nhân viên</option>
                            <option value="hus012">Tiền gửi trực tuyến</option>
                            <option value="hus016">Tích lũy kiểu hối</option>
                            <option value="hus017">Tiết kiệm tự động</option>
                            <option value="hus018">Tiết kiệm lĩnh lãi định kỳ</option>
                            <option value="hus019">Tiết kiệm trả lãi trước</option>
                            <option value="hus020">Tiết kiệm thường</option>
                        </select>
                        <span>Loại tiền: </span>
                        <select name="loaitien">
                            <option value="all">Tất cả</option>
                            <option value="vnd">VND</option>
                            <option value="usd">USD</option>
                            <option value="eur">EUR</option>
                            <option value="aud">AUD</option>
                        </select>

                        <span>Tình trạng: </span>
                        <select name="tinhtrang">
                            <option value="all">Tất cả</option>
                            <option value="open">Đang mở</option>
                            <option value="close">Đã rút sổ</option>
                        </select>
                        <button type="submit"> Xác nhận </button>
                    </form>
                </div>
                <table>
                    <tr>
                        <th>STT</th>
                        <th>Tên chủ sổ</th>
                        <th>Tên NV quản lý</th>
                        <th>Loại tiết kiệm</th>
                        <th>Ngày mở sổ</th>
                        <th>Ngày hết hạn</th>
                        <th>Loại tiền</th>
                        <th>Tiền gửi</th>
                        <th>Tiền lãi</th>
                        <th>Tình trạng</th>
                    </tr>
                    <%
                        int stt = 0;
                        for (Saving s : savingList) {
                            stt++;
                            c = cdao.GetCustomer(s.getIdcustomer());
                            e = edao.GetEmployee(s.getIdemployee());
                            h = hdao.GetHusbandry(s.getIdhusbandry());
                    %>
                    <tr>
                        <td><%=stt%></td>
                        <% p = pdao.GetProfile(c.getIdprofile());%>
                        <td><%=p.getName()%></td>
                        <%p = pdao.GetProfile(e.getIdProfile());%>
                        <td><%=p.getName()%></td>
                        <td><%=h.getName()%></td>
                        <td><%=s.getProvisionDate()%></td>
                        <td><%=s.getExpirationDate()%></td>
                        <td><%=s.getTypeofmoney()%></td>
                        <td><%=s.getDepositTotal()%></td>
                        <td><%=s.getInterestTotal()%></td>
                        <% if (s.isMo()) {%>
                        <td>Mở</td>
                        <%} else {%>
                        <td>Đóng</td>
                    </tr>
                    <% }
                        }
                    %>
                </table>
            </div>

            <div id="VL" class="tabcontent"
                 <% if (request.getAttribute("loanList") != null) {%>  style="display: block" <%} %>  >
                <div>
                    <!--                    <button onclick="openForm('themstk')">Thêm sổ tiết kiệm </button>
                                        <button onclick="openForm('xoastk')">Xóa sổ tiết kiệm </button>-->
                    <form action="LoanListServlet" method="get">
                        <span>Loại vay lãi: </span>
                        <select name="loaivl">
                            <option value="all">Tất cả</option>
                            <option value="lo01">Cho vay sửa nhà</option>
                            <option value="lo02">Ngôi nhà mơ ước</option>
                            <option value="lo03">Gia đình thịnh vượng</option>
                            <option value="lo04">Cho vay mua nhà dự án</option>
                            <option value="lo05">Cho vay hỗ trợ mua nhà ở xã hội/thương mại</option>
                            <option value="lo06">Cho vay cá nhân</option>
                            <option value="lo14">Cho vay cán bộ công nhân viên</option>
                            <option value="lo07">Cho vay cán bộ quản lý điều hành/option>
                            <option value="lo08">Cho vay mua ô tô</option>
                            <option value="lo09">Thấu chi tài khoản cá nhân</option>
                            <option value="lo10">Kinh doanh tài lộc</option>
                            <option value="lo11">Cho vay cầm cố chứng khoán niêm yết</option>
                            <option value="lo12">Cho vay cầm cố giấy tờ</option>
                            <option value="lo13">Thấu chi cầm cố giấy tờ</option>
                        </select>

                        <span>Tình trạng: </span>
                        <select name="tinhtrang">
                            <option value="all">Tất cả</option>
                            <option value="open">Đang mở</option>
                            <option value="close">Đã rút sổ</option>
                        </select>
                        <button type="submit"> Xác nhận </button>
                    </form>
                </div>
                <table>
                    <tr>
                        <th>STT</th>
                        <th>Tên chủ sổ</th>
                        <th>Tên NV quản lý</th>
                        <th>Loại vay lãi</th>
                        <th>Ngày vay lãi</th>
                        <th>Ngày trả lãi</th>
                        <th>Tiền vay</th>
                        <th>Tiền lãi phải trả</th>
                        <th>Tình trạng</th>
                    </tr>
                    <%
                        stt = 0;
                        for (Loan lo : loanList) {
                            stt++;
                            c = cdao.GetCustomer(lo.getIdcustomer());
                            e = edao.GetEmployee(lo.getIdemployee());
                            le = ledao.GetLend(lo.getIdlend());
                    %>
                    <tr>
                        <td><%=stt%></td>
                        <% p = pdao.GetProfile(c.getIdprofile());%>
                        <td><%=p.getName()%></td>
                        <%p = pdao.GetProfile(e.getIdProfile());%>
                        <td><%=p.getName()%></td>
                        <td><%=le.getName()%></td>
                        <td><%=lo.getProvisionDate()%></td>
                        <td><%=lo.getExpirationDate()%></td>
                        <td><%=lo.getLoanamount()%></td>
                        <td><%=lo.getInterestTotal()%></td>
                        <% if (lo.isMo()) {%>
                        <td>Mở</td>
                        <%} else {%>
                        <td>Đóng</td>
                    </tr>
                    <% }
                        }
                    %>
                </table>
            </div>

            <div id="BC" class="tabcontent">
                <form action="ReportServlet"  method="post" > 
                    <span>Chọn kì hạn: </span>
                    <select name="term">>
                        <option selected value="LSTK">Tháng</option>
                        <option value="LVN">Quý</option>
                        <option value="TDT">Năm</option>
                    </select>
                    <span>Chọn thời gian cuối: </span> <input class="endDate" type="date" name="endDate"  min='2000-01-01' max='2000-13-13' required>
                    <button type="submit">Xuất báo cáo</button>
                </form>
            </div>

            <div id="CH" class="tabcontent">
                <form action="ConfigurationServlet" class=" DTG" method="post">
                    <span>Chọn loại: </span>
                    <select id="mainselect" name="type" onchange="showDiv1(this)">
                        <option selected value="">---</option>
                        <option value="CLSTK" id="chonstk">Sổ tiết kiệm</option>
                        <option value="CLVL">Vay lãi</option>
                    </select>
                    <div class="basichide" id="CLSTK"><span>Loại sổ tiết kiệm: </span>
                        <select class=" stk" name="typestk" onchange="showDiv2(this)">
                            <option selected value="">---</option>
                            <option value="inter01" id="tlcc">Tích lũy cho con - mở tài khoản</option>
                            <option value="inter02">Tích lũy cho con - sau 3 tháng</option>
                            <option value="inter03">Tích lũy cho con - sau 6 tháng</option>
                            <option value="inter04">Tích lũy cho con - 9 tháng</option>
                            <option value="inter05">Tích lũy cho con rút trước hạn</option>
                            <option value="inter07">Tích lũy kiều hối</option>
                            <option value="inter08">Lĩnh lãi định kỳ - VND</option>
                            <option value="inter09">Lĩnh lãi định kỳ - USD</option>
                            <option value="inter10">Trần lãi xuất không kỳ hạn</option>
                            <option value="inter11">Trần lãi xuất 7 ngày</option>
                            <option value="inter12">Trần lãi xuất 14 ngày</option>
                            <option value="inter13">Trần lãi xuất 1 tháng</option>
                            <option value="inter15">Trần lãi xuất 3 tháng</option>
                            <option value="inter16">Trần lãi xuất 6 tháng</option>
                            <option value="inter17">Trần lãi xuất 9 tháng</option>
                            <option value="inter18">Trần lãi xuất 12 tháng</option>
                            <option value="inter19">Trần lãi xuất 24 tháng</option>
                            <option value="inter21">Trần lãi xuất 48 tháng</option>
                            <option value="inter22">Trần lãi xuất 60 tháng</option>
                        </select></div>
                    <div class="basichide " id="CLVL"><span>Loại vay lãi: </span>
                        <select class=" vl" onchange="showDiv2(this)">
                            <option selected value="">---</option>
                            <option value="tldt">Tích lũy đầu tư</option>
                            <option value="aud">AUD ưu đãi</option>
                            <option value="tlcc">Tích lũy cho con</option>
                            <option value="tgcbcnv">Tiền gửi cán bộ công nhân viên</option>
                            <option value="tgtt">Tiền gửi trực tuyến</option>
                            <option value="tlkh">Tích lũy kiểu hối</option>
                            <option value="tktd">Tiết kiệm tự động</option>
                            <option value="tklldk">Tiết kiệm lĩnh lãi định kỳ</option>
                            <option value="tktlt">Tiết kiệm trả lãi trước</option>
                            <option value="tkt">Tiết kiệm thường</option>
                        </select></div>
                    <div class="basichide" id="CLT">
                        <span>Loại tiền: </span>
                        <select onchange="enabletype(this)" name="typeofmoney">
                            <option value="">---</option>
                            <option value="vnd" id="vnd">VND</option>
                            <option value="usd">USD</option>
                            <option value="eur">EUR</option>
                            <option value="aud">AUD</option>
                        </select>
                    </div>
                    Đổi tỉ giá: <input type="text" id="tigia" name="interestrate" placeholder="0.00" disabled ><br>
                    <input type="submit" id="thaydoi" value="Thay đổi">
                </form>
            </div>

            <div class="form-popup" id="themstk">
                <form action="AddSavingServlet" method="post" class="form-container">
                    <p id="title">Thêm sổ tiết kiệm</p>
                    <input type="text" name="id" placeholder='ID' required> <br>
                    <input  type="text"name="idcustomer" placeholder='IDCustomer' required> <br>
                    <input type="text" name="idemployee" placeholder='IDEmployee' required> <br>
                    <input type="text" name="idhusbandry" placeholder='IDHusbandry' required> <br>
                    <label>Ngày mở sổ: </label><input type="date" name="provisionDate" placeholder='Provision Date' class="endDate" type="date" name="endDate"  min='2000-01-01' max='2000-13-13' required> <br>
                    <span>Kì hạn: </span>
                    <select name="term" required>
                        <option value="1">1 tháng</option>
                        <option value="3">3 tháng</option>
                        <option value="6">6 tháng</option>
                        <option value="9">9 tháng</option>
                        <option value="12">12 tháng</option>
                    </select>
                    <span>Loại tiền: </span>
                    <select name="term" required>
                        <option value="vnd">VND</option>
                        <option value="usd">USD</option>
                        <option value="eur">EUR</option>
                        <option value="aud">AUD</option>
                    </select>
                    <input type="text" name="depositTotal" placeholder='Deposit Total' required> <br>
                    <input type="text" name="interestTotal" placeholder='Interest Total' required> <br>
                    <input type="submit" value="Xác nhận">
                    <button class="closeform" onclick="closeForm('themstk')" type="button">X</button>
                </form>
            </div>

        </div>

        <script>
            function openTab(evt, tabName) {
                // Declare all variables
                var i, tabcontent, tablinks;
                // Get all elements with class="tabcontent" and hide them
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }

                // Get all elements with class="tablinks" and remove the class "active"
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }

                // Show the current tab, and add an "active" class to the button that opened the tab
                document.getElementById(tabName).style.display = "block";
                evt.currentTarget.className += " active";
            }

            function showDiv1(t) {
                if (t.value === "CLSTK") {
                    document.getElementById(t.value).style.display = "inline-block";
                    document.getElementById("CLVL").style.display = "none";
                } else if (t.value === "CLVL") {
                    document.getElementById(t.value).style.display = "inline-block";
                    document.getElementById("CLSTK").style.display = "none";
                } else {
                    document.getElementById("CLVL").style.display = "none";
                    document.getElementById("CLSTK").style.display = "none";
                }
            }

            function showDiv2(t) {
                if (t.value !== "")
                    document.getElementById("CLT").style.display = "inline-block";
                else
                    document.getElementById("CLT").style.display = "none";
            }

            function enabletype(t) {
                if (t.value !== "")
                    document.getElementById("tigia").disabled = false;
                else
                    document.getElementById("tigia").disabled = true;
            }
            function openForm(form) {
                document.getElementById(form).style.display = "block";
            }

            function closeForm(form) {
                document.getElementById(form).style.display = "none";
                ;
            }

            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();
            if (dd < 10) {
                dd = '0' + dd
            }
            if (mm < 10) {
                mm = '0' + mm
            }

            today = yyyy + '-' + mm + '-' + dd;
            document.getElementByClass("endDate").setAttribute("max", today);
        </script>
    </body>

</html>
