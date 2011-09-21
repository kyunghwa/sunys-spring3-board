<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript" src="/common/js/Common.js" ></script> 
<link rel="STYLESHEET" type="text/css" href="/common/css/default.css" > 

<script type="text/javascript" language="JavaScript">
    var act = {
        login : function(){ 
            
            if(trim(document.getElementById("empno").value) === ''){
                alert('사원 번호를 입력해 주세요!');
            	return;
            }
            var f = document.getElementById("form");
            f.action = '/user/login.ok';
            f.submit();
        }
    }
</script>

<body >

<form:form commandName="emp" name="form" id="form" method="post" >
<div style="height:50px;"> </div>
<h2> 로그인 화면 </h2>
  <table width="550" border="0">
    <tr height="10"><td></td></tr>
    <tr>
        <td align="center" > empno : 

            <input type="text" id="empno" name="empno" value="" maxlength="5" size="10"/>            

            <a href="javascript:act.login();"  class="btn_big"><span>로그인</span></a> 
            <a href="/article/list.ok"  class="btn_big"><span>취 소</span></a>    
        </td>
    </tr>   
    
    <tr height="20"><td  align="center"><form:errors path="empno" cssClass="redB" /></td></tr>
    <tr>
        
    </tr>    
  </table>
  
</form:form>
</body>