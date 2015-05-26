$(function(){
	person.findAll(person.pageRequest);
});
var person = {
		transformPageData: function(dom, data) {
			var info = '';
			var content = data.content;
			for (var i = 0; i < content.length; i++) {
				info += '<p>' + (i + 1) + '. name: ' + content[i].name + ', email: ' + content[i].email + ', age: ' + content[i].age + ', gender: ' + content[i].gender + '</p>';
			}
			$(dom).html(info);
			if(data.first == true) $('#person .previous').attr('disabled', 'disabled');
			else $('#person .previous').removeAttr('disabled');
			if(data.last == true) $('#person .next').attr('disabled', 'disabled');
			else $('#person .next').removeAttr('disabled');
			$('#person .number').html(parseInt(data.number) + 1);
			$('#person .totalPages').html(data.totalPages);
		},
		transformData: function(dom, data) {
			var info = '';
			for (var i = 0; i < data.length; i++) {
				info += '<p>' + (i + 1) + '. name: ' + data[i].name + ', email: ' + data[i].email + ', age: ' + data[i].age + ', gender: ' + data[i].gender + '</p>';
			}
			$(dom).html(info);
		},
		url: {
			findAll: '/person/findAll',
			save: '/person/save',
			findByName: '/person/findByName',
			findByEmail: '/person/findByEmail'
		},
		pageRequest: {
			number: 0,
			size: 10
		},
		person: {
			name: '',
			email: '',
			age: 0,
			gender: ''
		},
		clearPerson: function() {
			person.person.name = '';
			person.person.email = '';
			person.person.age = 0;
			person.person.gender = '';
		},
		queryParam: {
			name: '',
			email: ''
		},
		clearQueryParam: function() {
			person.queryParam.name = '';
			person.queryParam.email = '';
		},
		findAll: function(pageRequest) {
			$.ajax({
				url: person.url.findAll,
				type: 'get',
				data: pageRequest,
				dataType: 'json',
				success: function(data) {
					person.transformPageData('#person #person_info', data);
				}
			});
		},
		addPersonBtn: function() {
			$('#person #add_person').submit(function(){
				person.person.name = $('#person #name').val();
				person.person.email = $('#person #email').val();
				person.person.age = $('#person #age').val();
				person.person.gender = $('#person #gender').val();
				if (person.person.name.trim() =='' || person.person.email.trim() == '') {
					$('#person #form_area').html("can't be null");
					return false;
				}
				$.ajax({
					url: person.url.save,
					data: person.person,
					type: 'post',
					dataType: 'json',
					success: function(data) {
						$('#person #form_area').html('succees[name: ' + data.name + ', email: ' + data.email + ', age: ' + data.age + ', gender: ' + data.gender + ']');
					},
					complete: function() {
						person.findAll(person.pageRequest);
						person.clearPerson();
						$('#person #name').val('');
						$('#person #email').val('');
						$('#person #age').val(20);
					}
				});
				return false; // 不要跳
			});
		},
		previousBtn: function() {
			$('#person .previous').on('click', function(){
				person.pageRequest.number = parseInt($('#person .number').html()) - 2;
				person.findAll(person.pageRequest);
			});
		},
		nextBtn: function() {
			$('#person .next').on('click', function(){
				person.pageRequest.number = parseInt($('#person .number').html());
				person.findAll(person.pageRequest);
			});
		},
		nameSearchBtn: function() {
			$('#person #name_search').on('click', function(){
				person.queryParam.name = $('#person #name_key').val();
				$.ajax({
					url: person.url.findByName,
					data: person.queryParam,
					type: 'get',
					dataType: 'json',
					success: function(data) {
						person.transformData('#person #name_area', data);
					},
					complete: function() {
						person.clearQueryParam();
					}
				});
			});
		},
		emailSearchBtn: function() {
			$('#person #email_search').on('click', function(){
				person.queryParam.email = $('#person #email_key').val();
				$.ajax({
					url: person.url.findByEmail,
					data: person.queryParam,
					type: 'get',
					dataType: 'json',
					success: function(data) {
						person.transformData('#person #email_area', data);
					},
					complete: function() {
						person.clearQueryParam();
					}
				});
			});
		}
}