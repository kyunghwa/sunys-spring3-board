<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<html>
<head>
 <title><decorator:title default="example" /></title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <decorator:head />
</head>  
<body class="yui-skin-sam">
<table width="100%" height="100%" border="1">
 <tr height="50">
  <td id="header" colspan="2">  header area</td>
 </tr>
 
 <tr>
  <td valign="top" width="15%" > left area   </td>

  <td width="75%">
   <table width="100%" height="100%" cellspacing="0">
    <tr>
     <td id="pageTitle">
      <decorator:title />
     </td>
    </tr>
    <tr>
     <td valign="top" height="100%" style="padding:5px 5px 5px 15px;">
      <decorator:body />
     </td>
    </tr>
    <tr height="30"><td></td></tr>
   </table>
  </td>
 </tr>

 <tr height="40">
  <td id="footer" height="40" colspan="2" align="center">  footer area </td>
 </tr>
</table>

</body>
</html>