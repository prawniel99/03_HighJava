<%@page import="a.vo.Avo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
window.onload = function() {
	
	let div1 = document.getElementById('div1');
	let div1child = document.createElement('div');
	
	code = "";
	//document.getElementById('div1').innerHTML = "wtf";
	
    <%
	List<Avo> list = (List<Avo>)request.getAttribute("list");
	for(Avo mem : list) {
		String id = mem.getMem_id();
		String nm = mem.getMem_name();
		String pw = mem.getMem_pass();
		%> 
		code += '<p>';
		code += `<%= id %>`;
		code += `<%= nm %>`;
		code += `<%= pw %>`;
		code += '</p>';
		<% 
		
		
	}
	%>
	div1child.innerHTML = code;
	div1.appendChild(div1child);
	//document.getElementById('div1').innerHTML = code;
}
</script>

<script>
	code = "";
	
	document.getElementById('div1').innerHTML = code;
</script>

</head>
<body>
    <table border="1" id="memberTable">
        <thead>
            <tr>
                <th>id</th>
                <th>pw</th>
                <th>nm</th>
                <!-- 필요한 만큼 컬럼을 더 추가 -->
            </tr>
        </thead>
        <tbody>
        	<tr>
        		<td><%= list.get(0).getMem_id() %></td>
            <!-- 여기서 데이터를 삽입할 예정 -->
        	</tr>
        </tbody>
    </table>
    
    <div id="div1"></div>
    div1
    
    
	<script>


</script>
</body>
</html>