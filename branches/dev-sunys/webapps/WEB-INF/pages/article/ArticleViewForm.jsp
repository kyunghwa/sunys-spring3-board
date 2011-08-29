<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="/common/js/Common.js" ></script> 
<link rel="STYLESHEET" type="text/css" href="/common/css/default.css" > 

<script type="text/javascript">

    var act = {
        goWriteForm : function(){ 
            location.href="/article/form.ok?communityId=${article.communityId}";                        
        },
        articleList : function(){
            location.href="/article/list.ok?communityId=${article.communityId}";
        },
        goReplyForm : function(){
            var f = document.getElementById("form");
            f.action = '/article/replyForm.ok';
            f.submit();
        },
        goModifyForm : function(){
            var f = document.getElementById("form");
            f.action = '/article/modifyForm.ok';
            f.submit();
        },
        runRemove : function(){
            var f = document.getElementById("form");
            if(confirm('정말 삭제 하시겠습니까?')){           
                f.action = '/article/remove.ok';
                f.submit();
            }else{
                return;
            }
        }
    } 
    
</script>


<form name="form" id="form" action="" method="post" >
<input type="hidden" name="articleId"   value="${article.articleId}" id="articleId" />
<input type="hidden" name="communityId" value="${article.communityId}" />
    
<table width="650" cellspacing="0" cellpadding="0" border="0">
    <tr height="20"><td></td></tr>
    <tr height="20"> 
        <td class="tableTtile" style='padding:2px 5px 0 10px' width="550"> 자유게시판</td>
        <td class="grayB" width="100">oracleclub.com</td>
    </tr>
</table>


<table width="650" cellspacing="0" cellpadding="0" border="0">
    
    <tr><td class="tableHL"  height="1" colspan="2"></td></tr>
    <tr height="22">
        <td width="450" style='padding:2px 5px 0 15px' ><div id="scrapTitle">${article.title}</div></td>
        <td width="200" align="right" class="idxS">${article.name} : <fmt:formatDate value="${article.registYmdt}" pattern="yyyy-MM-dd" />&nbsp; </td>
    </tr>    
    <tr><td class="tableHL"  height="1" colspan="2"></td></tr>
    
	<c:if test="${!empty fileList}" >
	    <tr height="22">
	        <td style='padding:2px 5px 0 15px' colspan="2">
	<c:forEach var="file" items="${fileList}" varStatus="c" >        
	            <img src="/imgs/ui/icon/ico_file.gif" border="0" /> <a href="/article/download.ok?fileId=${file.fileId}" class="linkA">${file.originFilename}</a> <span class="txtS">(<fmt:formatNumber value="${file.fileSize}" type="number"/> Bytes)</span><BR>
	</c:forEach>
	        </td>
	    </tr>    
	    <tr><td class="tableL"  height="1" colspan="2"></td></tr>
	</c:if>

    <tr height="200">   
        <td  colspan="2" valign="top" align="center">
            <table width="630" cellspacing="0" cellpadding="0" border="0">
                <tr height="10"><td colspan="2"></td></tr>
                <tr>
                    <td colspan="2">
                        ${article.content}
                    </td>
                </tr>       
                <tr height="10"><td colspan="2"></td></tr>                        
            </table>
        </td>
    </tr>
    
    <tr><td class="tableHL"  height="1" colspan="2"></td></tr>
</table>
</form>
<!--  본문 끝  --> 

<table width="650" cellspacing="0" cellpadding="0" border="0">
    <tr height="5"><td></td></tr> 
    <tr>
        <td width="50%" align="left">
            <a href="javascript:act.goWriteForm();"  class="btn_big"><span>글 등 록</span></a>
            <a href="javascript:act.goReplyForm();"  class="btn_big"><span>글 답 변</span></a>
            <a href="javascript:act.goModifyForm();"  class="btn_big"><span>글 수 정</span></a>
            <a href="javascript:act.runRemove();"  class="btn_big"><span>글 삭 제</span></a>            
        </td>
        <td width="50%" align="right">
            <a href="javascript:act.articleList();"  class="btn_big"><span>목록보기</span></a>
        </td>
    </tr>
    <tr height="20"><td></td></tr>
</table>