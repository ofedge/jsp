$(function(){
	country.findAll(country.pageRequest);
	bindCountryBtn();
});

var bindCountryBtn = function() {
	country.previousBtn();
	country.nextBtn();
	country.countrySearchBtn();
}

var country = {
		transformPageData: function(dom, data) {
			var sb = new StringBuffer();
			var content = data.content;
			for (var i = 0; i < content.length; i++) {
				sb.append('<tr><td>').append(i + 1).append('</td>');
				sb.append('<td>').append(content[i].name).append('</td>');
				sb.append('<td>').append(content[i].region).append('</td>');
				sb.append('<td>').append(content[i].code).append('</td></tr>');
			}
			$(dom).html(sb.toString());
			if(data.first == true) $('#country .previous').attr('disabled', 'disabled');
			else $('#country .previous').removeAttr('disabled');
			if(data.last == true) $('#country .next').attr('disabled', 'disabled');
			else $('#country .next').removeAttr('disabled');
			$('#country .number').html(parseInt(data.number) + 1);
			$('#country .totalPages').html(data.totalPages);
		},
		transformData: function(dom, data) {
			var sb = new StringBuffer();
			for (var i = 0; i < data.length; i++) {
				sb.append('<tr><td>').append(i + 1).append('</td>');
				sb.append('<td>').append(data[i].name).append('</td>');
				sb.append('<td>').append(data[i].region).append('</td>');
				sb.append('<td>').append(data[i].code).append('</td></tr>');
			}
			$(dom).html(info);
		},
		url: {
			findAll: '/country/findAll',
			findByCountryname: '/country/findByCountryname/'
		},
		pageRequest: {
			number: 0,
			size: 10
		},
		findAll: function(pageRequest) {
			$.ajax({
				url: country.url.findAll,
				type: 'get',
				data: pageRequest,
				dataType: 'json',
				success: function(data) {
					country.transformPageData('#country #country_info tbody', data);
				}
			});
		},
		previousBtn: function() {
			$('#country .previous').on('click', function(){
				country.pageRequest.number = parseInt($('#country .number').html()) - 2;
				country.findAll(country.pageRequest);
			});
		},
		nextBtn: function() {
			$('#country .next').on('click', function(){
				country.pageRequest.number = parseInt($('#country .number').html());
				country.findAll(country.pageRequest);
			});
		},
		countrySearchBtn: function() {
			$('#country #country_search').on('click', function(){
				var countryName = $('#country #country_key').val();
				$.ajax({
					url: country.url.findByCountryname + countryName,
					type: 'get',
					dataType: 'json',
					success: function(data) {
						person.transformData('#country #country_area tbody', data);
					}
				});
			});
		}
}