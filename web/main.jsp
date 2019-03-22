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
            CustomerDAO cdao = new CustomerDAO();
            ProfileDAO pdao = new ProfileDAO();
            EmployeeDAO edao = new EmployeeDAO();
            HusbandryDAO hdao = new HusbandryDAO();
            ArrayList<Saving> savingList = new ArrayList<Saving>();
            Customer c = new Customer();
            Profile p = new Profile();
            Employee e = new Employee();
            Husbandry h = new Husbandry();
            if (request.getAttribute("savingList") == null) {
                savingList = sdao.GetSaving("all", "all", "all");
            } else {
                savingList = (ArrayList<Saving>) request.getAttribute("savingList");
            }
        %>
        <a href="main.jsp"> <img  src="images/logo.png" alt="Vietcombank" style="width:15%"> </a>
        <div class="menu">
            <!-- Tab -->
            <div class="tab">
                <a href="#stk"> <button class="tablinks" onclick="openTab(event, 'STK')">Sổ tiết kiệm</button> </a>
                <a href="#vl"> <button class="tablinks" onclick="openTab(event, 'VL')">Vay lãi</button> </a>
                <a href="#xbc"> <button class="tablinks" onclick="openTab(event, 'BC')">Xuất báo cáo</button> </a>
                <a href="#ch"><button class="tablinks" onclick="openTab(event, 'CH')">Cấu hình</button> </a>
            </div>
            <!-- Tab content -->
            <div id="STK" class="tabcontent" <% if (request.getAttribute("savingList") != null) {%>  style="display: block" <%} %>>
                <sql:setDataSource var="bank" driver="com.mysql.jdbc.Driver"
                                   url="jdbc:mysql://localhost:3306/bank"
                                   user="root"  password=""/>
                <div>
                    <button onclick="openForm('themstk')">Thêm sổ tiết kiệm </button>
                    <button onclick="openForm('xoastk')">Xóa sổ tiết kiệm </button>
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

            <div id="VL" class="tabcontent">
                <span>Loại vay lãi: </span>
                <select>
                    <option value="all">Tất cả</option>
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
                </select>
                <span>Loại tiền: </span>
                <select>
                    <option value="all">Tất cả</option>
                    <option value="vnd">VND</option>
                    <option value="usd">USD</option>
                    <option value="eur">EUR</option>
                    <option value="aud">AUD</option>
                </select>

                <span>Tình trạng: </span>
                <select>
                    <option value="all">Tất cả</option>
                    <option value="open">Đang vay</option>
                    <option value="close">Đã trả nợ</option>
                </select>
                <table>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Age</th>
                    </tr>
                    <tr>
                        <td>Jill</td>
                        <td>Smith</td>
                        <td>50</td>
                    </tr>
                    <tr>
                        <td>Eve</td>
                        <td>Jackson</td>
                        <td>94</td>
                    </tr>
                </table>
            </div>

            <div id="BC" class="tabcontent">
                <form action="ReportServlet"  method="post" > 
                    <span>Chọn loại báo cáo: </span>
                    <select name="">
                        <option selected value="LSTK">Lãi trả từ sổ tiết kiệm</option>
                        <option value="LVN">Lãi thu về từ vay nợ</option>
                        <option value="TDT">Tổng doanh thu</option>
                    </select
                    <span>Chọn kì hạn: </span>
                    <select name="term">>
                        <option selected value="LSTK">Tháng</option>
                        <option value="LVN">Quý</option>
                        <option value="TDT">Năm</option>
                    </select>
                    <span>Chọn thời gian: </span> <input type="date" name="endDate">
                    <button type="submit">Xuất báo cáo</button>
                </form>
            </div>

            <div id="CH" class="tabcontent">
                <form action="" class=" DTG">
                    <span>Chọn loại: </span>
                    <select id="mainselect" onchange="showDiv1(this)">
                        <option selected value="">---</option>
                        <option value="CLSTK">Sổ tiết kiệm</option>
                        <option value="CLVL">Vay lãi</option>
                    </select>
                    <div class="basichide" id="CLSTK"><span>Loại sổ tiết kiệm: </span>
                        <select class=" stk" onchange="showDiv2(this)">
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
                        <select onchange="enabletype(this)">
                            <option value="">---</option>
                            <option value="vnd">VND</option>
                            <option value="usd">USD</option>
                            <option value="eur">EUR</option>
                            <option value="aud">AUD</option>
                        </select>
                    </div>
                    Đổi tỉ giá: <input type="text" id="tigia" name="interestrate" placeholder="0.00" disabled><br>
                    <input type="submit" value="Thay đổi">
                </form>
            </div>

            <div class="form-popup" id="themstk">
                <form action="AddSavingServlet" method="post" class="form-container">
                    <p id="title">Thêm sổ tiết kiệm</p>
                    <input type="text" name="id" placeholder='ID' required> <br>
                    <input  type="text"name="idcustomer" placeholder='IDCustomer' required> <br>
                    <input type="text" name="idemployee" placeholder='IDEmployee' required> <br>
                    <input type="text" name="idhusbandry" placeholder='IDHusbandry' required> <br>
                    <label>Ngày mở sổ: </label><input type="date" name="provisionDate" placeholder='Provision Date' required> <br>
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
            <div class="form-popup" id="xoastk">
                <form action="DeleteSavingServlet" method="post" class="form-container">
                    <p id="title">Xóa sổ tiết kiệm</p>
                    <label> Nhập ID sổ tiết kiệm cần xóa: </label>
                    <input name="id" placeholder='ID' required> <br>
                    <input type="submit" value="Xác nhận">
                    <button class="closeform" onclick="closeForm('xoastk')" type="button">X</button>
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

        </script>
    </body>

</html>
