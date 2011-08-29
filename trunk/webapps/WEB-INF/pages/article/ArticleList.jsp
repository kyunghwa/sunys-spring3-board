<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="/common/js/Common.js" ></script> 
<link rel="STYLESHEET" type="text/css" href="/common/css/default.css" > 

<script type="text/javascript">

    var act = {
        goWriteForm : function(){ 
            var f = document.getElementById("form");
            f.action = '/article/form.ok';
            f.submit();
        },
        search : function(){
            document.form.submit();
        }
    }
        
</script>

<body onload="showMessage('${msg}');">
<form name="form" action="/article/list.ok" id="form" method="post" OnSubmit="act.search();">
<input type="hidden" id="communityId" name="communityId" value="${search.communityId}" />

 

<table width="650" cellspacing="0" cellpadding="0" border="0">
    <tr height="20"><td></td></tr>
    <tr height="20">
        <td class="tableTtile" style='padding:2px 5px 0 10px' > 자유 게시판</td>        
        <td class="grayB" align="right">oracleclub.com</td>
    </tr>
</table>

    
<table width="650" cellspacing="0" cellpadding="0" border="0" >
    <tr ><td class="tableHL" height="1" colspan="6" width="650" ></td></tr>
    <tr height="22" align="center"  >
        <td width="40" class="tableH">번호</td>
        <td class="tableH"> 제목 </td>
        <td width="80" class="tableH">작성자</td>
        <td width="100" class="tableH">작성일</td>
    </tr>        
    <tr ><td width="650" class="tableHL" height="1" colspan="6" ></td></tr>


<c:forEach var="info" items="${articleList}" varStatus="c" >
    <tr height="22" align="center" onmouseover="this.className='tableOver'" onmouseout="this.className='tableOut'">
        <td width="40" class="grayS" >${info.articleId}</td>
        <td align="left" style='padding:2px 10px 0 15px'>
            <c:if test="${info.reLevel>0}">
                <img src="/imgs/ui/blank.gif" border=0 height="1" width="${info.reLevel*10}" />
                <img src="/imgs/ui/icon/re.gif" border="0" />
            </c:if>                         
            <a href="/article/view.ok?articleId=${info.articleId}" class="tableA">${info.title}</a>
            
            
        </td>
        <td width="80" >${info.name}</td>
        <td width="100" class="txtS"><fmt:formatDate value="${info.registYmdt}" pattern="yyyy-MM-dd" /></td>
    </tr>
    <tr ><td class="tableL" height="1" colspan="6" width="650"  ></td></tr>
</c:forEach>
    
    <tr height=22><td colspan="7" align="center" >${pageLink}</td></tr>
</table>

<table width="650" border="0" cellspacing="0" cellpadding="0">
    <tr height=7><td ></td></tr>
    <tr height=20>
        <td  width="80%">
            <select name="searchKey" class="combobox">
                <option value="CONTENT" <c:if test="${search.searchKey=='CONTENT'}">selected</c:if>>내용</option>
                <option value="TITLE"  <c:if test="${search.searchKey=='TITLE'}">selected</c:if>>제목</option>                 
                <option value="NAME"  <c:if test="${search.searchKey=='NAME'}">selected</c:if>>작성자</option> 
            </select>

            <input type="text" name="searchValue" value="${search.searchValue}" class="txtbox" size="25" />
            <a href="javascript:act.search();"  class="btn_big"><span>검 색</span></a>            
        </td>
        <td  width="20%" align="right">
            <a href="javascript:act.goWriteForm();"  class="btn_big"><span>글 등 록</span></a>
        </td>
    </tr>
</table>

        
</form>
</body>