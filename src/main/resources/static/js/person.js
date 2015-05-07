var transformData = function(dom, data) {
	var info = '';
	for (var i = 0; i < data.length; i++) {
		info += '<p>' + (i + 1) + '. name: ' + data[i].name + ', email: ' + data[i].email + '</p>';
	}
	$(dom).html(info);
}

var find_all = function() {
	$.ajax({
		url: '/findAll',
		type: 'post',
		dataType: 'json',
		success: function(data) {
			transformData('#info', data);
		}
	});
}

$(function(){
	find_all();
	$('#add_person').submit(function(){
		var name = $('#name').val();
		var email = $('#email').val();
		if (name.trim() =='' || email.trim() == '') {
			$('#form_area').html("can't be null");
			return false;
		}
		$.ajax({
			url: '/save',
			data: {'name': name, 'email': email},
			type: 'post',
			dataType: 'json',
			success: function(data) {
				$('#form_area').html('succees[name: ' + data.name + ', email: ' + data.email + ']');
			},
			complete: function() {
				find_all();
				$('#name').val('');
				$('#email').val('');
			}
		});
		return false; // 不要跳
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