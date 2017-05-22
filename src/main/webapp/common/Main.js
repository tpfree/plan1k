/**
 * 
 */
var myMask_info = "加载数据中,请稍后...";
var myMask;

var footHtml="<div style=\"height:30;text-align:right;margin-top:5;\">"
	+"<span class='line'></span>&nbsp;&nbsp;Copyright©2016&nbsp;&nbsp; "
	+"&nbsp;&nbsp;&nbsp;&nbsp;<span class='line'></span>&nbsp;&nbsp;技术支持：</div>";
var left=(document.body.clientWidth-550)/2;
var topHtml="<div id='xttitle' style='float:left;'><span style='line-height:30px;font-size:25px;color: #FCC711;font-weight: bold;'>"+areaName+"全民健身指导站</span></div>"
+"<div style='float: right;width:250px;height:50px;margin-right:10px;'>"
+"<img style=\"height:40px;float:left;margin-right:5px;cursor:pointer;\" src='images/setting.png' alt='设置' style=\"cursor:pointer;\" onclick=\"setting();\">"
+"<table><tr><td style='color:#FCC711'>"+name+"&nbsp;&nbsp;&nbsp;</td><td><img style=\"height:20px\" src='images/power.png' alt='注销' style=\"cursor:pointer;\" onclick=\"cancel();\"><td></td></tr>"
+"<tr><td colspan=\"2\"><div id='sj' style='color:red; font-size: 13px;'></div></td></tr></table>";
+"</div>";

window.onresize=function(){
//	var left=(document.body.clientWidth-550)/2;
//	document.getElementById('xttitle').style.left=left+"px";
}
Ext.Loader.setConfig({enabled: true});

Ext.Loader.setPath('Ext.ux', 'jslib/ext/ux/');

Ext.require([
    'Ext.tab.*',
    'Ext.ux.TabCloseMenu'
]);
Ext.onReady(function() {
	 
	ajaxRequest();
    
    var rightContentMenu = new Ext.menu.Menu({
        id:'rightContentMenu',
        shadow :false,//解决IE10出现阴影问题
        listeners:{
        },
        items:[
            {
                text:'关闭当前页面',
                iconCls:'close',
                id:'closecurent',
                handler:function () {
                    var pp = tbPanel.getActiveTab();
                    if (pp.closable)
                    {
                        var iframe = pp.getEl().child('iframe');
                        iframe = null;
                        tbPanel.remove(pp,true);
                    }
                }
            },
            '-',
            {
                text:'关闭所有页面',
                handler:function () {
                	tbPanel.removeAll();
                }
            },
            {
                text:'关闭其他页面',
                handler:function () {
                	var items = [];
                	tbPanel.items.each(function (item) {
                        if (item.closable) {
                            if (!excludeActive || item != mainWorkSpace.getActiveTab()) {
                                items.push(item);
                            }
                        }
                    }, this);
                    Ext.each(items, function (item) {
                    	tbPanel.remove(item);
                    }, this);
                }
            },
            '-',
            {
                text:'刷新本页面',
                iconCls:'refresh',
                handler:function () {
                    var p = tbPanel.getActiveTab();
                    var iframe = p.getEl().child('iframe');
                    iframe.dom.contentWindow.location.reload();
                }
            }
        ]
    });
    
    var topPanel = new Ext.Panel({ 
		region : 'north',
		height : 60,
		collapsible : false,
		margins: '3 3 3 3',
		frame:true,
		bodyStyle: {
            background: '#157fcc'// url(images/home/dddd.jpg) no-repeat 50% 50% / 100%'
        }, 
		scrollable:true,
   		html:topHtml
	});

	var footPanel = new Ext.Panel({
		region : 'south',
		height : 25,
		margins: '3 0 0 0',
		bodyStyle: 'background:#157fcc;',
		collapsible : false,
		html:footHtml
	});
	var currentItem;
	var tbPanel = new Ext.TabPanel({
		region : 'center',
		enableTabScroll : true,
		margins: '0 3 0 0', 
		activeTab : 0,
		frame:true,
		listeners:{
            'remove':function (t, p) {
                p.hide();
            },
            'tabchange':function (t, p) {
            },
            'itemcontextmenu':function(view,record,item,index,e,eOpts){
                e.preventDefault();  
                e.stopEvent();  
                tbPanel.setActiveTab(item);
                rightContentMenu.showAt(e.getXY());
            }
        },
        plugins:Ext.create('Ext.ux.TabCloseMenu', {
            closeTabText : '关闭当前页',  
            closeOthersTabsText : '关闭其他页',  
            closeAllTabsText : '关闭所有页',
            extraItemsTail: [
                             '-',
                             {
                                 text: '可关闭',
                                 checked: true,
                                 hideOnClick: true,
                                 handler: function (item) {
                                     currentItem.tab.setClosable(item.checked);
                                 }
                             },
                             '-',
                             {
                                 text: '刷新本页面',
                                 //checked: true,
                                 hideOnClick: true,
                                 handler: function(item) {
                                	 var p = tbPanel.getActiveTab();
                                	 if(p){
                                		 var iframe = p.getEl().child('frame_main');
                                		 iframe.dom.contentWindow.location.reload();
                                	 }
                                 }
                             }
                         ],
                         listeners: {
                             beforemenu: function (menu, item) {
                            	 tbPanel.setActiveTab(item);
//                                 var enabled = menu.child('[text="Enabled"]'); 
                                 menu.child('[text="可关闭"]').setChecked(item.closable);
//                                 if (item.tab.active) {
//                                     enabled.disable();
//                                 } else {
//                                     enabled.enable();
//                                     enabled.setChecked(!item.tab.isDisabled());
//                                 }

                                 currentItem = item;
                             }
                         }
                     }),
//        plugins:
//        	Ext.create('Ext.ux.TabCloseMenu', {  
//                closeTabText : '关闭当前页',  
//                closeOthersTabsText : '关闭其他页',  
//                closeAllTabsText : '关闭所有页'  
//            }),  
//        	Ext.create('Ext.ux.TabCloseMenu', {
//        	enableRerfesh: true,
//        	showCloseAll: false,
//        	showCloseOthers: false,
//        	extraItemsTail: [
//        	'-',
//        	{
//	        	text: '刷新',
//	        	hideOnClick: true,
//	        	handler: function (item) {
//	        		var tabName = currentItem.el.id;//获取选项卡的id
//	        		tabs.setLoading("加载中,如果加载的内容空白可以右击标题刷新...");//设置遮罩
//	        		var i = window.frames[tabName].location.reload();//frames[tabName]这是iframe的name,设置成与tab id同名
//	        		setTimeout(function () {//这张持续时间5秒
//	        			tabs.setLoading(false);
//	        		}, 5000);
//	        	}
//        	}]
//        }),
		items : []
	});
	
	var treeStore = Ext.create('Ext.data.TreeStore', {
        proxy : {
            type : 'ajax',
            url : 'navTreeController.do?getTreeList',
            reader : {
                type : 'json'
            }
        },
        nodeList:function(store,records){
        	for(var i=0;i<records.length;i++){
        		var record=records[i];
        		
        		if(record.raw.isHomeNode==1){
            		tbPanel.add({
    					id : record.raw.id,
    					title : record.raw.text,
    					autoScroll : true,
    					closable : false,
    					icon:record.data.icon,
    					html : '<iframe id="frame_main" src="'
    							+ record.raw.url
    							+ '" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>'
    				});
            	}
        		if(record.childNodes.length==0){
        			break;
        		}
        		store.nodeList(store,record.childNodes);
        	}
        	
        },
        listeners:{
        	load:function (store, records) {
        		if(records){
        			store.nodeList(store,records.childNodes);
        		}
			}
        },
        root : {
            expanded : true
        },
        folderSort : true
    });

	var tree=Ext.create('Ext.tree.Panel', {
	    title: '导航栏',
	    width: 200,
	    height: 150,
	    margins: '0 3 0 3',     
	    store: treeStore,
	    bodyStyle: 'border:0;cursor: pointer;font-size:15px',
	    region:'west',
	    frame:true,
	    rootVisible: false,
	    collapsible: true,
	    listeners:{
            itemclick: function(navTree,record, item, index, e, eOpts ){
            	if (record.raw.url) {
        			var n = tbPanel.getComponent(record.raw.id);
        			if (!n) {
        				n = tbPanel.add({
        					id : record.raw.id,
        					title : record.raw.text,
        					autoScroll : true,
        					closable : true,
        					icon:record.data.icon,
        					html : '<iframe id="frame_main" src="'
        							+ record.raw.url
        							+ '" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>'
        				});
        			}
        			
        		}
        		tbPanel.setActiveTab(n);
            },
			activate:function(tab){   
				window.frames["iframe"+tab.id].location.reload();    
			}
        },
        bbar : []
	});
	
	tree.expandAll();
	var viewport = new Ext.Viewport({
		enableTabScroll : true,
		layout : "border",
		autoScroll : true,
		items : [topPanel,tree, tbPanel,footPanel ]
	});
	tick();
});

function setting(){
	var win=new bodyBuilding.UserSettingWindow();
	win.show();
}

function cancel(){
	Ext.MessageBox.confirm("提示", "确认退出", function(e) {
	if(e=="yes"){
			Ext.Ajax.request({
			    url: "userController.do?logout",
			    success: function(response){
					var json=Ext.decode(response.responseText);
			        if(json.success){
				    	location.href="login.jsp";
			        }
			    }
			});
		}
	});
}
function showLocale(objD) {
	var str;
	var yy = objD.getYear();
	if (yy < 1900)
		yy = yy + 1900;
	var MM = objD.getMonth() + 1;
	if (MM < 10)
		MM = '0' + MM;
	var dd = objD.getDate();
	if (dd < 10)
		dd = '0' + dd;
	var hh = objD.getHours();
	if (hh < 10)
		hh = '0' + hh;
	var mm = objD.getMinutes();
	if (mm < 10)
		mm = '0' + mm;
	var ss = objD.getSeconds();
	if (ss < 10)
		ss = '0' + ss;
	var ww = objD.getDay();
	if (ww == 0)
		ww = "星期日";
	if (ww == 1)
		ww = "星期一";
	if (ww == 2)
		ww = "星期二";
	if (ww == 3)
		ww = "星期三";
	if (ww == 4)
		ww = "星期四";
	if (ww == 5)
		ww = "星期五";
	if (ww == 6)
		ww = "星期六";
	str = yy + "年" + MM + "月" + dd + "日" + "  " + ww + "  " + hh + ":"
			+ mm + ":" + ss;
	return (str);
}
function tick() {
	var today;
	today = new Date();
	document.getElementById("sj").innerHTML = showLocale(today);
	window.setTimeout("tick();", 1000);
}





