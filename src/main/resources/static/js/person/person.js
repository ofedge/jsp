$(function(){
	bindPersonBtn();
	person.findAll(person.pageRequest);
});

var bindPersonBtn = function() {
	person.addPersonBtn();
	person.previousBtn();
	person.nextBtn();
	person.searchBtn();
	person.addPersonModalBtn();
	person.addPersonSubmitBtn();
}

var person = {
		transformPageData: function(dom, data) {
			var sb = new StringBuffer();
			var content = data.content;
			for (var i = 0; i < content.length; i++) {
				sb.append('<tr><td>').append(i + 1).append('</td>');
				sb.append('<td>').append(content[i].name).append('</td>');
				sb.append('<td>').append(content[i].email).append('</td>');
				sb.append('<td>').append(content[i].age).append('</td>');
				sb.append('<td>').append(content[i].gender).append('</td>');
				sb.append('<td>').append(content[i].country).append('</td></tr>');
			}
			$(dom).html(sb.toString());
			if(data.first == true) $('#person .previous').attr('disabled', 'disabled');
			else $('#person .previous').removeAttr('disabled');
			if(data.last == true) $('#person .next').attr('disabled', 'disabled');
			else $('#person .next').removeAttr('disabled');
			$('#person .number').html(parseInt(data.number) + 1);
			$('#person .totalPages').html(data.totalPages);
		},
		transformData: function(dom, data) {
			var sb = new StringBuffer();
			for (var i = 0; i < data.length; i++) {
				sb.append('<tr><td>').append(i + 1).append('</td>');
				sb.append('<td>').append(data[i].name).append('</td>');
				sb.append('<td>').append(data[i].email).append('</td>');
				sb.append('<td>').append(data[i].age).append('</td>');
				sb.append('<td>').append(data[i].gender).append('</td></tr>');
			}
			$(dom).html(sb.toString());
		},
		url: {
			findAllPerson: '/person/findAllPerson',
			save: '/person/save',
			findCountryBean: '/country/findCountryBean'
		},
		pageRequest: {
			number: 0,
			size: 10,
			property: '',
			order: ''
		},
		person: {
			name: '',
			email: '',
			age: 0,
			gender: '',
			countryId: 0
		},
		clearPerson: function() {
			person.person.name = '';
			person.person.email = '';
			person.person.age = 0;
			person.person.gender = '';
			person.person.countryId = 0;
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
				url: person.url.findAllPerson,
				type: 'get',
				data: pageRequest,
				dataType: 'json',
				success: function(data) {
					person.transformPageData('#person #person_info tbody', data);
				}
			});
		},
		addPersonBtn: function() {
			$('#add_person_form').submit(function(){
				person.person.name = $('#name').val();
				person.person.email = $('#email').val();
				person.person.age = $('#age').val();
				person.person.gender = $('#gender').val();
				if (person.person.name == '' || person.person.email == '') {
					return false;
				}
				person.person.countryId = $('#country_id').val();
				$.ajax({
					url: person.url.save,
					data: person.person,
					type: 'post',
					dataType: 'json',
					success: function(data) {
						
					},
					complete: function() {
						person.findAll(person.pageRequest);
						person.clearPerson();
						$('#name').val('');
						$('#email').val('');
						$('#age').val('');
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
		searchBtn: function() {
			$('#search_person').on('click', function(){
				var paramArray = new Array();
				if($('#name_key').val() != ''){
					paramArray.push(TablePrefix.person + 'name');
					paramArray.push(Condition.like);
					paramArray.push('%' + $('#name_key').val() + '%');
				}
				if($('#email_key').val() != ''){
					paramArray.push(TablePrefix.person + 'email');
					paramArray.push(Condition.like);
					paramArray.push('%' + $('#email_key').val() + '%');
				}
				if($('#age_min').val() != ''){
					paramArray.push(TablePrefix.person + 'age');
					paramArray.push(Condition.moreOrEqual);
					paramArray.push($('#age_min').val());
				}
				if($('#age_max').val() != ''){
					paramArray.push(TablePrefix.person + 'age');
					paramArray.push(Condition.lessOrEqual);
					paramArray.push($('#age_max').val());
				}
				if($('#gender_key').val() != 'all'){
					paramArray.push(TablePrefix.person + 'gender');
					paramArray.push(Condition.equal);
					paramArray.push($('#gender_key').val());
				}
				if($('#country_key').val() != ''){
					paramArray.push(TablePrefix.country + 'name');
					paramArray.push(Condition.like);
					paramArray.push('%' + $('#country_key').val() + '%');
				}
				person.pageRequest.property = paramArray.join(',');
				person.findAll(person.pageRequest);
			});
		},
		addPersonModalBtn: function(){
			$('#add_person').on('click', function(){
				$('#name').val('');
				$('#email').val('');
				$('#age').val('');
				person.loadCountryList();
				$('#add_person_modal').modal('show');
			});
		},
		addPersonSubmitBtn: function(){
			$('#save_person').on('click', function(){
				$('#add_person_form').trigger('submit');
			});
		},
		loadCountryList: function(){
			$.ajax({
				url: person.url.findCountryBean,
				type: 'get',
				dataType: 'json',
				success: function(data){
					var sb = new StringBuffer();
					for (var i = 0; i < data.length; i++) {
						sb.append('<option value="').append(data[i].id).append('">').append(data[i].name).append('</option>');
					}
					$('#country_id').html(sb.toString());
				}
			});
		}
}