$(function(){
	signup.init();
	signup.btn();
	$('#username').focus();
});
var signup = {
		init:function(){
			$('[data-toggle="popover"]').popover({
				trigger: 'manual'
			});
		},
		passSubmit: {
			username: false,
			password: false,
			repassword: false
		},
		btn: function(){
			// username
			$('#username').on('change', function(){
				var username = $(this).val();
				if(username != ''){
					$.ajax({
						url: '/user/existsUser',
						data: {'username': username},
						type: 'post',
						success: function(data){
							if(data){
								$('div.form-group:has(#username)').addClass('has-error');
								$('#username').attr('data-content','username already exists.').popover('show');
								signup.passSubmit.username = false;
							}else{
								$('div.form-group:has(#username)').removeClass('has-error');
								$('#username').popover('hide');
								signup.passSubmit.username = true;
							}
						}
					});
				}else{
					$('#username').attr('data-content','username can\'t be null.').popover('show');
				}
			});
			// password
			$('#password').on('keyup', function(){
				if($(this).val() != ''){
					$('div.form-group:has(#password)').removeClass('has-error');
					$('#password').popover('hide');
					signup.passSubmit.password = true;
				}else{
					$('div.form-group:has(#password)').addClass('has-error');
					$('#password').attr('data-content','password can\'t be null.').popover('show');
					signup.passSubmit.password = false;
				}
			});
			// repassword
			$('#repassword').on('keyup', function(){
				var password = $('#password').val();
				var rePassword = $('#repassword').val();
				if(rePassword == password){
					$('#repassword').popover('hide');
					$('div.form-group:has(#repassword)').removeClass('has-error');
					signup.passSubmit.repassword = true;
				}else{
					$('#repassword').attr('data-content','password mismatches!.').popover('show');
					$('div.form-group:has(#repassword)').addClass('has-error');
					signup.passSubmit.repassword = false;
				}
			});
			// submit
			$('#signup').submit(function(){
				if(signup.passSubmit.username)
					return true;
				else
					return false;
			});
		}
}