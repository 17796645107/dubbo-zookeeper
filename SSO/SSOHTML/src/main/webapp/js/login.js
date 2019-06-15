$(function() {
	$('.checkbox').click(function(event) {
		if ($(this).hasClass('checked')) {
			$(this).removeClass('checked');
		}else{
			$(this).addClass('checked');
		}
	});
	$('input').focusin(function(event) {
		$(this).css('borderColor', '#0079CC');
	});
	$('input').focusout(function(event) {
		$(this).css('borderColor', '#cacaca');
	});

	$("#loginbtn").click(function() {
		$.ajax({
			url : "http://localhost:8080/SSOWEB/user/getUser",
			type : "POST",
			data : {
				"username" : $("#userName").val(),
				"password" : $("#password").val()
			},
			dataType:"json",
			success : function(datas){
				alert(datas.code);
				if(datas.code==200){
					//跳转
					location.href="http://localhost:8080/GoodsWEB/goods/listGoods";
				}else{
					alert(datas.respMessage+":"+datas.msg);
				}
			}
		});
	});
});