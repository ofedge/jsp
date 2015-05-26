$(function(){
	console.log('general.js 加载成功!');
	switchPage();
	bindPersonBtn();
	bindCountryBtn();
});

var switchPage = function() {
	$('#show_person').on('click', function(){
		if($('#person').is(':hidden')){
			person.findAll(person.pageRequest);
			$('#person').show();
		}
		$('#country').hide();
	});
	$('#show_country').on('click', function(){
		if($('#country').is(':hidden')){
			country.findAll(country.pageRequest);
			$('#country').show();
		}
		$('#person').hide();
	});
}

var bindPersonBtn = function() {
	person.addPersonBtn();
	person.previousBtn();
	person.nextBtn();
	person.nameSearchBtn();
	person.emailSearchBtn();
}

var bindCountryBtn = function() {
	country.previousBtn();
	country.nextBtn();
	country.countrySearchBtn();
}