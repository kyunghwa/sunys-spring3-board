<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript" src="/common/js/Common.js" ></script> 
<link rel="STYLESHEET" type="text/css" href="/common/css/default.css" > 

<script type="text/javascript" language="JavaScript">
    var act = {
        join : function(){ 
            
            if(trim(document.getElementById("id").value) === ''){
                alert('아이디를 입력해 주세요!');
            	return;
            }else if(trim(document.getElementById("passwd").value) === ''){
                alert('패스워드를 입력해 주세요!');
                return;
            }else if(trim(document.getElementById("name").value) === ''){
                alert('이름을 입력해 주세요!');
                return;
            }else if(trim(document.getElementById("email").value) === ''){
                alert('이메일을 입력해 주세요!');
                return;
            }else if(trim(document.getElementById("hp").value) === ''){
                alert('핸드폰번호를 입력해 주세요!');
                return;
            }
            
            var f = document.getElementById("form");
            f.action = '/user/join.ok';
            f.submit();
        }
    }
</script>

<body >

<form:form commandName="emp" name="form" id="form" method="post" >
<div style="height:50px;"> </div>
<h2> 로그인 화면 </h2>
  <table width="550" border="0">
    <tr height="10"><td colspan="2"></td></tr>
    <tr>
        <td width="80">ID :</td>
        <td>
        	<input type="text" id="id" name="id" value="" maxlength="10" size="10"/>
            <a href="javascript:act.join();"  class="btn_big"><span>가 입</span></a> 
            <a href="/user/loginform.ok"  class="btn_big"><span>취 소</span></a>
        </td>
    </tr>           
    
    <tr>
    	<td width="80">PASS :</td>
    	<td>
    		<input type="password" id="passwd" name="passwd" value=""  maxlength="10" size="10"/>
    	</td>
    </tr>    
    
    <tr>
    	<td width="80">NAME :</td>
    	<td>
    		<input type="text" id="name" name="name" value=""  maxlength="10" size="10"/>
    	</td>
    </tr> 
    
    <tr>
    	<td width="80">E-MAIL :</td>
    	<td>
    		<input type="text" id="email" name=""email"" value=""  maxlength="10" size="10"/>
    	</td>
    </tr> 
    
    <tr>
    	<td width="80">HP :</td>
    	<td>
    		<input type="text" id="hp" name="hp" value=""  maxlength="10" size="10"/>
    	</td>
    </tr> 
    <tr height="20"><td  align="center" colspan="2"><form:errors path="empno" cssClass="redB" /></td></tr>
  </table>
  
</form:form>
</body>