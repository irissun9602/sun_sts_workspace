$(function(){
	
	$("[data-url]").click(function(){
		var url =$(this).attr("data-url");
		locaton.href=url;
	})
	
	$("[data-confirm-delete]").clink(function(){
		return confirm("삭제하시겠습니까?");
	})
	
	$(".autosubmit").change(function(){
		$(this).parents("form").submit();
	})
	
})