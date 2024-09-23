<%@page import="kr.or.ddit.member.vo.AdminVO"%>
<%@ page import="kr.or.ddit.member.vo.MemberVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    session = request.getSession();
    MemberVO loggedInMember = (MemberVO) session.getAttribute("loggedInMember");
    // 하민
    if(loggedInMember==null) {
	    AdminVO admincheck = (AdminVO)session.getAttribute("loggedInAdmin");
    	// System.out.println(admincheck.getAdminId());
	    loggedInMember = new MemberVO();
    	loggedInMember.setMemId(admincheck.getAdminId());
    	loggedInMember.setMemPass(admincheck.getAdminPass());
    	session.setAttribute("loggedInMember", loggedInMember);
    	
    	System.out.println("admin id changed to mem id " + loggedInMember.getMemId());
    	System.out.println("admin pass changed to mem pass " + loggedInMember.getMemPass());
    } else {
    	System.out.println(loggedInMember.getMemId());
    }
    System.out.println("can we command print in jsp to java server");
    System.out.println("yes we can");
    // 하민
%>
<html>
<head>
    <title>Main Layout</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- 하민 -->
    <script>
    window.onload = function() {
    	console.log(<%=loggedInMember%>);
    }
    	if(<%admincheck%> != null) {
		    window.onload = function() {
		        console.log('<%= admincheck.getAdminId() %>');
		        console.log('loggedInMember' + <%= loggedInMember%>);
		    };
    	} else {
    		console.log('not admin');
    	}
    </script>
    <!-- 하민 -->
</head>
<body>

<div class="header-top">
   <a href="<%=request.getContextPath()%>/mainHAMIN?view=indexHAMIN">
       <img src="<%=request.getContextPath()%>/images/연근옷장로고.jpg" alt="연근옷장로고.jpg" style="height: 35px;">
   </a>
</div>


<nav class="main-nav">
    <ul>
        <div class="nav-left">
            <li class="dropdown">
                <a href="#">Shop</a>
                <ul class="dropdown-content">
                    <li><a href="<%=request.getContextPath()%>/prod/prodNewArrListHAMIN.do">New Arrivals</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodBestListHAMIN.do">Best</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodListHAMIN.do">All</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodOuterListHAMIN.do">Outer</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodTopListHAMIN.do">Top</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodBottomListHAMIN.do">Bottom</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodAccListHAMIN.do">Acc</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#">Community</a>
                <ul class="dropdown-content">
                    <li><a href="<%=request.getContextPath()%>/notice/noticeListHAMIN.do">Notice</a></li>
                    <li><a href="<%=request.getContextPath()%>/qnaMainHAMIN.do">QnA</a></li>
                </ul>
            </li>
        </div>

        <div class="nav-right">
            <li><a href="#">My Page</a></li>
            <% if (loggedInMember != null) { %>
            <li><a href="<%=request.getContextPath()%>/member/logoutHAMIN.do">Logout</a></li>
            <% } else { %>
            <li><a href="<%=request.getContextPath()%>/member/loginHAMIN.do">Login</a></li> <!-- ? -->
            <li><a href="<%=request.getContextPath()%>/member/registerHAMIN.do">Join</a></li>
            <% }; %>
        
    </div>
     
    </ul>
</nav>




<!-- 메인 콘텐츠 -->
<div class="main-content">
    <jsp:include page="${contentPage}" />
</div>

<!-- 공통 푸터 -->
<div class="footer">
    <p>CUSTOMER CENTER 042.256.2569</p>
    <p>MON-FRI [10:00 - 17:00] WEEKEND, HOLIDAYS OFF</p>
    <p>Lotus Root Market No.5 All rights reserved</p>
</div>
</body>
</html>
