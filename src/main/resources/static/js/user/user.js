$(function(){
	$("#avatar").fileinput({
		maxFileSize: 200,
		previewFileType: "image",
		browseLabel: " Browser",
		browseClass: 'btn btn-primary',
		browseIcon: '<span class="glyphicon glyphicon-picture"></span>'
	});
});