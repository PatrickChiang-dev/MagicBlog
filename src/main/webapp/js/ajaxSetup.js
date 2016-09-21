/**
 * ajax全局设置
 * 
 * @author jcl
 * @since 2014-12-22
 */
$(document).ready(function() {
	$.ajaxSetup({
		cache : false,
		complete : function(XHR, TS) {
			var resText = XHR.responseText;
			var sessionstatus = XHR.getResponseHeader("sessionstatus");
			var loginPath = XHR.getResponseHeader("loginPath");
			if (911 == XHR.status && "timeout" == sessionstatus) {
				//if (window.confirm('session timeout')) {
				//	window.location.replace(loginPath);
				//}
				alert("session time out!")
				window.location.replace(loginPath);
				return;
			}
		}
	});

});
