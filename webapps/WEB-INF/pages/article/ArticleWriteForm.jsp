<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!-- http://developer.yahoo.com/yui/editor/ -->
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/editor/assets/skins/sam/simpleeditor.css" />
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/element/element-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/container/container_core-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/editor/simpleeditor-min.js"></script>

<script type="text/javascript" src="/common/js/Common.js" ></script> 
<link rel="STYLESHEET" type="text/css" href="/common/css/default.css" > 

<script type="text/javascript">
	var myEditor;
	
	(function() {
	    var Dom = YAHOO.util.Dom,
	        Event = YAHOO.util.Event;
	    
	    var myConfig = {
	        height: '300px',
	        width: '600px',
	        dompath: true,
	        focusAtStart: true
	    };
	
	    YAHOO.log('Create the Editor..', 'info', 'example');
	    myEditor = new YAHOO.widget.SimpleEditor('editor', myConfig);
	    myEditor.render();
	
	})();

    var rowIndex = 1;
    var act = {
        addFile : function (tableId){           
            if(rowIndex == 5) {
                return;
            }
                   
            var id = document.getElementById(tableId);
            var len = id.rows.length;
            rowIndex = len;
            var newRow = id.insertRow(len);
            rowIndex ++;
            var td0 = newRow.insertCell(0);
            var td1 = newRow.insertCell(1);
            var td2 = newRow.insertCell(2);
            td0.innerHTML = " <input type='file' name='filename' id='filename"+rowIndex+"' size='35' class='btn' /> ";
            td1.innerHTML = "  ";
            td2.innerHTML = "  ";
            
            document.getElementById("rowCount").value = rowIndex;
        },
        
        delFile : function (tableId){
            if(rowIndex<2){
                return;
            }else{
                
                rowIndex--;
                document.getElementById("rowCount").value = rowIndex;
                var id = document.getElementById(tableId);   
                //var len = id.rows.length;
                id.deleteRow(-1);
            }
        },
            
        checkFile : function (){
            var extArray = new Array(".php3",".php4",".asp",".jsp",".php",".html",".htm",".html",".inc",".js",".pl",".cgi",".java",".sh",".bash");
            for(i=1 ; i<rowIndex+1; i++){
               var fullname = trim(document.getElementById("filename"+i).value);
               if(fullname != ''){
                   var filename = fullname.slice(fullname.lastIndexOf("\\")+1);
                   var fileext = filename.slice(filename.lastIndexOf(".")).toLowerCase();
                   for(j=0 ; j<extArray.length ; j++){
                        if(extArray[j]==fileext){
                            return true;
                        }
                   }
               }
            }
            return false;
        },

        articleWrite : function (){

            myEditor.saveHTML();

            if(act.checkFile()){
                alert("첨부 할 수 없는 파일 확장자(html,js,jsp..)가 있습니다!. \n zip 파일로 압축해서 올려주세요!");
                return;
            }
            
            var f = document.form;
            var subject = document.getElementById("title").value;                
                    
            //if(trim(subject) == ''){
            //    alert('제목을 입력해 주세요');
            //    document.getElementById("title").focus();
            //    return;
            //}        
           
            if(confirm('글을 등록 하시겠습니까?')){
                f.action ="/article/write.ok";
                f.submit();    
            }else{
                return;
            }
        }, 

        articleList : function(){
            location.href="/article/list.ok";
        }
    }        
</script>


<body class="yui-skin-sam">

<!--  본문 시작 -->

<form:form name="form"  commandName="article" method="post" enctype="multipart/form-data"  >
<input type="hidden" name="communityId" id="communityId" value="${communityId}" />
<input type="hidden" name="rowCount" id="rowCount" value="1" />
    
<table width="650" cellspacing="0" cellpadding="0" border="0">
    <tr height="20"><td></td></tr>
    <tr height="20">
        <td class="tableTtile" style='padding:2px 5px 0 10px' width="550"> 자유게시판</td>
        <td class="grayB" width="100">oracleclub.com</td>
    </tr>
</table>

<table width="650" cellspacing="1" cellpadding="0" border="0">          
    
    <tr><td class="tableHL" width="650" height="1" colspan="2"></td></tr>
    <tr height="22" ><td align="center" colspan="2" >글 &nbsp; 쓰 &nbsp; 기</td></tr>    
    <tr><td class="tableHL" width="650" height="1" colspan="2"></td></tr>
        
    <tr height="22">                
        <td class="tableH" width="110">이 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;름</td>
        <td width="540"  style='padding:2px 5px 0 10px;'>
        <input type="text" name="name" value="${article.name}" class="txtbox" maxlength="10" />        
        <br><form:errors path="name" cssClass="redB" />
        </td>
    </tr>

    <tr height="22">            
        <td class="tableH">제 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;목 </td>
        <td style='padding:2px 5px 0 10px;'>
            <input type="text" value="${article.title}" size=80 name="title" id="title" class="txtbox" maxlength="100" />
            <br><form:errors path="title" cssClass="redB" />            
            
        </td>
    </tr>


    <tr height="402">            
        <td  valign="middle" colspan="2">            
            <textarea id="editor" name="content" rows="20" cols="75">${article.content}</textarea>
            <br><form:errors path="content" cssClass="redB" />
        </td>
    </tr>   

    <tr height="22">            
        <td class="tableH">파일첨부 </td>
        <td valign="top" style='padding:2px 5px 0 10px;' >
            <table id="insertTable" border=0 cellpadding=0 cellspacing=0 width="530" >
                <tr>
                    <td width="330"><input type="file"  name="filename" id="filename1" size="35" class="txtbox" /></td>
                    <td width="110">
                        <a href="javascript:act.addFile('insertTable');"  class="btn_sml"><span>추가</span></a>
                        <a href="javascript:act.delFile('insertTable');"  class="btn_sml"><span>삭제</span></a>
                    </td>
                    <td width="100"><label class="orangeB"> 10M 이하</label></td>
                </tr>
            </table>
        </td>
    </tr>       
  
    <tr height="3"><td></td><td></td></tr>
    <tr><td class="tableHL" width="650" height="1" colspan="2"></td></tr>
    <tr height="10"><td></td></tr>
    <tr> 
        <td align="center" colspan="2">
        <a href="javascript:act.articleWrite();"  class="btn_big"><span>글 등 록</span></a>
        <a href="javascript:act.articleList();"  class="btn_big"><span>취 소</span></a>     
        </td>
    </tr>   
</table>
         
        
</form:form>
</body>