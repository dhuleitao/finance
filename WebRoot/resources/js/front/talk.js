/**
 * 页面加载
 */
$(function(){
	render();
	var content = "参见陛下，微臣是DHU智能机器人";
	content += "<br/>@欢迎光临东华大学财务报销系统@";
	content += "<br/>我将竭诚为您服务！";
	// 添加公众号的开场白
	appendDialog("talk_recordbox","DHU",content);
	var div = "";
	div += "<br/>";
	$('#jp-container').children().eq(0).children().eq(0).append(div);
	render();
});

/**
 * 发送消息
 * @param basePath
 */
function send() {
	var content = $("#contents").val();
	if(!content) {
		alert("请陛下输入内容！");
		return;
	}
	$.ajax({
		url : $("#basePath").val() + "users/Users_auto.action",
		type : "POST",
		dataType : "text",
		timeout : 10000,
		success : function (data) {
			appendDialog("talk_recordboxme","小白",content);
			appendDialog("talk_recordbox","DHU",data);
			$("#contents").val("");
			render();
		},
		data : {"content":content}
	});
	//$('#content').scrollTop( $('#content')[0].scrollHeight );
	//$("#jp-container").animate({ scrollTop: $('#jp-container')[0].scrollHeight}, 1000);

}

/**
 * 渲染方法，加载滚动条
 */
function render() {
	// the element we want to apply the jScrollPane
	var $el= $('#jp-container').jScrollPane({
		verticalGutter 	: -16
	}),
	// the extension functions and options 	
	extensionPlugin 	= {
		extPluginOpts	: {
			// speed for the fadeOut animation
			mouseLeaveFadeSpeed	: 500,
			// scrollbar fades out after hovertimeout_t milliseconds
			hovertimeout_t		: 1000,
			// if set to false, the scrollbar will be shown on mouseenter and hidden on mouseleave
			// if set to true, the same will happen, but the scrollbar will be also hidden on mouseenter after "hovertimeout_t" ms
			// also, it will be shown when we start to scroll and hidden when stopping
			useTimeout			: true,
			// the extension only applies for devices with width > deviceWidth
			deviceWidth			: 980
		},
		hovertimeout	: null, // timeout to hide the scrollbar
		isScrollbarHover: false,// true if the mouse is over the scrollbar
		elementtimeout	: null,	// avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar
		isScrolling		: false,// true if scrolling
		addHoverFunc	: function() {
			// run only if the window has a width bigger than deviceWidth
			if( $(window).width() <= this.extPluginOpts.deviceWidth ) return false;
			var instance		= this;
			// functions to show / hide the scrollbar
			$.fn.mouseenter 	= $.fn.show;
			$.fn.jspmouseleave 	= $.fn.fadeOut;
			// hide the jScrollPane vertical bar
			var $vBar			= this.getContentPane().siblings('.jspVerticalBar').hide();
			/*
			 * mouseenter / mouseleave events on the main element
			 * also scrollstart / scrollstop - @James Padolsey : http://james.padolsey.com/javascript/special-scroll-events-for-jquery/
			 */
			$el.bind('mouseenter.jsp',function() {
				
				// show the scrollbar
				$vBar.stop( true, true ).jspmouseenter();
				
				if( !instance.extPluginOpts.useTimeout ) return false;
				
				// hide the scrollbar after hovertimeout_t ms
				clearTimeout( instance.hovertimeout );
				instance.hovertimeout 	= setTimeout(function() {
					// if scrolling at the moment don't hide it
					if( !instance.isScrolling )
						$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
				}, instance.extPluginOpts.hovertimeout_t );
			}).bind('mouseleave.jsp',function() {
				// hide the scrollbar
				if( !instance.extPluginOpts.useTimeout )
					$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
				else {
				clearTimeout( instance.elementtimeout );
				if( !instance.isScrolling )
						$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
				}
			});
			if( this.extPluginOpts.useTimeout ) {
				$el.bind('scrollstart.jsp', function() {
					// when scrolling show the scrollbar
					clearTimeout( instance.hovertimeout );
					instance.isScrolling	= true;
					$vBar.stop( true, true ).jspmouseenter();
				}).bind('scrollstop.jsp', function() {
					// when stop scrolling hide the scrollbar (if not hovering it at the moment)
					clearTimeout( instance.hovertimeout );
					instance.isScrolling	= false;
					instance.hovertimeout 	= setTimeout(function() {
						if( !instance.isScrollbarHover )
								$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
						}, instance.extPluginOpts.hovertimeout_t );
				});
				// wrap the scrollbar
				// we need this to be able to add the mouseenter / mouseleave events to the scrollbar
				var $vBarWrapper	= $('<div/>').css({
					position	: 'absolute',
					left		: $vBar.css('left'),
					top			: $vBar.css('top'),
					right		: $vBar.css('right'),
					bottom		: $vBar.css('bottom'),
					width		: $vBar.width(),
					height		: $vBar.height()
				}).bind('mouseenter.jsp',function() {
					clearTimeout( instance.hovertimeout );
					clearTimeout( instance.elementtimeout );
					instance.isScrollbarHover	= true;
					// show the scrollbar after 100 ms.
					// avoids showing the scrollbar when moving from inside the element to outside, passing over the scrollbar								
					instance.elementtimeout	= setTimeout(function() {
						$vBar.stop( true, true ).jspmouseenter();
					}, 100 );	
				}).bind('mouseleave.jsp',function() {
					// hide the scrollbar after hovertimeout_t
					clearTimeout( instance.hovertimeout );
					instance.isScrollbarHover	= false;
					instance.hovertimeout = setTimeout(function() {
					// if scrolling at the moment don't hide it
					if( !instance.isScrolling )
							$vBar.stop( true, true ).jspmouseleave( instance.extPluginOpts.mouseLeaveFadeSpeed || 0 );
					}, instance.extPluginOpts.hovertimeout_t );
				});
				$vBar.wrap( $vBarWrapper );
			}
		}
	},
	// the jScrollPane instance
	jspapi = $el.data('jsp');
	// extend the jScollPane by merging	
	$.extend( true, jspapi, extensionPlugin );

	jspapi.addHoverFunc();
	//$("#jp-container").animate({ scrollTop: $('#jp-container')[0].scrollHeight}, 1000);
	//$('#jp-container').scrollTop($('#djp-container')[0].scrollHeight);

}

/**
 * 向聊天记录中添加聊天内容
 * @param myClass 添内容的样式
 * @param name 发送消息的账号名称
 * @param content 发送的内容
 */
function appendDialog(myClass,name,content) {
	var div = "";
	div += "<div class='" + myClass + "'>";
	div += "<div class='user'><img src='" + $("#basePath").val() + "resources/images/thumbs/" + myClass + ".jpg'/>" + name + "</div>";
	div += "<div class='talk_recordtextbg'>&nbsp;</div>";
	div += "<div class='talk_recordtext'>";
	div += "<h3>" + content + "</h3>";
	div += "<span class='talk_time'>" + getCurrentDate() + "</span>";
	div += "</div>";
	div += "</div>";
	div += "<br/>";
	$('#jp-container').children().eq(0).children().eq(0).append(div);
	$('#jp-container').scrollTop( $('#jp-container')[0].scrollHeight ); 
}

/**
 * 获取当前系统时间
 * @returns {String} 当前系统时间
 */
function getCurrentDate() {
	var date = new Date();
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + (date.getHours() < 10 ? "0" + date.getHours() : date.getHours()) + ":" + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes());
}