$(function(){
	user.avatarFileInput();
	user.switchPage();
	user.verify();
});

var user = {
		avatarFileInput: function(){
			$("#avatar").fileinput({
				maxFileSize: 200,
				previewFileType: "image",
				browseLabel: " Browser",
				browseClass: 'btn btn-primary',
				browseIcon: '<span class="glyphicon glyphicon-picture"></span>'
			});
		},
		switchPage: function(){
			$('#show_update_profile').on('click', function(){
				if($('#update_profile').hasClass('hidden')){
					$('#update_profile').removeClass('hidden');
					$(this).addClass('active');
				}
				$('#update_password').addClass('hidden');
				$('#show_update_password').removeClass('active');
			});
			$('#show_update_password').on('click', function(){
				if($('#update_password').hasClass('hidden')){
					$('#update_password').removeClass('hidden');
					$(this).addClass('active');
				}
				$('#update_profile').addClass('hidden');
				$('#show_update_profile').removeClass('active');
			});
		},
		verify: function(){
			$('#oldPassword').on('keyup', function(){
				if($(this).val() != ''){
					$('div.form-group:has(#oldPassword)').removeClass('has-error');
					$('#oldPassword').popover('hide');
//					signup.passSubmit.password = true;
				}else{
					$('div.form-group:has(#oldPassword)').addClass('has-error');
					$('#oldPassword').attr('data-content','password can\'t be null.').popover('show');
//					signup.passSubmit.password = false;
				}
			});
			$('#newPassword').on('keyup', function(){
				if($(this).val() != ''){
					$('div.form-group:has(#newPassword)').removeClass('has-error');
					$('#newPassword').popover('hide');
//					signup.passSubmit.password = true;
				}else{
					$('div.form-group:has(#newPassword)').addClass('has-error');
					$('#newPassword').attr('data-content','password can\'t be null.').popover('show');
//					signup.passSubmit.password = false;
				}
			});
			$('#reNewPassword').on('keyup', function(){
				var password = $('#newPassword').val();
				var rePassword = $('#reNewPassword').val();
				if(rePassword == password){
					$('#reNewPassword').popover('hide');
					$('div.form-group:has(#reNewPassword)').removeClass('has-error');
//					signup.passSubmit.repassword = true;
				}else{
					$('#reNewPassword').attr('data-content','password mismatches!.').popover('show');
					$('div.form-group:has(#reNewPassword)').addClass('has-error');
//					signup.passSubmit.repassword = false;
				}
			});
		}
} 