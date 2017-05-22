function msgInfo(text){
	Ext.MessageBox.show({
		title:"提示",
		msg:text,
		animEl:"id1",
		animate:true,
		icon:Ext.MessageBox.INFO,
		closable:false
	});
	setTimeout(function () {
        Ext.Msg.hide();
    },500);
}
function ajaxRequest(){
    Ext.Ajax.on('requestcomplete',checkSessionStatus, this);    
    function checkSessionStatus(conn,response,options){
		if(typeof(response.getResponseHeader)=="function"&&response.getResponseHeader('sessionstatus')&&response.getResponseHeader('sessionstatus')=="timeout"){
            Ext.Msg.alert('提示', '登入超时,系统将自动跳转到登陆页面,请重新登入!');
            window.top.location.href = "login.jsp";                              
    	}
    }   
}