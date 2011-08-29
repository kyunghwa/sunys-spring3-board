
var NS4;
var IE4;
var sUserAgent = navigator.userAgent;
var isOpera = sUserAgent.indexOf("Opera") > -1;
var isIE = sUserAgent.indexOf("compatible") > -1 
           && sUserAgent.indexOf("MSIE") > -1
           && !isOpera;
var nonstr = '!^*()+|\?&%:;{}~';

if (isIE){
    IE4 = true;
    NS4 = false;
}else{
    IE4 = false;
    NS4 = true;
}


//입력한 문자열의 모든 공백문자를 제거한다.
function trim(str){
	var cnt = str.length;
	
	for( var i=0 ; i < cnt ; i++){
		str = str.replace(' ', '');
	}
	return str;
}


function showMessage(msg){
	if(msg != ''){
		alert(msg);	
  	}	
}

function wnopen( url, name, width, height ) {
  window.open(url, name, "scrollbars=0 width="+width+" height="+height);
}

function openScroll( url, name, width, height) {
  window.open(url, name, "scrollbars=1, resizable=yes, width="+width+", height="+height);
}

String.prototype.bytes = function(){
    var str = this;
    var l = 0;
    for (var i=0; i<str.length; i++) 
        l += (str.charCodeAt(i) > 128) ? 2 : 1;

    return l;
}


String.prototype.trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g, ""); 
}   	


function isChecked(chkbox){
	var flag = false;
	for(var i=0 ; i<chkbox.length ; i++){
		if(chkbox[i].checked){
			flag = true;
			break;
		}	
	}
	return flag;
}

function getCheckedId(chkbox){
	var id = 0;
	for(var i=0 ; i<chkbox.length ; i++){
		if(chkbox[i].checked){
			id = chkbox[i].value;
			break;
		}	
	}
	return id;
}

function checkedAll(chkbox){
	var flag = false;
	for(var i=0 ; i<chkbox.length ; i++){
		if(chkbox[i].checked){
			flag = true;
			break;
		}	
	}
	
	if(flag){
		for(var i=0 ; i<chkbox.length ; i++){
			chkbox[i].checked = false;
		}	
	}else{
		for(var i=0 ; i<chkbox.length ; i++){
			chkbox[i].checked = true;
		}
	}
}


function CheckType(s,spc) {
	var i;
    for(i=0; i<s.length; i++) {
    	if (spc.indexOf(s.substring(i, i+1)) > 0) {
        	return false;
        }
    }         
    return true;
} 
 


/*
 * radio button 을 disable 한다. 
 */
function disableRadio(obj){
    for(i=0; i<obj.length; i++){
        obj[i].disabled = true;        
    }
}


/*
 * radio button 을 enable 한다. 
 */
function enableRadio(obj){
    for(i=0; i<obj.length; i++){
        obj[i].disabled = false;        
    }
}


function disableObj(obj){
    obj.disabled = true; 
}


function enableObj(obj){
    obj.disabled = false; 
}


function resizeFrame(mframe) {
    var min_h = 100;
    var oIFrame = document.getElementById(mframe);

    try {          
      
      var oDoc = oIFrame.contentDocument || oIFrame.contentWindow.document;        

      if (/MSIE/.test(navigator.userAgent)) {
        var frmHeight = oDoc.body.scrollHeight;
      } else {
        var s = oDoc.body.appendChild(document.createElement('DIV'))
        s.style.clear = 'both';

        var frmHeight = s.offsetTop;
        s.parentNode.removeChild(s);
      }
      

      if (frmHeight < min_h) frmHeight = min_h;

      oIFrame.style.height = frmHeight;

    } catch (e) {  }        
}   



