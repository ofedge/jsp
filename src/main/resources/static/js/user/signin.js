$(function(){
	$('#spring-boot-demo-navbar-collpase ul li').on('mouseover', function(){
		$(this).addClass("active");
	}).on('mouseout', function(){
		$(this).removeClass("active");
	});
});