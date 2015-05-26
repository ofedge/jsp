var transformPageData = function(dom, data) {
	var info = '';
	var content = data.content;
	for (var i = 0; i < content.length; i++) {
		info += '<p>' + (i + 1) + '. name: ' + content[i].name + ', email: ' + content[i].email + ', age: ' + content[i].age + ', gender: ' + content[i].gender + '</p>';
	}
	$(dom).html(info);
	if(data.first == true) $('#previous').attr('disabled', 'disabled');
	else $('#previous').removeAttr('disabled');
	if(data.last == true) $('#next').attr('disabled', 'disabled');
	else $('#next').removeAttr('disabled');
	$('#number').html(parseInt(data.number) + 1);
	$('#totalPages').html(data.totalPages);
}

var transformData = function(dom, data) {
	var info = '';
	for (var i = 0; i < data.length; i++) {
		info += '<p>' + (i + 1) + '. name: ' + data[i].name + ', email: ' + data[i].email + ', age: ' + data[i].age + ', gender: ' + data[i].gender + '</p>';
	}
	$(dom).html(info);
}

var pageRequest = {
		number: 0,
		size: 10
}

var findAll = function(pageRequest) {
	$.ajax({
		url: '/findAll',
		type: 'post',
		data: pageRequest,
		dataType: 'json',
		success: function(data) {
			transformPageData('#info', data);
		}
	});
}

$(function(){
	findAll(pageRequest);
	$('#add_person').submit(function(){
		var name = $('#name').val();
		var email = $('#email').val();
		var age = $('#age').val();
		var gender = $('#gender').val();
		if (name.trim() =='' || email.trim() == '') {
			$('#form_area').html("can't be null");
			return false;
		}
		$.ajax({
			url: '/save',
			data: {'name': name, 'email': email, 'age': age, 'gender': gender},
			type: 'post',
			dataType: 'json',
			success: function(data) {
				$('#form_area').html('succees[name: ' + data.name + ', email: ' + data.email + ', age: ' + data.age + ', gender: ' + data.gender + ']');
			},
			complete: function() {
				findAll(pageRequest);
				$('#name').val('');
				$('#email').val('');
				$('#age').val(20);
			}
		});
		return false; // 不要跳
	});
	$('#previous').on('click', function(){
		pageRequest.number = parseInt($('#number').html()) - 2;
		findAll(pageRequest)
	});
	$('#next').on('click', function(){
		pageRequest.number = parseInt($('#number').html());
		findAll(pageRequest);
	});
	$('#name_search').on('click', function(){
		var name = $('#name_key').val();
		$.ajax({
			url: 'findByName',
			data: {'name': name},
			type: 'post',
			dataType: 'json',
			success: function(data) {
				transformData('#name_area', data);
			}
		});
	});
	$('#email_search').on('click', function(){
		var email = $('#email_key').val();
		$.ajax({
			url: 'findByEmail',
			data: {'email': email},
			type: 'post',
			dataType: 'json',
			success: function(data) {
				transformData('#email_area', data);
			}
		});
	});
});