$(function(){
	$('#spring-boot-demo-navbar-collpase ul li').on('mouseover', function(){
		$(this).addClass("active");
	}).on('mouseout', function(){
		$(this).removeClass("active");
	});
});

// 排序参数
var Direction = {
		asc: 'ASC',
		desc: 'DESC'
}

// 条件参数
var Condition = {
		equal: '=',
		like: 'like',
		moreThan: '>',
		moreOrEqual: '>=',
		lessThan: '<',
		lessOrEqual: '<='
}

var TablePrefix = {
		person: 'p.',
		country: 'c.',
}

var StringBuffer = function(str) {
	if (str != undefined)
		this.value = new Array(str);
	else
		this.value = new Array();

	if (StringBuffer.prototype.append == undefined) {
		StringBuffer.prototype.append = function(str) {
			this.value.push(str);
			return this;
		}
	}

	StringBuffer.prototype.toString = function() {
		return this.value.join("");
	}

	if (StringBuffer.prototype.clear == undefined) {
		StringBuffer.prototype.clear = function() {
			this.value = [];
		}
	}
}