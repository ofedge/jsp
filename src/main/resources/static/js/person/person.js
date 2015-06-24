$(function(){
	bindPersonBtn();
	person.findAll(person.pageRequest);
});

var bindPersonBtn = function() {
	person.previousBtn();
	person.nextBtn();
	person.searchBtn();
	person.addPersonModalBtn();
	person.updateBtn();
	person.loadCountryList();
}

var person = {
		// 结果转换成html填充到页面
		transformPageData: function(dom, data) {
			var sb = new StringBuffer();
			var content = data.content;
			for (var i = 0; i < content.length; i++) {
				sb.append('<tr><td>').append(i + 1).append('</td>');
				sb.append('<td>').append(content[i].name).append('</td>');
				sb.append('<td>').append(content[i].email).append('</td>');
				sb.append('<td>').append(content[i].age).append('</td>');
				sb.append('<td>').append(content[i].gender).append('</td>');
				sb.append('<td>').append(content[i].country).append('</td>');
				sb.append('<td hover-data = "').append(content[i].id).append('"><button type="button" class="btn btn-default edit_person">update</button></td></tr>')
			}
			$(dom).html(sb.toString());
		},
		// 结果转换html填充到页面
		transformData: function(dom, data) {
			var sb = new StringBuffer();
			for (var i = 0; i < data.length; i++) {
				sb.append('<tr><td>').append(i + 1).append('</td>');
				sb.append('<td>').append(data[i].name).append('</td>');
				sb.append('<td>').append(data[i].email).append('</td>');
				sb.append('<td>').append(data[i].age).append('</td>');
			}
			$(dom).html(sb.toString());
		},
		url: {
			findAllPerson: '/person/findAllPerson',
			save: '/person/save',
			findCountryBean: '/country/findCountryBean',
			findById: '/person/findById/',
			updatePerson: '/person/updatePerson'
		},
		pageRequest: {
			number: 0,
			size: 10,
			property: '',
			order: ''
		},
		person: {
			id: 0,
			name: '',
			email: '',
			age: 0,
			gender: '',
			countryId: 0
		},
		clearPerson: function() {
			person.person.id = 0;
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
					person.option.currentPage = data.number + 1;
					person.option.totalPages = data.totalPages;
				},
				complete: function() {
					$('#pagination').bootstrapPaginator(person.option);
				}
			});
		},
		option: {
			bootstrapMajorVersion: 3,
			currentPage: 1,
			totalPages: 10,
			pageUrl: function(type, page, current){
				return "javascript:void(0);";
			},
			onPageClicked: function(e,originalEvent,type,page){
				person.pageRequest.number = page - 1;
				person.findAll(person.pageRequest);
			}
		},
		// person save 或 update 按钮绑定方法
		addPersonSubmit: function(url) {
			person.person.name = $('#name').val();
			person.person.email = $('#email').val();
			person.person.age = $('#age').val();
			person.person.gender = $('#gender').val();
			person.person.countryId = $('#country_id').val();
			if (person.person.name == '' || person.person.email == '' || person.person.gender == 'unknown' || person.person.countryId == 0) {
				return false;
			}
			$.ajax({
				url: url,
				data: person.person,
				type: 'post',
				dataType: 'json',
				success: function(data) {
					alert(data);
				},
				complete: function() {
					person.findAll(person.pageRequest);
					$('#add_person_modal').modal('hide');
					person.clearPerson();
					person.initFormFunc();
				}
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
		// search 按钮事件
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
				person.pageRequest.number = 0;
				person.findAll(person.pageRequest);
			});
		},
		// 显示添加 person 模态对话框
		addPersonModalBtn: function(){
			$('#add_person').on('click', function(){
				person.initFormFunc();
				person.person.id = 0;
				$('#modal_dialog_title').html('Add Person');
				$('#add_person_modal').modal('show');
				person.addPersonSubmitBtn(person.url.save);
			});
		},
		// 添加 person save 按钮
		addPersonSubmitBtn: function(url){
			$('#save_person').on('click', function(){
				person.addPersonSubmit(url);
			});
		},
		// 加载 country 下拉列表
		loadCountryList: function(){
			$.ajax({
				url: person.url.findCountryBean,
				type: 'get',
				dataType: 'json',
				success: function(data){
					var sb = new StringBuffer();
					sb.append('<option value="0">please choose</option>');
					for (var i = 0; i < data.length; i++) {
						sb.append('<option value="').append(data[i].id).append('">').append(data[i].name).append('</option>');
					}
					$('#country_id').html(sb.toString());
				}
			});
		},
		// update 按钮填充表单并显示 update 模态框
		updateBtn: function(){
			$('#person_info').on('click', '.edit_person', function(){
				person.initFormFunc();
				var personId = $(this).parent().attr('hover-data');
				$.ajax({
					url: person.url.findById + personId,
					type: 'get',
					dataType: 'json',
					success: function(data){
						person.person.id = data.id;
						person.person.name = data.name;
						person.person.email = data.email;
						person.person.age = data.age;
						person.person.gender = data.gender;
						person.person.countryId = data.countryId;
						$('#name').val(data.name);
						$('#email').val(data.email);
						$('#age').val(data.age);
						$('#gender').val(data.gender);
						$('#country_id').val(data.countryId);
					},
					complete: function(){
						$('#modal_dialog_title').html('Update Person');
						$('#add_person_modal').modal('show');
					}
				});
			});
			person.addPersonSubmitBtn(person.url.updatePerson);
		},
		initFormFunc: function(){
			$('#name').val('');
			$('#email').val('');
			$('#age').val('');
			$('#gender').val('unknown');
			$('#country_id').val(0);
		}
}