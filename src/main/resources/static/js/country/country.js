$(function(){
	country.findAll(country.pageRequest);
	bindCountryBtn();
});

var bindCountryBtn = function() {
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
					country.option.currentPage = data.number + 1;
					country.option.totalPages = data.totalPages;
				},
				complete: function() {
					$('#pagination').bootstrapPaginator(country.option);
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
				country.pageRequest.number = page - 1;
				country.findAll(country.pageRequest);
			}
		}
}