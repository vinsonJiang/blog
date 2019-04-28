/**
 * 控制导航及返回顶部按钮
 */
$(document).ready(function(){
//	$("#doc-container").fadeOut(1000);
	$("#doc-container").hide();
	$("#doc-container").fadeIn(1000);
//	function getUrlParam(name) {
//        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
//        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
//        if (r != null) return unescape(r[2]); return null; //返回参数值
//	}
//	$(function(){
//		var category = getUrlParam('category');
//		if(category==null){
//			category=0;
//		}
//		$("#category"+category).addClass('current');
//	})

    $("#js-backup-top").click(function () {
        $("body,html").animate({scrollTop: 0}, 500);
    });
    window.onscroll = function () {
        if (document.documentElement.scrollTop + document.body.scrollTop > 100) {
            $("#js-backup-top").addClass("show");
        }
        else {
            $("#js-backup-top").removeClass("show");
        }
    }


    var currentObj;
    $(".m-nav ul li").hover(function(){
        currentObj=$(".m-nav ul .current");
        $(currentObj).removeClass("current");
        $(this).addClass("current");
    },function(){
        $(this).removeClass("current");
        $(currentObj).addClass("current");
    }).click(function(){
        $(".m-nav ul li").removeClass("current");
        $(this).addClass("current");
        currentObj=this;
    });
    
    $(".u-icon-menu").click(function(){
    	if ($("#header").hasClass("nav-opened")){
    		$("#header").removeClass("nav-opened");
    		$(".u-icon-menu").removeClass("close");
    	}else{
    		$("#header").addClass("nav-opened");
    		$(".u-icon-menu").addClass("close");
    	}
    });
    
    $(".search-btn").click(function(){
    	var keywords = $("#searchKeywords").val();
    	if(keywords.length==undefined || keywords==null || keywords.length==0){
    		alert("请输入搜索内容");
    		return false;
    	}else{
    		window.location.href="/blog?keywords=" + keywords;
    	}
    })
    

})
