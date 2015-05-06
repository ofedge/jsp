$(function(){
	$.ajax({
		url: '/findById',
		data: {"id": 1},
		type: 'post',
		success: function(data) {
			$('#info').html('name: ' + data.name + ', email: ' + data.email);
		}
	});
	$('#name_search').on('click', function(){
		var name = $('#name').val();
		$.ajax({
			url: 'findByName',
			data: {'name': name},
			type: 'post',
			success: function(data) {
				var info = ' ';
				for (var i = 0; i < data.length; i++) {
					info += '<p>' + (i + 1) + '. name: ' + data[i].name + ', email: ' + data[i].email + '</p>';
				}
				$('#name_area').html(info);
			}
		});
	});
	$('#email_search').on('click', function(){
		var email = $('#email').val();
		$.ajax({
			url: 'findByEmail',
			data: {'email': email},
			type: 'post',
			success: function(data) {
				var info = ' ';
				for (var i = 0; i < data.length; i++) {
					info += '<p>' + (i + 1) + '. name: ' + data[i].name + ', email: ' + data[i].email + '</p>';
				}
				$('#email_area').html(info);
			}
		});
	});
});