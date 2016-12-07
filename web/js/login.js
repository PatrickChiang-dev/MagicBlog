function login() {
    var userName = $("#inputUserName").val();
    var pwd = $("#inputPassword").val();
    var param = {};
    param.userName = userName;
    param.pwd = pwd;
    $.post("login",param,function(resp){
        if(resp.code==10000){
            document.location.href = "index.html";
        }else{
            alert(resp.msg);
        }
    },"json");
}